$(function() {
    $("#menuContainerBody a").click(function() {
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
            var menuName = obj_a.attr("menu-name");
            var menuUrl = obj_a.attr("menu-url");
            addNode(menuName,menuUrl);
            $(".third").removeClass("active");
            obj_a.addClass("active");
            var scrollWidth = 0;
            $("#tabNodeScrollContainer a").each(function(){
                scrollWidth += $(this).width() + 30;
            });
            $("#tabNodeScrollContainer").css("width",scrollWidth + "px");
            $("#tabNodeScroll").getNiceScroll().resize();
        }

        return false;
    });


    $("#menuContainerBody").niceScroll({
        cursorborder:"",
        cursorcolor:"rgba(185, 185, 185, 0.5)",
        autohidemode:false,
        boxzoom:true,
        oneaxismousemode: false
    });
    $("#tabNodeScroll").niceScroll({
        cursorborder:"",
        cursorcolor:"rgba(185, 185, 185, 0.5)",
        autohidemode:false,
        boxzoom:true
    });

    /*
            $("#nodeiFrame").append('<iframe id="node_iframe" class="common_iFrame" src="/stepController/list" style="border: none;width: 100%;height: 100%;"></iframe>');
    */

})


function addNode(name,url) {
    $(".tab-node-scroll-container").find("a").removeClass("active");
    var html = '';
    html += '<a href="javascript:void(0);" onclick="nodeClick(this)" class="tab-node active">';
    html += '<cite>'+name+'</cite><i class="fa fa-times" onclick="removeNode(this)"></i>';
    html += '</a>';
    $(".tab-node-scroll-container").append(html);

    addNodeiFrame(0,url);
}

function nodeClick(obj){
    $(obj).attr("class","tab-node active");
    $(obj).siblings().attr("class","tab-node");
}

function removeNode(obj) {
    $(obj).parent().remove();
}

function addNodeiFrame(index,url){
    $("#nodeiFrame").append('<iframe id="node_iframe_'+index+'" class="common_iFrame" src="'+url+'" style="border: none;width: 100%;height: 100%;"></iframe>');
}

