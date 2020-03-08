<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'/>
</head>
<body>
<form id="login-form" style="display: none">
    <div>
        <label>
            <input type="text" id="userName" value="fantasy"/>
        </label>
    </div>
    <div>
        <label>
            <input type="button" onclick="confirmLogin()" value="确认登录"/>
        </label>
    </div>
    <div>
        <label>
            <input type="button" onclick="cancelLogin()" value="取消登录"/>
        </label>
    </div>
</form>
<div id="div-text" style="display:"> 请稍等... 正在加载</div>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
    var token = '${token}';
    $(function () {
        let userName = $("#userName").val();
        $.post(
            "/qrcode/scan/ok",
            {
                "token": token,
                "userName": userName
            },
            function (data) {
                if (data.status){
                    $("#login-form").show();
                    $("#div-text").hide();
                }
            },
            "json"
        )
    });
    function confirmLogin() {
        let url = "/qrcode/scan/login/"+ token;
        let userName = $("#userName").val();
        $.post(url,{"userName":userName},function (data) {
            if (data.status) {
                $("#div-text").html("login success");
            }else{
                $("#div-text").html("login failed,please fresh your web page in PC");
            }
            $("#div-text").show();
            $("#login-form").hide();
        },"json")
    }
    function cancelLogin () {
        let url = "/qrcode/scan/cancel/"+ token;
        $.post(url,{},function (data) {
            if (data.status) {
                $("#div-text").html("cancel login success");
            }else{
                $("#div-text").html("cancel failed,please fresh your web page in PC");
            }
            $("#div-text").show();
            $("#login-form").hide();
        },"json")
    }
</script>
</body>
</html>