import webdriverio from 'webdriverio'
import {promises as fs} from 'fs'
import path from 'path'
import process from 'process'

const opts =
{
    path: '/wd/hub',
    hostname: '0.0.0.0',
    port: 4723,
    connectionRetryCount: 10,
    connectionRetryTimeout: 2000000,
    waitforTimeout: 2**31 - 1,
    waitforInterval: 2000,
    capabilities:
    {
        platformName:'Android',
        'appium:automationName':'UiAutomator2',
        'appium:app':path.join(path.dirname(new globalThis.URL(import.meta.url).pathname), 'cashzine.apk'),
        'appium:uiautomator2ServerInstallTimeout': 200000,
        'appium:androidInstallTimeout': 400000,
        'appium:adbExecTimeout': 400000,
        'appium:newCommandTimeout':250
    }
}

const client = await webdriverio.remote(opts)
await client.startRecordingScreen()
await client.startActivity('com.sky.sea.cashzine', 'com.sky.sea.home.main.MainActivity')
let current = await client.$('id=com.sky.sea.cashzine:id/iv_home_home')
await current.waitForExist()
await current.click()
current = await client.$('id=com.sky.sea.cashzine:id/tv_login_now')
await current.waitForExist()
await current.click()
//await new globalThis.Promise(_ => globalThis.setTimeout(_, 1000 * 60))
//console.log(await client.getPageSource())
current = await client.$('id=com.sky.sea.cashzine:id/tv_go_to_email_login')
await current.waitForExist()
await current.click()
current = await client.$('id=com.sky.sea.cashzine:id/et_phone_email')
await current.waitForExist()    
await current.addValue('chaowen.guo1@gmail.com')
current = await client.$('id=com.sky.sea.cashzine:id/et_password')
await current.waitForExist()
await current.addValue(process.argv.at(2))
current = await client.$('id=com.sky.sea.cashzine:id/tv_login')
await current.waitForExist()
await current.click()
current = await client.$('id=com.sky.sea.cashzine:id/iv_home_work')
await current.waitForExist()
await current.click()
current = await client.$('id=com.sky.sea.cashzine:id/title_container').$$('android.widget.TextView').at(2)
await current.waitForExist()
await current.click()
//await client.$('id=com.sky.sea.cashzine:id/iv_article_icon_big').click()
console.log(await client.getContexts())
await new globalThis.Promise(_ => globalThis.setTimeout(_, 1000 * 30))*/
/*const {height} = await client.getWindowRect()
for (const _ of globalThis.Array(10).keys()) await client.touchScroll(0, height)*/

await fs.writeFile('haha.mp4', await client.stopRecordingScreen(), 'base64')
await client.deleteSession()
