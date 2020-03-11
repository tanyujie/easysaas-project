 
    (function (doc, win) {
        var docEl = doc.documentElement,
            resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
            recalc = function () {
                var clientWidth = docEl.clientWidth;
                if (!clientWidth) return;
                if(clientWidth>=640){
                    docEl.style.fontSize = '100px';
                }else{
                    docEl.style.fontSize = 100 * (clientWidth / 640) + 'px';
                }
            };
 
        if (!doc.addEventListener) return;
        win.addEventListener(resizeEvt, recalc, false);
        doc.addEventListener('DOMContentLoaded', recalc, false);
    })(document, window);

  
    //历史记录时间结束

    // 点击顶部切换页面
    var odiv_lines1 = document.getElementsByClassName('header-info')[0];//获取顶部“访客信息”
    var odiv_lines2 = document.getElementsByClassName('header-rec')[0];//获取顶部“历史记录”
    var lines1 = document.getElementsByClassName('header-info-i')[0];//获取顶部访客信息的下横线
    var lines2 = document.getElementsByClassName('header-rec-i')[0];//获取顶部历史记录的下横线
    var ylInfo = document.getElementsByClassName("ylInfo")[0];//获取访客页面
    var ylVistor = document.getElementsByClassName("ylVistor")[0];//获取历史记录页面
    
    odiv_lines1.onclick = function(){//点击顶部“访客记录”实现下横线固定；且切换访客信息和历史记录页面
        odiv_lines1.style.color = "#2273f8"
        odiv_lines2.style.color = "#000000"
        lines1.className ="header-info-i cur"
        lines2.className ="header-rec-i"
        ylInfo.style.display = "block"
        ylVistor.style.display = "none"
    }
    /*odiv_lines2.onclick = function(){//点击顶部“历史记录”实现下横线固定；且切换访客信息和历史记录页面
        odiv_lines1.style.color = "#000000"
        odiv_lines2.style.color = "#2273f8"
        lines1.className ="header-info-i"
        lines2.className ="header-rec-i cur"
        ylInfo.style.display = "none"
        ylVistor.style.display = "block"
    }*/