import webdriverio from 'webdriverio'
import {promises as fs} from 'fs'

const opts = {
  path: '/wd/hub',
  hostname: '0.0.0.0',
  port: 4723,
  capabilities: {
    platformName: 'Android',
    automationName: 'UiAutomator2',
    app: 'ApiDemos-debug.apk'
  }
}

const client = await webdriverio.remote(opts)
client.startRecordingScreen()
await new globalThis.Promise(_ => globalThis.setTimeout(_, 1000 * 60))
await fs.writeFile('haha.mp4', client.stopRecordingScreen(), 'base64')
await client.deleteSession()
