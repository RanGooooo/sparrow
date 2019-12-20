/**
 * 校验方法
 * @author 赵宏宇
 */
var warning = window.warning || {};

var mydatatypeKey = "mydatatype";
var mystyleKey = "mystyle";
var messageSKey = "messageS";
var asyncKey = "asyncS";
var minLengthKey = "minLength";
var maxLengthKey = "maxLengthS";
var checkEmptySKey = "checkEmptyS";// false:不去校验空（用于有规则的校验）
var checkFunctionSKey = "checkFunctionS";//校验自定义方法
var locking = false;	//是否锁定到某个input框
$(function(){
    changeData();
    try{
        parent.loadingDivPasswordHideParent();
        parent.loadingDivHideParent();
    }catch(err){
        console.log("main ok");
    }
});

function Popup(message){
    alert(message);
}
/**
 * 用于提交校验
 * @returns
 */
function checkData(){
    locking = true;
    console.log('【checkData】');
    var checkDataFlag = true;
    var fieldnames = "";
    $("input").each(function(index,element){
        fieldnames = fieldnames + $(this).attr("name") + ",";
    });
    console.log(fieldnames);
    $(".form-control").each(function(index,element){
        checkDataFlag = warning.commonFunction(this);
        if(!checkDataFlag){
            return checkDataFlag;
        }
    });
    return checkDataFlag;
}
/**
 * 用于提交校验某个from表单
 * @param formId 表单id
 * @returns
 */
function checkDataByFormId(formId){
    console.log('【checkDataByFormId】');
    var checkDataFlag = true;
    if(formId){
        $("#" + formId + " .form-control").each(function(index,element){
            checkDataFlag = warning.commonFunction(this);
            if(!checkDataFlag){
                return checkDataFlag;
            }
        });
    }
    return checkDataFlag;
}
/**
 * 输入校验
 * @returns
 */
function changeData(){
    $(".form-control").keyup(function(){
        locking = false;
        var clazz = $(this).attr("class");
        if(clazz.indexOf('form-control')===-1){
            $(this).next().remove();
            return true;
        }
        warning.commonFunction(this);
    });
}
/**
 * 基础校验
 * 校验一个input内容
 */
warning.commonFunction = function(obj){
    console.log('【commonFunction】');
    var checkDataFlag = true;
    var datatype = $(obj).attr(mydatatypeKey);
    if(datatype != null && datatype != ''){
        var async = $(obj).attr(asyncKey);
        if(async){

        }else{
            var value = $(obj).val();
            var mystyle = $(obj).attr(mystyleKey);
            if(!mystyle){
                mystyle = '';
            }
            checkDataFlag = checkDataMain(obj,datatype,value,mystyle);
        }
    }
    return checkDataFlag;
};



function checkDataMain(obj,regex,value,mystyle){
    var checkDataFlag = true;
    var valueLength = value.length;
    var message = $(obj).attr(messageSKey);
    var checkEmpty = $(obj).attr(checkEmptySKey);
    var valueLengthTips = "";
    var minLength = $(obj).attr(minLengthKey);
    var maxLength = $(obj).attr(maxLengthKey);
    if(maxLength){
        valueLengthTips = "<span>"+valueLength + "/" + maxLength + "</span>";
    }
    if(message){
        message = "<span class='messageStyle'>"+message+"</span>";
    }else{
        message = "";
    }
    if(checkEmpty=='false'){
        if (value!=null&&value!='') {
            checkDataFlag = AssembleMessage(obj,regex,value,mystyle,valueLengthTips,message)
        }else{
            $(obj).next().remove();
        }
    }else{
        checkDataFlag = AssembleMessage(obj,regex,value,mystyle,valueLengthTips,message)
    }
    if(!checkDataFlag){
        var Y = $(obj).offset().top;
        if(Y>0 && locking){
            window.scrollTo(0,Y);
        }
    }
    return checkDataFlag;
}

function AssembleMessage(obj,regex,value,mystyle,valueLengthTips,message){
    if(regex =="*"){
        regex = /^[\s\S]*.*[^\s][\s\S]*$/;
    }
    var checkDataFlag = true;
    var rExp1 = new RegExp(regex);
    var valueLengthTipsMessage = "";
    if(rExp1.test(value)){
        valueLengthTipsMessage = valueLengthTips;
    }else{
        checkDataFlag = false;
        valueLengthTipsMessage = valueLengthTips + message;
    }
    var checkFunction = $(obj).attr(checkFunctionSKey);//校验自定义方法
    console.log(checkFunction);
    if(checkFunction){
        checkDataFlag = eval(checkFunction);
        console.log(checkDataFlag);
        if(checkDataFlag){
            valueLengthTipsMessage = valueLengthTips;
        }else{
            valueLengthTipsMessage = valueLengthTips + message;
        }
    }
    AssembleMMessageHtml(checkDataFlag,obj,mystyle,valueLengthTipsMessage);
    return checkDataFlag;
}


function AssembleMMessageHtml(checkDataFlag,obj,mystyle,message){
    $(obj).next().remove();
    if(checkDataFlag){
        $(obj).after("<span class='Validform_span_ok' style='"+mystyle+"'> <i class='iconfont icon-dui'></i>"+message+"</span>");
    }else{
        $(obj).after("<span class='Validform_span' style='"+mystyle+"'> <i class='iconfont icon-cuo'></i>" + message+"</span>");
    }
}

/**
 * 校验是否重复
 */
warning.uniqueCheckValue = function(param,obj,id,tableName,fieldName){
    param.url = "uniqueCheckValueController.do?uniqueCheckValue";
    return warning.commonCheckValue(param,obj,id,tableName,fieldName);
};

/**
 * 校验字段是否存在
 * async 是否异步校验 false 否 true 是
 */
warning.commonCheckValue = function(param,obj,id,tableName,fieldName){
    var async = param.async;
    console.log('[async1]' + async);
    if(async!==false){
        async = true;
    }
    console.log('[async2]' + async);
    var checkDataFlag = true;
    var valueStr = obj.val();
    var datatype = obj.attr(mydatatypeKey);
    var mystyle = obj.attr(mystyleKey);
    if(!mystyle){
        mystyle = '';
    }
    if(datatype !== null && datatype !== ''){
        checkDataFlag = checkDataMain(obj,datatype,valueStr,mystyle);
    }
    console.log('uniqueCheckValue');
    var successFalg = false;
    if(checkDataFlag){
        $.ajax({
            url: param.url ,
            data: {
                "id" : id,
                "valueStr" : valueStr,
                "tableName" : tableName,
                "fieldName" : fieldName
            },
            type: "post",
            async: async,
            success:function(jsonData){
                var data = $.parseJSON(jsonData);
                var success =  data.success;
                successFalg = success;
                var message = "";
                if(!success){
                    message = "<span class='messageStyle'>"+data.msg+"</span>";
                }
                AssembleMMessageHtml(success,obj,mystyle,message);
            }
        });
    }
    return successFalg;
};



//===========================================================

/**
 * 只能填写数字
 * @param obj
 * @returns
 */
function clearNoNum(obj){
    obj.value = obj.value.replace(/[^\d.]/g,"");  //清除“数字”和“.”以外的字符
    obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的
    obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
    obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d{6}).*$/,'$1$2.$3');//只能输入两个小数
    if(obj.value.indexOf(".")< 0 && obj.value !==""){//以上已经过滤，此处控制的是如果没有小数点，首位不能为类似于 01、02的金额
        obj.value= parseFloat(obj.value);
    }
}
/**
 * 只能填写整数
 * @param obj
 * @returns
 */
function clearNoNumInt(obj){
    obj.value = obj.value.replace(/[^\d.]/g,"");  //清除“数字”和“.”以外的字符
    obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的
    obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
    obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d{6}).*$/,'$1$2.$3');//只能输入两个小数
    if(obj.value !== ""){//以上已经过滤，此处控制的是如果没有小数点，首位不能为类似于 01、02的金额
        obj.value= parseInt(obj.value);
    }
}
