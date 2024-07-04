<%@page import="vo.bkMng.CategoryVO"%>
<%@page import="java.util.List"%>
<%@page import="controller.Controller"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ page import="vo.bkMng.InfoVO" %>      
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맛있는 레시피</title>
<style type="text/css">
	img{
		/* padding-left: 10px */
	}
</style>
<script type="text/javascript">

	function goAction(arg){
		
		frmSidebar.action = arg;
		frmSidebar.submit();
		
	}

</script>
</head>
<body>

<%

	InfoVO infoVO = (InfoVO)session.getAttribute("infoVO");
	List<CategoryVO> cvoList = null;
	
	if ( infoVO != null ) { 		
		cvoList = (List<CategoryVO>)session.getAttribute("bkCateList");
	}

%>		
       <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
<!--              <a class="sidebar-brand d-flex align-items-center justify-content-center" href="../frMng/main.jsp">
                <div class="sidebar-brand-text mx-3"> 메인으로 이동 </div>
            </a> -->
            <br><br><br>
<%  if ( infoVO != null) { %>
            <!-- Divider -->
            
	<%  for (CategoryVO cvo : cvoList ) { %>            
            
	            <hr class="sidebar-divider my-0">
	
	            <!-- Nav Item - 공지사항 -->
	            <li class="nav-item">
	                <a class="nav-link" href="javascript:goAction('<%=cvo.getAction() %>')">	                
	                    <i class="fas fa-fw fa-table"></i>
	                    <span><%= cvo.getCate_name() %></span>
	                </a>
	            </li>            
            
	<% } %>
            
            <hr class="sidebar-divider my-0">     
            <!-- Nav Item - 로그아웃 -->
            <li class="nav-item">
                <a class="nav-link" href="javascript:goAction('logout.do')">                
                    <img alt="" src="./img/logout.png" width="20px" height="30px">
                     <span>로그아웃</span></a>
                </a>
                   
            </li>            
            <hr class="sidebar-divider my-0">
            
            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>
            
<% } %>

        </ul>
        <!-- End of Sidebar -->
        
   		<form action="" method="post" name="frmSidebar"></form>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>   

</body>
</html>