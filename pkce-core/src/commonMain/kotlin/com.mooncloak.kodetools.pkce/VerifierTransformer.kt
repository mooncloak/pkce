package com.mooncloak.kodetools.pkce

import org.kotlincrypto.hash.sha2.SHA256

@ExperimentalPkceApi
public fun interface VerifierTransformer {

    public suspend fun transform(method: CodeChallengeMethod, verifier: ByteArray): ByteArray

    public companion object
}

@ExperimentalPkceApi
public val VerifierTransformer.Companion.Default: VerifierTransformer
    get() = DefaultVerifierTransformer

@ExperimentalPkceApi
internal data object DefaultVerifierTransformer : VerifierTransformer {

    override suspend fun transform(method: CodeChallengeMethod, verifier: ByteArray): ByteArray =
        when (method) {
            CodeChallengeMethod.Plain -> verifier
            CodeChallengeMethod.S256 -> SHA256().digest(verifier)
            else -> error("Unsupported Code Challenge Method.")
        }
}
