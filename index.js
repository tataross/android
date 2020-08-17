import squared from 'squared'
const div = globalThis.document.createElement('div')
div.textContent = 'fuck you'
squared.parseDocument(div)
squared.saveToArchive()
squared.reset()
