---
sidebar_position: 3
---

# Cloud Capabilities

Through the capabilities file it is also possible to integrate your tests with `cloud device farms`, such as Browserstack, SauceLabs, among others.

Very similar to the appium capabilities grouping, we can inform the capabilities needed to integrate with the cloud device farm as follows:

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
bstack:options: {
  project: MySampleProject,
  build: MySampleBuild,
  name: MySampleTest,
  buildTag: regression
}
```

or even:

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
sauce:options : {
  cacheId: "jnc0x1256",
  appiumVersion: "2.0.0-beta56"
}
```

See more details [here](https://appium.io/docs/en/latest/guides/caps/#basic-example-with-appiumoptions).

