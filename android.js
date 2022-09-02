import webdriverio from 'webdriverio'
import {promises as fs} from 'fs'
import path from 'path'

const opts =
{
    path: '/wd/hub',
    hostname: '0.0.0.0',
    port: 4723,
    capabilities:
    {
        platformName: 'Android',
        app: path.join(path.dirname(new globalThis.URL(import.meta.url).pathname), 'cashzine.apk'),
        noReset: true,
        uiautomator2ServerInstallTimeout: 90000,
        androidInstallTimeout: 180000,
        //connectionRetryTimeout: 600000,
        adbExecTimeout: 200000
    }
}

const client = await webdriverio.remote(opts)
await client.startRecordingScreen()
const tvLabel = await client.$$('id=com.sky.sea.cashzine:id/tv_label').at(0)
await tvLabel.click()
/*const tvFinish = await client.$('id=com.sky.sea.cashzine:id/tv_finshed')
await tvFinish.click()
const llAgree = await client.$('id=com.sky.sea.cashzine:id/ll_agree')
await llAgree.click()
const permissionAllowButton = await client.$('id=com.android.permissioncontroller:id/permission_allow_button')
await permissionAllowButton.click()
const ivHomeHome = await client.$('id=com.sky.sea.cashzine:id/iv_home_home')
await ivHomeHome.click()
const tvLoginNow = await client.$('id=com.sky.sea.cashzine:id/tv_login_now')
await tvLoginNow.click()
const tvGoToEmailLogin = await client.$('id=com.sky.sea.cashzine:id/tv_go_to_email_login')
await tvGoToEmailLogin.click()
const etPhoneEmail = await client.$('id=com.sky.sea.cashzine:id/et_phone_email')
await etPhoneEmail.setValue('chaowen.guo1@gmail.com')
const etPassword = await client.$('id=com.sky.sea.cashzine:id/et_password')*/

await fs.writeFile('haha.mp4', await client.stopRecordingScreen(), 'base64')
await client.deleteSession()
