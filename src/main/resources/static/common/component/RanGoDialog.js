var RanGoDialog = window.RanGoDialog || {};
var RanGoDialogInner = window.RanGoDialogInner || {};

RanGoDialog.init = function(datas){
    var id = common.guid();
    var parentFrameId = window.frameElement && window.frameElement.id || '';
    datas.id = id;
    datas.parentFrameId = parentFrameId;
    datas.iFrameId = 'iframe_' + id;
    $(top.document.body).append(RanGoDialogInner.initHtml(datas));

    RanGoDialogInner.initButtonClick(datas);
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
    html += '                   <em onclick="RanGoDialog.close(\''+id+'\');">';
    html += '                       <i class="fa fa-times"></i>';
    html += '                   </em>';
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


RanGoDialogInner.initButtonClick = function (param) {
    var id = param.id;
    var iFrameId =  param.iFrameId;
    var button = param.button;
    $(top.document).find("#"+id+" .ran-go-dialog-btn").click(function(){
        var buttonindex = $(this).attr("buttonindex");
        var click = button[buttonindex].click;
        var window = RanGoDialog.window(iFrameId);
        click.apply(null,[window]);
        RanGoDialog.close(id);
    });
};

RanGoDialogInner.initButtonHtml = function(param){
    var html = '';
    var button = param.button;
    $(button).each(function(index,obj){
        html += "<em class='ran-go-dialog-btn' buttonindex='"+index+"'><cite>"+obj.name+"</cite></em>";
    });
    return html;
};

RanGoDialog.close = function(id){
    $(top.document).find("#"+id).remove();
};

RanGoDialog.window = function(iFrameId){
    var window = top.document.getElementById(iFrameId).contentWindow;
    return window;
};