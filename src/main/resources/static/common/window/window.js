try {
    if(window.commonVue === undefined){
        window.commonVue = new Vue({
            el: '#commonVueApp',
            data: function() {
                return {
                }
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
                    const loading = this.$loading({
                        lock: true,
                        text: text,
                        spinner: spinner,
                        background: background
                    });
                    return loading;
                }
            }
        });
    }
}
catch(err){
}

