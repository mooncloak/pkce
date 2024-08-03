//[pkce-core](../../../index.md)/[com.mooncloak.kodetools.pkce](../index.md)/[Pkce](index.md)

# Pkce

class [Pkce](index.md)(base64Encoder: [Base64](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io.encoding/-base64/index.html) = Base64.UrlSafe, random: [Random](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.random/-random/index.html) = SecureRandom, transformer: [VerifierTransformer](../-verifier-transformer/index.md) = VerifierTransformer.Default)

A class implementing the Proof Key for Code Exchange (PKCE, pronounced &quot;pixy&quot;), [RFC-7636](https://datatracker.ietf.org/doc/html/rfc7636), protocol. This class contains functions that can be used to perform the protocol. However, note that the communication of the values between the parties involved is not handled by this class and must be handled out-of-band.

## Example Usage:

```kotlin
// Client:
val pkce = Pkce()

val verifier = pkce.generateCodeVerifier()
val challenge = pkce.createCodeChallenge(verifier = verifier, method = CodeChallengeMethod.S256)

// * Send the challenge and the method to the server along with the other required data, for the authorization code request.
// * Upon receipt of the authorization code, send that along with the verifier for the access token request.

// Server:
val pkce = Pkce()

val isVerified = pkce.isValid(
    verifier = clientVerifierFromAccessTokenRequest,
    challenge = clientChallengeFromAuthTokenRequest,
    method = clientMethodFromAuthTokenRequest
)

// If isVerified is `true`, then the server can respond to the client with the access token. Otherwise, an exception should be thrown.
```

#### See also

| | |
|---|---|
|  | [RFC-7636](https://datatracker.ietf.org/doc/html/rfc7636) |

## Constructors

| | |
|---|---|
| [Pkce](-pkce.md) | [common]<br>constructor(base64Encoder: [Base64](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io.encoding/-base64/index.html) = Base64.UrlSafe, random: [Random](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.random/-random/index.html) = SecureRandom, transformer: [VerifierTransformer](../-verifier-transformer/index.md) = VerifierTransformer.Default) |

## Functions

| Name | Summary |
|---|---|
| [createCodeChallenge](create-code-challenge.md) | [common]<br>suspend fun [createCodeChallenge](create-code-challenge.md)(verifier: [CodeVerifier](../-code-verifier/index.md), method: [CodeChallengeMethod](../-code-challenge-method/index.md) = CodeChallengeMethod.S256): [CodeChallenge](../-code-challenge/index.md)<br>Creates a &quot;code_challenge&quot;, specified in the PKCE protocol, from the provided [verifier](create-code-challenge.md), using the provided transformation [method](create-code-challenge.md). If the provided [method](create-code-challenge.md) is [CodeChallengeMethod.Plain](../-code-challenge-method/-companion/-plain.md), then the [verifier](create-code-challenge.md) is simply returned, otherwise, if the provided [method](create-code-challenge.md) is [CodeChallengeMethod.S256](../-code-challenge-method/-companion/-s256.md), an SHA-256 hash opertaion is performed and the result is returned. |
| [generateCodeVerifier](generate-code-verifier.md) | [common]<br>suspend fun [generateCodeVerifier](generate-code-verifier.md)(byteLength: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 32): [CodeVerifier](../-code-verifier/index.md)<br>Generates a &quot;code_verifier&quot; specified in the PKCE protocol. This value is considered a secure key. |
| [isValid](is-valid.md) | [common]<br>suspend fun [isValid](is-valid.md)(verifier: [CodeVerifier](../-code-verifier/index.md), challenge: [CodeChallenge](../-code-challenge/index.md), method: [CodeChallengeMethod](../-code-challenge-method/index.md) = CodeChallengeMethod.S256): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Verifies that the provided [verifier](is-valid.md) equals the provided [challenge](is-valid.md) after it is transformed using the provided [method](is-valid.md). Returns `true` if the values are equal, `false` otherwise. |
