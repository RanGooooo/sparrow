let RanGoDialog = window.RanGoDialog || {};
let RanGoDialogInner = window.RanGoDialogInner || {};

RanGoDialog.init = function(datas){
    let id = common.guid();
    let parentFrameId = window.frameElement && window.frameElement.id || '';
    datas.id = id;
    datas.parentFrameId = parentFrameId;
    datas.iFrameId = 'iframe_' + id;
    $(top.document.body).append(RanGoDialogInner.initHtml(datas));

    RanGoDialogInner.initButtonClick(datas);
};

RanGoDialogInner.initHtml = function(datas){
    let id = datas.id;
    let iFrameId = datas.iFrameId;
    let parentFrameId = datas.parentFrameId;
    let title = datas.title;
    let src = datas.src;
    let button = datas.button;
    let html = '';
    html += '<div id="'+id+'" class="dialog-container-mark">';
    html += '    <div class="dialog-container">';
    html += '       <div class="dialog-header">';
    html += '           <span class="dialog-title">'+title+'</span>';
    html += '           <em class="dialog-headerbtn" style="right: 50px;" onclick="RanGoDialog.reload(\''+iFrameId+'\');">';
    html += '               <i class="el-dialog__close el-icon el-icon-refresh-right"></i>';
    html += '           </em>';
    html += '           <em class="dialog-headerbtn" onclick="RanGoDialog.close(\''+id+'\');">';
    html += '               <i class="el-dialog__close el-icon el-icon-close"></i>';
    html += '           </em>';
    html += '        </div>';
    html += '        <div class="dialog-context">';
    html += '            <iframe id="'+iFrameId+'" class="dialog-iframe" src="'+src+'"></iframe>';
    html += '        </div>';
    html += '        <div class="dialog-footer">';
    html += '           <div style="text-align: right;">';
    html += RanGoDialogInner.initButtonHtml({
        id:id,
        iFrameId:iFrameId,
        parentFrameId:parentFrameId,
        button:button
    });
    html += '           </div>';
    html += '       </div>';
    html += '   </div>';
    html += '</div>';
    return html;

};


RanGoDialogInner.initButtonClick = function (param) {
    let id = param.id;
    let iFrameId =  param.iFrameId;
    let button = param.button;
    $(top.document).find("#"+id+" .dialog-button.dialog-button-primary").click(function(){
        let buttonindex = $(this).attr("buttonindex");
        let click = button[buttonindex].click;
        let window = RanGoDialog.window(iFrameId);
        click.apply(null,[window]);
        //RanGoDialog.close(id);
    });
};

RanGoDialogInner.initButtonHtml = function(param){
    let html = '';
    let button = param.button;
    $(button).each(function(index,obj){
        html += "<em class='dialog-button dialog-button-primary' :loading='true' buttonindex='"+index+"'>"+obj.name+"</em>";
    });
    return html;
};

RanGoDialog.close = function(id){
    $(top.document).find("#"+id).remove();
};

RanGoDialog.reload = function(iFrameId){
    $('#' + iFrameId).attr('src', $('#' + iFrameId).attr('src'));
};



RanGoDialog.window = function(iFrameId){
    let window = top.document.getElementById(iFrameId).contentWindow;
    return window;
};