try {
    if(window.windowVue === undefined){
        window.windowVue = new Vue({
            el: '#windowVue',
            data: {
                loading:null,
                buttonSize: "small",
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

