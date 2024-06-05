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
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
  <style type="text/css">
  	.card{transition: transform .5s; transform: scale(1.0);}
  	.card:hover{background-color: #ebe7b7;
  				transform: scale(1.1);  
   				transition: transform .5s; 
  		}
  	.button1:hover{background-color: white;}
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
</head>

<body>
<!--검색창-->
	 <section data-bs-version="5.1" class="features38 cid-ubxwyl9azq" id="features-66-ubxwyl9azq" style="  display: flex; justify-content: center; margin-top: 30px;">
		<form class="search-box" >
			<input class="search-txt" type="text" name="" placeholder="search">
			<button class="search-btn" type="submit"><i class="fa fa-search fa-lg"></i></button>
		</form>
	</section>
	<!--검색창-->
	<!--레시피 창-->
	<section data-bs-version="5.1" class="slider4 mbr-embla cid-ubxwyl8tSX" id="gallery-5-ubxwyl8tSX">
		<div class="container" style="margin-top: 30px;">
			<div class="btn-group btn-group-toggle " data-toggle="buttons" style="margin-left: 10px; margin-bottom: 10px;">
				<input type="button" class="button1"style="width: 90px; height: 50px;background-color: #0dcaf0; color: white;
						 border-style: none;  margin-top: 5px; font-size: 15px; border-radius: 10px 0 0 10px;" value="최신순" >
				<input type="button" class="button1"style="width: 90px; height: 50px; 
						background-color: #0dcaf0; color: white; border-style: none;  margin-top: 5px; font-size: 15px;" value="추천순">
				<input type="button" class="button1"style="width: 90px; height: 50px; 
						background-color: #0dcaf0; color: white; border-style: none;  margin-top: 5px; font-size: 15px;" value="관심순">
				<input type="button" class="button1"style="width: 90px; height: 50px; 
						background-color: #0dcaf0; color: white; border-style: none;  margin-top: 5px; font-size: 15px; border-radius: 0 10px 10px 0; " value="난이도순">
			</div>
			
		    <div class="row">
		    	<div class="col-12" style=" display: flex; justify-content: space-around;margin-top: 30px;">
			  		<div class="card" style="width: 300px; cursor: pointer;" onclick="location.href='fr_recipe_detail.jsp'">
					  <img src="../img/감자전.jpg" class="card-img-top" alt="..." style="width:300px; height: 200px;">
					  <div class="card-body">
					    <p class="card-text">감자전</p>
					  </div>
					</div>
					<div class="card" style="width: 300px;cursor: pointer;" onclick="#">
					  <img src="../img/떡볶이.jpg" class="card-img-top" alt="..." style="width:300px; height: 200px;">
					  <div class="card-body">
					    <p class="card-text">떡볶이</p>
					  </div>
					</div>
					<div class="card" style="width: 300px;cursor: pointer;" onclick="#">
					  <img src="../img/토스트.jpg" class="card-img-top" alt="..." style=" width:300px;height: 200px;">
					  <div class="card-body">
					    <p class="card-text">토스트</p>
					  </div>
					</div>
					<div class="card" style="width: 300px;cursor: pointer;" onclick="#">
					  <img src="../img/약과.jpg" class="card-img-top" alt="..." style=" width:300px;height: 200px;">
					  <div class="card-body">
					    <p class="card-text">약과</p>
					  </div>
					</div>
			    </div>
			    <div class="col-12" style=" display: flex; justify-content: space-around;margin-top: 15px;">
			  		<div class="card" style="width: 300px;cursor: pointer;" onclick="#">
					  <img src="../img/마카롱.jpg" class="card-img-top" alt="..." style=" width:300px;height: 200px;">
					  <div class="card-body">
					    <p class="card-text">마카롱</p>
					  </div>
					</div>
					<div class="card" style="width: 300px;cursor: pointer;" onclick="#">
					  <img src="../img/탕후루.jpg" class="card-img-top" alt="..." style=" width:300px;height: 200px;">
					  <div class="card-body">
					    <p class="card-text">탕후루</p>
					  </div>
					</div>
					<div class="card" style="width: 300px;cursor: pointer;" onclick="#">
					  <img src="../img/붕어빵.jpg" class="card-img-top" alt="..." style=" width:300px;height: 200px;">
					  <div class="card-body">
					    <p class="card-text">붕어빵</p>
					  </div>
					</div>
					<div class="card" style="width: 300px;cursor: pointer;" onclick="#">
					  <img src="../img/케이크.jpg" class="card-img-top" alt="..." style=" width:300px;height: 200px;">
					  <div class="card-body"> 
					    <p class="card-text">케이크</p>
					  </div>
					</div> 
			    </div>
			</div>
			<div style="display: flex; justify-content: center ;margin-top: 30px;" >
				<nav aria-label="Page navigation example" >
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