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
		
		frm.action = arg;
		frm.submit();		
		
	}

</script>
</head>
<body>

<%

InfoVO infoVO = (InfoVO)session.getAttribute("infoVO");

%>

       <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
             <a class="sidebar-brand d-flex align-items-center justify-content-center" href="../main.html">
                <div class="sidebar-brand-text mx-3"> 메인으로 이동 </div>
            </a>
<%  if ( infoVO != null ) { %>
            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - 공지사항 -->
            <li class="nav-item">
                <a class="nav-link" href="bk_announcement.html">
                    <i class="fas fa-fw fa-table"></i>
                    <span>공지사항</span></a>
            </li>
            
            <hr class="sidebar-divider my-0"> 
            <!-- Nav Item - 문의사항 -->
            <li class="nav-item">
                <a class="nav-link" href="bk_ask.html">
                    <i class="fas fa-fw fa-table"></i>
                    <span>문의사항</span></a> 
            </li>
            <hr class="sidebar-divider my-0">            

            <!-- Nav Item - 사용자관리 -->
            <li class="nav-item">            	
                 <a class="nav-link" href="javascript:goAction('user.do')">
                    <i class="fas fa-fw fa-table"></i>
                    <span>사용자관리</span></a>
            </li>
            <hr class="sidebar-divider my-0">            
            
            <!-- Nav Item - 레시피관리 -->
            <li class="nav-item">
                <a class="nav-link" href="bk_recipe.html">
                    <i class="fas fa-fw fa-table"></i>
                    <span>레시피관리</span></a>
            </li>
			<hr class="sidebar-divider my-0">            
            
            <!-- Nav Item - 메뉴관리 -->
            <li class="nav-item">
                <a class="nav-link" href="bk_menu.html">
                    <i class="fas fa-fw fa-table"></i>
                    <span>메뉴관리</span></a>
            </li>            
            <hr class="sidebar-divider my-0">    
            
            <!-- Nav Item - 관리자정보 -->
            <li class="nav-item">             	
                <a class="nav-link" href="javascript:goAction('maneger.do')">
                    <i class="fas fa-fw fa-table"></i>
                    <span>관리자정보</span></a>
            </li>            
            <hr class="sidebar-divider my-0">       
            
            <!-- Nav Item - 로그아웃 -->
            <li class="nav-item">
                <a class="nav-link" href="javascript:goAction('logout.do')">                
                    <img alt="" src="./img/logout1.png" width="20px" height="30px">
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
        
    <form action="" method="post" name="frm"></form>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>   

</body>
</html>