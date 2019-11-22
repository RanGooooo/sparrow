var rango_list = window.rango_list || {};

rango_list.fixed = {
    "LEFT" : 'left',
    "RIGHT" : 'right'
};

var datas = {
    "column":[
        {
            "fieldName":"id",
            "title":"ID",
            "width": "150",
            "fixed":"left"
        },
        {
            "fieldName":"firstName",
            "title":"姓",
            "width": "500",
            "fixed":"right"
        },
        {
            "fieldName":"lastName",
            "title":"名",
            "width": "500"
        },
        {
            "fieldName":"age",
            "width": "500",
            "title":"年龄"
        },
        {
            "fieldName":"friend",
            "title":"friend1"
        },
        {
            "fieldName":"FRIEND_FIXED",
            "title":"friend1",
            "fixed":"left"
        },
        {
            "fieldName":"friend",
            "title":"friend1"
        },
        {
            "fieldName":"friend",
            "title":"friend1"
        },
        {
            "fieldName":"friend",
            "title":"friend1"
        },
        {
            "fieldName":"friend_END",
            "title":"friend1"
        }

    ],
    "result": [
        { "firstName":"Bill" , "age":"12", "lastName":"Gates","id":"100861008610086" },
        { "firstName":"George" , "lastName":"Bush","id":"10010" ,"age":"12" },
        { "firstName":"Thomas" , "lastName":"Carter","id":"12315" ,"age":"12" },
        { "firstName":"Bill" , "age":"12", "lastName":"Gates","id":"100861008610086" },
        { "firstName":"George" , "lastName":"Bush","id":"10010" ,"age":"12" },
        { "firstName":"Thomas" , "lastName":"Carter","id":"12315" ,"age":"12" },
        { "firstName":"Bill" , "age":"12", "lastName":"Gates","id":"100861008610086" },
        { "firstName":"George" , "lastName":"Bush","id":"10010" ,"age":"12" },
        { "firstName":"Thomas" , "lastName":"Carter","id":"12315" ,"age":"12" },
        { "firstName":"Bill" , "age":"12", "lastName":"Gates","id":"100861008610086" },
        { "firstName":"George" , "lastName":"Bush","id":"10010" ,"age":"12" },
        { "firstName":"Thomas666" , "lastName":"Carter","id":"12315" ,"age":"12" }
    ]
};
var column = datas.column;
var result = datas.result;
var centerWidth = 0;
rango_list.assembleColumn = function(){
    $(column).each(function(index,obj){
        var fieldName = obj.fieldName;
        var width = parseInt(obj.width);
        var fixed = obj.fixed;
        var str = '';
        if(!width){
            width= 100;
        }
        str += 'style="width:'+width+'px;"';
        if(fixed){
            if(rango_list.fixed.LEFT===fixed){
                $(".table-title-fixed-left").append('<div class="table-title" '+str+'>'+fieldName+'</div>');
            }
            if(rango_list.fixed.RIGHT===fixed){
                $(".table-title-fixed-right").append('<div class="table-title" '+str+'>'+fieldName+'</div>');
            }
        }else{
            centerWidth += width;
            $(".table-title-scroll-container").append('<div class="table-title" '+str+'>'+fieldName+'</div>');
        }
    });
    $(".table-title-scroll-container").css("width", (centerWidth)+ "px");
    $(".table-bottom-scroll-container").css("width", (centerWidth)+ "px");
    var leftWidth= $(".table-title-fixed-left").width();
    var rightWidth= $(".table-title-fixed-right").width();

    $(".table-title-scroll").css("margin-left", (leftWidth)+ "px");
    $(".table-title-scroll").css("margin-right", (rightWidth)+ "px");
    $(".table-bottom-scroll").css("margin-left", (leftWidth)+ "px");
    $(".table-bottom-scroll").css("margin-right", (rightWidth)+ "px");
    $(".table-content-container-center").css("margin-left", (leftWidth)+ "px");
    $(".table-content-container-center").css("margin-right", (rightWidth)+ "px");
}

rango_list.assembleResult = function(){
    $(result).each(function (index,obj) {
        var map = assembleRow(column,obj);
        $(".table-content-container-left").append('<div>'+map.rowLeftHtml+'</div>');
        $(".table-content-container-right").append('<div>'+map.rowRightHtml+'</div>');
        $(".table-content-container-center").append('<div class="table-content-container-center-container">'+map.rowCenterHtml+'</div>');
    });
    $(".table-content-container-center-container").css("width", (centerWidth)+ "px");
}



function assembleRow(columnList,row_obj){
    var rowLeftHtml = '';
    var rowRightHtml = '';
    var rowCenterHtml = '';
    $(columnList).each(function (index,column) {
        var fieldName = column.fieldName;
        var width = column.width;
        var fixed = column.fixed;
        var str = '';
        if(!width){
            width= 100;
        }
        str += 'style="width:'+width+'px;"';
        var value = getValue(row_obj,fieldName);
        if(fixed){
            if(rango_list.fixed.LEFT===fixed){
                rowLeftHtml +='<div class="table-title" '+str+'>'+value+'</div>';
            }
            if(rango_list.fixed.RIGHT===fixed){
                rowRightHtml +='<div class="table-title" '+str+'>'+value+'</div>';
            }
        }else {
            rowCenterHtml +='<div class="table-title" '+str+'>'+value+'</div>';
        }
    });
    var map = {};
    map.rowLeftHtml = rowLeftHtml;
    map.rowRightHtml = rowRightHtml;
    map.rowCenterHtml = rowCenterHtml;
    return map;
}


function getValue(obj,fieldName){
    for (var key in obj) {
        console.log("================>>>")
        if(key === fieldName){
            return obj[fieldName];
        }
    }
}

$(function(){
    rango_list.assembleColumn();
    rango_list.assembleResult();

    var height= $(".table-content-container-right").height();
    $(".table-right-scroll").height(height);
});