//定义HTTP连接对象
var xmlHttp;

//实例化HTTP连接对象
function createXmlHttpRequest() {
    if(window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    } else if(window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
}


//发起登录请求
function main() {
    var emp_id=window.location.search;
    console.log(emp_id);
    createXmlHttpRequest();
    var url = "Main.do"+emp_id;
    //不知道这里的代码为啥要这样写。。。。。如果不这样写 mlHttp.readyState 会一直=1 而且返回的json不能被接收 草..........
    //console.log(url);
    xmlHttp.open("GET",url,true);
    xmlHttp.onreadystatechange = handleResult;
    xmlHttp.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
    xmlHttp.send(null);

}

//处理服务器返回的结果/更新页面
function handleResult() {
    console.log("进入这里handleresult");
    console.log(xmlHttp.readyState, xmlHttp.status);
    if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
        console.log("成功进入这里");
        console.log(typeof xmlHttp.responseText);//服务器响应的原始数据
        //console.log(typeof eval('('+xmlHttp.responseText+')'));//不推荐使用
        console.log(typeof JSON.parse(xmlHttp.responseText));
        rel = JSON.parse(xmlHttp.responseText);
        //console.log(rel.menutree.业务办理);

        firstul=$("<ul class=\"accordion\"></ul>");
        for( i in rel.menutree){
            fatherli=$("<li></li>");
            fatherspan=$("<span>"+i+"</span>");
            sondiv=$("<div></div>")
            sonul=$("<ul></ul>");
            console.log("这是父节点:"+i);
            for (j in rel.menutree[i]){
                //这里onclick可以将地址发送过去
                sonli=$("<li onclick='test()'>"+rel.menutree[i][j]+"</li>");
                sonul.append(sonli);
                console.log("这是子节点:"+rel.menutree[i][j]);
            }
            sondiv.append(sonul);
            fatherli.append(fatherspan);
            fatherli.append(sondiv);
            firstul.append(fatherli);
            $(".menu").append(firstul);
        }
        //这是点击大标题的效果 不要动
        $("ul.accordion li span").on('click', function () {
            $(this).parent().siblings().removeClass('selected').find('div').hide();
            $(this).parent().addClass('selected');
            $(this).next().slideDown(500);
        });
    }
}
