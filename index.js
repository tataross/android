import squared from 'squared'
const div = new globalThis.DOMParser().parseFromString('<div>fuck you</div>', 'text/html').body
squared.parseDocument(div)
squared.saveToArchive()
squared.reset()
