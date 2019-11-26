var RanGoTable = window.RanGoTable || {};
var RanGoTableInner = window.RanGoTableInner || {};

RanGoTable.fixed = {
    "LEFT" : 'left',
    "RIGHT" : 'right'
};



RanGoTable.init = function (datas) {
    /*查询==> 容器*/
    var SearchContainerId = "#searchContainer";
    /*查询==> input容器*/
    var SearchTableInputId = "#searchTableInput";
    
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
	var TableContentContainerRightScrollBarId = "#tableContentContainerRightScrollBar";
    /*表格==》内容容器==》中间内容*/
    var TableContentCenterId = "#tableContentCenter";
	/*表格==》内容容器==》左边内容*/
    var TableContentLeftId = "#tableContentLeft";
	/*表格==》内容容器==》右边内容*/
    var TableContentRightId = "#tableContentRight";
	/*表格==》底部容器==》底部滚动条*/
    var TableBottomScrollMarkId = "#tableBottomScrollMark";
    var TableBottomScrollBarId = "#tableBottomScrollBar";
    var settings = datas.settings;

    RanGoTableInner.initHeadHTML(settings);
    RanGoTableInner.initSearchHTML();
    RanGoTableInner.initTableHTML();
    RanGoTableInner.initBottomHTML();
    var column = datas.column;
    var result = datas.result;
    RanGoTableInner.assembleSearch({
        column: column,
        SearchContainer: $(SearchContainerId),
        SearchTableInput: $(SearchTableInputId)
    });
    var centerWidth = RanGoTableInner.assembleColumn({
		column: column,
        TableTitleLeft : $(TableTitleLeftId),
        TableTitleRight : $(TableTitleRightId),
        TableTitleCenterContainer : $(TableTitleCenterContainerId)
    });
    RanGoTableInner.assembleResult({
    	column: column,
    	result: result,
    	TableContentLeft: $(TableContentLeftId),
    	TableContentRight: $(TableContentRightId),
    	TableContentCenter: $(TableContentCenterId)
    });

    RanGoTableInner.setCenterWidth(centerWidth,[
		$(TableTitleCenterContainerId),
		$(TableBottomScrollBarId),
		$(TableContentCenterId + " .table-content-center-container")
    ]);
  

    var leftWidth = $(TableTitleLeftId).width();
    var rightWidth = $(TableTitleRightId).width();

    RanGoTableInner.setMargin(leftWidth,rightWidth,[
		$(TableTitleCenterId),
		$(TableBottomScrollMarkId),
		$(TableContentCenterId)
    ]);

    

    $(TableBottomScrollMarkId).scroll(function () {
        $(TableTitleCenterId).scrollLeft(this.scrollLeft);
        $(TableContentCenterId).scrollLeft(this.scrollLeft);
    });
    
    var height= $(TableContentCenterId).height();
    $(TableContentContainerRightScrollBarId).height(height);
    $(TableContentContainerRightScrollMarkId).scroll(function () {
        $(TableContentContainerId).scrollTop(this.scrollTop);
    });
};

RanGoTableInner.initHeadHTML = function (settings) {
    var html = '';
    html += '<div id="headContainer" class="head-container">';
    html += '    <table cellpadding="0" cellspacing="0" class="head-container-tool-table">';
    html += '        <tr>';
    html += '            <th>';
    html += '                <i class="fa fa-chevron-down"></i>';
    html += '            </th>';
    html += '        </tr>';
    html += '    </table>';
    html += '    <table cellpadding="0" cellspacing="0" class="head-container-title-table">';
    html += '        <tr>';
    html += '            <th>';
    html += '                <h3>'+settings.title+'</h3>';
    html += '            </th>';
    html += '        </tr>';
    html += '    </table>';
    html += '</div>';
    $(".m").append(html);
};

RanGoTableInner.initSearchHTML = function () {
    var html = '';
    html += '<div id="searchContainer" class="search-container">';
    html += '    <table cellpadding="0" cellspacing="0" id="searchTableInput" class="search-table-input"></table>';
    html += '    <table cellpadding="0" cellspacing="0" class="search-table-button">';
    html += '        <tr>';
    html += '            <th>';
    html += '                <button>搜索</button>';
    html += '            </th>';
    html += '            <th>';
    html += '                <button>重置</button>';
    html += '            </th>';
    html += '        </tr>';
    html += '    </table>';
    html += '</div>';
    $(".m").append(html);
};

RanGoTableInner.initTableHTML = function () {
    var html = '';
    html += '<div class="table-container">';
    html += '	<div class="table-title-container">';
    html += '		<div id="tableTitleLeft" class="table-title-left"></div>';
    html += '		<div id="tableTitleRight" class="table-title-right"></div>';
    html += '		<div id="tableTitleCenter" class="table-title-center">';
    html += '			<div id="tableTitleCenterContainer" class="table-title-center-container"></div>';
    html += '		</div>';
    html += '	</div>';
    html += '	<div id="tableContentContainer" class="table-content-container">';
    html += '		<div id="tableContentLeft" class="table-content-left"></div>';
    html += '		<div id="tableContentRight" class="table-content-right"></div>';
    html += '		<div id="tableContentCenter" class="table-content-center"></div>';
    html += '	</div>';
    html += '	<div id="tableContentContainerRightScrollMark" class="table-content-container-right-scroll-mark">';
    html += '		<div id="tableContentContainerRightScrollBar" class="table-content-container-right-scroll-bar"></div>';
    html += '	</div>';
    html += '</div>';
    html += '<div class="table-bottom-container">';
    html += '	<div id="tableBottomScrollMark" class="table-bottom-scroll-mark">';
    html += '		<div id="tableBottomScrollBar" class="table-bottom-scroll-bar"></div>';
    html += '	</div>';
    html += '</div>';
    $(".m").append(html);
};

RanGoTableInner.initBottomHTML = function () {
    var html = '';
    html += '<div class="bottom-container">';
    html += '    <table cellpadding="0" cellspacing="0" class="bottom-container-table">';
    html += '        <tr>';
    html += '            <th>';
    html += '                <select class="pagination-page-list">';
    html += '                    <option>10</option>';
    html += '                    <option>20</option>';
    html += '                    <option>30</option>';
    html += '                    <option>40</option>';
    html += '                    <option>50</option>';
    html += '                </select>';
    html += '            </th>';
    html += '            <th>';
    html += '                <a class="bottom-btn">';
    html += '                    <i class="fa fa-step-backward"></i>';
    html += '                </a>';
    html += '            </th>';
    html += '            <th>';
    html += '                <a class="bottom-btn">';
    html += '                    <i class="fa fa-caret-left" style="font-size: 26px;"></i>';
    html += '                </a>';
    html += '            </th>';
    html += '            <th>';
    html += '                <input type="text" value="1" size="2" style="text-align: center;">';
    html += '            </th>';
    html += '            <th>';
    html += '                <a class="bottom-btn">';
    html += '                    <i class="fa fa-caret-right" style="font-size: 26px;"></i>';
    html += '                </a>';
    html += '            </th>';
    html += '            <th>';
    html += '                <a class="bottom-btn">';
    html += '                    <i class="fa fa-step-forward"></i>';
    html += '                </a>';
    html += '            </th>';
    html += '            <th>';
    html += '                <a class="bottom-btn">';
    html += '                    <i class="fa fa-refresh"></i>';
    html += '                </a>';
    html += '            </th>';
    html += '        </tr>';
    html += '    </table>';
    html += '</div>';
    $(".m").append(html);
};


RanGoTableInner.assembleColumn = function(param){
    var column = param.column;
    var TableTitleLeft = param.TableTitleLeft;
    var TableTitleRight = param.TableTitleRight;
    var TableTitleCenterContainer = param.TableTitleCenterContainer;
    var centerWidth = 0;
    $(column).each(function(index,obj){
        var fieldName = obj.fieldName;
        var style = RanGoTableInner.assembleStyle(obj);
        var fixed = obj.fixed;
        if(fixed){
            if(RanGoTable.fixed.LEFT===fixed){
                TableTitleLeft.append(RanGoTableInner.getCell(style,fieldName));
            }
            if(RanGoTable.fixed.RIGHT===fixed){
                TableTitleRight.append(RanGoTableInner.getCell(style,fieldName));
            }
        }else{
            var width = parseInt(obj.width);
            if(!width){
                width= 100;
            }
            centerWidth += width;
            TableTitleCenterContainer.append(RanGoTableInner.getCell(style,fieldName));
        }
    });
    return centerWidth;
};

RanGoTableInner.assembleResult = function(param){
	var column = param.column;
	var result = param.result;
	var TableContentLeft = param.TableContentLeft;
	var TableContentRight = param.TableContentRight;
	var TableContentCenter = param.TableContentCenter;
    $(result).each(function (index,obj) {
        var map = RanGoTableInner.assembleRow(column,obj);
        TableContentLeft.append('<div>'+map.rowLeftHtml+'</div>');
        TableContentRight.append('<div>'+map.rowRightHtml+'</div>');
        TableContentCenter.append('<div class="table-content-center-container">'+map.rowCenterHtml+'</div>');
    });

};

RanGoTableInner.assembleSearch = function(param){
    var column = param.column;
    var SearchContainer = param.SearchContainer;
    var SearchTableInput = param.SearchTableInput;
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
    $(SearchContainer).css("height",searchContainerHeight + "px");
    $(SearchTableInput).append(tRHtml);
};


RanGoTableInner.assembleRow = function(columnList,row_obj){
    var rowLeftHtml = '';
    var rowRightHtml = '';
    var rowCenterHtml = '';
    $(columnList).each(function (index,column) {
        var fieldName = column.fieldName;
        var fixed = column.fixed;
        var style = RanGoTableInner.assembleStyle(column);
        var value = RanGoTableInner.getValue(row_obj,fieldName);
        if(fixed){
            if(RanGoTable.fixed.LEFT===fixed){
                rowLeftHtml +=RanGoTableInner.getCell(style,value);
            }
            if(RanGoTable.fixed.RIGHT===fixed){
                rowRightHtml +=RanGoTableInner.getCell(style,value);
            }
        }else {
            rowCenterHtml +=RanGoTableInner.getCell(style,value);
        }
    });
    var map = {};
    map.rowLeftHtml = rowLeftHtml;
    map.rowRightHtml = rowRightHtml;
    map.rowCenterHtml = rowCenterHtml;
    return map;
};

//////////////////////////////////////////////////////////

RanGoTableInner.assembleStyle = function(obj){
    var style = "";
    var width = obj.width;
    if(!width){
        width= 100;
    }
    style += 'width:'+width+'px;';
    return style;
};

RanGoTableInner.getValue = function(obj,fieldName){
    for (var key in obj) {
        if(key === fieldName){
            return obj[fieldName];
        }
    }
};

RanGoTableInner.setCenterWidth = function(centerWidth,objArr){
	$(objArr).each(function(index,obj){
		$(obj).css("width", (centerWidth)+ "px");
	})
};


RanGoTableInner.setMargin = function(leftWidth,rightWidth,objArr){
	$(objArr).each(function(index,obj){
		$(obj).css("margin-left", (leftWidth)+ "px");
	    $(obj).css("margin-right", (rightWidth)+ "px");
	})
};


RanGoTableInner.getCell = function(style,cellValue){
    return '<div class="table-cell" style="'+style+'">'+cellValue+'</div>';
};