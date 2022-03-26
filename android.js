import webdriverio from 'webdriverio'

const opts = {
  path: '/wd/hub',
  hostname: '0.0.0.0',
  port: 4723,
  capabilities: {
    platformName: "Android",
    platformVersion: "8",
    deviceName: "Android Emulator",
    app: "ApiDemos-debug.apk",
    appPackage: "io.appium.android.apis",
    appActivity: ".view.TextFields",
    automationName: "UiAutomator2"
  }
};

const client = await webdriverio.remote(opts);
const field = await client.$("android.widget.EditText");
await field.setValue("Hello World!");
const value = await field.getText();
await client.deleteSession();
