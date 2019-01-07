var cupa = 1; //当前页面，全局变量
var vm = null;
function pagereload(url,id,func){
    var timestamp=new Date().getTime();
    $.ajax({
        url:url+'?pageNo='+cupa+'&timestamp='+timestamp,
        type:'get',
        dataType:'JSON',
        success:function (data) {
            if(data.code="1"){
                var a = data.data.list;
                func(a);
                Paginatorinit(id,url,data.data.pages)
            }else{
                alert(JSON.stringify(data.msg));
            }

        },
        error: function(data){
            alert("网路异常");
        }
    })
}

function repagereload(url,id){
    var timestamp=new Date().getTime();
    $.ajax({
        url:url+'?pageNo='+cupa+'&timestamp='+timestamp,
        type:'get',
        dataType:'JSON',
        success:function (data) {
            if(data.code="1"){
                var b = data.data.list;
                //Vue.set(vm,sites, b)
                vm.$data.sites = b;

                console.log(b);
                Paginatorinit(id,url,data.data.pages)
            }else{
                alert(JSON.stringify(data.msg));
            }

        },
        error: function(data){
            alert("网路异常");
        }
    })
}

function Paginatorinit(id,url,pages){
    $(id).bootstrapPaginator({
        currentPage: 1,
        totalPages: pages,
        size:"normal",
        bootstrapMajorVersion: 3,
        alignment:"right",
        numberOfPages:8,
        itemTexts: function (type, page, current) {
            switch (type) {
                case "first": return "首页";
                case "prev": return "上一页";
                case "next": return "下一页";
                case "last": return "末页";
                case "page": return page;
            }//默认显示的是第一页。
        },
        onPageClicked: function (event, originalEvent, type, page){//给每个页眉绑定一个事件，其实就是ajax请求，其中page变量为当前点击的页上的数字。
            cupa = page
            $.ajax({
                url:url+'?pageNo='+page,
                type:'get',
                dataType:'JSON',
                success:function (data) {
                    if(data.code="1"){
                        a = data.data.list;
                        console.log(a);
                        vm.$data.sites = a;
                    }else{
                        alert(JSON.stringify(data.msg));
                    }

                },
                error: function(data){
                    alert("网路异常");
                }
            })
        }
    });
}

function searchlist(url,id,name){
    $.ajax({
        url:url+'?uId='+name,
        type:'get',
        dataType:'JSON',
        success:function (data) {
            if(data.code="1"){
                var b = data.data.list;
                vm.$data.sites = b;
                console.log(b);
                PaginatorinitSerrch(id,url,data.data.pages,name)
            }else{
                alert(JSON.stringify(data.msg));
            }

        },
        error: function(data){
            alert("网路异常");
        }
    })
}
function PaginatorinitSerrch(id,url,pages,name){
    $(id).bootstrapPaginator({
        currentPage: 1,
        totalPages: pages,
        size:"normal",
        bootstrapMajorVersion: 3,
        alignment:"right",
        numberOfPages:8,
        itemTexts: function (type, page, current) {
            switch (type) {
                case "first": return "首页";
                case "prev": return "上一页";
                case "next": return "下一页";
                case "last": return "末页";
                case "page": return page;
            }//默认显示的是第一页。
        },
        onPageClicked: function (event, originalEvent, type, page){//给每个页眉绑定一个事件，其实就是ajax请求，其中page变量为当前点击的页上的数字。
            cupa = page
            $.ajax({
                url:url+'?pageNo='+page+'&uId='+name,
                type:'get',
                dataType:'JSON',
                success:function (data) {
                    if(data.code="1"){
                        a = data.data.list;

                        vm.$data.sites = a;
                    }else{
                        alert(JSON.stringify(data.msg));
                    }

                },
                error: function(data){
                    alert("网路异常");
                }
            })
        }
    });
}



function getJson(url,func){$.ajax({
    type:'get',
    url:url,
    dataType: 'json',
    success: function(data){ if (data.code=="1"){var a = data.data.list;func(a);}else{  alert(JSON.stringify(data.msg));  }  },
    error: function(data){  alert("网路异常");  }  });
}


function postJson(url,datainfo){
    $.ajax({
        type:'post',
        url:url,
        dataType: 'json',
        contentType:"application/json;charset=UTF-8",
        data: datainfo,
        success: function(data){ if (data.code=="1"){ alert(data.msg) }else{  alert(JSON.stringify(data.msg));  }  },
        error: function(data){  alert("网路异常");  }
    });
}

function postJsondata(url,datainfo,func){$.ajax({
    type:'post',
    url:url,
    dataType: 'json',
    contentType:"application/json;charset=UTF-8",
    data: datainfo,
    success: function(data){ if (data.code=="1"){var a = data.data;func(a);}else{  alert(JSON.stringify(data.msg));  }  },
    error: function(data){  alert("网路异常");  }  });
}


function pushDom(datasou){
    vm = new Vue({
        el: '#app',
        data: {
            sites: datasou
        }
    })
}

function updateinfolist(a){

    $("#oId").val(a.oId);
    $("#uId").val(a.uId);
    $("#ofId").val(a.iId);
    $("#oftime").val(a.iGotime);
    $("#oNum").val(a.oNum);
    $("#oTotal").val(a.oTotal);
}


var adminlist_url = "../order/orderlist";//请求订单列表
var admininfo_url = "../order/orderinfo";//指定订单信息
var updateadmininfo_url = "../order/updateorderinfo";//修改
var deleteadmininfo_url = "../order/deleteorderinfo";//退订
var addadmin_url = "../order/addorder";//添加订单
var searchbyname_url = "../order/searchbyname";//搜索
var clear_url = "../order/deleteorderinfoclear";//清除订单


pagereload(adminlist_url,"#pageLimit",pushDom);



$("body").on('click','.deleteuserinfo',function(){
    var now = $(this);
    var id = now.data("id");
    var dataObj = { "oId" : id };
    var data = JSON.stringify(dataObj);
    postJson(deleteadmininfo_url,data);
    now.parent().parent().fadeTo("slow", 0.01, function(){//fade
        now.parent().parent().slideUp("slow", function() {//slide up
            now.parent().parent().remove();//then remove from the DOM
        });
    });
    repagereload(adminlist_url,"#pageLimit");
});

$("body").on('click','.clear',function(){
    var now = $(this);
    var id = now.data("id");
    var dataObj = { "oId" : id };
    var data = JSON.stringify(dataObj);
    postJson(clear_url,data);
        now.parent().parent().fadeTo("slow", 0.01, function(){//fade
            now.parent().parent().slideUp("slow", function() {//slide up
                now.parent().parent().remove();//then remove from the DOM
            });
        });
    repagereload(adminlist_url,"#pageLimit");
});

$("body").on('click','.userinfo',function(){
    var now = $(this);
    var uid = now.data("id");
    var dataObj = { "oId" : uid };
    var data = JSON.stringify(dataObj);
    postJsondata(admininfo_url,data,updateinfolist);

});

$("body").on('click','#userupdate',function(){
    var formjson = getStringjsonformdata("userupdateform");
    postJson(updateadmininfo_url,formjson);
    repagereload(adminlist_url,"#pageLimit");

});

$("body").on('click','#searchbook',function(){
    var name = $("#serrchinput").val();
    if(name == ""){
        repagereload(adminlist_url,"#pageLimit");
    }else{
        searchlist(searchbyname_url,"#pageLimit",name);
    }

});
$("body").on('click','#adminlog',function() {
    $.ajax({
        type: 'get',
        url: "../login/adminlogout",
        dataType: 'json',
        contentType: "application/json;charset=UTF-8",
        cache: false, //设置为 false 将不会从浏览器缓存中加载请求信息。

        //timeout: 150000, //设置请求超时时间（毫秒）。此设置将覆盖全局设置。
        success: function (data) {

            if (data.code == "1") {
                location.href = "index.html";
            }
            else {
                //location.href = "index.html";
            }
        },
        error: function (data) {
            //location.href = "index.html";
        }
    })
});
function startTime() {
    var today = new Date();
    var y = today.getFullYear();
    var M = today.getMonth()+1;
    var d = today.getDate();
    var w = today.getDay();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    var week=['星期天','星期一','星期二','星期三','星期四','星期五','星期六'];
    // add a zero in front of numbers<10
    m = checkTime(m);
    s = checkTime(s);
    $('#sj').html('本地时间：'+h+':'+m+':'+s+' '+y+'-'+M+'-'+d+" "+week[w]);//可改变格式
    t = setTimeout(startTime, 500);
    function checkTime(i) {
        if (i < 10) {
            i = "0" + i;
        }
        return i;
    }
}
startTime();