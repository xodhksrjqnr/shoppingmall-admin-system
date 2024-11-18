const loadPath = new Map([
    ['기초상품 요소', ['product/element', 'input', 'input.js', 'element2.css']]
]);

function isNotEmpty(obj) {
    return !isEmpty(obj);
}

function isEmpty(obj) {
    return (obj === undefined || obj === null || obj.length === 0);
}

function redirect(url) {
    location.href = url;
}

function reload(url) {
    window.location.reload();
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

class EventListener {

    static addTheListener(target, func) {
        Element.getFirst(target).addEventListener('click', (evt) => func(evt));
    }

    static addListeners(target, func) {
        Element.getAll(target).forEach(elem => elem.addEventListener('click', (evt) => func(evt)));
    }
}

class Form {

    constructor(form) {
        this.form = form;
    }

    /**
     * @param filterArrayData
     * @param targetId
     * type : Map
     * input example :
     * [
     *      {
     *          tag : value (required)
     *          elements : values (required)
     *          attributes : {
     *              type : type,
     *              name : name,
     *              id : id,
     *              value : value,
     *              ...
     *          }
     *          size : value
     *      }
     * ]
     */
    addTableForm(json) {
        const table = Element.create('table');

        json.objects.forEach(elem => {
            const tr = Element.create('tr');
            const td = Element.create('td');
            const th = Element.create('th');

            th.innerText = elem.title;
            switch (elem.tag) {
                case 'checkbox':
                    td.appendChild(Element.createTypeInput(elem.attributes, elem.elements));
                    break;
                case 'radio':
                    td.appendChild(Element.createTypeInput(elem.attributes, elem.elements));
                    break;
                case 'input':
                    td.appendChild(Element.createInput(elem.attributes));
                    break;
                case 'select':
                    td.appendChild(Element.createSelect(elem.attributes, elem.elements));
                    break;
                default:
                    break;
            }
            tr.appendChild(th);
            tr.appendChild(td);
            table.appendChild(tr);
        })

        this.form.prepend(table);
    }

    getQueryParameters() {
        let queryParameter = '';

        new FormData(this.form).forEach((value, key) => {
            if (isNotEmpty(value)) {
                queryParameter += key + '=' + value + '&';
            }
        });

        return queryParameter.length > 1 ? '?' + queryParameter : '';
    }

    submitInJson() {
        let object = {};
        new FormData(this.form).forEach((value, key) => object[key] = value);

        Data.postJson(this.form, object);
    }

}

class Data {

    static getJson(url, func) {
        fetch(url, {
            method: "GET",
            headers: {'Accept': 'application/json'},
        })
            .then(rep => rep.json())
            .then(data => func(data))
            .catch(err => alert('데이터 조회에 실패하였습니다.'))
    }

    static async postJson(form, object) {
        await fetch(form.action, {
            method: "POST",
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(object)
        })
            .then(rep => {  })
            .catch(err => { alert('데이터 등록에 실패하였습니다.') })
    }

}

class TUI {

    #instance;
    resetData = (newData) => this.#instance.resetData(newData);

    constructor(gridId, columns) {
        this.#instance = new tui.Grid({
            el: document.getElementById(gridId),
            columns: columns,
            data: []
        });

        tui.Grid.applyTheme('striped');
    }

}