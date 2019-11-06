var list = window.list || {};

var datas = {
    "column":[
        {
            "field_name":"id",
            "title":"ID",
            "width": "15px"
        },
        {
            "field_name":"firstName",
            "title":"姓"
        },
        {
            "field_name":"lastName",
            "title":"名"
        },
        {
            "field_name":"age",
            "title":"年龄"
        }

    ],
    "result": [
        { "firstName":"Bill" , "age":"12", "lastName":"Gates","id":"10086" },
        { "firstName":"George" , "lastName":"Bush","id":"10010" ,"age":"12" },
        { "firstName":"Thomas" , "lastName":"Carter","id":"12315" ,"age":"12" }
    ]
};


list.assembleColumnName = function(column){
    var html = '';
    html +='<div class="list-row">';
    html +='<div class="run-tab">';
    html +='<ul class="run-tab-title" style="left: -35px;">';
    $(column).each(function (index,obj) {
        var str = '';
        var width = obj.width;
        if(width){
            str += 'style="width:'+width+';"';
        }
        html +='<li class="run-tab-item"><cite '+str+'>'+obj.title+'</cite></li>';
    });
    html +='</ul>';
    html +='<div class="run-tab-btn run-tab-prev" onclick="left_move();"><<</div>';
    html +='<div class="run-tab-btn run-tab-next" onclick="right_move();">>></div>';
    html +='</div>';
    html +='</div>';
    return html;
};

list.setRow = function(index,obj){
    var html = '';
    html +='<div class="list-row" row_id="'+index+'">';
    html +='<div class="run-tab">';
    html +='<ul class="run-tab-title" style="left:-35px;" id="row_ul_'+index+'">';
    html +='</ul>';
    html +='<div class="run-tab-btn run-tab-prev" onclick="left_move();">'+index+'</div>';
    html +='<div class="run-tab-btn run-tab-next" onclick="right_move();">>></div>';
    html +='</div>';
    html +='</div>';
    return html;
};


function assembleRowItem(columnList,row_obj){
    var html = '';
    $(columnList).each(function (index,column) {
        var field_name = column.field_name;
        var value = getValue(row_obj,field_name);
        html +='<li class="run-tab-item"><cite>'+value+'</cite></li>';
    });
    return html;
}

function getValue(obj,field_name){
    debugger;
    for (var key in obj) {
        console.log("================>>>")
        if(key === field_name){
            return obj[field_name];
        }
    }
}

function showbody() {


    var column = datas.column;
    var columnNameRowHtml = list.assembleColumnName(column);
    $('.list-head').append(columnNameRowHtml);
    var result = datas.result;
    var rowListHtml = '';
    $(result).each(function (index,obj) {
        rowListHtml += list.setRow(index,obj);
    });
    $('.list-body').append(rowListHtml);

    $(result).each(function (index,obj) {
        $("#row_ul_" + index).append(assembleRowItem(column,obj));
    });


}
function getRow(index){

}

function getColumnNum(key) {
    
}

$(function () {
    showbody();
});


function left_move(){
    var px = $(".run-tab-title").css("left");
    var num = px.replace("px","");
    $(".run-tab-title").css("left",(parseInt(num) - 50) + "px");
}
function right_move(){
    var px = $(".run-tab-title").css("left");
    var num = px.replace("px","");
    if(num < 35){
        $(".run-tab-title").css("left",(parseInt(num) + 50) + "px");
    }
}