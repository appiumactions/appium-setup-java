# Appium Setup for Java

[![Javadocs](https://www.javadoc.io/badge/io.github.appiumactions/appium-setup.svg)](https://www.javadoc.io/doc/io.github.appiumactions/appium-setup)
[![Github Actions](https://github.com/appiumactions/appium-setup-java/actions/workflows/build-test.yml/badge.svg)](https://github.com/appiumactions/appium-setup-java/actions/workflows/build-test.yml)

This project aims to simplify the creation of the DesiredCapabilities object for creating a testing session with Appium in the Java language.
The creation of session capabilities can be done via a .yml file, without the need to be referenced in the Java test code.

## Motivation

### Without Appium Setup for Java

To build the capabilities of a test session, it is necessary to provide data that normally needs to be dynamic, such as the deviceName and platformVersion, making it necessary to create classes to manage the capabilities on several occasions.
Session management classes are also sometimes needed to run on different platforms, such as Android and iOS.

```java
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setPlatform(Platform.IOS);
capabilities.setCapability("appium:automationName", "XCuiTest");
capabilities.setCapability("appium:deviceName", "iPhone 15 Pro Max");
capabilities.setCapability("appium:platformVersion", "17.5");
capabilities.setCapability("appium:app", "/Users/my_user/IdeaProjects/my-project-test/src/main/resources/Wikipedia.app");

AppiumDriver driver = new AppiumDriver(new URI("http://127.0.0.1:4723").toURL(), capabilities);
```

### With Appium Setup for Java

Using Appium Setup Java, it is only necessary to create a file called capabilities.yml with the declaration of all capabilities necessary for the test session.
The file must be within the src/main/resources directory.

```yml 
platformName: "IOS"
appium:automationName: "XCuiTest"
appium:app: "/Users/my_user/IdeaProjects/my-project-test/src/main/resources/Wikipedia.app"
appium:deviceName: "iPhone 15 Pro Max"
appium:platformVersion: "17.5"
```

In the test code, it is only necessary to call the loadCapabilities method of the AppiumSetup class, no need to enter the .yml file path.

```java
DesiredCapabilities capabilities = new AppiumSetup().loadCapabilities();
AppiumDriver driver = new AppiumDriver(new URI("http://127.0.0.1:4723").toURL(), capabilities);
```

## How to use

### Step 1: Add the dependency to your project

Add the dependency to your project's pom.xml or build.gradle file.

```xml
<dependency>
    <groupId>io.github.appiumactions</groupId>
    <artifactId>appium-setup</artifactId>
    <version>$version</version>
</dependency>
```

### Step 2: Create the capabilities.yml file

Create a file called capabilities.yml in the resources folder of your project.

```yml
platformName: "IOS"
appium:automationName: "XCuiTest"
appium:app: "/Users/my_user/IdeaProjects/my-project-test/src/main/resources/Wikipedia.app"
appium:deviceName: "iPhone 15 Pro Max"
appium:platformVersion: "17.5"
```

### Step 3: Load the capabilities

In your test code, call the loadCapabilities method of the AppiumSetup class.

```java
DesiredCapabilities capabilities = new AppiumSetup().loadCapabilities();
AppiumDriver driver = new AppiumDriver(new URI("http://127.0.0.1:4723").toURL(), capabilities);
```

### Step 4: Run your tests

Run your tests as usual.

```shell
mvn test
```

## Execution with parameterized files

It is possible to create multiple .yml files with different capabilities and pass the file name as a parameter to the CLI.
It is only necessary that all capacity files are in the src/main/resources directory.

```shell
mvn test -Dcapabilities=capabilities-android.yml
```

## How to use appium:options

If you use a lot of appium: capabilities in your tests, it can get a little repetitive. You can combine all capabilities as an object value of a single appium:options capability instead, in which case you don't need to use prefixes on the capabilities inside the object. For example:
    
```yml
platformName: "Android"
appium:options: {
  automationName: "UiAutomator2",
  app: "/Users/my_user/IdeaProjects/my-project-test/src/main/resources/wikipedia.apk",
  deviceName: "Pixel Fold API 34",
  platformVersion: "14",
  autoGrantPermissions: true,
  appActivity: "org.wikipedia.main.MainActivity",
  appPackage: "org.wikipedia"
}
```