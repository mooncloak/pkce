# pkce

A Kotlin multiplatform implementation Proof key for Code Exchange (PKCE).

<img alt="GitHub tag (latest by date)" src="https://img.shields.io/github/v/tag/mooncloak/pkce">

Proof Key for Code Exchange (PKCE, pronounced "pixy") , RFC-7636, is a cryptographic challenge protocol used to mitigate
issues with the OAuth 2.0 specification. In particular, it prevents an attacker from intercepting an authorization code
from a redirect URI on a public client, such as a smartphone, and using it to obtain an access token from an OAuth 2.0
compliant authorization server.

The protocol defines a way for a client to generate a cryptographically secure key ("code_verifier"), and transform it
into a challenge ("code_challenge") which is sent to the authorization server, along with the transformation method, in
the authorization code request. When the client obtains the authorization code, it will send it along with the key ("
code_verifier"). The server then transforms the key, using the previously provided transformation method, and compares
it with the previously provided challenge value ("code_challenge"). If the values are equal then the server can provide
the client the access token, otherwise an error is returned as the client cannot be trusted. These values are generated
for every authorization code request.

## Status ⚠️

> [!Warning]
> This project is being actively developed but is in an early experimental state. Use the library
> cautiously and report back any issues. mooncloak is not responsible for any issues faced when
> using
> the library.

## Getting Started 🏁

Checkout the [releases page](https://github.com/mooncloak/kjwt/releases) to get the latest version.
<br/><br/>
<img alt="GitHub tag (latest by date)" src="https://img.shields.io/github/v/tag/mooncloak/pkce">

### Repository

```kotlin
repositories {
    maven("https://repo.repsy.io/mvn/mooncloak/public")
}
```

### Dependencies

```kotlin
implementation("com.mooncloak.kodetools.otp:otp-core:VERSION")
```

## Inspiration 🧠

This project was inspired by, yet completely independent of, the following open source projects:

| Project                                   | Language | License                                                             |
|-------------------------------------------|----------|---------------------------------------------------------------------|
| [krypt](https://github.com/chRyNaN/krypt) | Kotlin   | [Apache 2.0](https://github.com/chRyNaN/krypt/blob/develop/LICENSE) |

## Documentation 📃

More detailed documentation is available in the [docs](docs/) folder. The entry point to the
documentation can be
found [here](docs/index.md).

## Security 🛡️

For security vulnerabilities, concerns, or issues, please refer to
the [security policy](SECURITY.md) for more
information on appropriate approaches for disclosure.

## Contributing ✍️

Outside contributions are welcome for this project. Please follow
the [code of conduct](CODE_OF_CONDUCT.md)
and [coding conventions](CODING_CONVENTIONS.md) when contributing. If contributing code, please add
thorough documents
and tests. Thank you!

## License ⚖️

```
Copyright 2024 mooncloak

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
