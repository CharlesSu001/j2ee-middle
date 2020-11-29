function calc(){
    var num1=document.getElementById("num1").value;
    var num2=document.getElementById("num1").value;
    num1=parseFloat(num1);
    num2=parseFloat(num2);
    var result=num1+num2;
    document.getElementById("result").value=result;
}


function $(id){
    var value=document.getElementById(id).value;
    return value;
}

function generate(){
    var location=$("location");
    var companyType= $("companyType");
    var companyName= $("companyName");
    var bossName= $("bossName");
    var money= $("money");
    var product= $("product");
    var unit= $("unit");

    var result  = location +"最大"+companyType+companyName+"倒闭了，王八蛋老板"+bossName+"吃喝嫖赌，欠下了"+money+"个亿，"
        + "带着他的小姨子跑了!我们没有办法，拿着"+product+"抵工资!原价都是一"+unit+"多、两"+unit+"多、三"+unit+"多的"+product+"，"
        + "现在全部只卖二十块，统统只要二十块!"+bossName+"王八蛋，你不是人!我们辛辛苦苦给你干了大半年，"
        + "你不发工资，你还我血汗钱，还我血汗钱!";


    document.getElementById("result").value=result;

}


document.write("<p>浏览器产品名称：");
document.write(navigator.appName + "</p>");

document.write("<p>浏览器版本号：");
document.write(navigator.appVersion + "</p>");

document.write("<p>浏览器内部代码：");
document.write(navigator.appCodeName + "</p>");

document.write("<p>操作系统：");
document.write(navigator.platform + "</p>");

document.write("<p>是否启用Cookies：");
document.write(navigator.cookieEnabled + "</p>");

document.write("<p>浏览器的用户代理报头：");
document.write(navigator.userAgent + "</p>");


document.write("用户的屏幕分辨率: ")
document.write(screen.width + "*" + screen.height)
document.write("<br />")
document.write("可用区域大小: ")
document.write(screen.availWidth + "*" + screen.availHeight)
document.write("<br />")


var gareen={
    "name":"盖伦",
    "hp":616
};