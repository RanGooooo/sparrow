var RanGoTable = window.RanGoTable || {};

RanGoTable.fixed = {
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
            "fixed":"right",
            "query":true
        },
        {
            "fieldName":"lastName",
            "title":"名",
            "width": "500",
            "query":true
        },
        {
            "fieldName":"age",
            "width": "500",
            "title":"年龄",
            "query":true
        },
        {
            "fieldName":"friend",
            "title":"friend1",
            "query":true
        },
        {
            "fieldName":"FRIEND_FIXED",
            "title":"friend1",
            "fixed":"left",
            "query":true
        },
        {
            "fieldName":"friend",
            "title":"friend1",
            "query":true
        },
        {
            "fieldName":"friend",
            "title":"friend1",
            "query":true
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


RanGoTable.init = function (datas) {
    RanGoTable.initHeadContainerHTML();
    RanGoTable.initSearchContainerHTML();
    RanGoTable.initTableContainerHTML();
    RanGoTable.initBottomContainerHTML();
    var column = datas.column;
    var result = datas.result;
    RanGoTable.assembleSearch(column);
    var centerWidth = RanGoTable.assembleColumn(column);
    RanGoTable.assembleResult(column,result);
    $("#tableTitleScrollContainer").css("width", (centerWidth)+ "px");
    $("#tableBottomScrollContainer").css("width", (centerWidth)+ "px");
    $(".table-content-container-center-container").css("width", (centerWidth)+ "px");
};

RanGoTable.initHeadContainerHTML = function () {
    var html = '';
    html += '<div id="headContainer" class="head-container">';
    html += '<table cellpadding="0" cellspacing="0" class="head-container-tool-table">';
    html += '<tr>';
    html += '<th>';
    html += '<i class="fa fa-chevron-down"></i>';
    html += '</th>';
    html += '</tr>';
    html += '</table>';
    html += '<table cellpadding="0" cellspacing="0" class="head-container-title-table">';
    html += '<tr>';
    html += '<th>';
    html += '<h3>RanGo Table Title</h3>';
    html += '</th>';
    html += '</tr>';
    html += '</table>';
    html += '</div>';
    $(".m").append(html);
};

RanGoTable.initSearchContainerHTML = function () {
    var html = '';
    html += '<div id="searchContainer" class="head-container">';
    html += '<table cellpadding="0" cellspacing="0" id="searchTableInput" class="head-container-search-table-input"></table>';
    html += '<table cellpadding="0" cellspacing="0" class="head-container-search-table-button">';
    html += '<tr>';
    html += '<th>';
    html += '<button>搜索</button>';
    html += '</th>';
    html += '<th>';
    html += '<button>重置</button>';
    html += '</th>';
    html += '</tr>';
    html += '</table>';
    html += '</div>';
    $(".m").append(html);
};

RanGoTable.initTableContainerHTML = function () {
    var html = '';
    html += '<div class="table-container">';
    html += '<div class="table-title-container">';
    html += '<div id="tableTitleFixedLeft" class="table-title-fixed-left"></div>';
    html += '<div id="tableTitleFixedRight" class="table-title-fixed-right"></div>';
    html += '<div id="tableTitleScroll" class="table-title-scroll">';
    html += '<div id="tableTitleScrollContainer" class="table-title-scroll-container"></div>';
    html += '</div>';
    html += '</div>';
    html += '<div class="table-content-container-mark">';
    html += '<div id="tableContentContainer" class="table-content-container">';
    html += '<div id="tableContentContainerLeft" class="table-content-container-left"></div>';
    html += '<div id="tableContentContainerRight" class="table-content-container-right"></div>';
    html += '<div id="tableContentContainerCenter" class="table-content-container-center"></div>';
    html += '</div>';
    html += '<div id="tableContentRightScrollMark" class="table-content-right-scroll-mark">';
    html += '<div id="tableContentRightScroll" class="table-content-right-scroll"></div>';
    html += '</div>';
    html += '</div>';
    html += '</div>';
    html += '<div class="table-bottom-scroll-mark">';
    html += '<div id="tableBottomScroll" class="table-bottom-scroll">';
    html += '<div id="tableBottomScrollContainer" class="table-bottom-scroll-container"></div>';
    html += '</div>';
    html += '</div>';
    $(".m").append(html);
};

RanGoTable.initBottomContainerHTML = function () {
    var html = '';
    html += '<div class="bottom-container">';
    html += '<table cellpadding="0" cellspacing="0" class="bottom-container-table">';
    html += '<tr>';
    html += '<th>';
    html += '<select class="pagination-page-list">';
    html += '<option>10</option>';
    html += '<option>20</option>';
    html += '<option>30</option>';
    html += '<option>40</option>';
    html += '<option>50</option>';
    html += '</select>';
    html += '</th>';
    html += '<th>';
    html += '<a class="bottom-btn">';
    html += '<i class="fa fa-step-backward"></i>';
    html += '</a>';
    html += '</th>';
    html += '<th>';
    html += '<a class="bottom-btn">';
    html += '<i class="fa fa-caret-left" style="font-size: 26px;"></i>';
    html += '</a>';
    html += '</th>';
    html += '<th>';
    html += '<input type="text" value="1" size="2" style="text-align: center;">';
    html += '</th>';
    html += '<th>';
    html += '<a class="bottom-btn">';
    html += '<i class="fa fa-caret-right" style="font-size: 26px;"></i>';
    html += '</a>';
    html += '</th>';
    html += '<th>';
    html += '<a class="bottom-btn">';
    html += '<i class="fa fa-step-forward"></i>';
    html += '</a>';
    html += '</th>';
    html += '<th>';
    html += '<a class="bottom-btn">';
    html += '<i class="fa fa-refresh"></i>';
    html += '</a>';
    html += '</th>';
    html += '</tr>';
    html += '</table>';
    html += '</div>';
    $(".m").append(html);
};

RanGoTable.assembleColumn = function(column){
    var centerWidth = 0;
    $(column).each(function(index,obj){
        var fieldName = obj.fieldName;
        var style = assembleStyle(obj);
        var fixed = obj.fixed;
        if(fixed){
            if(RanGoTable.fixed.LEFT===fixed){
                $("#tableTitleFixedLeft").append('<div class="table-title" style="'+style+'">'+fieldName+'</div>');
            }
            if(RanGoTable.fixed.RIGHT===fixed){
                $("#tableTitleFixedRight").append('<div class="table-title" style="'+style+'">'+fieldName+'</div>');
            }
        }else{
            var width = parseInt(obj.width);
            if(!width){
                width= 100;
            }
            centerWidth += width;
            $("#tableTitleScrollContainer").append('<div class="table-title" style="'+style+'">'+fieldName+'</div>');
        }
    });

    var leftWidth= $("#tableTitleFixedLeft").width();
    var rightWidth= $("#tableTitleFixedRight").width();
    $("#tableTitleScroll").css("margin-left", (leftWidth)+ "px");
    $("#tableTitleScroll").css("margin-right", (rightWidth)+ "px");
    $("#tableBottomScroll").css("margin-left", (leftWidth)+ "px");
    $("#tableBottomScroll").css("margin-right", (rightWidth)+ "px");
    $(".table-content-container-center").css("margin-left", (leftWidth)+ "px");
    $(".table-content-container-center").css("margin-right", (rightWidth)+ "px");
    return centerWidth;
};

RanGoTable.assembleSearch = function(column){
    var searchItemArr = [];
    var thHtml = '';
    var i = 0;
    $(column).each(function(index,obj){
        var query = obj.query;
        var fieldName = obj.fieldName;
        if(query){
            i++;
            thHtml +='<th>';
            thHtml += fieldName;
            thHtml +='</th>';
            thHtml +='<th>';
            thHtml += '<input type="text" value="">';
            thHtml +='</th>';
            if(i === 3){
                searchItemArr.push(thHtml);
            }
            if(i>3){
                thHtml = '';
                i = 0;
            }
        }
    });
    var tRHtml = '';
    var searchContainerHeight = 5;
    $(searchItemArr).each(function(index,obj){
        searchContainerHeight = searchContainerHeight + 30;
        tRHtml +='<tr>';
        tRHtml +=obj;
        tRHtml +='</tr>';
    });
    $("#searchContainer").css("height",searchContainerHeight + "px");
    $("#searchTableInput").append(tRHtml);
};


RanGoTable.assembleResult = function(column,result){
    $(result).each(function (index,obj) {
        var map = assembleRow(column,obj);
        $("#tableContentContainerLeft").append('<div>'+map.rowLeftHtml+'</div>');
        $("#tableContentContainerRight").append('<div>'+map.rowRightHtml+'</div>');
        $("#tableContentContainerCenter").append('<div class="table-content-container-center-container">'+map.rowCenterHtml+'</div>');
    });

};





function assembleRow(columnList,row_obj){
    var rowLeftHtml = '';
    var rowRightHtml = '';
    var rowCenterHtml = '';
    $(columnList).each(function (index,column) {
        var fieldName = column.fieldName;
        var fixed = column.fixed;
        var style = assembleStyle(column);
        var value = getValue(row_obj,fieldName);
        if(fixed){
            if(RanGoTable.fixed.LEFT===fixed){
                rowLeftHtml +='<div class="table-title" style="'+style+'">'+value+'</div>';
            }
            if(RanGoTable.fixed.RIGHT===fixed){
                rowRightHtml +='<div class="table-title" style="'+style+'">'+value+'</div>';
            }
        }else {
            rowCenterHtml +='<div class="table-title" style="'+style+'">'+value+'</div>';
        }
    });
    var map = {};
    map.rowLeftHtml = rowLeftHtml;
    map.rowRightHtml = rowRightHtml;
    map.rowCenterHtml = rowCenterHtml;
    return map;
}

function assembleStyle(obj){
    var style = "";
    var width = obj.width;
    if(!width){
        width= 100;
    }
    style += 'width:'+width+'px;';
    return style;
};

function getValue(obj,fieldName){
    for (var key in obj) {
        console.log("================>>>");
        if(key === fieldName){
            return obj[fieldName];
        }
    }
}

$(function(){
    RanGoTable.init(datas)

    var height= $("#tableContentContainerRight").height();
    $("#tableContentRightScroll").height(height);
    $("#tableBottomScroll").scroll(function () {
        $("#tableTitleScroll").scrollTop(this.scrollTop);
        $("#tableTitleScroll").scrollLeft(this.scrollLeft);
        $(".table-content-container-center").scrollTop(this.scrollTop);
        $(".table-content-container-center").scrollLeft(this.scrollLeft);
    });
    $("#tableContentRightScrollMark").scroll(function () {
        $(".table-content-container").scrollTop(this.scrollTop);
    });
});
