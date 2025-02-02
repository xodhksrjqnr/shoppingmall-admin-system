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

class EventListener {

    static addTheListener(target, func) {
        // Element.getFirst(target).addEventListener('click', (evt) => func(evt));
    }

    static addListeners(target, func) {
        // Element.getAll(target).forEach(elem => elem.addEventListener('click', (evt) => func(evt)));
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
        this.form.prepend(Creator.table(json));
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

class Creator {

    static table(json) {
        const table = ElementTW.create({tag:'table'});

        json.objects.forEach(elem => {
            const tr = ElementTW.create({tag:'tr', attributes: (elem.attributes.hidden === '' ? {hidden: ''} : {})});
            const td = ElementTW.create({tag:'td'});
            const th = ElementTW.create({tag:'th', text:elem.title});

            td.append(ElementTW.create(elem).toElement());
            tr.append(th.toElement());
            tr.append(td.toElement());
            table.append(tr.toElement());
        })

        return table.toElement();
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

    static async postJson(form, object, func) {
        if (this.completeRequired(object)) {
            await fetch(form.action, {
                method: "POST",
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(object)
            })
                .then(rep => func())
                .catch(err => {console.log(err); alert('데이터 등록에 실패하였습니다.')})
        }
    }

    static completeRequired(object) {
        for (const key in object) {
            const target = document.getElementById(key);

            if (isNotEmpty(target) && target.getAttribute('required') === '' && isEmpty(object[key])) {
                target.focus();
                return false;
            }
        }
        return true;
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