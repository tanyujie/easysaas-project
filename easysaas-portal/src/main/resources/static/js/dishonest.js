function Dishonest11(){
	var p = new Object;
	p.confirm = function(){
		alert("w");
		var t=$(".name").val().trim(),i=$(".name").siblings(".tooltip-box");
		alert(t);
	};
}
var Dishonest1 = Dishonest11();
function search(){
	var t=$(".name").val().trim();
	location.href="/dishonest/result?name="+t+"&type=2"
}