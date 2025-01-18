var ElementTW = /** @class */ (function () {
    function ElementTW(element) {
        this.element = element;
    }
    ElementTW.create = function (tagInfoJson) {
        var createdTag = new ElementTW(document.createElement(tagInfoJson.tag));
        createdTag.setAttributes(tagInfoJson.attributes);
        createdTag.setTextContent(tagInfoJson.text);
        createdTag.setElements(tagInfoJson.elements);
        return createdTag;
    };
    ElementTW.get = function (id) {
        return new ElementTW(document.getElementById(id));
    };
    ElementTW.prototype.toElement = function () {
        return this.element;
    };
    ElementTW.prototype.setAttributes = function (json) {
        if (!(json === undefined || json === null || json.length === 0)) {
            for (var key in json) {
                this.element.setAttribute(key, json[key]);
            }
        }
        return this;
    };
    ElementTW.prototype.setTextContent = function (text) {
        if (!(text === undefined)) {
            this.element.textContent = text;
        }
        return this;
    };
    ElementTW.prototype.setElements = function (json) {
        var _this = this;
        if (!(json === undefined || json === null || json.length === 0)) {
            json.forEach(function (element) { return _this.element.append(ElementTW.create(element).toElement()); });
        }
    };
    ElementTW.prototype.removeAttributes = function (json) {
        if (!(json === undefined || json === null || json.length === 0)) {
            for (var key in json) {
                if (json[key] === '' || json[key] !== 'class') {
                    this.element.removeAttribute(key);
                }
                else {
                    this.element.classList.remove(json[key]);
                }
            }
        }
        return this;
    };
    ElementTW.prototype.append = function (element) {
        this.element.append(element);
        return this;
    };
    return ElementTW;
}());
