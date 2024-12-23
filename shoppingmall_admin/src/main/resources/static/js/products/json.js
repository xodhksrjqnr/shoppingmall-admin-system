const inputJson = {
    objects : [
        {
            title : '기초상품명',
            tag : 'input',
            attributes : {
                name : 'name'
            }
        },
        {
            title : '기초상품명(영문)',
            tag : 'input',
            attributes : {
                name : 'nameEng'
            }
        },
        {
            title : '기초상품코드',
            tag : 'input',
            attributes : {
                name : 'code'
            }
        },
        {
            title : '판매가',
            tag : 'input',
            attributes : {
                name : 'sellingPrice'
            }
        },
        {
            title : '원가',
            tag : 'input',
            attributes : {
                name : 'costPrice'
            }
        },
        {
            title : '재고',
            tag : 'input',
            attributes : {
                name : 'stock'
            }
        },
        {
            title : '브랜드',
            tag : 'input',
            attributes : {
                name : 'brand'
            }
        },
        {
            title : '원산지',
            tag : 'input',
            attributes : {
                name : 'placeOfOrigin'
            }
        },
    ]
};

const listJson = {
    objects : [
        {
            title : '기초상품명(한글/영문)',
            tag : 'input',
            elements : [],
            values : [],
            attributes : {
                name : 'name'
            }
        },
        {
            title : '기초상품코드',
            tag : 'input',
            elements : [],
            values : [],
            attributes : {
                name : 'code'
            }
        },
        {
            title : '기초상품 브랜드',
            tag : 'select',
            elements : ['', 'brand1','brand2','brand3','brand4','brand5'],
            attributes : {
                name : 'brand',
            }
        },
        // {
        //     tag : 'select',
        //     elements : ['option1','option2','option3','option4','option5'],
        //     attributes : {
        //         name : 'test3'
        //     }
        // },
        // {
        //     tag : 'radio',
        //     elements : ['radio1','radio2','radio3','radio4','radio5'],
        //     attributes : {
        //         name : 'test4',
        //         type : 'radio'
        //     }
        // }
    ]
};

const listTUIJson = [
    {
        header: 'Id',
        name: 'id'
    },
    {
        header: 'Name',
        name: 'name'
    },
    {
        header: 'NameEng',
        name: 'nameEng'
    },
    {
        header: 'Code',
        name: 'code'
    },
    {
        header: 'SellingPrice',
        name: 'sellingPrice'
    },
    {
        header: 'CostPrice',
        name: 'costPrice'
    },
    {
        header: 'Stock',
        name: 'stock'
    },
    {
        header: 'Brand',
        name: 'brand'
    },
    {
        header: 'PlaceOfOrigin',
        name: 'placeOfOrigin'
    },
    {
        header: 'CreatedDate',
        name: 'createdDate'
    }
]