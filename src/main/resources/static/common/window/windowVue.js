try {
    if(window.windowVue === undefined){
        window.windowVue = new Vue({
            el: '#windowVue',
            data: {
                loading:null,
                size_button: "medium",/*系统按钮大小*/
                size_input: "medium",/*系统输入框大小*/
            },
            mounted() {
            },
            methods: {
                showSuccessMessage(message){
                    this.$notify({title: "成功",message: message,type: "success"});
                },
                showWarningMessage(message){
                    this.$notify({title: "警告",message: message,type: "warning"});
                },
                showErrorMessage(message){
                    if(!message){
                        message = "系统错误";
                    }
                    this.$notify.error({title: "错误",message: message});
                },
                openFullScreen(text,spinner,background) {
                    this.loading = this.$loading({
                        background: background
                    });
                },
            }
        });
    }
}
catch(err){
}

