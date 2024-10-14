---
sidebar_position: 2
---

# Group Capabilities

It is common to use several capabilities with the `appium prefix`, making the file readability poor, as well as making the writing repetitive.

Alternatively, we can use the **`appium:options`** grouper.

See more details [here](https://appium.io/docs/en/latest/guides/caps/#using-appiumoptions-to-group-capabilities).

## How to use

See the example below on how to group all appium capabilities.

```yml
platformName: Android
appium:options: {
  automationName: UiAutomator2,
  app: /Users/my_user/IdeaProjects/my-project-test/src/main/resources/wikipedia.apk,
  deviceName: Pixel Fold API 34,
  platformVersion: "14",
  autoGrantPermissions: true,
  appActivity: org.wikipedia.main.MainActivity,
  appPackage: org.wikipedia
}
```