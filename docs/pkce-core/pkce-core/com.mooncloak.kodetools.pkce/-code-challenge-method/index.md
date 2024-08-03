//[pkce-core](../../../index.md)/[com.mooncloak.kodetools.pkce](../index.md)/[CodeChallengeMethod](index.md)

# CodeChallengeMethod

@[JvmInline](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-inline/index.html)

@Serializable

value class [CodeChallengeMethod](index.md)(val value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Represents the supported transformation methods in the PKCE protocol. Currently, the only supported methods are [Plain](-companion/-plain.md) and [S256](-companion/-s256.md). The [Plain](-companion/-plain.md) method performs no operation, while the [S256](-companion/-s256.md) performs an SHA-256 hash.

#### See also

| | |
|---|---|
|  | [RFC-7636](https://datatracker.ietf.org/doc/html/rfc7636) |

## Constructors

| | |
|---|---|
| [CodeChallengeMethod](-code-challenge-method.md) | [common]<br>constructor(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [value](value.md) | [common]<br>val [value](value.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
