
var datas = {
    "column":[
        {
            "field_name":"id",
            "title":"ID",
            "width": "500",
            "fixed":"left"
        },
        {
            "field_name":"firstName",
            "title":"姓",
            "width": "500",
            "fixed":"right"
        },
        {
            "field_name":"lastName",
            "title":"名",
            "width": "500"
        },
        {
            "field_name":"age",
            "width": "500",
            "title":"年龄"
        },
        {
            "field_name":"friend",
            "title":"friend1"
        },
        {
            "field_name":"friend",
            "title":"friend1"
        },
        {
            "field_name":"friend",
            "title":"friend1"
        },
        {
            "field_name":"friend",
            "title":"friend1"
        },
        {
            "field_name":"friend",
            "title":"friend1"
        },
        {
            "field_name":"friend_END",
            "title":"friend1"
        }

    ],
    "result": [
        { "firstName":"Bill" , "age":"12", "lastName":"Gates","id":"100861008610086" },
        { "firstName":"George" , "lastName":"Bush","id":"10010" ,"age":"12" },
        { "firstName":"Thomas" , "lastName":"Carter","id":"12315" ,"age":"12" }
    ]
};

function AssembleColumn(){
	var column = datas.column;
	var allWidth = 0;
	$(column).each(function(index,obj){
		var field_name = obj.field_name;
		var width = parseInt(obj.width);
		if(width){
			allWidth += width;
		}else{
			allWidth += 100;
			width= 100;
		}
		$(".table-title-scroll-container").append('<div class="table-title" style="width:'+width+'px;">'+field_name+'</div>')
	});
	$(".table-title-scroll-container").css("width", (allWidth)+ "px");
	var widthLeft = $("#fixed_container_left").width();
	var widthRight = $("#fixed_container_right").width();
	var widthS = $(window.document.body).width();
	var s = widthS-widthLeft-widthRight;
	//$(".table-title-scroll").css("width", (s)  + "px");
}

$(function(){
	AssembleColumn();
});