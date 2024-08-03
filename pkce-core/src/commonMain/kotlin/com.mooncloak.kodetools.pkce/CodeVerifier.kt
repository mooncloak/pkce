package com.mooncloak.kodetools.pkce

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@ExperimentalPkceApi
@JvmInline
@Serializable
public value class CodeVerifier public constructor(
    public val value: String
) {

    public companion object
}
