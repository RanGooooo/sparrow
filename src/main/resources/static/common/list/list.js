var list = window.list || {};

var datas = {
    "column":[
        {
            "field_name":"id",
            "title":"ID",
            "width": "15px",
            "fixed":"right"
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
        }

    ],
    "result": [
        { "firstName":"Bill" , "age":"12", "lastName":"Gates","id":"100861008610086" },
        { "firstName":"George" , "lastName":"Bush","id":"10010" ,"age":"12" },
        { "firstName":"Thomas" , "lastName":"Carter","id":"12315" ,"age":"12" }
    ]
};


list.assembleColumnName = function(column){
    var html = '';
    html +='<div class="list-row">';
    html +='<div class="run-tab">';
    html +='<ul class="run-tab-title">';
    $(column).each(function (index,obj) {
        var fixed = obj.fixed;
        if(!fixed){
            var str = '';
            var width = obj.width;
            if(width){
                str += 'style="width:'+width+';"';
            }
            html +='<li class="run-tab-item"><cite '+str+'>'+obj.title+'</cite></li>';
        }
    });
    html +='</ul>';



    html +='<div style="position: fixed;left: 35px;height: 35px;border: 1px red solid;">';
    html +='<div class="run-tab-item-span" onclick="left_move();"><<</div>';
    $(column).each(function (index,obj) {
        var fixed = obj.fixed;
        if(fixed){
            var str = '';
            var width = obj.width;
            if(width){
                str += 'style="width:'+width+';"';
            }
            html +='<div class="run-tab-item-span" '+str+'>'+obj.title+'</div>';
        }
    });

    html +='</div>';
    html +='<div class="run-tab-btn run-tab-next" onclick="right_move();">>></div>';

    html +='</div>';
    html +='</div>';
    return html;
};

list.setRow = function(index,obj){
    var html = '';
    html +='<div class="list-row" row_id="'+index+'">';
    html +='<div class="run-tab">';
    html +='<ul class="run-tab-title" id="row_ul_'+index+'">';
    html +='</ul>';
    html +='<div style="position: fixed;left: 35px;height: 35px;border: 1px red solid;" id="row_div_'+index+'" >';

    html +='<div class="run-tab-item-span"">'+index+'</div>';
    html +='</div>';
    html +='<div class="run-tab-btn run-tab-next" onclick="right_move();">>></div>';
    html +='</div>';
    html +='</div>';
    return html;
};


function assembleRowItem(columnList,row_obj){
    var rowdivitemhtml = '';
    var rowulitemhtml = '';
    $(columnList).each(function (index,column) {
        var field_name = column.field_name;
        var width = column.width;
        var fixed = column.fixed;
        var str = '';
        if(width){
            str += 'style="width:'+width+';"';
        }
        var value = getValue(row_obj,field_name);
        if(fixed){
            rowdivitemhtml +='<div class="run-tab-item-span" '+str+'>'+value+'</div>';
        }else {
            rowulitemhtml +='<li class="run-tab-item"><cite '+str+'>'+value+'</cite></li>';
        }

    });
    var map = {};
    map.rowdivitemhtml = rowdivitemhtml;
    map.rowulitemhtml = rowulitemhtml;
    return map;
}


function getValue(obj,field_name){
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
        var map = assembleRowItem(column,obj);

        $("#row_div_" + index).append(map.rowdivitemhtml);
        $("#row_ul_" + index).append(map.rowulitemhtml);

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
    $(".run-tab-title").css("left",(parseInt(num) + 50) + "px");
}