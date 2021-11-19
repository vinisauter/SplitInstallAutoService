# AutoService

A configuration/metadata generator for java.util.ServiceLoader-style service
providers

## AutoWhat‽

[Java][java] annotation processors and other systems use
[java.util.ServiceLoader][sl] to register implementations of well-known types
using META-INF metadata. However, it is easy for a developer to forget to update
or correctly specify the service descriptors. \
AutoService generates this metadata for the developer, for any class annotated
with `@AutoService`, avoiding typos, providing resistance to errors from
refactoring, etc.

## Example

Say you have:

```java
package foo.bar;
import javax.annotation.processing.Processor;
@AutoService(Processor.class)
final class MyProcessor implements Processor {
  // …
}
```

AutoService will generate the file
`META-INF/services/javax.annotation.processing.Processor` in the output classes
folder. The file will contain:

```
foo.bar.MyProcessor
```