---
sidebar_position: 3
---

# Add Dependency Gradle

Add the following dependency to your `build.gradle` file:

```gradle
dependencies {
    implementation 'io.github.appiumactions:appium-setup:+'
}
```

If you use gradle, there is an additional step to use parameterized files. Add the following line of code inside the `test method` in the `build.gradle` file:

```gradle
test {
    systemProperty 'capabilities', findProperty('capabilities')
    \\ other settings
}
```



Versions can be found [here](https://mvnrepository.com/artifact/io.github.appiumactions/appium-setup).