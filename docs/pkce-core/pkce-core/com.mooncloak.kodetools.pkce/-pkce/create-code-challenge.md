//[pkce-core](../../../index.md)/[com.mooncloak.kodetools.pkce](../index.md)/[Pkce](index.md)/[createCodeChallenge](create-code-challenge.md)

# createCodeChallenge

[common]\
suspend fun [createCodeChallenge](create-code-challenge.md)(verifier: [CodeVerifier](../-code-verifier/index.md), method: [CodeChallengeMethod](../-code-challenge-method/index.md) = CodeChallengeMethod.S256): [CodeChallenge](../-code-challenge/index.md)

Creates a &quot;code_challenge&quot;, specified in the PKCE protocol, from the provided [verifier](create-code-challenge.md), using the provided transformation [method](create-code-challenge.md). If the provided [method](create-code-challenge.md) is [CodeChallengeMethod.Plain](../-code-challenge-method/-companion/-plain.md), then the [verifier](create-code-challenge.md) is simply returned, otherwise, if the provided [method](create-code-challenge.md) is [CodeChallengeMethod.S256](../-code-challenge-method/-companion/-s256.md), an SHA-256 hash opertaion is performed and the result is returned.

#### See also

| | |
|---|---|
|  | [RFC-7636](https://datatracker.ietf.org/doc/html/rfc7636#section-4.2) |
