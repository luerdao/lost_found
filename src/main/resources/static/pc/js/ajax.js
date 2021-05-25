$(function(){
    $("#log").on("click", function () {//这里绑定了登录按钮
        let a= $("#username").val();
        console.log(a);
        let b= $("#password").val();
        console.log(b);
        $.ajax({//这里开始ajax请求
        	//向后台请求数据的方式
            type: 'get',//这个是get和post请求选择
            //请求后台的地址可以简写
            url: "http://localhost:8080/login",//这里填你的东西 比如我那边实例aaa就开了葛8080端口可以接收所有的东西
            data: {
                //这里是传的数据
                a:100,
                username:$("#username").val(),//绑定了uername
                password:$("#password").val(),//绑定了password
            },
            //这里是把响应体打印一下
            success: function (response) {
                console.log(response);
            },
        });
    });
})

