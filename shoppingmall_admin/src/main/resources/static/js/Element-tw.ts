class ElementTW {

    private readonly element : Element

    constructor(element) {
        this.element = element;
    }

    static create(tagInfoJson) {
        const createdTag = new ElementTW(document.createElement(tagInfoJson.tag));

        createdTag.setAttributes(tagInfoJson.attributes);
        createdTag.setTextContent(tagInfoJson.text);
        createdTag.setElements(tagInfoJson.elements);
        return createdTag;
    }

    static get(id) {
        return new ElementTW(document.getElementById(id));
    }

    toElement() {
        return this.element;
    }

    setAttributes(json) {
        if (!(json === undefined || json === null || json.length === 0)) {
            for (const key in json) {
                this.element.setAttribute(key, json[key]);
            }
        }
        return this;
    }

    setTextContent(text) {
        if (!(text === undefined)) {
            this.element.textContent = text;
        }
        return this;
    }

    setElements(json) {
        if (!(json === undefined || json === null || json.length === 0)) {
            json.forEach(element => this.element.append(ElementTW.create(element).toElement()));
        }
    }

    removeAttributes(json) {
        if (!(json === undefined || json === null || json.length === 0)) {
            for (const key in json) {
                if (json[key] === '' || json[key] !== 'class') {
                    this.element.removeAttribute(key);
                } else {
                    this.element.classList.remove(json[key]);
                }
            }
        }
        return this;
    }

    append(element) {
        this.element.append(element);
        return this;
    }
}