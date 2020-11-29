document.write("Hello Javascript");
document.write("第一段javascript");
document.write("第二段javascript");
alert(1);

x=10;
document.write("变量的值为:"+x);


var x;
document.write('声明了但是未赋值的时候，类型是： '+typeof x);
document.write("<br>");
x=5;
document.write('赋值为5之后，类型是： '+typeof x);
document.write("<br>");
x=5.1;
document.write('赋值为5.1之后，类型是： '+typeof x);
document.write("<br>");
x=true;
document.write('赋值为true之后，类型是： '+typeof x);
document.write("<br>");
x="hello";
document.write('赋值为hello之后，类型是： '+typeof x);


var a="hello javascript";
document.write("变量a的类型是:"+(typeof a));
document.write("<br>");
document.write("变量a的长度是:"+a.length);

function print(message){
    document.write("这是函数"+message);
}

function calc(x,y){
    return x+y;
}

print("第一句话");
print("第二句话");

var sum=calc(15,100);
print(sum);