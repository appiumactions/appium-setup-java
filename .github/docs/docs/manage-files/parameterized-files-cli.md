---
sidebar_position: 4
---

# Parameterized Files via CLI

In addition to the default file, capabilities.yml, it is also possible to have several capabilities files, aiming for **different coverage and variations for test sessions**.

> All capabilities files must be within the `src/main/resources` directory.

For example, we can have a file with the objective of running the test on the **Android** platform using a **Galaxy S22**. There are no rules for the name of these files, let's call it **capabilities-android.yml**

```yml
platformName: Android
appium:options: {
  automationName: UiAutomator2,
  app: /Users/my_user/IdeaProjects/my-project-test/src/main/resources/wikipedia.apk,
  deviceName: Galaxy S22,
  platformVersion: "14",
  autoGrantPermissions: true,
  appActivity: org.wikipedia.main.MainActivity,
  appPackage: org.wikipedia
}
```

To start an automated test session using these capabilities, it is not necessary to make changes to the Java code, simply enter the file via the command line, through the **`capabilities`** parameter.

If you are using **Maven**, use the following CLI:

```shell
mvn test -Dcapabilities=capabilities-android.yml
```

And if it's **Gradle**:

```shell
gradle test -Pcapabilities=capabilities-android.yml
```