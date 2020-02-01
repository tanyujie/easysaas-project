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

function jwindow(){
	var oCar = new Object;
	oCar.toggleFilter = function(i){
		var t=$("#search-filter").hasClass("-folder");
		if(t){
			$(".expand").html("收起");
			$(".search-filter").removeClass("-folder");
		}									
		else{
			$(".expand").html("更多");
			$(".search-filter").addClass("-folder");
		}
	};
	oCar.companyExport = function(){
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
	}
		//e(i).closest(".search-filter").hasClass("-folder")||e(i).closest(".search-filter").hasClass("-showfilter")?(e(i).closest(".search-filter").removeClass("-folder").removeClass("-showfilter"),e(i).html("收起"),t.stget&&t.stget("CompanySearch.Filter.More")):(e(i).closest(".search-filter").find(".filter-select").length?e(i).closest(".search-filter").addClass("-showfilter"):e(i).closest(".search-filter").addClass("-folder"),e(i).html("更多"),t.stget&&t.stget("CompanySearch.Filter.Close"))},
	 return oCar;
}
var window1 = jwindow();
