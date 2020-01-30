$(document).ready(function(){
 

$("#btnCompanyExport").click(function(){
	$.ajax({
        async : false,    //表示请求是否异步处理
        type : "post",    //请求类型
        url : "/company/export.do",
        data: {exportNumber:100, email:"13551259347@139.com",keyword:"北京"},
        dataType : "json",
        success: function (data) {
          console.log(data); 
          alert(data);
        },
        error:function (data) {
            alert(data.result);
        }
    });
}); 
});


