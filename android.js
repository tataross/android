import webdriverio from 'webdriverio'

const opts = {
  path: '/wd/hub',
  hostname: '0.0.0.0',
  port: 4723,
  capabilities: {
    platformName: "Android",
    deviceName: "haha",
    app: "ApiDemos-debug.apk",
    appPackage: "io.appium.android.apis",
    appActivity: ".view.TextFields"
  }
};

webdriverio.startRecordingScreen()
