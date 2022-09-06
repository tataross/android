/import webdriverio from 'webdriverio'
import {promises as fs} from 'fs'
import path from 'path'
import process from 'process'

const opts =
{
    path: '/wd/hub',
    hostname: '0.0.0.0',
    port: 4723,
    connectionRetryCount: 6,
    connectionRetryTimeout: 2000000,
    capabilities:
    {
        platformName:'Android',
        'appium:automationName':'UiAutomator2',
        'appium:app':path.join(path.dirname(new globalThis.URL(import.meta.url).pathname), 'cashzine.apk'),
        'appium:uiautomator2ServerInstallTimeout':200000,
        'appium:androidInstallTimeout':400000,
        'appium:adbExecTimeout':400000,
        'appium:newCommandTimeout':120
    }
}

const client = await webdriverio.remote(opts)
await client.startRecordingScreen()
await new globalThis.Promise(_ => globalThis.setTimeout(_, 1000 * 30))
let current = await client.waitUntil(async () =>
{
    const _ = await client.$$('id=com.sky.sea.cashzine:id/tv_label')
    return  _.length ? _.at(0) : false
}, {timeout:2**31 - 1})
await current.click()
current = await client.$('id=com.sky.sea.cashzine:id/tv_finshed')
await current.waitForExist({timeout:2**31 - 1})
await current.click()
current = await client.$('id=com.sky.sea.cashzine:id/ll_agree')
await current.waitForExist({timeout:2**31 - 1})
await current.click()
current = await client.$('id=com.android.permissioncontroller:id/permission_allow_button')
await current.waitForExist({timeout:2**31 - 1})
await current.click()
current = await client.$('id=com.sky.sea.cashzine:id/iv_home_home')
await current.waitForExist({timeout:2**31 - 1})
await current.click()
current = await client.$('id=com.sky.sea.cashzine:id/tv_login_now')
await current.waitForExist({timeout:2**31 - 1})
await current.click()
current = await client.$('id=com.sky.sea.cashzine:id/tv_go_to_email_login')
await current.waitForExist({timeout:2**31 - 1})
await current.click()
await client.$('id=com.sky.sea.cashzine:id/et_phone_email').setValue('chaowen.guo1@gmail.com')
await client.$('id=com.sky.sea.cashzine:id/et_password').setValue(process.argv.at(2))
await client.$('id=com.sky.sea.cashzine:id/tv_login').click()
await client.$('id=com.sky.sea.cashzine:id/iv_home_work').click()
console.log(await client.getPageSource())
await client.$('id=com.sky.sea.cashzine:id/iv_article_icon_big').click()
console.log(await client.getContexts())
await new globalThis.Promise(_ => globalThis.setTimeout(_, 1000 * 30))
/*const {height} = await client.getWindowRect()
for (const _ of globalThis.Array(10).keys()) await client.touchScroll(0, height)*/

await fs.writeFile('haha.mp4', await client.stopRecordingScreen(), 'base64')
await client.deleteSession()
