<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html >
<head>  
  <meta charset="UTF-8"> 
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <link rel="shortcut icon" href="assets/images/gdf61b046222fac5a3cd6fdc38144-h_lvo11nj9.png" type="image/x-icon">
  <meta name="description" content="간단하고 맛있는 레시피"> 
  <title>맛있는 레시피</title>
  <link rel="stylesheet" href="https://r.mobirisesite.com/418493/assets/web/assets/mobirise-icons/mobirise-icons.css?rnd=1714583083056">
  <link rel="stylesheet" href="https://r.mobirisesite.com/418493/assets/web/assets/mobirise-icons2/mobirise2.css?rnd=1714583083056">
  <link rel="stylesheet" href="https://r.mobirisesite.com/418493/assets/bootstrap/css/bootstrap.min.css?rnd=1714583083056">
  <link rel="stylesheet" href="https://r.mobirisesite.com/418493/assets/bootstrap/css/bootstrap-grid.min.css?rnd=1714583083056">
  <link rel="stylesheet" href="https://r.mobirisesite.com/418493/assets/bootstrap/css/bootstrap-reboot.min.css?rnd=1714583083056">
  <link rel="stylesheet" href="https://r.mobirisesite.com/418493/assets/dropdown/css/style.css?rnd=1714583083056">
  <link rel="stylesheet" href="https://r.mobirisesite.com/418493/assets/theme/css/style.css?rnd=1714583083056">
  <link rel="preload" href="https://fonts.googleapis.com/css2?family=Roboto+Flex:wght@400;700&display=swap&display=swap" as="style" onload="this.onload=null;this.rel='stylesheet'">
  <link rel="stylesheet" href="https://r.mobirisesite.com/418493/assets/css/mbr-additional.css?rnd=1714583083056" type="text/css">
  
  <style type="text/css">
  	.card{transition: transform .5s; transform: scale(1.0);}
  	.card:hover{background-color: #ebe7b7;
  				transform: scale(1.1);  
    			transition: transform .5s; 
  	}
	.search-box{
		height: 50px;
		width: 400px;
		background: white;
		border-radius: 40px;
		padding: 10px;
		border: 1px solid #f9deec; 
		font-size: 24px;
		margin-top: 20px;
	}
	.search-txt{
		width: 220px;
		background: none;
		outline:none;
		border: none;
		float: left;
		padding:0;
		color: #797979;
		font-size: 15px;
		line-height: 30px;
		margin-left: 10px;
	
	}
	.search-btn{
		height: 100%;
		width: 40px;
		background: none;
		border-radius: 50%x;
		padding: 10px;
		border: none; 
		font-size:16px;
		display:flex;
		justify-content: center;
		align-items:center;
		color:lightgray;
		float: right;
		
	}
	#select {
	 	width: 20%; 
	 	border-radius: 20px; 
	 	text-align: center; 
	 	font-size: 15px;
	 	padding-top: 5px;
	 	margin-right: 10px;
	}
	#styleOn {
	    color: #000;
	    background-color: #ffc107;
	    border-color: #ffc107
	}

	</style>
  
	<script type="text/javascript">
	
		function move(args){
			frmGo.recipe_id.value = args;
 			frmGo.action = "recipeDetail.to";
			frmGo.submit();
		}
		
		function orderby(args){
 			frmGo.action = "recipeSearch.to";
			frmGo.h_orderby.value = args
			frmGo.submit();
		}		
		
		function search(){
			frmGo.action = "recipeSearch.to";
			frmGo.page.value = 1;
			frmGo.classId.value = frmGo.class_name.value;
			frmGo.submit();			 
		}
		
		function gotoPage(page, ord){
			frmGo.action = "recipeSearch.to";
			frmGo.page.value = page;
			frmGo.h_orderby.value = ord;
			frmGo.submit();			 
		}
		
		function setValue(){
			frmGo.searchText.value = frmGo.h_searchText.value;
			frmGo.class_name.value = frmGo.classId.value;
		}
			
 	</script>    
</head>
<body onload="setValue()">
	<!--검색창-->
	<section data-bs-version="5.1" class="features38 cid-ubxwyl9azq" id="features-66-ubxwyl9azq" style="display: flex; justify-content: center; margin-top: 20px;">
	
		<form action="" method="post" name="frmGo" class="search-box" >
		<input type="hidden" value="${PageInfo.searchText }" name="h_searchText">
		<input type="hidden" value="${PageInfo.page }" name="page">
		<input type="hidden" value="" name="h_orderby">
		<input type="hidden" value="${PageInfo.class_id }" name="classId">
		<input type="hidden" value="" name="recipe_id" >
		
		<div>
		
			<select	name="class_name" class="search-txt" id="select">			
			<option value="" >- 전체 -</option>
			<c:forEach var="c" items="${class_name}">
				<option value="${c.class_id}">${c.class_name}</option>
			</c:forEach>	
			</select>								
			
			<input class="search-txt" type="search" name="searchText"  placeholder="search...">
			
			<a href="javascript:search()">				
			<button class="search-btn" type="button"><i class="fa fa-search fa-lg"></i></button>
			</a>
			
		</div>

	</section>
	<!--검색창-->
	<!--레시피 창-->
	<section data-bs-version="5.1" class="slider4 mbr-embla cid-ubxwyl8tSX" id="gallery-5-ubxwyl8tSX">
		<div class="container" style="margin-top: 20px;">
	 	
 			<div class="btn-group btn-group-sm" role="group" style="margin-left: 50px; margin-bottom: 10px;"> 
 	
	 			<c:choose>
	 				<c:when test="${PageInfo.orderby == 'recipe_date'}"> 
						<input type="button" name = "recipe_date" id="styleOn" class="btn btn-outline-warning" value="최신순" onclick="orderby('recipe_date')">
					</c:when>
					<c:otherwise>
						<input type="button" name = "recipe_date" class="btn btn-outline-warning" value="최신순" onclick="orderby('recipe_date')">
					</c:otherwise>
				</c:choose>	
					
	 			<c:choose>
	 				<c:when test="${PageInfo.orderby == 'recipe_rcm'}"> 
						<input type="button" name = "recipe_rcm" id="styleOn" class="btn btn-outline-warning" value="추천순" onclick="orderby('recipe_rcm')">
					</c:when>
					<c:otherwise>
						<input type="button" name = "recipe_rcm" class="btn btn-outline-warning" value="추천순" onclick="orderby('recipe_rcm')">
					</c:otherwise>
				</c:choose>
					
	 			<c:choose>
	 				<c:when test="${PageInfo.orderby == 'recipe_good'}"> 
						<input type="button" name = "recipe_good" id="styleOn" class="btn btn-outline-warning" value="관심순" onclick="orderby('recipe_good')">
					</c:when>
					<c:otherwise>
						<input type="button" name = "recipe_good" class="btn btn-outline-warning" value="관심순" onclick="orderby('recipe_good')">
					</c:otherwise>
				</c:choose>								
					
	 			<c:choose>
	 				<c:when test="${PageInfo.orderby == 'recipe_level'}"> 
						<input type="button" name = "recipe_level" id="styleOn" class="btn btn-outline-warning" value="난이도순" onclick="orderby('recipe_level')">
					</c:when>
					<c:otherwise>
						<input type="button" name = "recipe_level" class="btn btn-outline-warning" value="난이도순" onclick="orderby('recipe_level')">
					</c:otherwise>
				</c:choose>	
				
			</div>
			
		    <c:set var = "page" scope = "page" value = "${PageInfo.page  } "/>
		    <c:set var = "endPage" scope = "page" value = "${PageInfo.endPage  } "/>							
		    <c:set var = "limit" scope = "page" value = "${PageInfo.limit  } "/>
			<fmt:parseNumber var = "nowPage" value = "${page}"/>							
			<fmt:parseNumber var = "endPage1" value = "${endPage}"/>							
			<fmt:parseNumber var = "limit1" value = "${limit}"/>	
			
			<div class="row">
			
				<div style=" display: flex; justify-content: start; margin-top: 10px; margin-left: 50px">
				<c:forEach var="repSea1" items="${recipeSearch1 }" varStatus="status"> 
			  		<div class="card" style="width: 300px;cursor: pointer;" onclick="move('${repSea1.recipe_id }')">					  
					  <img src="${repSea1.img_main }" class="card-img-top" alt="..." style="width:300px; height: 200px;">
					  <!-- <img src="../view/img/frMng/제육.jpg" class="card-img-top" alt="..." style="width:300px; height: 200px;"> -->				
					  <div class="card-body">
					    <p class="card-text">${repSea1.recipe_title }</p>
					  </div>
					</div>
				
				</c:forEach>
				</div>
				
				<div style=" display: flex; justify-content: start; margin-top: 10px; margin-left: 50px">
				<c:forEach var="repSea2" items="${recipeSearch2 }" varStatus="status"> 
				
			  		<div class="card" style="width: 300px;cursor: pointer;" onclick="move('${repSea2.recipe_id }')">					  
					  <img src="${repSea2.img_main }" class="card-img-top" alt="..." style="width:300px; height: 200px;">
					  <div class="card-body">
					    <p class="card-text">${repSea2.recipe_title }</p>
					  </div>
					</div>
				
				</c:forEach>
				</div>
				
			</div>
			
<%-- [ s : ${PageInfo.startPage } ]  [ e : ${PageInfo.endPage }] --%>

			<div style="display: flex; justify-content: center ;margin-top: 10px; margin-bottom: 0px;"  >
				<nav aria-label="Page navigation example">
				  <ul class="pagination">
				  	<li class="page-item">
						<c:choose>
						  	<c:when test = "${nowPage<=1}">
						     <a class="page-link" href="#" aria-label="Previous">
						       <span aria-hidden="true">&laquo;</span>
						     </a>
						  	</c:when>
						<c:otherwise>
						     <a class="page-link" href="javascript:gotoPage('${nowPage-1}', '${PageInfo.orderby}')" aria-label="Previous">
						       <span aria-hidden="true">&laquo;</span>
						     </a>
						</c:otherwise>
						</c:choose>		
				  	</li> 	
				  	
					<c:forEach var="i" begin="${PageInfo.startPage }" end="${PageInfo.endPage }">
				    	<li class="page-item"><a class="page-link" href="javascript:gotoPage('${i }', '${PageInfo.orderby}')">
				    	<c:choose>
				    		<c:when test = "${i==nowPage}">	
				    			<font color="#F29661"><b>${i }</b></font>
							</c:when>
							<c:otherwise>
								${i }
							</c:otherwise>
						</c:choose>						    	
				    	</a></li>
				    </c:forEach>
				  	
				    <li class="page-item">
 					    <c:choose>
					    	<c:when test = "${nowPage>=endPage1}">
						      <a class="page-link" href="#" aria-label="Next">
						        <span aria-hidden="true">&raquo;</span>
						      </a>
						    </c:when>
						    <c:otherwise>
						      <a class="page-link" href="javascript:gotoPage('${nowPage+1}', '${PageInfo.orderby}')" aria-label="Next">
						        <span aria-hidden="true">&raquo;</span>
						      </a>							    
						    </c:otherwise>
					 	</c:choose>
				    </li>				  		  
				    
				  </ul>
				</nav>
			</div> 
			
			</form>
			
		</div>
	</section>
	<!--레시피 창-->
</body>
</html>