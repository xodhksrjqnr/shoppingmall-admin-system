const inputJson = {
    objects : [
        {title : '기초상품명', tag : 'input', attributes : {id : 'name', name : 'name', required : ''}},
        {title : '기초상품명(영문)', tag : 'input', attributes : {id : 'nameEng', name : 'nameEng', required : ''}},
        {title : '기초상품코드', tag : 'select', attributes : {id : 'code', name : 'code', required : ''}},
        {title : '기초상품코드id', tag : 'select', attributes : {id : 'codeId', name : 'codeId', required : '', hidden : ''}},
        {title : '판매가', tag : 'input', attributes : {id : 'sellingPrice', name : 'sellingPrice', required : ''}},
        {title : '원가', tag : 'input', attributes : {id : 'costPrice', name : 'costPrice', required : ''}},
        {title : '재고', tag : 'input', attributes : {id : 'stock', name : 'stock', required : ''}},
        {title : '브랜드', tag : 'select', attributes : {id : 'brand', name : 'brand', required : ''}},
        {title : '원산지', tag : 'input', attributes : {id : 'placeOfOrigin', name : 'placeOfOrigin', required : ''}},
        {title : '상품 이미지', tag : 'input', attributes : {type : 'file', id : 'images', name : 'images', accept : 'image/*', multiple : '', required : ''}},
    ]
};

const viewJson = {
    objects : [
        {title : '기초상품명', tag : 'span', attributes : {id : 'name'}},
        {title : '기초상품명(영문)', tag : 'span', attributes : {id : 'nameEng'}},
        {title : '기초상품코드', tag : 'span', attributes : {id : 'code'}},
        {title : '판매가', tag : 'span', attributes : {id : 'sellingPrice'}},
        {title : '원가', tag : 'span', attributes : {id : 'costPrice'}},
        {title : '재고', tag : 'span', attributes : {id : 'stock'}},
        {title : '브랜드', tag : 'span', attributes : {id : 'brand'}},
        {title : '원산지', tag : 'span', attributes : {id : 'placeOfOrigin'}},
        {title : '상품 이미지', tag : 'div', attributes : {id : 'image'}},
    ]
};

const listJson = {
    objects : [
        {title : '상품명(한글/영문)', tag : 'input', attributes : {name : 'name'}},
        {title : '기초상품코드', tag : 'input', attributes : {name : 'code'}},
        {title : '브랜드', tag : 'div', attributes : {id : 'brand', name : 'brand'}}
    ]
};

const listTUIJson = [
    {header: 'Id', name: 'id'},
    {header: 'Name', name: 'name'},
    {header: 'NameEng', name: 'nameEng'},
    {header: 'Code', name: 'code'},
    {header: 'SellingPrice', name: 'sellingPrice'},
    {header: 'CostPrice', name: 'costPrice'},
    {header: 'Stock', name: 'stock'},
    {header: 'Brand', name: 'brand'},
    {header: 'PlaceOfOrigin', name: 'placeOfOrigin'},
    {header: 'CreatedDate', name: 'createdDate'}
]