$(function () {
    tableList();
});
function tableList(){
    $.ajax({
        url:"/DBTableController/searchTableList",
        type:"post",
        data : {
        },
        async:false,
        success:function(jsonData){
            var result = jsonData.object;
            var html = '';
            $(result).each(function (index,obj) {
                html += '<div class="code-common-div" table-name="'+obj.tableName+'" onclick="columnList(this)">'+obj.tableName+'</div>'
            });
            $("#tableList").html(html);
        },
        error:function(e){
            common.showMessage("错误！！");
        }
    });
}

function columnList(obj){
    $(obj).siblings().removeClass("active");
    $(obj).addClass("active");
    var tableName = $(obj).attr("table-name");
    $("#table").val(tableName);
    var tableNameArr = tableName.split("_");
    var entity = "";
    $(tableNameArr).each(function (index,obj) {
        if(obj.length > 1){
            entity += obj.substring(0, 1).toUpperCase() + obj.substring(1);
        }else{
            entity += obj.toUpperCase();
        }
    });
    $("#entity").val(entity);
    var model = tableNameArr[tableNameArr.length - 1];
    $("#model").val(model);

    $.ajax({
        url:"/DBColumnController/searchColumnList",
        type:"post",
        data : {
            "tableName":tableName
        },
        async:false,
        success:function(jsonData){
            var result = jsonData.object;
            var html = '';
            $(result).each(function (index,obj) {
                html += '<div class="code-common-div"><span>'+obj.columnName+'</span><span style="float: right;">'+obj.dataType+'</span></div>'
            });
            $("#columnList").html(html);
        },
        error:function(e){
            common.showMessage("错误！！");
        }
    });
}

function codeSave() {
    if(!checkData()){
        throw 'error';
    }
    $.ajax({
        url:"/THCodeController/codeSave",
        type:"post",
        async:false,
        data:formToJsonObject("baseForm"),
        success:function(result){
            common.showMessage(result.message);
            if(!result.success){
                throw 'error';
            }
        },
        error:function(e){
            common.showMessage("错误！！");
        }
    });
}