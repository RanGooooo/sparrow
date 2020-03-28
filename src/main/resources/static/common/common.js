/**
 * 公共方法
 * @author 赵宏宇
 */
var common = window.common || {};

common.messageType = {
    "SUCCESS" : 200,
    "WARNING" : 300,
    "ERROR" : 500,
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
common.showMessageS = function(result){
    var success = result.success;
    var msg = result.message;
    var type = common.messageType.SUCCESS;
    if(!success){
        type = common.messageType.WARNING;
    }
    common.showMessage(type,msg)
};
/**
 * 对jQuery的ajax方法的二次封装
 */
common.ajax = function(param) {
    var mergeParam = $.extend({
        type : 'POST',
        async:true,
        timeout : 30000
    } , param , {
        error:function(e){
            common.showMessage(common.messageType.ERROR,null);
            throw 'error';
        },
        complete : function(response) {
            //再覆盖外部的complete方法之前并且不是session超时状态的情况，这个complete方法帮助运行外部complete方法
            if(param.complete && typeof param.complete == "function") {
                param.complete();
            }
        }
    });
    $.ajax(mergeParam);
};
/**
 * 获取UUID
 */
common.guid = function() {
    function S4() {
        return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
    }
    return (S4()+S4()+S4()+S4()+S4()+S4()+S4()+S4());
};
