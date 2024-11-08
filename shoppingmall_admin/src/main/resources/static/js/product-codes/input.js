const url = "/api/product-codes/sub?parentId=";
const groupIndexArray = ['A', 'B', 'C', 'D', 'E', 'F'];
let selectedGroupIndex = 'A';

Load.getJsonData(url + '0', appendChildElementById);

EventListener.addListeners('article > div > ul', function (evt) {
    let target = evt.target;

    resetSubData(target.parentElement.id.split('_')[1], target.id);
    Load.getJsonData(url + target.id, appendChildElementById);
    clearSelect(target.parentElement.id);
    Element.addClass(target, 'selected');
});

EventListener.addListeners('article > div > button', function (evt) {
    let target = evt.target;

    Element.setValueById('group_index', target.id.split('_')[1]);
    Element.setValueById('parent_id', target.value);
});

EventListener.addTheListener('form > button', function (evt) {
    let form = evt.target.parentElement;

    fetch('/api/products-codes', {
        method: "POST",
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            groupIndex: form.groupIndex.value,
            name: form.name.value,
            parentId: form.parentId.value
        })});
});

function appendChildElementById(productElements) {
    const elements = productElements['groupList'][selectedGroupIndex];

    if (isNotEmpty(elements)) {
        const parentElement = Element.getById('element_' + elements[0]['groupIndex']);

        elements.forEach(elem => {
            parentElement.innerHTML += '<li class="no-style" id="' + elem.id + '">' + elem.name + '</li>';
        });
    }

    if (selectedGroupIndex !== 'F') {
        Element.addClassById('button_' + selectedGroupIndex, 'selected');
    }
}

function resetSubData(groupIndex, parentId) {
    let needClear = false;

    for (let i = 0; i < groupIndexArray.length - 1; i++) {
        if (needClear) {
            Element.clearTextContentById('element_' + groupIndexArray[i]);
            Element.removeClassById('button_' + groupIndexArray[i], 'selected');
            Element.setValueById('button_' + groupIndexArray[i], parentId);
            parentId = '';
        }

        needClear = (groupIndex === groupIndexArray[i]) || needClear;

        if (groupIndexArray[i] === groupIndex) {
            selectedGroupIndex = groupIndexArray[i + 1];
        }
    }
}

function clearSelect(group) {
    Array.from(Element.getById(group).children).forEach(li => Element.removeClass(li, 'selected'));
}