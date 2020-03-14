var RanGoTable = window.RanGoTable || {};
var RanGoTableInner = window.RanGoTableInner || {};

RanGoTable.fixed = {
    "LEFT" : 'left',
    "RIGHT" : 'right'
};

$(function () {
    $(window).resize(function () {          //当浏览器大小变化时改变面板大小
        initHeight();
    });
});

function initHeight(){
    var clientHeight = document.documentElement.clientHeight;
    var searchContainerHeight = $("#searchContainer").height();
    $(".table-content-container").height(clientHeight -135 - searchContainerHeight);
}

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
    settings.InnerIdArr = {};
    settings.InnerIdArr.TableContentLeft = TableContentLeftId;
    settings.InnerIdArr.TableContentRight = TableContentRightId;
    settings.InnerIdArr.TableContentCenter = TableContentCenterId;


    /*初始化HTML*/
    RanGoTableInner.initHeadHTML(settings);
    RanGoTableInner.initSearchHTML(settings);
    RanGoTableInner.initTableHTML(settings);
    RanGoTableInner.initBottomHTML(settings);

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
    settings.InnerCenterWidth = centerWidth;

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
        $(TableBottomScrollMarkId)
    ]);
    RanGoTableInner.setMargin(leftWidth,rightWidth - 17,[
        $(TableContentCenterId)
    ]);

    //初始化高度
    initHeight();

    /*初始化滚动条*/
    $(TableBottomScrollMarkId).scroll(function () {
        $(TableTitleCenterId).scrollLeft(this.scrollLeft);
        $(TableContentCenterId).scrollLeft(this.scrollLeft);
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

    RanGoTableInner.openTreeBtnClick({
        column: column,
        settings: settings
    });
};


RanGoTableInner.openTreeBtnClick = function (param) {
    var column = param.column;
    var settings = param.settings;
    var parentRowId = param.parentRowId;
    var str = '.open-tree-btn';
    if(parentRowId !== undefined){
        str = "div[parentRowId='"+parentRowId+"'] .open-tree-btn";
    }
    $(str).click(function(){
        var obj = $(this);
        var nodeId = RanGoTableInner.openTreeObjGetRow(obj).attr("rowId");

        RanGoTableInner.showHideMenuNode({
            openTreeObj:obj
        });
        RanGoTableInner.insertRow({
            insertRowId:nodeId,
            openTreeObj:obj,
            column: column,
            settings: settings
        });
        RanGoTableInner.setCenterWidth(settings.InnerCenterWidth,[
            $(settings.InnerIdArr.TableContentCenter + " .table-content-center-container")
        ]);
    });
};



RanGoTableInner.initHeadHTML = function (settings) {
    var tool = settings.tool;
    var toolHtml = '';
    $(tool).each(function(index,obj){
        toolHtml += '  <em class="common-button-icon" onclick="'+obj.click+'"><i class="'+obj.icon+'"></i></em>';
    });
    var html = '';
    html += '<div class="head-container">';
    html += '    <table cellpadding="0" cellspacing="0" style="width: 100%;">';
    html += '        <tr>';
    html += '            <th style="text-align: left;">';
    html += '               <em id="searchContainerViewBtn" class="common-button-icon">';
    html += '                   <i class="fa fa-angle-down fa-fw"></i>';
    html += '               </em>';
    html +=                 toolHtml;
    html += '                <em class="common-button-icon"><i class="fa fa-search fa-fw"></i></em>';
    html += '                <em class="common-button-icon"><i class="fa fa-repeat fa-fw"></i></em>';
    html += '            </th>';
    html += '            <th style="text-align: end;">';
    html += '            </th>';
    html += '        </tr>';
    html += '    </table>';
    html += '</div>';
    $("#" + settings.id).append(html);
};

RanGoTableInner.initSearchHTML = function (settings) {
    var html = '';
    html += '<div id="searchContainer" class="search-container">';
    html += '    <table cellpadding="0" cellspacing="0" id="searchTableInputContainer" class="search-table-input-container"></table>';
    html += '</div>';
    $("#" + settings.id).append(html);
};

RanGoTableInner.initTableHTML = function (settings) {
    var html = '';
    html += '<div class="table-container">';
    html += '	<div class="table-title-container">';
    html += '		<div id="tableTitleLeft" class="table-color-common table-title-left"></div>';
    html += '		<div id="tableTitleRight" class="table-color-common table-title-right"></div>';
    html += '		<div id="tableTitleCenter" class="table-color-common table-title-center">';
    html += '			<div id="tableTitleCenterContainer" class="table-title-center-container"></div>';
    html += '		</div>';
    html += '	</div>';

    html += '	    <div id="tableContentContainer" class="table-content-container">';
    html += '		    <div id="tableContentLeft" class="table-content-left"></div>';
    html += '		    <div id="tableContentRight" class="table-content-right"></div>';
    html += '		    <div id="tableContentCenter" class="table-content-center"></div>';
    html += '	    </div>';

    html += '</div>';
    html += '<div class="table-color-common table-bottom-container">';
    html += '	<div id="tableBottomScrollMark" class="table-bottom-scroll-mark">';
    html += '		<div id="tableBottomScrollBar" class="table-bottom-scroll-bar"></div>';
    html += '	</div>';
    html += '</div>';
    $("#" + settings.id).append(html);
};

RanGoTableInner.initBottomHTML = function (settings) {
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
    html += '                <em class="common-button-icon"><i class="fa fa-angle-double-left fa-fw"></i></em>';
    html += '            </th>';
    html += '            <th>';
    html += '                <em class="common-button-icon"><i class="fa fa-angle-left fa-fw"></i></em>';
    html += '            </th>';
    html += '            <th>';
    html += '                <input type="text" value="1" size="2" style="text-align: center;height: 28px;width:40px;font-size: 15px;padding: 0;border: 1px solid #ddd;">';
    html += '            </th>';
    html += '            <th>';
    html += '                 <em class="common-button-icon"><i class="fa fa-angle-right fa-fw"></i></em>';
    html += '            </th>';
    html += '            <th>';
    html += '                <em class="common-button-icon"><i class="fa fa-angle-double-right fa-fw"></i></em>';
    html += '            </th>';
    html += '            <th>';
    html += '                <em class="common-button-icon" id="refreshBtn"><i class="fa fa-spinner fa-pulse fa-fw"></i></em>';
    html += '            </th>';
    html += '        </tr>';
    html += '    </table>';
    html += '</div>';
    $("#" + settings.id).append(html);
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
        var title = obj.title;
        var style = RanGoTableInner.assembleStyle(obj);
        var fixed = obj.fixed;
        if(fixed){
            if(RanGoTable.fixed.LEFT===fixed){
                TableTitleLeft.append(RanGoTableInner.getCommonCell({
                    style:style,
                    cellValue:title
                }));
            }
            if(RanGoTable.fixed.RIGHT===fixed){
                TableTitleRight.append(RanGoTableInner.getCommonCell({
                    style:style,
                    cellValue:title
                }));
            }
        }else{
            var width = parseInt(obj.width);
            if(!width){
                width= 100;
            }
            centerWidth += width;
            TableTitleCenterContainer.append(RanGoTableInner.getCommonCell({
                style:style,
                cellValue:title
            }));
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
        var rowId = obj.id;
        TableContentLeft.append('<div class="table-row" rowId="'+rowId+'">'+map.rowLeftHtml+'</div>');
        TableContentRight.append('<div class="table-row" rowId="'+rowId+'">'+map.rowRightHtml+'</div>');
        TableContentCenter.append('<div class="table-row table-content-center-container"  rowId="'+rowId+'">'+map.rowCenterHtml+'</div>');
    });
};

RanGoTableInner.guid = function() {
    function S4() {
        return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
    }
    return (S4()+S4()+S4()+S4()+S4()+S4()+S4()+S4());
};

RanGoTableInner.assembleSearch = function(param){
    var column = param.column;
    var SearchContainer = param.SearchContainer;
    var SearchTableInputContainer = param.SearchTableInputContainer;
    var searchItemArr = [];
    var thHtml = '';
    var i = 0;
    $(column).each(function(index,obj){
        var query = obj.query;
        var title = obj.title;
        if(query){
            i++;
            thHtml +='<th>';
            thHtml += title;
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
    var insertRowId = param.insertRowId;
    var paddingLeft =  openTreeObj.parent().parent().css("padding-left");
    var column = param.column;
    var settings = param.settings;

    var TableContentLeft = $(settings.InnerIdArr.TableContentLeft);
    var TableContentRight = $(settings.InnerIdArr.TableContentRight);
    var TableContentCenter = $(settings.InnerIdArr.TableContentCenter);

    /*var TableContentLeft = param.TableContentLeft;
    var TableContentRight = param.TableContentRight;
    var TableContentCenter = param.TableContentCenter;*/

    var childNodeHtml = TableContentLeft.find("div[rowId='"+insertRowId+"']").next("div[parentRowId='"+insertRowId+"']").html();
    if(childNodeHtml !== undefined){
        return;
    }
    var result = settings.treeExpand.apply(null,[insertRowId]);
    if(result.length === 0){
        return;
    }
    $('<div parentRowId="'+insertRowId+'"></div>').insertAfter(TableContentLeft.find("div[rowId='"+insertRowId+"']"));
    $('<div parentRowId="'+insertRowId+'"></div>').insertAfter(TableContentRight.find("div[rowId='"+insertRowId+"']"));
    $('<div parentRowId="'+insertRowId+'"></div>').insertAfter(TableContentCenter.find("div[rowId='"+insertRowId+"']"));

    $(result).each(function (index,obj) {
        var map = RanGoTableInner.assembleRow({
            paddingLeft: paddingLeft,
            column: column,
            row_obj: obj,
            settings: settings
        });
        /*TableContentLeft.append('<div class="table-row" rowId="'+rowId+'">'+map.rowLeftHtml+'</div>');
        TableContentRight.append('<div class="table-row" rowId="'+rowId+'">'+map.rowRightHtml+'</div>');
        TableContentCenter.append('<div class="table-row table-content-center-container"  rowId="'+rowId+'">'+map.rowCenterHtml+'</div>');*/
        var rowId = obj.id;
        TableContentLeft.find("div[parentRowId='"+insertRowId+"']").append('<div class="table-row" rowId="'+rowId+'">'+map.rowLeftHtml+'</div>');
        TableContentRight.find("div[parentRowId='"+insertRowId+"']").append('<div class="table-row" rowId="'+rowId+'">'+map.rowRightHtml+'</div>');
        TableContentCenter.find("div[parentRowId='"+insertRowId+"']").append('<div class="table-row table-content-center-container" rowId="'+rowId+'">'+map.rowCenterHtml+'</div>');
    });
    RanGoTableInner.openTreeBtnClick({
        column: column,
        settings: settings,
        parentRowId:insertRowId
    });
};

RanGoTableInner.assembleRow = function(param){
    var column = param.column;
    var row_obj = param.row_obj;
    var settings = param.settings;

    /*var tree = settings.tree;*/
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
        var tree = column.tree;
        var style = RanGoTableInner.assembleStyle(column);
        var value = RanGoTableInner.getValue(row_obj,fieldName);
        if(fixed){
            if(RanGoTable.fixed.LEFT===fixed){
                if(tree){
                    rowLeftHtml += RanGoTableInner.getTreeCell({
                        value:value,
                        paddingLeft:paddingLeft,
                        style:style
                    });

                }else{
                    rowLeftHtml +=RanGoTableInner.getCommonCell({
                        style:style,
                        cellValue:value
                    });
                }
            }
            if(RanGoTable.fixed.RIGHT===fixed){
                var containerStyle = '';
                if(fieldName === 'opt'){
                    containerStyle = 'height: 22px;line-height: 22px;';
                    value = RanGoTableInner.getCellBtn({
                        key:'opt',
                        settings: settings,
                        row_obj:row_obj
                    });
                }
                rowRightHtml += RanGoTableInner.getCommonCell({
                    style:style,
                    cellValue:value,
                    containerStyle:containerStyle
                });
            }
        }else {
            rowCenterHtml += RanGoTableInner.getCommonCell({
                style:style,
                cellValue:value
            });
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
    var display = obj.display;
    if(!width){
        width= 100;
    }
    if(display){
        style += 'display:'+ display + ";";
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
        return RanGoTableInner.getSimpleCell('width:25px;padding:0;','<input type="checkbox" class="table-cell-common-context" name=""/>');
    }
    if(settings.radio){
        return RanGoTableInner.getSimpleCell('width:25px;padding:0;','<input type="radio" class="table-cell-common-context" name=""/>');
    }
    return '';
};
//=========================TREE==============================
RanGoTableInner.getTreeCell = function(param){
    var value = param.value;
    var paddingLeft = param.paddingLeft;
    var style = param.style;
    var openMenuBtn= RanGoTableInner.getCellBtn({
        key:'tree'
    });
    if(paddingLeft){
        paddingLeft = parseInt(paddingLeft.replace("px","")) + 20 + "px";
        style += 'padding-left:' + paddingLeft;
    }
    return RanGoTableInner.getCommonCell({
        style:style,
        cellValue:openMenuBtn + value,
        containerStyle:'left: auto;right: auto;'
    });
};

//=======================================================
RanGoTableInner.getCellBtn = function(param){
    var key = param.key;
    var settings = param.settings;
    if(key === 'tree'){
        return '<em class="common-button-icon open-tree-btn"><i class="fa fa-angle-down common-button-rotate"></i></em>';
    }
    if(key === 'opt'){
        var optstr = '';
        var opt = settings.opt;
        var row_obj = param.row_obj;
        $(opt).each(function (index,obj) {
            var click = obj.click;
            var fields = click.substring(click.indexOf('(')+1,click.indexOf(')'));
            var fieldArr = fields.split(',');

            var values = '';
            $(fieldArr).each(function (index,field) {
                values += '\'' + RanGoTableInner.getValue(row_obj,field) + '\'' + ',';
            });
            if(values.length > 0){
                values = values.substring(0,values.length - 1);
            }
            var clickName = click.substring(0,click.indexOf('(')+1) + values + ');';
            /*optstr += '<button class="" style="height: 22px;width: max-content;padding: 0 8px;">'+obj.name+'</button>';*/
            //optstr += '<span class="common-span" onclick="'+clickName+'"></span>';
            optstr += '<em class="common-button-icon opt-btn" onclick="'+clickName+'" ><i class="'+obj.icon+'"></i>'+obj.name +'</em>';
        });
        return optstr;
    }

};

RanGoTableInner.getCommonCell = function(param){
    var style = param.style;
    var cellValue = param.cellValue;
    var containerStyle = param.containerStyle;
    return '<div class="table-cell" style="'+style+'"><div class="table-cell-container" style="'+containerStyle+'">'+cellValue+'</div></div>';
};

RanGoTableInner.getSimpleCell = function(style,cellValue){
    return '<div class="table-cell" style="'+style+'">'+cellValue+'</div>';
};

//=======================tool===========================
RanGoTableInner.showHideSearchContainer = function (param){
    var obj = param.obj;
    var SearchContainer = param.SearchContainer;
    SearchContainer.toggle();
    RanGoTableInner.buttonRotate(param);
    initHeight();
};
/**
 * 按钮逆时针旋转90°
 */
RanGoTableInner.buttonRotate = function (param){
    var obj = $(param.obj).find('i');
    if(obj.attr("class").indexOf("common-button-rotate")!==-1){
        obj.removeClass("common-button-rotate");
    }else{
        obj.addClass("common-button-rotate");
    }
};

//===========================分页============================

RanGoTableInner.refresh = function (param){
    var obj = param.obj;
};

//===========================菜单============================
RanGoTableInner.showHideMenuNode = function (param){
    var openTreeObj = param.openTreeObj;
    var insertRowId = RanGoTableInner.openTreeObjGetRow(openTreeObj).attr("rowId");
    $("div[parentRowId='"+insertRowId+"']").toggle();
    RanGoTableInner.buttonRotate({
        obj:openTreeObj
    });
};

RanGoTableInner.openTreeObjGetRow = function(openTreeObj){
    return openTreeObj.parent().parent().parent();
};

RanGoTable.reset = function(datas){
    $("#" + datas.settings.id).html('');
};
