# SplitInstallAutoService

A configuration/metadata generator for java.util.ServiceLoader-style service providers

KSP annotation processors and other systems use
[java.util.ServiceLoader][sl] to register implementations of well-known types using META-INF
metadata. However, it is easy for a developer to forget to update or correctly specify the service
descriptors. \
SplitInstallAutoService generates this metadata for the developer, for any class annotated
with `@ImplementationOf`, avoiding typos, providing resistance to errors from refactoring, etc.

## Example

Say you have:

```java
package foo.bar;

import androidx.annotation.Keep;

import foo.bar.TheInterface;

@Keep
@ImplementationOf(TheInterface.class)
final class TheImplementation implements TheInterface {
    // …
}
```

```kotlin
package foo.bar

import androidx.annotation.Keep
import foo.bar.TheInterface

@Keep
@ImplementationOf(InstallTimeProvider::class)
class TheImplementation : TheInterface {
    // …
}
```

SplitInstallAutoService will generate the file
`META-INF/services/foo.bar.TheInterface` in the output classes folder. The file will contain:

```
foo.bar.TheImplementation
```

## References

[Google Kotlin Symbol Processing API](https://github.com/google/ksp)

[Google AutoService](https://github.com/google/auto/tree/master/service)
