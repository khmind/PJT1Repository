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
	h5{
		padding-top: 5px;
		padding-bottom: 5px;
	}

</style>

<script type="text/javascript">

	function goAction(arg){
		
		frmGo.action = arg;
		frmGo.submit();
		
	}

</script>
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
				<form action="" method="post" name="frmGo">
				
				   <div class="div1">
				       <h5>&nbsp;&nbsp;&nbsp;아이디 : ${userInfo.user_id} </h5>
				   </div>		
				   <div class="div2">
				       <h5>&nbsp;&nbsp;&nbsp;성&nbsp;&nbsp;&nbsp;&nbsp;명 : ${userInfo.user_name} </h5>
				   </div>					   
				   		
				
				   <div class="form-floating div2">
				     <input type="password" class="form-control" id="floatingPassword" placeholder="Password" >
				     <label for="floatingPassword">Password..</label>
				   </div>
				   <div class="form-floating div2">
				     <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="user_pw" >
				     <label for="floatingPassword">Password..</label>
				   </div>
				   <div class="form-floating div2">
				     <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="user_email">
				     <label for="floatingInput">${userInfo.user_email}</label>
				   </div>    
					<div class="form-button">					    
					    <button class="btn btn-secondary w-100 py-2" type="button" onclick="goAction('userInfoModify.to')">수정</button>
					</div>    
					<div class="form-button">
					    <button class="btn btn-warning w-100 py-2" type="button" onclick="goAction('logout.to')">로그아웃</button>
					</div>    					
				</form>
				
			</main>
			
			<!--  왼쪽 메뉴  -->
	  		<!-- Sidebar -->
			<%@ include file="fr_sidebar.jsp" %>
			<!-- End of Sidebar --> 
			
		<!-- Content end--------------------------------------------------------------------->
		</div>
	</div>

    
</section>

    
      
</body>
</html>