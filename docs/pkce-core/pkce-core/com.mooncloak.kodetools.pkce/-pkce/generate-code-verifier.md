//[pkce-core](../../../index.md)/[com.mooncloak.kodetools.pkce](../index.md)/[Pkce](index.md)/[generateCodeVerifier](generate-code-verifier.md)

# generateCodeVerifier

[common]\
suspend fun [generateCodeVerifier](generate-code-verifier.md)(byteLength: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 32): [CodeVerifier](../-code-verifier/index.md)

Generates a &quot;code_verifier&quot; specified in the PKCE protocol. This value is considered a secure key.

#### See also

| | |
|---|---|
|  | [RFC-7636](https://datatracker.ietf.org/doc/html/rfc7636#section-4.1) |
