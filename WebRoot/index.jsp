<%@page import="cn.Travel.Factory.DaoFactory"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="cn.Travel.Factory.*" %>
<%@page import="cn.Travel.vo.*" %>

<!DOCTYPE html>
<html>
<head>


<meta charset="utf-8">
<style>
div.logo{
    background-color:white;
    color:white;
    padding:0px;
    margin:-1px;
    width: 4000px;
    height: auto;

}
</style>
<style>
.dropbtn {
    background-color: #4CAF50;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
    background-color: #3e8e41;
}
</style>
<meta charset="utf-8">

<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #46a3ff;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #ffa042;
}
</style>
<meta charset="utf-8">  
<style>
div.img {
    margin: 5px;
    border: 1px solid #ccc;
    float: left;
    width: 250px;
}

div.img:hover {
    border: 1px solid #777;
	float:left;

}

div.img img {
    width: 100%;
    height: 200px;
}

div.desc {
    padding: 15px;
    text-align: center;
}

</style>
</head>
<body>
<div class="logo">
  <div class="logo">
    <a target="_blank">
      <img src="assets/img/666111.png "width="1250" height="70">
    </a>
  </div>
</div>
<ul>
  <li><a class="active" href="#home">旅游首页</a></li>
  <li><a href="#news">周末游</a></li>
  <li><a href="#contact">跟团游</a></li>
  <li><a href="#about">自由行</a></li>
  <li><a href="#about">邮轮</a></li>
  <li><a href="#about">酒店+景点</a></li>
  <li><a href="#about">当地玩乐</a></li>
  <li><a href="#about">主题游</a></li>
  <li><a href="#about">定制旅行</a></li>
  <li><a href="#about">游学</a></li>
  <li><a href="#about">签证</a></li>  
  <li><a href="#about">企业会讲</a></li>  
  <li><a href="#about">高端游</a></li>  
  <li><a href="#about">爱玩户外</a></li>
  <li><a href="#about">保险</a></li> 
  <li><a href="#about">特卖会</a></li>
  <li><a href="table-list-img.jsp">查看我的订单详情</a></li>
</ul>

<div class="dropdown" float="left">

  <button class="dropbtn">热门城市</button>
  <div class="dropdown-content">
    <a href="http://weekend.ctrip.com/around/Beijing">   北京     </a>
    <a href="">敬请期待...</a>
  </div>
  <div>
  </div>
</div>
<%
   
   List<Photo> list=new ArrayList<Photo>();
   list=DaoFactory.getIPhotoImpl().find();
   Iterator<Photo> iter=list.iterator();
   while(iter.hasNext()){
	   Photo photo=iter.next();
	   
	   
%>
<div class="responsive">
  <div class="img">
    <a target="_blank">
      <img src="<%="Upload/"+photo.getPhoto()%>">
    </a>
    <div class="desc"><a href="/TravelPoject/webroot2/two/home/introduction.jsp?id=<%=photo.getId() %>&&note=<%=photo.getNote()%>&&price=<%=photo.getPrice()%>&&usename=<%=session.getAttribute("usename")%>&&photo=<%=photo.getPhoto()%>"><%=photo.getNote()%></a></div>
    <div class="desc"><h8>价格:¥</h8><%=photo.getPrice() %>&nbsp<h9 style="color:red"><%=photo.getRecom() %></h9></div>
    <%-- <div><center> <a href="shopping.jsp?id=<%=photo.getId() %>&&note=<%=photo.getNote()%>&&price=<%=photo.getPrice()%>&&usename=<%=session.getAttribute("usename")%>&&photo=<%=photo.getPhoto()%>">购</a></h8></center></div> --%>
    
  </div>
</div>

<%
   }
%>


</body>
</html>
</html>
