package com.mooncloak.kodetools.pkce

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * Represents the supported transformation methods in the PKCE protocol. Currently, the only
 * supported methods are [Plain] and [S256]. The [Plain] method performs no operation, while the
 * [S256] performs an SHA-256 hash.
 *
 * @see [RFC-7636](https://datatracker.ietf.org/doc/html/rfc7636)
 */
@JvmInline
@Serializable
@ExperimentalPkceApi
public value class CodeChallengeMethod public constructor(
    public val value: String
) {

    public companion object {

        public val Plain: CodeChallengeMethod = CodeChallengeMethod(value = "plain")
        public val S256: CodeChallengeMethod = CodeChallengeMethod(value = "S256")
    }
}
