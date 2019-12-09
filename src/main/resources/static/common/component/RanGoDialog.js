var RanGoDialog = window.RanGoDialog || {};
var RanGoDialogInner = window.RanGoDialogInner || {};

RanGoDialog.init = function (datas) {
    var currentFrameId = window.frameElement && window.frameElement.id || '';
    datas.currentFrameId = currentFrameId;
    $(top.document.body).append(RanGoDialog.initHtml(datas));
};

RanGoDialog.initButtonHtml = function(param){
  var html = '';
  var id = param.id;
  var currentFrameId = param.currentFrameId;
  var button = param.button;

  $(button).each(function(index,obj){
      var method = obj.method;
      var name = obj.name;
      html += '<a href="javascript:void(0);" onclick="RanGoDialog.onclick(\''+id+'\',\''+currentFrameId+'\',\''+method+'\')"><cite>'+name+'</cite></a>';
  });
  return html;
};

RanGoDialog.onclick = function(id,currentFrameId,functionName){
    var openFrameId =  'iframe_' + id;
    top.document.getElementById(currentFrameId).contentWindow.eval(functionName+'(\''+openFrameId+'\')');
};

RanGoDialog.initHtml = function(datas){
    var title = datas.title;
    var src = datas.src;
    var button = datas.button;
    var currentFrameId = datas.currentFrameId;
    var id = common.guid();
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
    html += '            <iframe id="iframe_'+id+'" class="dialog-iframe" src="'+src+'"></iframe>';
    html += '        </div>';
    html += '        <table class="dialog-bottom-table" cellpadding="0" cellspacing="0">';
    html += '            <tr>';
    html += '                <th class="dialog-bottom-table-right-th" style="padding-bottom: 2px;">';
    html += RanGoDialog.initButtonHtml({
        id:id,
        currentFrameId:currentFrameId,
        button:button
    });
    html += '                </th>';
    html += '            </tr>';
    html += '        </table>';
    html += '    </div>';
    html += '</div>';
    return html;
};

RanGoDialog.close = function(id){
    $("#" + id).remove();
};