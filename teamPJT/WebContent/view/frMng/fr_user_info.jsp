<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<style>


	.div1{
		margin-top: 50px;
		margin-bottom: 0px;
	}
	
	.div2{
		margin-top: 0px;
		margin-bottom: 0px;
	}
	

	.form-floating {
 		width: 300px;
		height: 70px
	
	}
	
 	.form-button{
		width: 280px;		
	} 
	
	.bd-sidebar{
		padding-top: 10px;
		padding-bottom: 50px;	
	}

</style>
</head>
<body>

<section data-bs-version="5.1" class="features38 cid-ubxwyl9azq" id="features-66-ubxwyl9azq">

	<div class="container">
	
  		<div class="row justify-content-center">
  		<!-- Content here ---------------------------------------------------------------->
		  
		  	<!--  오른쪽 메인  -->
			<main class="col-md-9 col-xl-8 py-md-3 pl-md-2 bd-content " role="main">
			
			    <div class="d-md-flex flex-md-row-reverse align-items-center justify-content-between">			      
		       	  <a class="btn btn-sm btn-bd-light my-2 my-md-0" href="#" ></a>
			      <h4 class="bd-title" id="content">개인정보</h4>
			    </div>	
				<form>
				   <div class="form-floating div1">
				     <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
				     <label for="floatingPassword">Password</label>
				   </div>
				   <div class="form-floating div2">
				     <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
				     <label for="floatingPassword">Password</label>
				   </div>
				   <div class="form-floating div2">
				     <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
				     <label for="floatingInput">Email address</label>
				   </div>    
					<div class="form-button">
					    <!-- <button class="btn btn-primary w-100 py-2" type="submit">수정</button> -->
					    <button class="btn btn-secondary w-100 py-2" type="submit">수정</button>
					</div>    
				</form>
				
			</main>
			
			
			<!--  왼쪽 메뉴  -->
	  		<!-- Sidebar -->
			<!-- <div id="sidebar"></div> -->
			<!-- End of Sidebar -->  	
					
 			<div class="col-md-3 col-xl-2 bd-sidebar">
			
				<div class="collapse d-md-block row" id="bd-docs-nav">
				  <nav class="bd-links" aria-label="Main navigation">				
				      <div class="bd-toc-item">
				        <a class="bd-toc-link" href="fr_user_info.jsp">
				          	개인정보
				        </a>
				      </div>
				
				      <div class="bd-toc-item">
				        <a class="bd-toc-link" href="fr_myRecipe.jsp">
				          	나의레시피
				        </a>
				      </div>
				
				      <div class="bd-toc-item">
				        <a class="bd-toc-link" href="fr_interest_recipe.jsp">
				          	관심레시피
				        </a>
				      </div>
				
				      <div class="bd-toc-item">
				        <a class="bd-toc-link" href="fr_recommend_recipe.jsp">
				          	추천레시피
				        </a>
				      </div>
				
				      <div class="bd-toc-item">
				        <a class="bd-toc-link" href="fr_announcement.jsp">
				          	공지사항
				        </a>
				      </div>
				
				      <div class="bd-toc-item">
				        <a class="bd-toc-link" href="fr_ask.jsp">
				          	문의사항
				        </a>
				      </div>
				  </nav>
				</div>
			
			</div>  			

		<!-- Content end--------------------------------------------------------------------->
		</div>
	</div>

    
</section>

    
      
</body>
</html>