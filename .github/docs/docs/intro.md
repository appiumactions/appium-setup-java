---
sidebar_position: 1
---

# Appium Setup - Intro

let's learn a little more about Appium Mobile Actions

## About

This project aims to simplify the creation of the **DesiredCapabilities** object for creating a testing session with **Appium** in the **Java** language. The creation of session capabilities can be done via a `.yml` file, without the need to be referenced in the Java test code.

## Motivation

### Without Appium Setup 

To build the capabilities of a test session, it is necessary to provide data that normally needs to be dynamic, such as the deviceName and platformVersion, making it necessary to create classes to manage the capabilities on several occasions. Session management classes are also sometimes needed to run on different platforms, such as Android and iOS.

```java
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setPlatform(Platform.IOS);
capabilities.setCapability("appium:automationName", "XCuiTest");
capabilities.setCapability("appium:deviceName", "iPhone 15 Pro Max");
capabilities.setCapability("appium:platformVersion", "17.5");
capabilities.setCapability("appium:app", "/Users/my_user/IdeaProjects/my-project-test/src/main/resources/Wikipedia.app");

AppiumDriver driver = new AppiumDriver(new URI("http://127.0.0.1:4723").toURL(), capabilities);
```

### With Appium Setup

Using Appium Setup Java, it is only necessary to create a file called **capabilities.yml** with the declaration of all capabilities necessary for the test session. The file must be within the `src/main/resources` directory.

```yml
platformName: IOS
appium:automationName: XCuiTest
appium:app: /Users/my_user/IdeaProjects/my-project-test/src/main/resources/Wikipedia.app
appium:deviceName: iPhone 15 Pro Max
appium:platformVersion: "17.5"
```

In the test code, it is only necessary to call the loadCapabilities method of the AppiumSetup class, **no need to enter the .yml file path**.

```java
DesiredCapabilities capabilities = new AppiumSetup().loadCapabilities();
AppiumDriver driver = new AppiumDriver(new URI("http://127.0.0.1:4723").toURL(), capabilities);
```

## Open Source

One of the objectives of this project is to provide more resources to software quality engineers who use Java and Appium as a stack for automated mobile testing. Help make this community even stronger!

Contributions are welcome! Please refer to the [contributing guidelines](https://github.com/appiumactions/appium-setup-java/blob/main/CONTRIBUTING.md) for more information.