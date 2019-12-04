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
    var SearchTableInputContainerId = "#searchTableInputContainer";

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

    /*初始化HTML*/
    RanGoTableInner.initHeadHTML(settings);
    RanGoTableInner.initSearchHTML();
    RanGoTableInner.initTableHTML();
    RanGoTableInner.initBottomHTML();

    /*组装HTML*/
    var column = datas.column;
    var result = datas.result;
    RanGoTableInner.assembleSearch({
        column: column,
        settings: settings,
        SearchContainer: $(SearchContainerId),
        SearchTableInputContainer: $(SearchTableInputContainerId)
    });
    var centerWidth = RanGoTableInner.assembleColumn({
        column: column,
        settings: settings,
        TableTitleLeft : $(TableTitleLeftId),
        TableTitleRight : $(TableTitleRightId),
        TableTitleCenterContainer : $(TableTitleCenterContainerId)
    });
    RanGoTableInner.assembleResult({
        column: column,
        result: result,
        settings: settings,
        TableContentLeft: $(TableContentLeftId),
        TableContentRight: $(TableContentRightId),
        TableContentCenter: $(TableContentCenterId)
    });

    /*初始化CSS*/
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

    /*初始化滚动条*/
    $(TableBottomScrollMarkId).scroll(function () {
        $(TableTitleCenterId).scrollLeft(this.scrollLeft);
        $(TableContentCenterId).scrollLeft(this.scrollLeft);
    });

    var height= $(TableContentCenterId).height();
    $(TableContentContainerRightScrollBarId).height(height);
    $(TableContentContainerRightScrollMarkId).scroll(function () {
        $(TableContentContainerId).scrollTop(this.scrollTop);
    });


    /*初始化点击方法*/
    $("#searchContainerViewBtn").click(function(){
        RanGoTableInner.showHideSearchContainer({
            obj: $(this),
            SearchContainer: $(SearchContainerId)
        });
    });

    $("#refreshBtn").click(function(){
        RanGoTableInner.refresh({
            obj: $(this)
        });
    });

    $(".open-tree-btn").click(function(){
        var obj = $(this);

        RanGoTableInner.insertRow({
            openTreeObj:obj,
            column: column,
            result: result,
            settings: settings,
            TableContentLeft: $(TableContentLeftId),
            TableContentRight: $(TableContentRightId),
            TableContentCenter: $(TableContentCenterId)
        });

        RanGoTableInner.setCenterWidth(centerWidth,[
            $(TableContentCenterId + " .table-content-center-container")
        ]);

        var height= $(TableContentCenterId).height();
        $(TableContentContainerRightScrollBarId).height(height);
    });

};

RanGoTableInner.initHeadHTML = function (settings) {
    var tool = settings.tool;
    var toolHtml = '';
    $(tool).each(function(index,obj){
        toolHtml += '  <a href="javascript:void(0);" class="common-button-icon" onclick="'+obj.click+'"><i class="'+obj.icon+'"></i></a>';
    });
    var html = '';
    html += '<div class="head-container">';
    html += '    <table cellpadding="0" cellspacing="0" style="width: 100%;">';
    html += '        <tr>';
    html += '            <th style="text-align: left;">';
    html += '               <a id="searchContainerViewBtn" class="common-button-icon" href="javascript:void(0);">';
    html += '                   <i class="fa fa-angle-down"></i>';
    html += '               </a>';
    html +=                 toolHtml;
    html += '            </th>';
    html += '            <th style="text-align: end;">';
    html += '                <a class="common-button-icon"><i class="fa fa-search"></i></a>';
    html += '                <a class="common-button-icon"><i class="fa fa-repeat"></i></a>';
    html += '            </th>';
    html += '        </tr>';
    html += '    </table>';
    html += '</div>';
    $(".m").append(html);
};

RanGoTableInner.initSearchHTML = function () {
    var html = '';
    html += '<div id="searchContainer" class="search-container">';
    html += '    <table cellpadding="0" cellspacing="0" id="searchTableInputContainer" class="search-table-input-container"></table>';
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
    /*    html += '       <div style="width: 100%;height: 200px;position: fixed;background: #f0f8ff96;">';
        html += '           <div class="loading" style="position: absolute;top: 45%;left: 49%;"></div>';
        html += '       </div>';*/
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
    html += '        <tr style="line-height: 0;">';
    html += '            <th>';
    html += '                <select class="pagination-page-list" style="height: 28px;width:40px;font-size: 15px;border: 1px solid #ddd;">';
    html += '                    <option>10</option>';
    html += '                    <option>20</option>';
    html += '                    <option>30</option>';
    html += '                    <option>40</option>';
    html += '                    <option>50</option>';
    html += '                </select>';
    html += '            </th>';
    html += '            <th>';
    html += '                <a class="common-button-icon"><i class="fa fa-angle-double-left"></i></a>';
    html += '            </th>';
    html += '            <th>';
    html += '                <a class="common-button-icon"><i class="fa fa-angle-left"></i></a>';
    html += '            </th>';
    html += '            <th>';
    html += '                <input type="text" value="1" size="2" style="text-align: center;height: 28px;width:40px;font-size: 15px;padding: 0;border: 1px solid #ddd;">';
    html += '            </th>';
    html += '            <th>';
    html += '                 <a class="common-button-icon"><i class="fa fa-angle-right"></i></button>';
    html += '            </th>';
    html += '            <th>';
    html += '                <a class="common-button-icon"><i class="fa fa-angle-double-right"></i></a>';
    html += '            </th>';
    html += '            <th>';
    /*<i class="fa fa-repeat" style="font-size: 13px;"></i>*/
    html += '                <a id="refreshBtn" class="common-button-icon" style="padding-left: 2px;"><div class="loading"></div></a>';
    html += '            </th>';
    html += '        </tr>';
    html += '    </table>';
    html += '</div>';
    $(".m").append(html);
};


RanGoTableInner.assembleColumn = function(param){
    var column = param.column;
    var settings = param.settings;
    var TableTitleLeft = param.TableTitleLeft;
    var TableTitleRight = param.TableTitleRight;
    var TableTitleCenterContainer = param.TableTitleCenterContainer;
    var centerWidth = 0;


    TableTitleLeft.append(RanGoTableInner.getCellCheckbox({
        settings:settings
    }));


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
    var settings = param.settings;
    var TableContentLeft = param.TableContentLeft;
    var TableContentRight = param.TableContentRight;
    var TableContentCenter = param.TableContentCenter;
    $(result).each(function (index,obj) {
        var map = RanGoTableInner.assembleRow({
            column: column,
            row_obj: obj,
            settings: settings
        });
        var rowId = RanGoTableInner.guid();
        TableContentLeft.append('<div rowId="'+rowId+'">'+map.rowLeftHtml+'</div>');
        TableContentRight.append('<div rowId="'+rowId+'">'+map.rowRightHtml+'</div>');
        TableContentCenter.append('<div rowId="'+rowId+'" class="table-content-center-container">'+map.rowCenterHtml+'</div>');
    });
};


RanGoTableInner.guid = function() {
    function S4() {
        return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
    }
    return (S4()+S4()+S4()+S4()+S4()+S4()+S4()+S4());
}


RanGoTableInner.assembleSearch = function(param){
    var column = param.column;
    var SearchContainer = param.SearchContainer;
    var SearchTableInputContainer = param.SearchTableInputContainer;
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
            thHtml += '<input class="form-control form-control-sm" type="text">';
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
    $(SearchTableInputContainer).append(tRHtml);
};

RanGoTableInner.insertRow  = function(param){

    var openTreeObj = param.openTreeObj;
    var insertRowId = openTreeObj.parent().parent().attr("rowId");
    var paddingLeft =  openTreeObj.parent().css("padding-left");


    var column = param.column;
    var result = param.result;
    var settings = param.settings;
    var TableContentLeft = param.TableContentLeft;
    var TableContentRight = param.TableContentRight;
    var TableContentCenter = param.TableContentCenter;
    $(result).each(function (index,obj) {
        var map = RanGoTableInner.assembleRow({
            paddingLeft: paddingLeft,
            column: column,
            row_obj: obj,
            settings: settings
        });
        $('<div>'+map.rowLeftHtml+'</div>').insertAfter(TableContentLeft.find("div[rowId='"+insertRowId+"']")); //将本身插入到目标tr的后面
        $('<div>'+map.rowRightHtml+'</div>').insertAfter(TableContentRight.find("div[rowId='"+insertRowId+"']")); //将本身插入到目标tr的后面
        $('<div class="table-content-center-container">'+map.rowCenterHtml+'</div>').insertAfter(TableContentCenter.find("div[rowId='"+insertRowId+"']")); //将本身插入到目标tr的后面
    });
};

RanGoTableInner.assembleRow = function(param){
    var column = param.column;
    var row_obj = param.row_obj;
    var settings = param.settings;

    var tree = settings.tree;
    var paddingLeft = param.paddingLeft;

    var rowLeftHtml = '';
    var rowRightHtml = '';
    var rowCenterHtml = '';

    rowLeftHtml +=RanGoTableInner.getCellCheckbox({
        settings:settings
    });

    $(column).each(function (index,column) {
        var fieldName = column.fieldName;
        var fixed = column.fixed;
        var style = RanGoTableInner.assembleStyle(column);
        var value = RanGoTableInner.getValue(row_obj,fieldName);
        if(fixed){
            if(RanGoTable.fixed.LEFT===fixed){
                if(tree && index === 0){
                    var openMenuBtn= RanGoTableInner.getCellBtn({
                        settings:settings
                    });
                    if(paddingLeft){
                        paddingLeft = parseInt(paddingLeft.replace("px","")) + 20 + "px";
                        style += 'padding-left:' + paddingLeft;
                    }
                    rowLeftHtml +=RanGoTableInner.getCell(style,openMenuBtn + value);
                }else{
                    rowLeftHtml +=RanGoTableInner.getCell(style,value);
                }
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

RanGoTableInner.getCellCheckbox = function(param){
    var settings = param.settings;
    if(settings.checkbox){
        return RanGoTableInner.getCell('width:25px;padding:0;','<input type="checkbox" class="table-cell-common-context" name=""/>');
    }
    if(settings.radio){
        return RanGoTableInner.getCell('width:25px;padding:0;','<input type="radio" class="table-cell-common-context" name=""/>');
    }
    return '';
};

RanGoTableInner.getCellBtn = function(param){
    var settings = param.settings;
    return '<a href="javascript:void(0);"  class="open-tree-btn common-button-icon" style="width: 18px;height: 18px;float: left;"><i class="fa fa-angle-right"></i></a>';
};

RanGoTableInner.getCell = function(style,cellValue){
    return '<div class="table-cell" style="'+style+'">'+cellValue+'</div>';
};

//=======================tool===========================
RanGoTableInner.showHideSearchContainer = function (param){
    var obj = param.obj;
    var SearchContainer = param.SearchContainer;
    SearchContainer.slideToggle("slow");
    if(obj.attr("class").indexOf("common-button-rotate")!=-1){
        console.log(1);
        obj.attr("class","common-button-icon")
    }else{
        console.log(2);
        obj.attr("class","common-button-icon common-button-rotate")
    }
};

//===========================分页============================

RanGoTableInner.refresh = function (param){
    var obj = param.obj;


};