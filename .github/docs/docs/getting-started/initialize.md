---
sidebar_position: 4
---

# Initialize

After the dependency is added to the project, it is necessary to create the `capabilities.yml` file with the desired capabilities and simply initialize the `AppiumSetup` object to have access to the `loadCapabilities` method.

## Capabilities

Create the **capabilities.yml** file and enter the capabilities that will be used in your test.

> **Important**: the capabilities.yml file must be in the project's `src/main/resources` directory

```yml
platformName: IOS
appium:automationName: XCuiTest
appium:app: /Users/my_user/IdeaProjects/my-project-test/src/main/resources/Wikipedia.app
appium:deviceName: iPhone 15 Pro Max
appium:platformVersion: "17.5"
```

Add the call to the **loadCapabilities** method, which returns the `DesiredCapabilites` object with the capabilities informed in the **capabilities.yml** file.

After that, pass the DesiredCapabilities object in the **AppiumDriver constructor**.

```java 
DesiredCapabilities capabilities = new AppiumSetup().loadCapabilities();
AppiumDriver driver = new AppiumDriver(new URI("http://127.0.0.1:4723").toURL(), capabilities);
```

### and then run your tests!

If you use Maven in your project, then run the following command:

```shell
mvn test
```

If you use Gradle, then run:

```shell
gradle test
```