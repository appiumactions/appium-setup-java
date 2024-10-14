---
sidebar_position: 1
---

# Capabilities File

The capabiltiies.yml file must contain only the capabilities necessary for the testing session.
The capabilities must follow the [W3C WebDriver specification](https://appium.io/docs/en/latest/guides/caps/).

> **Important**: the capabilities.yml file must be in the project's `src/main/resources` directory

## Mandatory capabilities

Some capabilities are mandatory for the test session to be created. Based on these capabilities, the decision is made about which **driver** and **automated testing framework** will be used.

### platformName

The `platformName` capability is mandatory as it tells you the type of platform hosting the application or browser.
We can base ourselves on the [platform enum](https://www.javadoc.io/doc/org.seleniumhq.selenium/selenium-api/latest/org/openqa/selenium/Platform.html) provided by Selenium to know which platforms can be informed.

For mobile test automation, the most commonly used platforms are `Android` and `IOS`.

```yml
platformName: Android
```

```yml
platformName: IOS
```

### automationName

The `automationName` capability is mandatory as it tells you the name of the Appium driver to use.
We can base ourselves on the [automation name enum](https://javadoc.io/doc/io.appium/java-client/latest/io/appium/java_client/remote/AutomationName.html) provided by Java Client (Appium) to know which automation names can be informed.

For mobile test automation, the most commonly used platforms are `UIAutomator2` for Android and `XCuiTest` for iOS.

```yml
appium:automationName: UIAutomator2
```

```yml
appium:automationName: XCuiTest
```

## Complete file

Below, we have 2 example files, targeting both platforms, **Android** and **iOS**.

### Android

```yml
platformName: Android
appium:automationName: UiAutomator2
appium:app: /Users/my_user/IdeaProjects/my-project-test/src/main/resources/wikipedia.apk
appium:deviceName: Pixel Fold API 34
appium:platformVersion: "14"
appium:autoGrantPermissions: true
appium:appActivity: org.wikipedia.main.MainActivity
appium:appPackage: org.wikipedia
```

### iOS

```yml
platformName: IOS
appium:automationName: XCuiTest
appium:app: /Users/my_user/IdeaProjects/my-project-test/src/main/resources/Wikipedia.app
appium:deviceName: iPhone 15 Pro Max
appium:platformVersion: "17.5"
```