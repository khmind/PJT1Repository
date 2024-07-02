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
	
	.orderby {		
		
		width: 90px; height: 50px;
		background-color: #0dcaf0; 
		color: white; 
		border-style: none;  
		margin-top: 5px; 
		font-size: 15px; 		
		
	} 
	</style>
  
	<script type="text/javascript">
	
	
		function move(args){	
			
 			frmGo.action = "";
			frmGo.user_id.value = args
			frmGo.submit();
			
		}
		
		function orderby(args){	
			
			//alert (args);
			
 			frmGo.action = "recipeSearch.to";
			frmGo.h_orderby.value = args
			frmGo.submit();			
		}		
		
		function search(){
			
			frmGo.action = "recipeSearch.to";
			frmGo.page.value = 1;
			frmGo.submit();			 
		}
		
		function gotoPage(page){
			
			frmGo.action = "recipeSearch.to";
			frmGo.page.value = page;
			frmGo.submit();			 
		}
		
		function setValue(){
						 
			frmGo.searchText.value = frmGo.h_searchText.value;
			 
		}
			
 	</script>    
</head>
<body onload="setValue()">
	<!--검색창-->
	
	<section data-bs-version="5.1" class="features38 cid-ubxwyl9azq" id="features-66-ubxwyl9azq" style="  display: flex; justify-content: center; margin-top: 30px;">
	
		<form action="" method="post" name="frmGo" class="search-box" >
		<input type="hidden" value="${PageInfo.searchText }" name="h_searchText">
		<input type="hidden" value="${PageInfo.page }" name="page">
		<input type="hidden" value="" name="h_orderby">
		<input type="hidden" value="${PageInfo.class_id }" name="classId">
		
			<div>
				<input class="search-txt" type="search" name="searchText"  placeholder="search...">
				<a href="javascript:search()">
				<!-- <button class="search-btn" type="submit"><i class="fa fa-search fa-lg"></i></button> -->	
				<button class="search-btn" type="button"><i class="fa fa-search fa-lg"></i></button>
				</a>
			</div>
	</section>
	<!--검색창-->
	<!--레시피 창-->
	<section data-bs-version="5.1" class="slider4 mbr-embla cid-ubxwyl8tSX" id="gallery-5-ubxwyl8tSX">
		<div class="container" style="margin-top: 30px;">
<!-- 			<div class="btn-group btn-group-toggle " data-toggle="buttons" style="margin-left: 50px; margin-bottom: 10px;">
				<input type="button" name = "recipe_date" style="width: 90px; height: 50px;
						background-color: #0dcaf0; color: white; border-style: none;  margin-top: 5px; font-size: 15px; border-radius: 10px 0 0 10px; " value="최신순"> &nbsp;
				<input type="button" name = "recipe_rcm" style="width: 90px; height: 50px; 
						background-color: #0dcaf0; color: white; border-style: none;  margin-top: 5px; font-size: 15px;" value="추천순"> &nbsp;
				<input type="button" name = "recipe_good" style="width: 90px; height: 50px; 
						background-color: #0dcaf0; color: white; border-style: none;  margin-top: 5px; font-size: 15px;" value="관심순"> &nbsp;
				<input type="button" name = "recipe_level" style="width: 90px; height: 50px; 
						background-color: #0dcaf0; color: white; border-style: none;  margin-top: 5px; font-size: 15px; border-radius: 0 10px 10px 0; " value="난이도순">
			</div> -->
			
			
			<div class="btn-group btn-group-toggle " data-toggle="buttons" style="margin-left: 50px; margin-bottom: 10px;">
				<input type="button" class="orderby" name = "recipe_date" value="최신순" onclick="orderby('recipe_date')" style="border-radius: 10px 0 0 10px; " >
				<input type="button" class="orderby" name = "recipe_rcm"  value="추천순" onclick="orderby('recipe_rcm')" >
				<input type="button" class="orderby" name = "recipe_good" value="관심순" onclick="orderby('recipe_good')" >
				<input type="button" class="orderby" name = "recipe_level" value="난이도순" onclick="orderby('recipe_level')"  style="border-radius: 0 10px 10px 0; " >
			</div>			
			
		
<!-- 			
 			<div class="btn-group btn-group-toggle " data-toggle="buttons" style="margin-left: 50px; margin-bottom: 10px;"> 
				<input type="button" name = "recipe_date" class="btn btn-outline-primary" value="최신순">
				<input type="button" name = "recipe_rcm" class="btn btn-outline-primary"  value="추천순">
				<input type="button" name = "recipe_good" class="btn btn-outline-primary"  value="관심순">
				<input type="button" name = "recipe_level" class="btn btn-outline-primary" value="난이도순">
			</div>		
			 -->		
			 	
		    <c:set var = "page" scope = "page" value = "${PageInfo.page  } "/>
		    <c:set var = "endPage" scope = "page" value = "${PageInfo.endPage  } "/>							
		    <c:set var = "limit" scope = "page" value = "${PageInfo.limit  } "/>
			<fmt:parseNumber var = "nowPage" value = "${page}"/>							
			<fmt:parseNumber var = "endPage1" value = "${endPage}"/>							
			<fmt:parseNumber var = "limit1" value = "${limit}"/>	
			
			<div class="row">
			
				<div style=" display: flex; justify-content: start; margin-top: 20px; margin-left: 50px">
				<c:forEach var="repSea1" items="${recipeSearch1 }" varStatus="status"> 
				
			  		<div class="card" style="width: 300px;cursor: pointer;" onclick="location.href='fr_recipe_detail.jsp'">					  
					  <img src="${repSea1.img_main }" class="card-img-top" alt="..." style="width:300px; height: 200px;">
					  <div class="card-body">
					    <p class="card-text">${repSea1.recipe_title }</p>
					  </div>
					</div>
				
				</c:forEach>
				</div>
				
				<div style=" display: flex; justify-content: start; margin-top: 30px; margin-left: 50px">
				<c:forEach var="repSea2" items="${recipeSearch2 }" varStatus="status"> 
				
			  		<div class="card" style="width: 300px;cursor: pointer;" onclick="location.href='fr_recipe_detail.jsp'">					  
					  <img src="${repSea2.img_main }" class="card-img-top" alt="..." style="width:300px; height: 200px;">
					  <div class="card-body">
					    <p class="card-text">${repSea2.recipe_title }</p>
					  </div>
					</div>
				
				</c:forEach>
				</div>
				
			</div>
[ s : ${PageInfo.startPage } ]  [ e : ${PageInfo.endPage }]
			<div style="display: flex; justify-content: center ;margin-top: 30px;" >
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
						     <a class="page-link" href="javascript:gotoPage('${nowPage-1}')" aria-label="Previous">
						       <span aria-hidden="true">&laquo;</span>
						     </a>
						</c:otherwise>
						</c:choose>		
				  	</li> 	
				  	
					<c:forEach var="i" begin="${PageInfo.startPage }" end="${PageInfo.endPage }">
				    	<li class="page-item"><a class="page-link" href="javascript:gotoPage('${i }')">
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
						      <a class="page-link" href="javascript:gotoPage('${nowPage+1}')" aria-label="Next">
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