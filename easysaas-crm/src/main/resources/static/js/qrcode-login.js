var qrcode = {
    token: "",
    count: 0,
    interval: "",
    getQrCode: function () {
        $.getJSON("/qrcode", function (data) {
            if (data.status) {
                let d = data.data;
                qrcode.token = d.token;
                qrcode.count = 0;
                $("#qrCodeImage").attr("src", "data:image/png;base64," + d.image);
                qrcode.interval = setInterval(qrcode.waitScan, 2000);
                $(".qrcode").show();
               // $(".error-text").hide();
               // $(".confirm-box").hide();
            }
        });
    },
    waitScan: function () {
        if (qrcode.count > 60) {
            clearInterval(qrcode.interval);
           // $(".error-text").show();
            //$(".qrcode").hide();
           // $(".confirm-box").hide();
        } else {
            qrcode.count++;
            $.getJSON("/qrcode/scan/loop", {"token": qrcode.token}, function (data) {
                if (data.status) {
                    if (data.type === 1) {
                        // 待扫描
                        console.log("待扫描,继续轮询");
                    } else if (data.type === 2) {
                        // 已扫描，待登录
                        $("#user-name-text").html(data.userName);
                      //  $(".confirm-box").show();
                       // $(".error-text").hide();
                        $(".qrcode").hide();
                    } else if (data.type === 3) {
                        // 已经确认登录
                        clearInterval(qrcode.interval);
                        window.location.href = "/welcome?userName=" + data.userName;
                    } else {
                        // 其余情况全部重新加载
                        clearInterval(qrcode.interval);
                        qrcode.getQrCode();
                    }
                }
            })
        }
    }
};