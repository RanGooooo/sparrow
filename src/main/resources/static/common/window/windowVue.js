try {
    if(window.windowVue === undefined){
        window.windowVue = new Vue({
            data: {
                loading:null,
                size_button: "small",/*系统按钮大小*/
                size_input: "small",/*系统输入框大小*/
            },
            mounted() {
            },
            methods: {

            }
        });
    }
}
catch(err){
}

