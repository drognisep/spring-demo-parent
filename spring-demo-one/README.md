# IoC Example

Run `HelloSpringApp.java` to see the below output (without Spring setup text):

```
Get 'Coach' by Class. Highlander rules, there can be only one.
Today's workout is "Run until you die from it!", and your fortune is "Today is going to be a great day!"
Get 'Coach' by config ID (config method name)
Today's workout is "Run until you die from it!", and your fortune is "Today is going to be a great day!"
Same 'Coach' instance between invocations? true
Same 'FortuneService' instance between invocations? false

No bean named 'myCoach' is defined
Uh-oh! Can't pick up our XML configured beans because we used *annotation* base config instead!

From XML configured bean: Today's workout is "Run until you die from it!", and your fortune is "You gonna die!"
```

See `AppConfig.java` for annotation based config, and `src/main/resources/annotationContext.xml` for XML based config, both are demonstrated in the main method.
