/**
 * 公共方法
 * @author 赵宏宇
 */
let common = window.common || {};

common.messageType = {
    "SUCCESS" : "success",
    "WARNING" : "warning",
    "ERROR" : "error",
};

/** 全屏等待加载 */
common.openFullScreen = function(){
    top.window.windowVue.loading = top.window.windowVue.$loading({
        background: "rgba(255, 255, 255, 0.7)"
    });
};
/** 全屏加载 */
common.openFullScreenClose = function(){
    setTimeout(() => {
        top.window.windowVue.loading.close();
    }, 500);
};

/** 展示指定消息内容 */
common.showMessage = function(type,msg){
    if(type === common.messageType.SUCCESS){
        top.window.windowVue.$notify({title: "成功",message: msg,type: common.messageType.SUCCESS});
    }
    if(type === common.messageType.WARNING){
        top.window.windowVue.$notify({title: "警告",message: msg,type: common.messageType.WARNING});
    }
    if(type === common.messageType.ERROR){
        if(!msg){
            msg = "系统错误";
        }
        top.window.windowVue.$notify.error({title: "错误",message: msg});
    }
};
common.showMessageS = function(result){
    let type = result.type;
    let msg = result.message;
    common.showMessage(type,msg)
};
/** 对jQuery的ajax方法的二次封装 */
common.ajax = function(param) {
    common.openFullScreen();
    let mergeParam = $.extend({
        type : 'POST',
        async:true,
        timeout : 30000
    } , param , {
        error:function(e){
            common.showMessage(common.messageType.ERROR,null);
            throw 'error';
        },
        complete : function(response) {
            common.openFullScreenClose();
            //再覆盖外部的complete方法之前并且不是session超时状态的情况，这个complete方法帮助运行外部complete方法
            if(param.complete && typeof param.complete === "function") {
                param.complete();
            }
        }
    });
    $.ajax(mergeParam);
};
/** 获取UUID */
common.uuid = function() {
    function S4() {
        return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
    }
    return (S4()+S4()+S4()+S4()+S4()+S4()+S4()+S4());
};

common.iFrameApp = function(iFrameId){
    return $("#" + iFrameId)[0].contentWindow.app;
};