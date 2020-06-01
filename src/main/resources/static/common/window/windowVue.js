try {
    if(window.windowVue === undefined){
        window.windowVue = new Vue({
            el: "#windowVueApp",
            data: {
                loading:null,/*页面遮挡*/
                size_button: "small",/*系统按钮大小*/
                size_input: "small",/*系统输入框大小*/
                dialog_width: {
                    WIDTH_XXL : "1200px",
                    WIDTH_XL : "900px",
                    WIDTH_L : "600px",
                    WIDTH_M : "500px",
                    WIDTH_SM : "200px",
                },
                dialog_height: {
                    HEIGHT_XXL : "800px",
                    HEIGHT_XL : "600px",
                    HEIGHT_L : "400px",
                    HEIGHT_M : "200px",
                    HEIGHT_SM : "100px"
                },
            }
        });
    }
}
catch(err){
}

