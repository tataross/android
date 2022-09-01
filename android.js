import webdriverio from 'webdriverio'
import {promises as fs} from 'fs'
import path from 'path'

const opts = {
  path: '/wd/hub',
  hostname: '0.0.0.0',
  port: 4723,
  capabilities: {
    platformName: 'Android',
    app: path.join(path.dirname(new globalThis.URL(import.meta.url).pathname), 'cashzine.apk'),
    connectionRetryCount: 10
  }
}

const client = await webdriverio.remote(opts)
await client.startRecordingScreen()
for (const _ of globalThis.Array(20).keys())
{
    console.log(await client.getCurrentActivity(), await client.getCurrentPackage())
    await new globalThis.Promise(_ => globalThis.setTimeout(_, 1000 * 10))
}
await fs.writeFile('haha.mp4', await client.stopRecordingScreen(), 'base64')
await client.deleteSession()
