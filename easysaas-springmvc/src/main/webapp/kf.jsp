<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>在线客服</title>


</head>
<body style="text-algin:center">
请稍后正在为您转入...
<script>

//第一步先声明全局时间方法

    //易聊js引入
    document.writeln("<script type='text/javascript' charset='UTF-8' src='http://scripts.easyliao.com/js/easyliao.js'><\/script>");

    window.onload=function(){
        function openJesongChat1(a,b,c,d,e){var f="";return"c"==b?f+="n="+c:"g"==b&&(f+="g="+c),d&&(f+="&tag="+d),e&&(f+="&msg="+window.encodeURIComponent(e)),openNoJesongJsChat1(a,f),!1}function openNoJesongJsChat1(a,b){var d,e,c="http://live.jswebcall.com/live/chat.do?c="+a;c=c+"&chatUrl="+window.encodeURIComponent(window.location.href),"string"==typeof b&&0!=b.length&&(c+="&"+b),getCook("JESONG_VISITOR_ID")&&(c=c+"&v="+getCook("JESONG_VISITOR_ID")),getCook("JESONG_USER_ID")&&(c=c+"&u="+getCook("JESONG_USER_ID")),getCook("im_refer")?c=c+"&ref="+window.encodeURIComponent(getCook("im_refer")):(d=getPageRefer(),""!=d&&(c=c+"&ref="+window.encodeURIComponent(d))),e=null,getCook("JESONG_EXT_DATA")&&(e=getCook("JESONG_EXT_DATA")),"undefined"!=typeof JESONG_EXT_DATA&&(e=JESONG_EXT_DATA),null!=e&&""!=e&&(c=c+"&ext="+window.encodeURIComponent(e)),window.location=c}
        openJesongChat1("13157","g","25433",0,"");
    }




</script>
</body>
</html>
