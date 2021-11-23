/**
 * 公共方法
 * @author 赵宏宇
 */
let common = window.common || {};

common.constant = {
    "TOPID" : "TOP"
};

/** ===================展示指定消息内容=================== */
common.messageType = {
    "SUCCESS" : "success",
    "WARNING" : "warning",
    "ERROR" : "error",
    "INFO" : "info"
};
common.showMessage = function(type,msg){
    if(type === common.messageType.SUCCESS){
        common.windowVue().$notify({title: "成功",message: msg,type: type});
    }
    if(type === common.messageType.WARNING){
        common.windowVue().$notify({title: "警告",message: msg,type: type});
    }
    if(type === common.messageType.ERROR){
        if(!msg){
            msg = "系统错误";
        }
        common.windowVue().$notify.error({title: "错误",message: msg});
    }
};
common.showMessageS = function(result){
    let type = result.type;
    let msg = result.message;
    common.showMessage(type,msg)
};
/** ==================================================== */

common.confirm = function (param) {
    let type = param.type;
    let iconClass = "";
    if(type === common.messageType.SUCCESS){
        iconClass = "common-green el-icon-success";
    }
    if(type === common.messageType.WARNING){
        iconClass = "common-orange el-icon-warning";
    }
    if(type === common.messageType.ERROR){
        iconClass = "common-red el-icon-question";
    }
    if(type === common.messageType.INFO){
        iconClass = "common-blue el-icon-info";
    }
    return common.windowVue().$confirm(param.message, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: type,
        iconClass: iconClass
    });
};

/** 全屏等待加载 */
common.openFullScreen = function(){
    common.windowVue().loading = common.windowVue().$loading({
        background: "rgba(255, 255, 255, 0.7)"
    });
};
/** 全屏加载 */
common.openFullScreenClose = function(){
    common.windowVue().loading.close();
};

/** 对jQuery的ajax方法的二次封装 */
common.ajax = function(param) {
    common.openFullScreen();
    let mergeParam = $.extend({
        type: 'POST',
        async: true,
        timeout: 30000,
        contentType: "menu/json",
    } , param , {
        error:function(e){
            console.error(JSON.stringify(e));
            common.showMessage(common.messageType.ERROR,null);
            common.openFullScreenClose();
        },
        complete : function(response) {
            try {
                if(response.responseJSON.type === common.messageType.WARNING){
                    common.showMessage(response.responseJSON.type,response.responseJSON.message);
                }
            } catch(err) {}
            common.openFullScreenClose();
            //再覆盖外部的complete方法之前并且不是session超时状态的情况，这个complete方法帮助运行外部complete方法
            if(param.complete && typeof param.complete === "function") {
                param.complete();
            }
        }
    });
    $.ajax(mergeParam);
};

common.windowVue = function(){
    return top.window.windowVue;
};

/** 获取UUID */
common.uuid = function() {
    function S4() {
        return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
    }
    return (S4()+S4()+S4()+S4()+S4()+S4()+S4()+S4());
};


common.frame = function(frameId){
    return $("#" + frameId)[0].contentWindow;
};

common.frameReload = function(frameId){
    common.frame(frameId).location.reload(true);
};
common.notNull = function(obj){
    if(obj!==undefined&&obj!==null){
        return true;
    }
    return false;
};

