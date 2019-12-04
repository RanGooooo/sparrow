/**
 * 公共方法
 * @author 赵宏宇
 */
var common = window.common || {};

/**
 *  展示指定消息内容
 */
common.showMessage = function(msg){
    if(msg){
        alert(msg);
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
