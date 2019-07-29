<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="cn.Travel.vo.*" %>
<%@page import="cn.Travel.Factory.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
  <link rel="stylesheet" href="assets/css/amazeui.css" />
  <link rel="stylesheet" href="assets/css/other.min.css" />
</head>
<body class="login-container">
<%
     
     /*  List<Photo> list=DaoFactory.getIPhotoImpl().find();
      Iterator<Photo> iter=list.iterator();
      while(iter.hasNext()){
    	  Photo photo=new Photo();
    	  photo=iter.next(); */
      String id=request.getParameter("id");
      String note=request.getParameter("note");
      String price=request.getParameter("price");
%>
  <div class="login-box">
  <div class="logo-img">
      <center><img src="assets/img/shop3.png" alt="" margin=-10px /></center>
    </div>
   
    <form  class="am-form" method="get"  action="ShopServlet" data-am-validator>
      <div class="am-form-group">
      
        <label for="doc-vld-name-2"><i class="am-icon-user"></i></label>
        <input type="text" id="usename" name="id" minlength="3" placeholder="订单编号"  value="<%=id %>" readonly/>
      </div>

      <div class="am-form-group">
        <label for="doc-vld-name-2"><i class="am-icon-user"></i></label>
        <input type="text" id="usename" name="note" minlength="3" placeholder="订单信息" required value="<%=note%>" readonly/>
      </div>
      <div class="am-form-group">
        <label for="doc-vld-name-2"><i class="am-icon-user"></i></label>
        <input type="text" id="usename" name="price" minlength="3" placeholder="订单价格" required value="<%=price%>" readonly/>
      </div>
      <div class="am-form-group">
        <label for="doc-vld-name-2"><i class="am-icon-user"></i></label>
        <input type="text" id="usename" name="usename" minlength="3" placeholder="请输入收货人信息" value="<%=request.getParameter("usename")%> " readonly/>
      </div>
       <div class="am-form-group">
        <label for="doc-vld-name-2"><i class="am-icon-user"></i></label>
        <input type="hidden" id="photo" name="photo" minlength="3" placeholder="隐藏的图片信息" value="<%=request.getParameter("photo")%> " readonly/>
      </div>
      <button class="am-btn am-btn-secondary"  type="submit">结算</button>
    </form>
    
  </div>

</body>
</html>
