<%@page import="java.nio.channels.SeekableByteChannel"%>
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
 <base href="<%=basePath%>">
    <meta charset="utf-8">
    <style>
.div-left{
   float:right

}
</style>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>第四小组旅行网用户管理界面</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="assets/css/app.css">
    <script src="assets/js/jquery.min.js"></script>
       <script type="text/javascript" >
       function go(){
    	   window.location.reload()
       }
      </script>
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
                                <span class="am-badge am-badge-success am-round item-feed-badge">4</span>
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
                                                <span>客服佳祺</span>
                                            </div>
                                            <div class="am-text-truncate"> 亲爱的贵宾,竭诚为您服务 </div>
                                            <div class="menu-messages-content-time">2018-09-21 下午 16:40</div>
                                        </div>
                                    </a>
                                </li>

                                <li class="tpl-dropdown-menu-messages">
                                    <a href="javascript:;" class="tpl-dropdown-menu-messages-item am-cf">
                                        <div class="menu-messages-ico">
                                            <img src="assets/img/user02.png" alt="">
                                        </div>
                                        <div class="menu-messages-time">
                                            5天前
                                        </div>
                                        <div class="menu-messages-content">
                                            <div class="menu-messages-content-title">
                                                <i class="am-icon-circle-o am-text-warning"></i>
                                                <span>客服刘伟</span>
                                            </div>
                                            <div class="am-text-truncate"> 竭诚为您服务 </div>
                                            <div class="menu-messages-content-time">2016-09-16 上午 09:23</div>
                                        </div>
                                    </a>
                                </li>
                                <li class="tpl-dropdown-menu-messages">
                                    <a href="javascript:;" class="tpl-dropdown-menu-messages-item am-cf">
                                        <i class="am-icon-circle-o"></i> 进入列表…
                                    </a>
                                </li>
                            </ul>
                        </li>

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
                                                <span>客服小伟</span>
                                            </div>
                                            <div class="am-text-truncate"> 欢迎您进入第四旅行网，旅行网的成长，则离不开用户的支持。 </div>
                                            <div class="menu-messages-content-time">2016-09-21 下午 16:40</div>
                                        </div>
                                    </a>
                                </li>

                                <li class="tpl-dropdown-menu-messages">
                                    <a href="javascript:;" class="tpl-dropdown-menu-messages-item am-cf">
                                        <div class="menu-messages-ico">
                                            <img src="assets/img/user02.png" alt="">
                                        </div>
                                        <div class="menu-messages-time">
                                            5天前
                                        </div>
                                        <div class="menu-messages-content">
                                            <div class="menu-messages-content-title">
                                                <i class="am-icon-circle-o am-text-warning"></i>
                                                <span>客服小陈</span>
                                            </div>
                                            <div class="am-text-truncate"> 为了能最准确的传达所描述的问题， 建议你在反馈时附上演示，方便我们理解。 </div>
                                            <div class="menu-messages-content-time">2016-09-16 上午 09:23</div>
                                        </div>
                                    </a>
                                </li>
                                <li class="tpl-dropdown-menu-messages">
                                    <a href="table-list-img.jsp" class="tpl-dropdown-menu-messages-item am-cf">
                                        <i class="am-icon-circle-o"></i> 查看我的订单
                                    </a>
                                </li>
                            </ul>
                        </li>

                        <!-- 退出 -->
                        <li class="am-text-sm">
                            <a href="/TravelPoject/WebRoot1/index.html">
                                <span class="am-icon-sign-out"></span> 退出
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

        </header>
        <!-- 风格切换 -->
        <div class="tpl-skiner">
            <div class="tpl-skiner-toggle am-icon-cog">
            </div>
            <div class="tpl-skiner-content">
                <div class="tpl-skiner-content-title">
                    选择主题
                </div>
                <div class="tpl-skiner-content-bar">
                    <span class="skiner-color skiner-white" data-color="theme-white"></span>
                    <span class="skiner-color skiner-black" data-color="theme-black"></span>
                </div>
            </div>
        </div>
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
                    <a href="javascript:;" class="tpl-user-panel-action-link"> <span class="am-icon-pencil"></span> 账号设置</a>
                </div>
            </div>


            <!-- 菜单 -->
           
                <li class="sidebar-nav-link">
                    <a href="/TravelPoject/WebRoot1/index.html">
                        <i class="am-icon-home sidebar-nav-link-logo"></i> 首页
                    </a>
                </li>
                <li class="sidebar-nav-link">
                    <a href="chart.jsp">
                        <i class="am-icon-home sidebar-nav-link-logo"></i> 个人年度账单
                    </a>
                </li>
                
                <li class="sidebar-nav-heading">Page<a href="index.jsp"><span class="sidebar-nav-heading-info"> 购物页面</span></li>
                  
                   <li class="sidebar-nav-link">
                    <a href="javascript:;" class="sidebar-nav-sub-title active">
                        <i class="am-icon-table sidebar-nav-link-logo"></i> 我的订单
                        <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico sidebar-nav-sub-ico-rotate"></span>
                    </a>
                    
                </li>
                <li class="sidebar-nav-link">
                    <a href="Csign-up.html">
                        <i class="am-icon-clone sidebar-nav-link-logo"></i> 注册
                        <span class="am-badge am-badge-secondary sidebar-nav-link-logo-ico am-round am-fr am-margin-right-sm">6</span>
                    </a>
                </li>
                <li class="sidebar-nav-link">
                    <a href="Clogin.html">
                        <i class="am-icon-key sidebar-nav-link-logo"></i> 登录
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
                                <div class="widget-title  am-cf">我的订单</div>


                            </div>
                            
                                
                          

                                <div class="am-u-sm-12">
                                
                                    <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black ">
                                        <thead>
                                            <tr>
                                                <th>订单图片</th>
                                                <th>订单编号</th>
                                        
                                                <th>订单景点内容</th>
                                                <th>下单时间</th>
                                                <th>实付款</th>
                                         
                                            </tr>
                                        </thead>
  
                                        <tbody>
                                          <%
                                          
                                       
                                          String usename=String.valueOf(session.getAttribute("usename"));
                                          int limit2=5;
                                          int i=0;
          
                                          try{
                                              i=Integer.parseInt(request.getParameter("currentpage")); /* 加入try语句目的是使初始时无法接收到参数的时候停止检索,跳到上边变量赋值为1 */
                                          }catch(Exception e){
                                        	  
                                          }
                                          int limit1=i*5;
                                          consumer vo=new consumer();
                                          vo.setUsename(usename);
                                          vo.setLimit1(limit1);
                                          vo.setLimit2(limit2);
                                          
           List<consumer> list=DaoFactory.getIConsumerImpl().Limit(vo);
           Iterator<consumer> iter=list.iterator();
           while(iter.hasNext()){
        	   consumer consumer=new consumer();
        	   consumer=iter.next();
           
        %>
                                            <tr class="gradeX">
                                                
                                                <td>
                                                    <img src="<%="Upload/"+consumer.getPhoto()%>" class="tpl-table-line-img" alt="">
                                                </td>
                                                <td class="am-text-middle"><%=consumer.getId() %></td>
                                                <td class="am-text-middle"><%=consumer.getNote() %></td>
                                                <td class="am-text-middle"><%=consumer.getData() %></td>
                                                <td class="am-text-middle"><%=consumer.getPrice() %></td>
                                                    
                                                
                                            </tr>
                                       
                                            <!-- more data -->
                                                                             <%
           }
                                      %>
                                        </tbody>
     
                                    </table>
                                </div>
                                

                                   <div class="am-fr">
                                        <ul class="am-pagination tpl-pagination">
                                            <li class="am-disabled"><a href="#">«</a></li>
                                            <li ><a href="table-list-img.jsp?currentpage=0">1</a></li>
                                            <li><a href="table-list-img.jsp?currentpage=1"  >2</a></li>
                                            <li><a href="table-list-img.jsp?currentpage=2" >3</a></li>
                                            <li><a href="table-list-img.jsp?currentpage=3" >4</a></li>
                                            <li><a href="table-list-img.jsp?currentpage=4" >5</a></li>
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
    <script src="assets/js/app.js"></script>

</body>

</html>