var RanGoDialog = window.RanGoDialog || {};
var RanGoDialogInner = window.RanGoDialogInner || {};

RanGoDialog.init = function (datas) {
    $("body").append(RanGoDialog.initHtml(datas));
};

RanGoDialog.initButtonHtml = function(button){
  var html = '';
  $(button).each(function(index,obj){
      var method = obj.method + '();';
      var name = obj.name;
      html += '<a href="javascript:void(0);" onclick="'+method+'"><cite>'+name+'</cite></a>';
  });
  return html;
};

RanGoDialog.initHtml = function(datas){
    var title = datas.title;
    var src = datas.src;
    var button = datas.button;
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
    html += '            <iframe id="menuAdd" class="dialog-iframe" src="'+src+'"></iframe>';
    html += '        </div>';
    html += '        <table class="dialog-bottom-table" cellpadding="0" cellspacing="0">';
    html += '            <tr>';
    html += '                <th class="dialog-bottom-table-right-th" style="padding-bottom: 2px;">';
    html += RanGoDialog.initButtonHtml(button);
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