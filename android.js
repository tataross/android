import webdriverio from 'webdriverio'
import {promises as fs} from 'fs'
import path from 'path'
import process from 'process'

const opts =
{
    path: '/wd/hub',
    hostname: '0.0.0.0',
    port: 4723,
    capabilities:
    {
        platformName: 'Android',
        app: path.join(path.dirname(new globalThis.URL(import.meta.url).pathname), 'cashzine.apk'),
        uiautomator2ServerInstallTimeout: 90000,
        androidInstallTimeout: 180000,
        //connectionRetryTimeout: 600000,
        adbExecTimeout: 130000
    }
}

const client = await webdriverio.remote(opts)
await client.startRecordingScreen()
await client.setImplicitTimeout(1000)
const tvLabel = await client.$$('id=com.sky.sea.cashzine:id/tv_label').at(0)
await tvLabel.click()
await client.$('id=com.sky.sea.cashzine:id/tv_finshed').click()
await client.$('id=com.sky.sea.cashzine:id/ll_agree').click()
await client.$('id=com.android.permissioncontroller:id/permission_allow_button').click()
await client.$('id=com.sky.sea.cashzine:id/iv_home_home').click()
await client.$('id=com.sky.sea.cashzine:id/tv_login_now').click()
await client.$('id=com.sky.sea.cashzine:id/tv_go_to_email_login').click()
await client.$('id=com.sky.sea.cashzine:id/et_phone_email').setValue('chaowen.guo1@gmail.com')
await client.$('id=com.sky.sea.cashzine:id/et_password').setValue(process.argv.at(2))
await client.$('id=com.sky.sea.cashzine:id/tv_login').click()
await client.$('id=com.sky.sea.cashzine:id/iv_home_work').click()
await client.$('id=com.sky.sea.cashzine:id/iv_article_icon_big').click()
console.log(await client.getContexts())
await new globalThis.Promise(_ => globalThis.setTimeout(_, 1000 * 30))
const {width, height} = await client.getWindowRect()
for (const _ of globalThis.Array(10).keys()) await client.touchScroll(0, height)

await fs.writeFile('haha.mp4', await client.stopRecordingScreen(), 'base64')
await client.deleteSession()
