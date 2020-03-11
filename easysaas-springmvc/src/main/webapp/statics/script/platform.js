var PT = PT || {};

$.extend($.fn.panel.defaults, {
	loadingMessage : '加载中....'
});
$.extend($.fn.datagrid.defaults, {
	loadMsg : '数据加载中....',
	rownumbers : true,
	pagination : true,
	pageSize : 15,
	singleSelect : true,
	pageList : [15,25,30,50]
});

$.extend($.fn.panel.defaults, {
	onBeforeDestroy : function() {
		var frame = $('iframe', this);
		try {
			if (frame.length > 0) {
				for (var i = 0; i < frame.length; i++) {
					frame[i].src = '';
					frame[i].contentWindow.document.write('');
					frame[i].contentWindow.close();
				}
				frame.remove();
				if (navigator.userAgent.indexOf("MSIE") > 0) {// IE特有回收内存方法
					try {
						CollectGarbage();
					} catch (e) {
					}
				}
			}
		} catch (e) {
		}
	}
});

var panelMoveOpts = {
	onMove : function(left, top) {
		var l = left;
		var t = top;
		if (l < 1) {
			l = 1;
		}
		if (t < 1) {
			t = 1;
		}
		var width = parseInt($(this).parent().css('width')) + 14;
		var height = parseInt($(this).parent().css('height')) + 14;
		var right = l + width;
		var buttom = t + height;
		var browserWidth = $(window).width();
		var browserHeight = $(window).height();
		if (right > browserWidth) {
			l = browserWidth - width;
		}
		if (buttom > browserHeight) {
			t = browserHeight - height;
		}
		$(this).parent().css({
			left : l,
			top : t
		});
	}
};
$.extend($.fn.dialog.defaults, panelMoveOpts);
$.extend($.fn.window.defaults, panelMoveOpts);
$.extend($.fn.panel.defaults, panelMoveOpts);


var dataLoadErrorOpts = {
	onLoadError : function(XMLHttpRequest) {
		if (parent.$ && parent.$.messager) {
			parent.$.messager.progress('close');
			//parent.$.messager.alert('错误', XMLHttpRequest.responseText);
		} else {
			$.messager.progress('close');
			//$.messager.alert('错误', XMLHttpRequest.responseText);
		}
	}
};
$.extend($.fn.datagrid.defaults, dataLoadErrorOpts);
$.extend($.fn.treegrid.defaults, dataLoadErrorOpts);
$.extend($.fn.tree.defaults, dataLoadErrorOpts);
$.extend($.fn.combogrid.defaults, dataLoadErrorOpts);
$.extend($.fn.combobox.defaults, dataLoadErrorOpts);
$.extend($.fn.form.defaults, dataLoadErrorOpts);


/*$.extend($.fn.combobox.defaults, {
	onShowPanel : function() {
		var _options = $(this).combobox('options');
		if (_options.mode == 'remote') { 如果是自动补全模式 
			var _value = $(this).combobox('textbox').val();
			var _combobox = $(this);
			if (_value.length > 0) {
				$.post(_options.url, {
					q : _value
				}, function(result) {
					if (result && result.length > 0) {
						_combobox.combobox('loadData', result);
					}
				}, 'json');
			}
		}
	},
	onHidePanel : function() {
		var _options = $(this).combobox('options');
		if (_options.mode == 'remote') { 如果是自动补全模式 
			var _data = $(this).combobox('getData'); 下拉框所有选项 
			var _value = $(this).combobox('getValue'); 用户输入的值 
			var _b = false; 标识是否在下拉列表中找到了用户输入的字符 
			for (var i = 0; i < _data.length; i++) {
				if (_data[i][_options.valueField] == _value) {
					_b = true;
				}
			}
			if (!_b) { 如果在下拉列表中没找到用户输入的字符 
				$(this).combobox('setValue', '');
			}
		}
	}
});


$.extend($.fn.combogrid.defaults, {
	onShowPanel : function() {
		var _options = $(this).combogrid('options');
		if (_options.mode == 'remote') { 如果是自动补全模式 
			var _value = $(this).combogrid('textbox').val();
			if (_value.length > 0) {
				$(this).combogrid('grid').datagrid("load", {
					q : _value
				});
			}
		}
	},
	onHidePanel : function() {
		var _options = $(this).combogrid('options');
		if (_options.mode == 'remote') { 如果是自动补全模式 
			var _data = $(this).combogrid('grid').datagrid('getData').rows; 下拉框所有选项 
			var _value = $(this).combogrid('getValue'); 用户输入的值 
			var _b = false; 标识是否在下拉列表中找到了用户输入的字符 
			for (var i = 0; i < _data.length; i++) {
				if (_data[i][_options.idField] == _value) {
					_b = true;
				}
			}
			if (!_b) { 如果在下拉列表中没找到用户输入的字符 
				$(this).combogrid('setValue', '');
			}
		}
	}
});*/


$.extend($.fn.validatebox.defaults.rules, {
	eqPwd : {/* 验证两次密码是否一致功能 */
		validator : function(value, param) {
			return value == $(param[0]).val();
		},
		message : '密码不一致！'
	}
});

/*sy.loadFilter = {
	loadFilter : function(data, parent) {
		var opt = $(this).data().tree.options;
		var idField, textField, parentField;
		if (opt.parentField) {
			idField = opt.idField || 'id';
			textField = opt.textField || 'text';
			parentField = opt.parentField || 'pid';
			var i, l, treeData = [], tmpMap = [];
			for (i = 0, l = data.length; i < l; i++) {
				tmpMap[data[i][idField]] = data[i];
			}
			for (i = 0, l = data.length; i < l; i++) {
				if (tmpMap[data[i][parentField]] && data[i][idField] != data[i][parentField]) {
					if (!tmpMap[data[i][parentField]]['children'])
						tmpMap[data[i][parentField]]['children'] = [];
					data[i]['text'] = data[i][textField];
					tmpMap[data[i][parentField]]['children'].push(data[i]);
				} else {
					data[i]['text'] = data[i][textField];
					treeData.push(data[i]);
				}
			}
			return treeData;
		}
		return data;
	}
};
$.extend($.fn.combotree.defaults, sy.loadFilter);
$.extend($.fn.tree.defaults, sy.loadFilter);
*/
/*
$.extend($.fn.treegrid.defaults, {
	loadFilter : function(data, parentId) {
		var opt = $(this).data().treegrid.options;
		var idField, treeField, parentField;
		if (opt.parentField) {
			idField = opt.idField || 'id';
			treeField = opt.textField || 'text';
			parentField = opt.parentField || 'pid';
			var i, l, treeData = [], tmpMap = [];
			for (i = 0, l = data.length; i < l; i++) {
				tmpMap[data[i][idField]] = data[i];
			}
			for (i = 0, l = data.length; i < l; i++) {
				if (tmpMap[data[i][parentField]] && data[i][idField] != data[i][parentField]) {
					if (!tmpMap[data[i][parentField]]['children'])
						tmpMap[data[i][parentField]]['children'] = [];
					data[i]['text'] = data[i][treeField];
					tmpMap[data[i][parentField]]['children'].push(data[i]);
				} else {
					data[i]['text'] = data[i][treeField];
					treeData.push(data[i]);
				}
			}
			return treeData;
		}
		return data;
	}
});
*/
PT.alert = function(message){
	$.messager.alert("提示", message, "info");
};
PT.error = function(message){
	$.messager.alert("操作失败", message, "error");
};
PT.confirm = function(message, callback){
	$.messager.confirm("提示", message, function(r){
		if (r){
			callback();
		}
	});
};
PT.progress = function(message){
	$.messager.progress({
		text : message,
		interval : 300
	});
};
PT.closeProgress = function(){
	$.messager.progress("close");
};
PT.getAjaxUrl = function(uri){
	if(uri.indexOf("?")>0){
		uri += "&";
	}else{
		uri += "?";
	}
	uri += "_ajax=1";
	return uri;
};
PT.ajax = function(uri,params,callback){
	$.ajax({
		url:PT.getAjaxUrl(uri),
		type:'POST',
		dataType:'json',
		data:params||{},
		success:function(data){
			if(data.type == -1){
				window.location.reload(true);
			}else if(data.type == 0){
				PT.error(data.message);
			}else{
				callback(data);
			}
		}
	});
};
PT.execute = function(fun){
	window.setTimeout(fun, 1);
};
PT.uiSequence = 0;

PT.genId = function(ui) {
	PT.uiSequence++;
	return ui+"_"+PT.uiSequence;
};
PT.date2Text = function(v, fmt) {
	var fv = function(s){
		if(s<10){
			return '0'+s;
		}else{
			return s;
		}
	};
	if(typeof v=='string'){
		return v;
	}
	if (typeof v == 'number'){
		var v1 = new Date();
		v1.setTime(v);
		v = v1;
	} 
	if(v&&typeof v == 'object'){
		var fmtItem = ['yyyy','MM','dd','hh','mm','ss'];
		if(!fmt){
			fmt = 'yyyy-MM-dd';
		}
		var exp = new RegExp('(' + fmtItem.join('|') + ')', "g");
        var fv = function(v) {
            return v < 10 ? ('0' + v) : v;
        };
        return fmt.replace(exp, function($1, $2) {
            switch ($2) {
                case 'yyyy':return v.getFullYear();
                case 'MM':return fv(v.getMonth() + 1);
                case 'dd':return fv(v.getDate());
                case 'hh':return fv(v.getHours());
                case 'mm':return fv(v.getMinutes());
                case 'ss':return fv(v.getSeconds());
            }
        });
	}else{
		return '';
	}
};
PT.dialogForm = function(opts){
	var id = PT.genId("dialogForm");
	var options = $.extend(opts,{
		iconCls:'icon-form',
		onLoad : function(){
			$(this).parent().find("span.icon-ok").parent().parent().linkbutton("enable");
			if(options.loadSuccess){
				options.loadSuccess(this);
			}
		},
		onClose : function() {
			$(this).dialog("destroy");
		},
		onBeforeLoad : function(param){
		},
		onLoadError : function(){
			$(this).dialog("close");
			PT.error("数据加载错误，请联系管理员！");
		},
		extractor: function(data){
			var pattern = /<body[^>]*>((.|[\n\r])*)<\/body>/im;
			var matches = pattern.exec(data);
			if (matches){
				return matches[1];
			} else {
				return data;
			}
		},
		novalidate:false,
		ajax:false,
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			disabled:true,
			handler:function(){
				$(this).parent().parent().find('form').form('submit', {   
				    url:PT.getAjaxUrl(opts.commitURL), 
				    onSubmit: function(params){
				    	var flag = $(this).parent().parent().find('form').form('validate');
				    	if(options.beforeSubmit){
				    		flag = flag && options.beforeSubmit();
				    	}
				    	if(flag){
				    		$("#"+id).parent().find("span.icon-ok").parent().parent().linkbutton("disable");
				    		PT.progress("数据提交中...");
				    	}
				    	return flag;
				    },success:function(data){
				    	try{
				    		PT.closeProgress();
					    	var data=eval('('+data+')');
					        if(data.type == 0){
					        	$("#"+id).parent().find("span.icon-ok").parent().parent().linkbutton("enable");
					        	PT.error(data.message);
					        }else if(data.type == -1){//未登录
					        	window.location.reload(true);
					        }else{
					        	$('#'+id).dialog("close");
					        	if(options.commitSuccess){
					        		options.commitSuccess(data);
					        	}
					        }
				    	}catch(e){
				    		$("#"+id).parent().find("span.icon-ok").parent().parent().linkbutton("enable");
				    		PT.error("操作失败:"+e.message);
				    	}
				    }   
				});
			}
		},{
			text:'取消',
			iconCls:'icon-cancel',
			handler:function(){
				$("#" + id).dialog('close');
			}
		}]
	});
	options.modal = true;
	if(opts.customButtons){
		/*var closeFun = function(){
			$("#" + id).dialog('close');
		};
		for(var i=0; i<opts.customButtons.length; i++){
			var e = opts.customButtons[i];
			var event = opts.customButtons[i].handler;
			if(event){
				opts.customButtons[i].handler = function(){
					if(event){
						alert(e.text);
						event.apply(this, [closeFun]);
					}
				};
			}
		}*/
		if(opts.customButtonPos == "left"){
			for(var i=0; i<options.buttons.length; i++){
				opts.customButtons.push(options.buttons[i]);
			}
			options.buttons = opts.customButtons;
		}else{
			for(var i=0; i<opts.customButtons.length; i++){
				options.buttons.push(opts.customButtons[i]);
			}
		}
	}
	return $("<div id=\""+id+"\"></div>").dialog(options);
};

PT.modalDialog = function(options) {
	var opts = $.extend({
		title : '&nbsp;',
		width : 640,
		height : 480,
		modal : true,
		onClose : function() {
			$(this).dialog('destroy');
		}
	}, options);
	opts.modal = true;// 强制此dialog为模式化，无视传递过来的modal参数
	if (options.url) {
		opts.content = '<iframe id="" src="' + options.url + '" allowTransparency="true" scrolling="auto" width="100%" height="98%" frameBorder="0" name=""></iframe>';
	}
	return $('<div/>').dialog(opts);
};

PT.tpl = function (s, obj, escape) {
	var jsonValue = (function () {
        var existProp = function (obj, t) {
            return typeof obj[t] != 'undefined';
        };
        var ignoreCase = function (obj, t) {
            if (existProp(obj, t)) return obj[t];
            if (existProp(obj, t.toLowerCase())) return obj[t.toLowerCase()];
            return obj[t.toUpperCase()];
        };
        return function (obj, key, def) {
            var tokens = key.split(".");
            for (var i = 0; i < tokens.length; i++) {
                var t = tokens[i];
                obj = ignoreCase(obj, t);
                if (obj == undefined) break;
            }
            return obj == undefined ? def : obj;
        };
    })();
	var escapeXml = (function () {
        var htmlEscapes = {
            '&': '&amp;',
            '<': '&lt;',
            '>': '&gt;',
            '"': '&quot;',
            "'": '&#x27;',
            '/': '&#x2F;',
            '\u0000': ''
        };
        var htmlEscapeReg = /[&<>\u0000"'\/]/g;
        return function (v) {
            v = v || '';
            return typeof v == 'string' ? v.replace(htmlEscapeReg, function (m) {
                return htmlEscapes[m];
            }) : v;
        };
    })();
    return s.replace(/\{([a-zA-z0-9]*)\}/ig, function ($1, $2) {
        var v = $.isArray(obj) ? obj[$2] : jsonValue(obj, $2);
        return escape && v ? escapeXml(v) : v;
    });
};

$(function(){
	$(document).ajaxStart(function(){
		if(parent && parent.PT){
			parent.PT.progress("数据提交中...");
		}else{
			PT.progress("数据提交中...");
		}
		
	}).ajaxStop(function(){
		if(parent && parent.PT){
			parent.PT.closeProgress();
		}else{
			PT.closeProgress();
		}
		
	});
});

/*PT.progressBar = function(options) {
	if (typeof options == 'string') {
		if (options == 'close') {
			$('#syProgressBarDiv').dialog('destroy');
		}
	} else {
		if ($('#syProgressBarDiv').length < 1) {
			var opts = $.extend({
				title : '&nbsp;',
				closable : false,
				width : 300,
				height : 60,
				modal : true,
				content : '<div id="syProgressBar" class="easyui-progressbar" data-options="value:0"></div>'
			}, options);
			$('<div id="syProgressBarDiv"/>').dialog(opts);
			$.parser.parse('#syProgressBarDiv');
		} else {
			$('#syProgressBarDiv').dialog('open');
		}
		if (options.value) {
			$('#syProgressBar').progressbar('setValue', options.value);
		}
	}
};*/
/**/

/**
 * 等同于原form的load方法，但是这个方法支持{data:{name:''}}形式的对象赋值
 */
/*$.extend($.fn.form.methods, {
	loadData : function(jq, data) {
		return jq.each(function() {
			load(this, data);
		});

		function load(target, data) {
			if (!$.data(target, 'form')) {
				$.data(target, 'form', {
					options : $.extend({}, $.fn.form.defaults)
				});
			}
			var opts = $.data(target, 'form').options;

			if (typeof data == 'string') {
				var param = {};
				if (opts.onBeforeLoad.call(target, param) == false)
					return;

				$.ajax({
					url : data,
					data : param,
					dataType : 'json',
					success : function(data) {
						_load(data);
					},
					error : function() {
						opts.onLoadError.apply(target, arguments);
					}
				});
			} else {
				_load(data);
			}
			function _load(data) {
				var form = $(target);
				var formFields = form.find("input[name],select[name],textarea[name]");
				formFields.each(function() {
					var name = this.name;
					var value = jQuery.proxy(function() {
						try {
							return eval('this.' + name);
						} catch (e) {
							return "";
						}
					}, data)();
					var rr = _checkField(name, value);
					if (!rr.length) {
						var f = form.find("input[numberboxName=\"" + name + "\"]");
						if (f.length) {
							f.numberbox("setValue", value);
						} else {
							$("input[name=\"" + name + "\"]", form).val(value);
							$("textarea[name=\"" + name + "\"]", form).val(value);
							$("select[name=\"" + name + "\"]", form).val(value);
						}
					}
					_loadCombo(name, value);
				});
				opts.onLoadSuccess.call(target, data);
				$(target).form("validate");
			}

			function _checkField(name, val) {
				var rr = $(target).find('input[name="' + name + '"][type=radio], input[name="' + name + '"][type=checkbox]');
				rr._propAttr('checked', false);
				rr.each(function() {
					var f = $(this);
					if (f.val() == String(val) || $.inArray(f.val(), val) >= 0) {
						f._propAttr('checked', true);
					}
				});
				return rr;
			}

			function _loadCombo(name, val) {
				var form = $(target);
				var cc = [ 'combobox', 'combotree', 'combogrid', 'datetimebox', 'datebox', 'combo' ];
				var c = form.find('[comboName="' + name + '"]');
				if (c.length) {
					for (var i = 0; i < cc.length; i++) {
						var type = cc[i];
						if (c.hasClass(type + '-f')) {
							if (c[type]('options').multiple) {
								c[type]('setValues', val);
							} else {
								c[type]('setValue', val);
							}
							return;
						}
					}
				}
			}
		}
	}
});*/


/*sy.changeTheme = function(themeName) {
	var $easyuiTheme = $('#easyuiTheme');
	var url = $easyuiTheme.attr('href');
	var href = url.substring(0, url.indexOf('themes')) + 'themes/' + themeName + '/easyui.css';
	$easyuiTheme.attr('href', href);

	var $iframe = $('iframe');
	if ($iframe.length > 0) {
		for (var i = 0; i < $iframe.length; i++) {
			var ifr = $iframe[i];
			try {
				$(ifr).contents().find('#easyuiTheme').attr('href', href);
			} catch (e) {
				try {
					ifr.contentWindow.document.getElementById('easyuiTheme').href = href;
				} catch (e) {
				}
			}
		}
	}

	sy.cookie('easyuiTheme', themeName, {
		expires : 7
	});
};*/



/*
function onChangeTheme(theme){
	var link = $('#content').find('link:first');
	link.attr('href', '/easyui/themes/'+theme+'/easyui.css');
}*/