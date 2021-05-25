//这个aaa文件理论上来说跟前端关系应该不大

const express =require('express');
const app = express();


app.get('/jquery-server',(request,response)=>{
    setHeader('Access-Control-Allow-Origin','*');
    response.send("收到了");//这里能选择你要发的数据
})

app.listen(8080,()=>{
    console.log("at8000");
})