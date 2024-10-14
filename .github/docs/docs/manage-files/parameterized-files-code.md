---
sidebar_position: 5
---

# Parameterized Files via Code

It is also possible to carry out this parameterization via code, using the `loadCapabilities` method.

```java
DesiredCapabilities capabilities = new AppiumSetup().loadCapabilities("capabilities-android.yml");
AppiumDriver driver = new AppiumDriver(new URI("http://127.0.0.1:4723").toURL(), capabilities);
```

> All capabilities files must be within the `src/main/resources` directory.

## TestNG

Using the **TestNG** framework, it is possible to create a suite file and through the `@Parameters` annotation, we can inform different **capabilities** for each test.

Example of the test method, prepared for execution with parameterization via suite and via CLI.

```java
@Test
@Parameters("capabilitiesFile")
public void test(@Optional String capabilitiesFile) throws MalformedURLException, URISyntaxException {
    DesiredCapabilities capabilities = capabilitiesFile == null
            ? new AppiumSetup().loadCapabilities()
            : new AppiumSetup().loadCapabilities(capabilitiesFile);

    AppiumDriver driver = new AppiumDriver(new URI("http://127.0.0.1:4723").toURL(), capabilities);

    \\ test code
}
```

Sample TestNG suite file: 

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Smoke" verbose="1" parallel="tests" thread-count="2">
    <test name="Sample - Android">
        <parameter name="capabilitiesFile" value="capabilities-android.yml"/>
        <classes>
            <class name="SampleTest"/>
        </classes>
    </test>
    <test name="Sample - iOS">
        <parameter name="capabilitiesFile" value="capabilities-ios.yml"/>
        <classes>
            <class name="SampleTest"/>
        </classes>
    </test>
</suite>
```
