package com.mooncloak.kodetools.pkce

import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi
import kotlin.random.Random

/**
 * A class implementing the Proof Key for Code Exchange (PKCE, pronounced "pixy"),
 * [RFC-7636](https://datatracker.ietf.org/doc/html/rfc7636), protocol. This class contains
 * functions that can be used to perform the protocol. However, note that the communication of the
 * values between the parties involved is not handled by this class and must be handled
 * out-of-band.
 *
 * ## Example Usage:
 *
 * ```kotlin
 * // Client:
 * val pkce = Pkce()
 *
 * val verifier = pkce.generateCodeVerifier()
 * val challenge = pkce.createCodeChallenge(verifier = verifier, method = CodeChallengeMethod.S256)
 *
 * // * Send the challenge and the method to the server along with the other required data, for the authorization code request.
 * // * Upon receipt of the authorization code, send that along with the verifier for the access token request.
 *
 * // Server:
 * val pkce = Pkce()
 *
 * val isVerified = pkce.isValid(
 *     verifier = clientVerifierFromAccessTokenRequest,
 *     challenge = clientChallengeFromAuthTokenRequest,
 *     method = clientMethodFromAuthTokenRequest
 * )
 *
 * // If isVerified is `true`, then the server can respond to the client with the access token. Otherwise, an exception should be thrown.
 * ```
 *
 * @property [base64Encoder] The [Base64] utility used in the protocol to encode values to a Base64
 * URL encoded [String]s.
 *
 * @property [random] The Secure [Random] utility used to generate the code verifier for the
 * protocol.
 *
 * @property [transformer] The function used to transform the verifier [ByteArray] into the output
 * code challenge [ByteArray]. This function should return the plain verifier value when the method
 * is [CodeChallengeMethod.Plain], and perform a SHA256 hash when the method is
 * [CodeChallengeMethod.S256].
 *
 * @see [RFC-7636](https://datatracker.ietf.org/doc/html/rfc7636)
 */
@ExperimentalPkceApi
@OptIn(ExperimentalEncodingApi::class)
@Suppress("SpellCheckingInspection")
public class Pkce public constructor(
    private val base64Encoder: Base64 = Base64.UrlSafe,
    private val random: Random = SecureRandom,
    private val transformer: VerifierTransformer = VerifierTransformer.Default
) {

    /**
     * Generates a "code_verifier" specified in the PKCE protocol. This value is considered a
     * secure key.
     *
     * @see [RFC-7636](https://datatracker.ietf.org/doc/html/rfc7636#section-4.1)
     */
    @Suppress("RedundantSuspendModifier")
    public suspend fun generateCodeVerifier(byteLength: Int = 32): CodeVerifier {
        val bytes = random.nextBytes(byteLength)

        return CodeVerifier(value = base64Encoder.encode(bytes))
    }

    /**
     * Creates a "code_challenge", specified in the PKCE protocol, from the provided [verifier],
     * using the provided transformation [method]. If the provided [method] is
     * [CodeChallengeMethod.Plain], then the [verifier] is simply returned, otherwise, if the
     * provided [method] is [CodeChallengeMethod.S256], an SHA-256 hash opertaion is performed and
     * the result is returned.
     *
     * @see [RFC-7636](https://datatracker.ietf.org/doc/html/rfc7636#section-4.2)
     */
    @Suppress("MemberVisibilityCanBePrivate")
    public suspend fun createCodeChallenge(
        verifier: CodeVerifier,
        method: CodeChallengeMethod = CodeChallengeMethod.S256
    ): CodeChallenge =
        when (method) {
            CodeChallengeMethod.Plain -> CodeChallenge(value = verifier.value)

            CodeChallengeMethod.S256 -> {
                val hash = transformer.transform(method, verifier.value.encodeToByteArray())

                CodeChallenge(value = base64Encoder.encode(hash))
            }

            else -> error("Unsupported Code Challenge Method.")
        }

    /**
     * Verifies that the provided [verifier] equals the provided [challenge] after it is transformed
     * using the provided [method]. Returns `true` if the values are equal, `false` otherwise.
     *
     * @see [RFC-7636](https://datatracker.ietf.org/doc/html/rfc7636#section-4.6)
     */
    public suspend fun isValid(
        verifier: CodeVerifier,
        challenge: CodeChallenge,
        method: CodeChallengeMethod = CodeChallengeMethod.S256
    ): Boolean {
        val actualChallenge = createCodeChallenge(
            verifier = verifier,
            method = method
        )

        return actualChallenge.value == challenge.value
    }
}
