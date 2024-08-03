package com.mooncloak.kodetools.pkce

import org.kotlincrypto.endians.BigEndian
import kotlin.random.Random

/**
 * Represents a cryptographically secure [Random] (csprng) implementation that can be used for
 * cryptographic functions.
 *
 * > [!Warning]
 * > While this implementation is considered secure, it is not meant to be used outside the scope
 * > of this library, and no guarantees are made about its usage or implementation.
 */
@ExperimentalPkceApi
internal data object SecureRandom : Random() {

    private val delegate: org.kotlincrypto.SecureRandom = org.kotlincrypto.SecureRandom()

    override fun nextBits(bitCount: Int): Int {
        require(bitCount in 0..32) { "'bitCount' property must be in the range 0 to 32." }

        if (bitCount == 0) return 0

        val bytes = delegate.nextBytesOf(Int.SIZE_BITS)

        return BigEndian.bytesToInt(bytes[0], bytes[1], bytes[2], bytes[3])
            .takeUpperBits(bitCount)
    }

    /**
     * Takes upper [bitCount] bits (0..32) from this number.
     *
     * **Note:** This is taken from the Kotlin [Random] implementation.
     */
    private fun Int.takeUpperBits(bitCount: Int): Int =
        this.ushr(32 - bitCount) and (-bitCount).shr(31)
}
