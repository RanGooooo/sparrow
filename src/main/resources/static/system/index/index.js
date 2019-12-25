$(function() {
    $("#menuContainerBody em").click(function() {
        var obj_a = $(this);
        var obj_down = obj_a.find(".fa-chevron-down");
        if(obj_down.attr("class")){
            if(obj_down.attr("class").indexOf("fa-chevron-down-rotate")!=-1){
                obj_down.attr("class","fa fa-chevron-down");
            }else{
                obj_down.attr("class","fa fa-chevron-down fa-chevron-down-rotate");
            }
        }

        var clazz_a = obj_a.attr("class");
        if(clazz_a != "third"){
            $(this).siblings("ul").toggle();
            $("#menuContainerBody").getNiceScroll().resize();
        }
        if(clazz_a === "third"){
            var uuid = common.guid();
            var menuName = obj_a.attr("xxxxxxxxx-name");
            var menuUrl = obj_a.attr("xxxxxxxxx-url");
            addNode(uuid,menuName,menuUrl);
            $(".third").removeClass("active");
            obj_a.addClass("active");
            var scrollWidth = 0;
            $("#tabNodeScrollContainer em").each(function(){
                scrollWidth += $(this).width() + 30;
            });
            $("#tabNodeScrollContainer").css("width",scrollWidth + "px");
            $("#tabNodeScroll").getNiceScroll().resize();
        }

        return false;
    });


   /* $("#menuContainerBody").niceScroll({
        cursorborder:"",
        cursorcolor:"rgba(185, 185, 185, 0.5)",
        autohidemode:false,
        boxzoom:true,
        oneaxismousemode: false
    });
   */ $("#tabNodeScroll").niceScroll({
        cursorborder:"",
        cursorcolor:"rgba(185, 185, 18  5, 0.5)",
        autohidemode:false,
        boxzoom:true
    });

    /*
            $("#nodeiFrame").append('<iframe id="node_iframe" class="common_iFrame" src="/stepController/list" style="border: none;width: 100%;height: 100%;"></iframe>');
    */

})


function addNode(id,name,url) {
    $(".tab-node-scroll-container").find("em").removeClass("active");
    var html = '';
    html += '<em menuid="'+id+'" href="javascript:void(0);" onclick="nodeClick(this)" class="tab-node active">';
    html += '<cite>'+name+'</cite><i class="fa fa-times" onclick="removeNode(this)"></i>';
    html += '</em>';
    $(".tab-node-scroll-container").append(html);

    addNodeiFrame(id,url);
}

function nodeClick(obj){
    var menuid = $(obj).attr("menuid");
    $(obj).attr("class","tab-node active");
    $(obj).siblings().attr("class","tab-node");
    $("#nodeiFrame iframe").each(function(index,iframe) {
        var iframeMenuid = $(iframe).attr("menuid");
        if(iframeMenuid === menuid){
            $(iframe).show();
        }else{
            $(iframe).hide();
        }
    })
}

function removeNode(obj) {
    $(obj).parent().remove();
}

function addNodeiFrame(id,url){
    $("#nodeiFrame iframe").hide();
    $("#nodeiFrame").append('<iframe menuid="'+id+'" class="common_iFrame" src="'+url+'" style="border: none;width: 100%;height: 100%;"></iframe>');
}

