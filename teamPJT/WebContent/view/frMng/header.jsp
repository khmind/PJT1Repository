<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <link rel="shortcut icon" href="./assets/images/gdf61b046222fac5a3cd6fdc38144-h_lvo11nj9.png" type="image/x-icon">
  <meta name="description" content="간단하고 맛있는 레시피">
  <title>맛있는 레시피</title>
  <link rel="stylesheet" href="https://r.mobirisesite.com/418493/assets/web/assets/mobirise-icons/mobirise-icons.css?rnd=1714583083056">
  <link rel="stylesheet" href="https://r.mobirisesite.com/418493/assets/web/assets/mobirise-icons2/mobirise2.css?rnd=1714583083056">
  <link rel="stylesheet" href="https://r.mobirisesite.com/418493/assets/bootstrap/css/bootstrap.min.css?rnd=1714583083056">
  <link rel="stylesheet" href="https://r.mobirisesite.com/418493/assets/bootstrap/css/bootstrap-grid.min.css?rnd=1714583083056">
  <link rel="stylesheet" href="https://r.mobirisesite.com/418493/assets/bootstrap/css/bootstrap-reboot.min.css?rnd=1714583083056">
  <link rel="stylesheet" href="https://r.mobirisesite.com/418493/assets/theme/css/style.css?rnd=1714583083056">
  <link rel="preload" href="https://fonts.googleapis.com/css2?family=Roboto+Flex:wght@400;700&display=swap&display=swap" as="style" onload="this.onload=null;this.rel='stylesheet'">
  <link rel="stylesheet" href="./frMng/css/inquiry_bootStrap.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
</head>
<body>


<c:if test="${navbar ne null}">

  <!-- header 시작 -->
<section data-bs-version="5.1" class="menu menu2 cid-ubxwyl6rXa" once="menu" id="menu-5-ubxwyl6rXa">
	<nav class="navbar navbar-dropdown navbar-fixed-top navbar-expand-lg">
		<div class="container">
			<div class="navbar-brand">
				<!-- <a href="./main.jsp"> -->
				<a href="./main.to">
					<span class="navbar-logo">
						<img src="./assets/images/gdf61b046222fac5a3cd6fdc38144-h_lvo11nj9.png" alt="" style="height: 4.5rem;">
					</span>
					<span class="navbar-caption-wrap"><a class="navbar-caption text-black display-4" href="./main.to">맛있는 레시피</a></span>
				</a>
			</div>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-bs-toggle="collapse" data-target="#navbarSupportedContent"
					data-bs-target="#navbarSupportedContent"
					aria-controls="navbarNavAltMarkup" aria-expanded="false"
					aria-label="Toggle navigation"></button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav" data-app-modern-menu="true">
					
					<c:forEach var="nav" items="${navbar}" varStatus="status">  
					
						<%-- <li class="nav-item"><a class="nav-link link text-black display-4" href="${nav.action }" --%>
						<li class="nav-item"><a class="nav-link link text-black display-4" href="fr_recipelist_kor.jsp"
							data-bs-auto-close="outside" aria-expanded="false">${nav.cate_name }</a>
						</li>		
					
					</c:forEach>
					
					</ul>
					<div >
						<!-- <a href="fr_recipelist_all.jsp" style="margin-right: 20px; color: lightgray"><i class="fas fa-search fa-2x"></i></a> -->	
						<a href="recipeSearch.to" style="margin-right: 20px; color: lightgray"><i class="fas fa-search fa-2x"></i></a>
					</div>
					<c:if test="${sessionScope.loginVO ==null }">
					<div class="navbar-buttons mbr-section-btn">
						<a class="btn btn-warning-outline display-4" href="./frMng/login.html">
							<span class="mbri-login mbr-iconfont mbr-iconfont-btn" style="color: rgb(119, 135, 165);"></span>
							로그인<span class="mbri-로그인 mbr-iconfont mbr-iconfont-btn"></span>
						</a>
					</div>
					</c:if>
					 
					<c:if test="${sessionScope.loginVO != null }">
					<div class="navbar-buttons mbr-section-btn">
						<a class="btn btn-warning-outline display-4" href="./frMng/fr_user_info.jsp">
							<span class="mbri-login mbr-iconfont mbr-iconfont-btn" style="color: rgb(119, 135, 165);"></span>
							마이페이지<span class="mbri-로그인 mbr-iconfont mbr-iconfont-btn"></span>
						</a>
					</div>
					</c:if>
				</div>
		</div>
	</nav>
</section>

</c:if>

<!-- header 끝 -->
</body>
</html>