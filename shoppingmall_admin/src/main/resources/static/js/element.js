class Element {

    static setAttributes(target, json) {
        if (isEmpty(json)) {
            return;
        }

        for (const key in json) {
            target.setAttribute(key, json[key]);
        }
    }

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

    static create(tagName, attributes) {
        const elem = document.createElement(tagName);

        this.setAttributes(elem, attributes);

        return elem;
    }

    static createInput(attributes) {
        return this.create('input', attributes);
    }

    static createSelect(attributes, elements) {
        const select = this.create('select', attributes);

        elements.forEach(elem => {
            const option = this.create('option', { value : elem });

            option.innerText = elem;
            select.appendChild(option);
        });

        return select;
    }

    static createTypeInput(attributes, elements) {
        const div = this.create('div');

        elements.forEach(elem => {
            const label = this.create('label', { for : elem });

            label.innerText = elem;
            div.appendChild(this.create('input', attributes));
            div.appendChild(label);
        });

        return div;
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

    static appendById(id, element) {
        this.getById(id).appendChild(element);
    }
}