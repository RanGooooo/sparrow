var RanGoDialog = window.RanGoDialog || {};
var RanGoDialogInner = window.RanGoDialogInner || {};

RanGoDialog.init = function (datas) {
    $("body").append(RanGoDialog.initHtml(datas));
};

RanGoDialog.initHtml = function(datas){
    var title = datas.title;
    var src = datas.src;
    var html = '';
    html += '<div class="dialog-container-mark">';
    html += '    <div class="dialog-container">';
    html += '        <table cellpadding="0" cellspacing="0">';
    html += '            <tr>';
    html += '                <th class="dialog-top-table-left-th"><span>'+title+'</span></th>';
    html += '                <th class="dialog-top-table-right-th">';
    html += '                    <button type="button" class="btn btn-outline-secondary btn-sm"><i class="fa fa-times"></i></button>';
    html += '                </th>';
    html += '            </tr>';
    html += '        </table>';
    html += '        <div class="dialog-context">';
    html += '            <iframe class="dialog-iframe" src="'+src+'"></iframe>';
    html += '        </div>';
    html += '        <table class="dialog-bottom-table" cellpadding="0" cellspacing="0">';
    html += '            <tr>';
    html += '                <th class="dialog-bottom-table-right-th">';
    html += '                    <button type="button" class="btn btn-primary btn-sm">确定</button>';
    html += '                </th>';
    html += '            </tr>';
    html += '        </table>';
    html += '    </div>';
    html += '</div>';
    return html;
};