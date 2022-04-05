import webdriverio from 'webdriverio'
import {promises as fs} from 'fs'

const opts = {
  path: '/wd/hub',
  hostname: '0.0.0.0',
  port: 4723,
  capabilities: {
    platformName: 'Android',
    automationName: 'UiAutomator2'
  }
}

const client = await webdriverio.remote(opts)
await client.startRecordingScreen()
await client.installApp('cashmagnetNew.apk')
await fs.writeFile('haha.mp4', await client.stopRecordingScreen(), 'base64')
await client.deleteSession()
