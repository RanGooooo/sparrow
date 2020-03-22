/**
 * 公共方法
 * @author 赵宏宇
 */
var common = window.common || {};

// var commonVue = window.commonVue || {};


common.messageType = {
    "SUCCESS" : 1300,
    "WARNING" : 800,
    "ERROR" : 550,
};
/**
 *  展示指定消息内容
 */
common.showMessage = function(type,msg){
    if(type === common.messageType.SUCCESS){
        top.window.commonVue.showSuccessMessage(msg);
    }
    if(type === common.messageType.WARNING){
        top.window.commonVue.showWarningMessage(msg);
    }
    if(type === common.messageType.ERROR){
        top.window.commonVue.showErrorMessage(msg);
    }
};

/**
 * 从新加载Datagrid
 */
common.reloadDatagrid = function(id){
    if(id){
        $('#' + id).datagrid('reload');
    }
};

/**
 * 从新加载页面
 */
common.reload = function(){
    window.location.reload();
};


/**
 * 对jQuery的ajax方法的二次封装
 */
common.ajax = function(param) {
    try{
        parent.loadingDivShowParent();
    }catch(err){
        console.log("main ok");
    }
    var mergeParam = $.extend({
        type : 'POST',
        timeout : 30000
    } , param , {
        complete : function(response) {
            //再覆盖外部的complete方法之前并且不是session超时状态的情况，这个complete方法帮助运行外部complete方法
            if(param.complete && typeof param.complete == "function") {
                param.complete();
            }
            try{
                parent.loadingDivHideParent();
            }catch(err){
                console.log("main ok");
            }
        }
    });
    $.ajax(mergeParam);
};


common.guid = function() {
    function S4() {
        return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
    }
    return (S4()+S4()+S4()+S4()+S4()+S4()+S4()+S4());
};
