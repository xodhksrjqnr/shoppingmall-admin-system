const loadPath = new Map([
    ['기초상품 요소', ['product/element', 'input', 'input.js', 'element2.css']]
]);

function isNotEmpty(obj) {
    return !isEmpty(obj);
}

function isEmpty(obj) {
    return (obj === undefined || obj === null || obj.length === 0);
}

class LinkInfo {
    static #link = new Map([
        ['tagName', new Map([['js', 'script'], ['css', 'link']])],
        ['importLocation', new Map([['js', 'footer'], ['css', 'head']])]
    ]);

    static getLinkInfo(title, fileExtension) {
        return this.#link.get(title).get(fileExtension);
    }

    static getTagName(fileExtension) {
        return this.getLinkInfo('tagName', fileExtension);
    }

    static getImportLocation(fileExtension) {
        return this.getLinkInfo('importLocation', fileExtension);
    }
}

class Load {

    static loadFile(title) {
        const paths = loadPath.get(title);
        let main = Element.getFirst('main');

        main.innerHTML = '';
        fetch('page/' + paths[0] + '/' + paths[1])
            .then(res => res.text())
            .then(data => {
                this.#load(paths[0], paths[3], 'css');
                main.loadAndChangeHtml()
                main.innerHTML = data;
                this.#load(paths[0], paths[2], 'js');
            });
    }

    static #load(targetPath, fileName, fileExtension) {
        const path = '/static/' + fileExtension + '/' + targetPath + '/' + fileName;
        let elem = this.#findElem(path, LinkInfo.getTagName(fileExtension));

        if (isEmpty(elem)) {
            elem = (fileExtension === 'js' ? Element.createScript(path) : Element.createLink('stylesheet', path));
            Element.getFirst(LinkInfo.getImportLocation(fileExtension)).appendChild(elem);
        }

        if (fileExtension === 'js') {

        }
    }

    static #findElem(targetPath, type) {
        let attribute = (type === 'script' ? 'src' : 'href');
        let findElem;

        Element.getAll(type).forEach(elem => {
            if (elem.getAttribute(attribute) === targetPath) {
                findElem = elem;
            };
        });

        return findElem;
    }

    static getJsonData(url, func) {
        fetch(url)
            .then(rep => rep.json())
            .then(data => func(data));
    }
}

class Element {

    static setValueById(id, value) {
        this.getById(id).value = value;
    }

    static clearTextContentById(id) {
        this.setTextContentById(id, '');
    }

    static clearFirstTextContent(target) {
        this.setFirstTextContent(target, '');
    }

    static setTextContentById(id, value) {
        this.getById(id).textContent = value;
    }

    static setFirstTextContent(target, value) {
        this.getFirst(target).textContent = value;
    }

    static getById(id) {
        return document.getElementById(id);
    }

    static getFirst(target) {
        return document.querySelector(target);
    }

    static getAll(target) {
        return document.querySelectorAll(target);
    }

    static addClassById(id, value) {
        this.addClass(this.getById(id), value);
    }

    static addClass(element, value) {
        element.classList.add(value);
    }

    static removeClassById(id, value) {
        this.removeClass(this.getById(id), value);
    }

    static removeClass(element, value) {
        element.classList.remove(value);
    }

    static create(tagName) {
        return document.createElement(tagName);
    }

    static createScript(src) {
        const elem = this.create('script');

        elem.src = src;
        return elem;
    }

    static createLink(rel, href) {
        const elem = this.create('link');

        elem.rel = rel;
        elem.href = href;
        return elem;
    }
}

class EventListener {

    static addTheListener(target, func) {
        Element.getFirst(target).addEventListener('click', (evt) => func(evt));
    }

    static addListeners(target, func) {
        Element.getAll(target).forEach(elem => elem.addEventListener('click', (evt) => func(evt)));
    }
}