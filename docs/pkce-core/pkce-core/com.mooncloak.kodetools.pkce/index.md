//[pkce-core](../../index.md)/[com.mooncloak.kodetools.pkce](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [CodeChallenge](-code-challenge/index.md) | [common]<br>@[JvmInline](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-inline/index.html)<br>@Serializable<br>value class [CodeChallenge](-code-challenge/index.md)(val value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [CodeChallengeMethod](-code-challenge-method/index.md) | [common]<br>@[JvmInline](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-inline/index.html)<br>@Serializable<br>value class [CodeChallengeMethod](-code-challenge-method/index.md)(val value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Represents the supported transformation methods in the PKCE protocol. Currently, the only supported methods are [Plain](-code-challenge-method/-companion/-plain.md) and [S256](-code-challenge-method/-companion/-s256.md). The [Plain](-code-challenge-method/-companion/-plain.md) method performs no operation, while the [S256](-code-challenge-method/-companion/-s256.md) performs an SHA-256 hash. |
| [CodeVerifier](-code-verifier/index.md) | [common]<br>@[JvmInline](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-inline/index.html)<br>@Serializable<br>value class [CodeVerifier](-code-verifier/index.md)(val value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [ExperimentalPkceApi](-experimental-pkce-api/index.md) | [common]<br>annotation class [ExperimentalPkceApi](-experimental-pkce-api/index.md) |
| [Pkce](-pkce/index.md) | [common]<br>class [Pkce](-pkce/index.md)(base64Encoder: [Base64](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io.encoding/-base64/index.html) = Base64.UrlSafe, random: [Random](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.random/-random/index.html) = SecureRandom, transformer: [VerifierTransformer](-verifier-transformer/index.md) = VerifierTransformer.Default)<br>A class implementing the Proof Key for Code Exchange (PKCE, pronounced &quot;pixy&quot;), [RFC-7636](https://datatracker.ietf.org/doc/html/rfc7636), protocol. This class contains functions that can be used to perform the protocol. However, note that the communication of the values between the parties involved is not handled by this class and must be handled out-of-band. |
| [VerifierTransformer](-verifier-transformer/index.md) | [common]<br>fun interface [VerifierTransformer](-verifier-transformer/index.md) |

## Properties

| Name | Summary |
|---|---|
| [Default](-default.md) | [common]<br>val [VerifierTransformer.Companion](-verifier-transformer/-companion/index.md).[Default](-default.md): [VerifierTransformer](-verifier-transformer/index.md) |
