var RanGoDialog = window.RanGoDialog || {};
var RanGoDialogInner = window.RanGoDialogInner || {};

RanGoDialog.init = function(datas){
    var id = common.guid();
    var parentFrameId = window.frameElement && window.frameElement.id || '';
    datas.id = id;
    datas.parentFrameId = parentFrameId;
    datas.iFrameId = 'iframe_' + id;
    $(top.document.body).append(RanGoDialogInner.initHtml(datas));
};

RanGoDialogInner.initHtml = function(datas){
    var id = datas.id;
    var iFrameId = datas.iFrameId;
    var parentFrameId = datas.parentFrameId;
    var title = datas.title;
    var src = datas.src;
    var button = datas.button;

    var html = '';
    html += '<div id="'+id+'" class="dialog-container-mark">';
    html += '    <div class="dialog-container">';
    html += '        <table cellpadding="0" cellspacing="0">';
    html += '            <tr>';
    html += '                <th class="dialog-top-table-left-th"><span>'+title+'</span></th>';
    html += '                <th class="dialog-top-table-right-th">';
    html += '                   <a href="javascript:void(0);" onclick="RanGoDialog.close(\''+id+'\');">';
    html += '                       <i class="fa fa-times"></i>';
    html += '                   </a>';
    html += '                </th>';
    html += '            </tr>';
    html += '        </table>';
    html += '        <div class="dialog-context">';
    html += '            <iframe id="'+iFrameId+'" class="dialog-iframe" src="'+src+'"></iframe>';
    html += '        </div>';
    html += '        <table class="dialog-bottom-table" cellpadding="0" cellspacing="0">';
    html += '            <tr>';
    html += '                <th class="dialog-bottom-table-right-th" style="padding-bottom: 2px;">';
    html += RanGoDialogInner.initButtonHtml({
        id:id,
        iFrameId:iFrameId,
        parentFrameId:parentFrameId,
        button:button
    });
    html += '                </th>';
    html += '            </tr>';
    html += '        </table>';
    html += '    </div>';
    html += '</div>';
    return html;
};

RanGoDialogInner.initButtonHtml = function(param){
    var html = '';
    var button = param.button;
    $(button).each(function(index,obj){
        param.click = obj.click;
        html += "<a href='javascript:void(0);' onclick='RanGoDialogInner.onclick("+JSON.stringify(param)+")'><cite>"+obj.name+"</cite></a>";
    });
    return html;
};

RanGoDialogInner.onclick = function(param){
    var id = param.id;
    var iFrameId =  param.iFrameId;
    var parentFrameId = param.parentFrameId;
    var click = param.click;
    top.document.getElementById(parentFrameId).contentWindow.eval(click+'(\''+iFrameId+'\')');
    RanGoDialog.close(id);
};

RanGoDialog.close = function(id){
    $("#" + id).remove();
};

RanGoDialog.window = function(openFrameId){
    var window = top.document.getElementById(openFrameId).contentWindow;
    return window;
};

