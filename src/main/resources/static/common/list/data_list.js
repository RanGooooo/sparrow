var list = window.list || {};

var datas = {
    "column":[
        {
            "field_name":"id",
            "title":"ID",
            "width": "15px",
            "fixed":"left"
        },
        {
            "field_name":"firstName",
            "title":"姓",
            "width": "25px",
            "fixed":"right"
        },
        {
            "field_name":"lastName",
            "title":"名",
            "width": "500px"
        },
        {
            "field_name":"age",
            "title":"年龄"
        },
        {
            "field_name":"friend",
            "title":"friend1"
        },
        {
            "field_name":"friend",
            "title":"friend1"
        },
        {
            "field_name":"friend",
            "title":"friend1"
        },
        {
            "field_name":"friend",
            "title":"friend1"
        },
        {
            "field_name":"friend",
            "title":"friend1"
        },
        {
            "field_name":"friend",
            "title":"friend1"
        }

    ],
    "result": [
        { "firstName":"Bill" , "age":"12", "lastName":"Gates","id":"100861008610086" },
        { "firstName":"George" , "lastName":"Bush","id":"10010" ,"age":"12" },
        { "firstName":"Thomas" , "lastName":"Carter","id":"12315" ,"age":"12" }
    ]
};


/*
var column = datas.column;
var columnNameRowHtml = list.assembleColumnName(column);
*/


$(function () {
    showbody();
});

function showbody(){
    var column = datas.column;
    $(column).each(function(index,obj){
    <div class="table-title">字段名称1</div>
            <div class="table-title">字段名称2</div>
    });
}