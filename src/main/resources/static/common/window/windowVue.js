try {
    if(window.windowVue === undefined){
        window.windowVue = new Vue({
            data: {
                loading:null,/*页面遮挡*/
                size_button: "small",/*系统按钮大小*/
                size_input: "small",/*系统输入框大小*/
            }
        });
    }
}
catch(err){
}

