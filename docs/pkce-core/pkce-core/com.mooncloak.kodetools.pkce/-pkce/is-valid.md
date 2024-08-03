//[pkce-core](../../../index.md)/[com.mooncloak.kodetools.pkce](../index.md)/[Pkce](index.md)/[isValid](is-valid.md)

# isValid

[common]\
suspend fun [isValid](is-valid.md)(verifier: [CodeVerifier](../-code-verifier/index.md), challenge: [CodeChallenge](../-code-challenge/index.md), method: [CodeChallengeMethod](../-code-challenge-method/index.md) = CodeChallengeMethod.S256): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Verifies that the provided [verifier](is-valid.md) equals the provided [challenge](is-valid.md) after it is transformed using the provided [method](is-valid.md). Returns `true` if the values are equal, `false` otherwise.

#### See also

| | |
|---|---|
|  | [RFC-7636](https://datatracker.ietf.org/doc/html/rfc7636#section-4.6) |
