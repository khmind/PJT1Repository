<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  </style>
  
	<script type="text/javascript">
	
	
		function move(args){	
			
 			frmGo.action = "userModify.do";
			frmGo.user_id.value = args
			frmGo.submit();
			//window.open('bk_user_detail.html', '_self');
		}
		
		function search(){
			
			frmGo.action = "user.do";
			frmGo.page.value = 1;
			frmGo.submit();			 
		}
		
		function gotoPage(page){
			
			frmGo.action = "user.do";
			frmGo.page.value = page;
			frmGo.submit();			 
		}
		
		function setValue(){

			 frmGo.sel1.value = frmGo.h_sel1.value;
			 frmGo.sel2.value = frmGo.h_sel2.value;
			 frmGo.searchText.value = frmGo.h_searchText.value;
			 
		}
			
 	</script>    
</head>
<body>
	<!--검색창-->
	<section data-bs-version="5.1" class="features38 cid-ubxwyl9azq" id="features-66-ubxwyl9azq" style="  display: flex; justify-content: center; margin-top: 30px;">
	
		<form class="search-box" >
			<div>
				<input class="search-txt" type="text" name="searchText"  placeholder="search">
				<button class="search-btn" type="submit"><i class="fa fa-search fa-lg"></i></button>	
			</div>
		
		
	</section>
	<!--검색창-->
	<!--레시피 창-->
	<section data-bs-version="5.1" class="slider4 mbr-embla cid-ubxwyl8tSX" id="gallery-5-ubxwyl8tSX">
		<div class="container" style="margin-top: 30px;">
			<div class="btn-group btn-group-toggle " data-toggle="buttons" style="margin-left: 10px; margin-bottom: 10px;">
			<input type="button" style="width: 90px; height: 50px;
						background-color: #0dcaf0; color: white; border-style: none;  margin-top: 5px; font-size: 15px; border-radius: 10px 0 0 10px; " value="최신순">
				<input type="button" style="width: 90px; height: 50px; 
						background-color: #0dcaf0; color: white; border-style: none;  margin-top: 5px; font-size: 15px;" value="추천순">
				<input type="button" style="width: 90px; height: 50px; 
						background-color: #0dcaf0; color: white; border-style: none;  margin-top: 5px; font-size: 15px;" value="관심순">
				<input type="button" style="width: 90px; height: 50px; 
						background-color: #0dcaf0; color: white; border-style: none;  margin-top: 5px; font-size: 15px; border-radius: 0 10px 10px 0; " value="난이도순">
			</div>
			
			
			<div class="row">
			
				<div class="col-12" style=" display: flex; justify-content: space-around;margin-top: 30px; ">
				<c:forEach var="repSea1" items="${recipeSearch1 }" varStatus="status"> 
				
			  		<div class="card" style="width: 300px;cursor: pointer;" onclick="location.href='fr_recipe_detail.jsp'">					  
					  <img src="${repSea1.img_main }" class="card-img-top" alt="..." style="width:300px; height: 200px;">
					  <div class="card-body">
					    <p class="card-text">${repSea1.recipe_title }</p>
					  </div>
					</div>
				
				</c:forEach>
				</div>
				
				<div class="col-12" style=" display: flex; justify-content: space-around;margin-top: 30px; ">
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
			<!-- 
		    <div class="row">
		    	<div class="col-12" style=" display: flex; justify-content: space-around;margin-top: 30px; ">
			  		<div class="card" style="width: 300px;cursor: pointer;" onclick="location.href='fr_recipe_detail.jsp'">
					  <img src="../img/제육.jpg" class="card-img-top" alt="..." style="width:300px; height: 200px;">
					  <div class="card-body">
					    <p class="card-text">맛있는 제육</p>
					  </div>
					</div>
					<div class="card" style="width: 300px;cursor: pointer;" onclick="#">
					  <img src="../img/피자.jpg" class="card-img-top" alt="..." style=" width:300px;height: 200px;">
					  <div class="card-body">
					    <p class="card-text">피자</p>
					  </div>
					</div>
			  		<div class="card" style="width: 300px;cursor: pointer;" onclick="#">
					  <img src="../img/짜장면.jpg" class="card-img-top" alt="..." style=" width:300px;height: 200px;">
					  <div class="card-body">
					    <p class="card-text">짜장면</p>
					  </div>
					</div>
					<div class="card" style="width: 300px;cursor: pointer;" onclick="#">
					  <img src="../img/규동.jpg" class="card-img-top" alt="..." style=" width:300px;height: 200px;">
					  <div class="card-body">
					    <p class="card-text">규동</p>
					  </div>
					</div>
			    </div>
			    <div class="col-12" style=" display: flex; justify-content: space-around; margin-top: 15px;">
					<div class="card" style="width: 300px;cursor: pointer;" onclick="#">
					  <img src="../img/콩나물국.png" class="card-img-top" alt="..." style="width:300px; height: 200px;">
					  <div class="card-body">
					    <p class="card-text">시원한 콩나물국</p>
					  </div>
					</div>
					<div class="card" style="width: 300px;cursor: pointer;" onclick="#">
					  <img src="../img/파스타.jpg" class="card-img-top" alt="..." style=" width:300px;height: 200px;">
					  <div class="card-body">
					    <p class="card-text">파스타</p>
					  </div>
					</div>
					<div class="card" style="width: 300px;cursor: pointer;" onclick="#">
					  <img src="../img/탕수육.jpg" class="card-img-top" alt="..." style=" width:300px;height: 200px;">
					  <div class="card-body">
					    <p class="card-text">탕수육</p>
					  </div>
					</div>
					<div class="card" style="width: 300px;cursor: pointer;" onclick="#">
					  <img src="../img/우동.jpg" class="card-img-top" alt="..." style=" width:300px;height: 200px;">
					  <div class="card-body"> 
					    <p class="card-text">우동</p>
					  </div>
					</div> 
			    </div>
			</div>
			
			 -->
			<div style="display: flex; justify-content: center ;margin-top: 30px;" >
				<nav aria-label="Page navigation example">
				  <ul class="pagination">
				    <li class="page-item">
				      <a class="page-link" href="#" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li> 
				    <li class="page-item"><a class="page-link" href="#">1</a></li>
				    <li class="page-item"><a class="page-link" href="#">2</a></li>
				    <li class="page-item"><a class="page-link" href="#">3</a></li>
				    <li class="page-item">
				      <a class="page-link" href="#" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				  </ul>
				</nav>
			</div> 
			
			</form>
			
		</div>
	</section>
	<!--레시피 창-->
	<script src="assets/web/assets/jquery/jquery.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="assets/smoothscroll/smooth-scroll.js"></script>
	<script src="assets/ytplayer/index.js"></script>
	<script src="assets/dropdown/js/navbar-dropdown.js"></script>
	<script src="assets/embla/embla.min.js"></script>
	<script src="assets/embla/script.js"></script>
	<script src="assets/theme/js/script.js"></script>
</body>
</html>