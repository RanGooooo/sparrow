var RanGoTable = window.RanGoTable || {};

RanGoTable.fixed = {
    "LEFT" : 'left',
    "RIGHT" : 'right'
};



RanGoTable.init = function (datas) {
	/*表格==》表头容器==》中间内容*/
    var TableTitleCenterId = "#tableTitleCenter";
	var TableTitleCenterContainerId = "#tableTitleCenterContainer";
	/*表格==》表头容器==》左边内容*/
    var TableTitleLeftId = "#tableTitleLeft";
    /*表格==》表头容器==》右边内容*/
    var TableTitleRightId = "#tableTitleRight";
    

    /*表格==》内容容器*/
    var TableContentContainerId = "#tableContentContainer";
	/*表格==》内容容器==》右边滚动条*/
	var TableContentContainerRightScrollMarkId = "#tableContentContainerRightScrollMark";
	var TableContentContainerRightScrollId = "#tableContentContainerRightScroll";
    /*表格==》内容容器==》中间内容*/
    var TableContentCenterId = "#tableContentCenter";


	/*表 BOTTOM*/
    var TableBottomScrollId = "#tableBottomScroll";
    var TableBottomScrollContainerId = "#tableBottomScrollContainer";

    RanGoTable.initHeadHTML();
    RanGoTable.initSearchHTML();
    RanGoTable.initTableHTML();
    RanGoTable.initBottomHTML();
    var column = datas.column;
    var result = datas.result;
    RanGoTable.assembleSearch(column);
    var centerWidth = RanGoTable.assembleColumn({
		column: column,
        TableTitleLeft : $(TableTitleLeftId),
        TableTitleRight : $(TableTitleRightId),
        TableTitleCenterContainer : $(TableTitleCenterContainerId),
        TableTitleCenter : $(TableTitleCenterId),
        TableBottomScroll : $(TableBottomScrollId)
    });

    var leftWidth = $(TableTitleLeftId).width();
    var rightWidth = $(TableTitleRightId).width();

    $(TableTitleCenterId).css("margin-left", (leftWidth)+ "px");
    $(TableTitleCenterId).css("margin-right", (rightWidth)+ "px");
    $(TableBottomScrollId).css("margin-left", (leftWidth)+ "px");
    $(TableBottomScrollId).css("margin-right", (rightWidth)+ "px");
    $(TableContentCenterId).css("margin-left", (leftWidth)+ "px");
    $(TableContentCenterId).css("margin-right", (rightWidth)+ "px");

    RanGoTable.assembleResult(column,result);
    $(TableTitleCenterContainerId).css("width", (centerWidth)+ "px");
    $(TableBottomScrollContainerId).css("width", (centerWidth)+ "px");
    $(TableContentCenterId + " .table-content-container-center-container").css("width", (centerWidth)+ "px");

    

    $(TableBottomScrollId).scroll(function () {
        $(TableTitleCenterId).scrollTop(this.scrollTop);
        $(TableTitleCenterId).scrollLeft(this.scrollLeft);
        $(TableContentCenterId).scrollTop(this.scrollTop);
        $(TableContentCenterId).scrollLeft(this.scrollLeft);
    });
    
    var height= $(TableContentCenterId).height();
    $(TableContentContainerRightScrollId).height(height);
    $(TableContentContainerRightScrollMarkId).scroll(function () {
        $(TableContentContainerId).scrollTop(this.scrollTop);
    });
};

RanGoTable.initHeadHTML = function () {
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

RanGoTable.initSearchHTML = function () {
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

RanGoTable.initTableHTML = function () {
    var html = '';
    html += '<div class="table-container">';
    html += '<div class="table-title-container">';
    html += '<div id="tableTitleLeft" class="table-title-fixed-left"></div>';
    html += '<div id="tableTitleRight" class="table-title-fixed-right"></div>';
    html += '<div id="tableTitleCenter" class="table-title-scroll">';
    html += '<div id="tableTitleCenterContainer" class="table-title-scroll-container"></div>';
    html += '</div>';
    html += '</div>';
    html += '<div class="table-content-container-mark">';
    html += '<div id="tableContentContainer" class="table-content-container">';
    html += '<div id="tableContentLeft" class="table-content-container-left"></div>';
    html += '<div id="tableContentRight" class="table-content-container-right"></div>';
    html += '<div id="tableContentCenter" class="table-content-container-center"></div>';
    html += '</div>';
    html += '<div id="tableContentContainerRightScrollMark" class="table-content-container-right-scroll-mark">';
    html += '<div id="tableContentContainerRightScroll" class="table-content-container-right-scroll"></div>';
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

RanGoTable.initBottomHTML = function () {
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


RanGoTable.assembleColumn = function(param){
    var column = param.column;
    var TableTitleLeft = param.TableTitleLeft;
    var TableTitleRight = param.TableTitleRight;
    var TableTitleCenterContainer = param.TableTitleCenterContainer;
    var TableTitleCenter = param.TableTitleCenter;
    var TableBottomScroll = param.TableBottomScroll;
    var centerWidth = 0;
    $(column).each(function(index,obj){
        var fieldName = obj.fieldName;
        var style = assembleStyle(obj);
        var fixed = obj.fixed;
        if(fixed){
            if(RanGoTable.fixed.LEFT===fixed){
                TableTitleLeft.append(RanGoTable.getCell(style,fieldName));
            }
            if(RanGoTable.fixed.RIGHT===fixed){
                TableTitleRight.append(RanGoTable.getCell(style,fieldName));
            }
        }else{
            var width = parseInt(obj.width);
            if(!width){
                width= 100;
            }
            centerWidth += width;
            TableTitleCenterContainer.append(RanGoTable.getCell(style,fieldName));
        }
    });
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
        $("#tableContentLeft").append('<div>'+map.rowLeftHtml+'</div>');
        $("#tableContentRight").append('<div>'+map.rowRightHtml+'</div>');
        $("#tableContentCenter").append('<div class="table-content-container-center-container">'+map.rowCenterHtml+'</div>');
    });

};

RanGoTable.getCell = function(style,cellValue){
    var html = '<div class="table-cell" style="'+style+'">'+cellValue+'</div>';
    return html;
}



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
                rowLeftHtml +=RanGoTable.getCell(style,value);
            }
            if(RanGoTable.fixed.RIGHT===fixed){
                rowRightHtml +=RanGoTable.getCell(style,value);
            }
        }else {
            rowCenterHtml +=RanGoTable.getCell(style,value);
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