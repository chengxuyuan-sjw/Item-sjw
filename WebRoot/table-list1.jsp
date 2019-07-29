<%@page import="cn.Travel.Factory.DaoFactory"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="cn.Travel.vo.*" %>
<%@page import="cn.Travel.Factory.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>第四小组旅行网</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="第四小组旅行网" />
    <script src="assets/js/echarts.min.js"></script>
    <link rel="stylesheet" href="assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="assets/css/app.css">
    <script src="assets/js/jquery.min.js"></script>

</head>

<body data-type="widgets">
    <script src="assets/js/theme.js"></script>
    <div class="am-g tpl-g">
        <!-- 头部 -->
        <header>
            <!-- logo -->
            <div class="am-fl tpl-header-logo">
                <a href="javascript:;"><img src="assets/img/logo.png" alt=""></a>
            </div>
            <!-- 右侧内容 -->
            <div class="tpl-header-fluid">
                <!-- 侧边切换 -->
                <div class="am-fl tpl-header-switch-button am-icon-list">
                    <span>

                </span>
                </div>
                <!-- 搜索 -->
                
                <!-- 其它功能-->
                <div class="am-fr tpl-header-navbar">
                    <ul>
                        <!-- 欢迎语 -->
                        <li class="am-text-sm tpl-header-navbar-welcome">
                            <a href="javascript:;">欢迎你, <span><%=session.getAttribute("usename") %></span> </a>
                        </li>

                        <!-- 新邮件 -->
                        <li class="am-dropdown tpl-dropdown" data-am-dropdown>
                            <a href="javascript:;" class="am-dropdown-toggle tpl-dropdown-toggle" data-am-dropdown-toggle>
                                <i class="am-icon-envelope"></i>
                                
                            </a>
                            <!-- 弹出列表 -->
                            <ul class="am-dropdown-content tpl-dropdown-content">
                                <li class="tpl-dropdown-menu-messages">
                                    <a href="javascript:;" class="tpl-dropdown-menu-messages-item am-cf">
                                        <div class="menu-messages-ico">
                                            <img src="assets/img/user04.png" alt="">
                                        </div>
                                        <div class="menu-messages-time">
                                            3小时前
                                        </div>
                                        <div class="menu-messages-content">
                                            <div class="menu-messages-content-title">
                                                <i class="am-icon-circle-o am-text-success"></i>
                                                <span>第四旅行网</span>
                                            </div>
                                            <div class="am-text-truncate"> 尊敬的管理员<%=session.getAttribute("usename") %>,欢迎您登陆 </div>
                                            <div class="menu-messages-content-time">2019.01.17</div>
                                        </div>
                                    </a>
                                </li>

                             
                                <li class="tpl-dropdown-menu-messages">
                                    <a href="deletphoto.jsp" class="tpl-dropdown-menu-messages-item am-cf">
                                        <i class="am-icon-circle-o"></i> 进入景点信息修改系统…
                                    </a>
                                </li>
                            </ul>
                        </li>

                        

                            

                     
                        <li class="am-text-sm">
                            <a href="/TravelPoject/WebRoot1/index.html">
                                <span class="am-icon-sign-out"></span> 退出
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

        </header>
        
        <!-- 侧边导航栏 -->
        <div class="left-sidebar">
            <!-- 用户信息 -->
            <div class="tpl-sidebar-user-panel">
                <div class="tpl-user-panel-slide-toggleable">
                    <div class="tpl-user-panel-profile-picture">
                        <img src="assets/img/user04.png" alt="">
                    </div>
                    <span class="user-panel-logged-in-text">
              <i class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
               <%=session.getAttribute("usename") %>
          </span>
                    
                </div>
            </div>

            <!-- 菜单 -->
            <ul class="sidebar-nav">
      
                <li class="sidebar-nav-link">
                    <a href="table-list1.jsp">
                        <i class="am-icon-home sidebar-nav-link-logo"></i> 首页
                    </a>
                </li>
                
             
                <li class="sidebar-nav-link">
                    <a href="javascript:;" class="sidebar-nav-sub-title active">
                        <i class="form.jsp"></i> 景点信息修改
                        <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico sidebar-nav-sub-ico-rotate"></span>
                    </a>
                    <ul class="sidebar-nav sidebar-nav-sub" style="display: block;">
                        <li class="sidebar-nav-link">
                            <a href="deletphoto.jsp" class="sub-active">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 修改景点信息
                            </a>
                        </li>

                        <li class="sidebar-nav-link">
                            <a href="form.jsp">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 上传景点图片
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="sidebar-nav-link">
                    <a href="updata.html">
                        <i class="am-icon-clone sidebar-nav-link-logo"></i> 个人信息修改
                        <span class="am-badge am-badge-secondary sidebar-nav-link-logo-ico am-round am-fr am-margin-right-sm"></span>
                    </a>
                </li>
                <li class="sidebar-nav-link">
                    <a href="login.html">
                        <i class="am-icon-key sidebar-nav-link-logo"></i> 登录
                    </a>
                </li>
                <li class="sidebar-nav-link">
                    <a href="index.jsp">
                        <i class="am-icon-tv sidebar-nav-link-logo"></i> 景点信息预览
                    </a>
                </li>

            </ul>
        </div>


        <!-- 内容区域 -->
        <div class="tpl-content-wrapper">
            <div class="row-content am-cf">
                <div class="row">
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                        <div class="widget am-cf">
                            <div class="widget-head am-cf">
                                <div class="widget-title  am-cf">客户完整信息</div>


                            </div>
               

                                <div class="am-u-sm-12">
                                
                                    <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black " id="example-r">
                                   
                                        <thead>
                                            <tr>
                                                <th>客户名</th>
                                                <th>所购物品</th>
                                                <th>物品简介</th>
                                                <th>下单时间</th>
                                                <th>实付款</th>
                                            </tr>
                                              <%
                                              int limit2=5;
                                              int i=0;
              
                                              try{
                                                  i=Integer.parseInt(request.getParameter("currentpage")); /* 加入try语句目的是使初始时无法接收到参数的时候停止检索,跳到上边变量赋值为1 */
                                              }catch(Exception e){
                                            	  
                                              }
                                              int limit1=i*5;
                                              consumer vo=new consumer();
        
                                              vo.setLimit1(limit1);
                                              vo.setLimit2(limit2);
                                              
               List<consumer> list=DaoFactory.getIConsumerImpl().all(vo);
               Iterator<consumer> iter=list.iterator();
               while(iter.hasNext()){
            	   consumer consumer=new consumer();
            	   consumer=iter.next();
               
                
                                 %>
                                        <tr>
                                            
							
										    		<td><%=consumer.getUsename() %></td>
										    		 <td>
                                                    <img src="<%="Upload/"+consumer.getPhoto()%>" class="tpl-table-line-img" alt="">
                                                     </td>
                                                     <td><%=consumer.getNote() %></td>
                                                     <td><%=consumer.getData() %></td>
                                                     <td><%=consumer.getPrice() %></td>
								
										    	</tr>
										    	  <%
                                 }
                                 %>
									    		
                                            </tr>
                                            <!-- more data -->
                                        </tbody>
                               
                                    </table>
                              
                                </div>
                                <div class="am-u-lg-12 am-cf">

                                    <div class="am-fr">
                                        <ul class="am-pagination tpl-pagination">
                                            <li class="am-disabled"><a href="#">«</a></li>
                                            <li > <a href="table-list1.jsp?currentpage=0">1</a></li>
                                            <li><a href="table-list1.jsp?currentpage=1">2</a></li>
                                            <li><a href="table-list1.jsp?currentpage=2">3</a></li>
                                            <li><a href="table-list1.jsp?currentpage=3">4</a></li>
                                            <li><a href="table-list1.jsp?currentpage=4">5</a></li>
                                            <li><a href="table-list1.jsp?currentpage=5">6</a></li>
                                            <li><a href="table-list1.jsp?currentpage=6">7</a></li>
                                            <li><a href="table-list1.jsp?currentpage=7">8</a></li>
          
                                            <li><a href="#">»</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="assets/js/amazeui.min.js"></script>
    <script src="assets/js/amazeui.datatables.min.js"></script>
    <script src="assets/js/dataTables.responsive.min.js"></script>
    <script src="assets/js/app.js"></script>

</body>

</html>