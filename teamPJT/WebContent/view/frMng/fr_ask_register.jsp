<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	<meta http-equiv="Pragma" content="no-cache"/>
	<meta http-equiv="Expires" content="0"/>
	<meta http-equiv="Cache-Control" content="no-cache"/>      
<title>Insert title here</title>
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

<script type="text/javascript">
 /*   function confirmModal() {
		
		location = "notice.do"; 
	} */
	function confirmModal3() { 
	
		location = "ask.to";

	}
</script>
<style type="text/css">
	#list1, #list2{
		float: right;
		height: 30px;
		width: 80px;        
        color: white;
        text-align: center;
        text-decoration: none;
        display: inline-block;
	}
	#list1{
		background-color: #086A87;
	}
	#list2{
		background-color: blue;
	}
	
 	#list1:hover {
	    background-color: #0489B1;
	}
 	#list2:hover {
	    background-color: #00C6ED;
	}
	
	.textA{
		margin-left: 20px;
		width: 600px;
		resize: none;
	}  
</style>
</head>
<body>
	<section data-bs-version="5.1" class="features38 cid-ubxwyl9azq" id="features-66-ubxwyl9azq">

	<div class="container">
	
  		<div class="row justify-content-center" >
  		<!-- Content here ---------------------------------------------------------------->
		  
		  	<!--  오른쪽 메인  -->
			<main class="col-md-9 col-xl-8 py-md-3 pl-md-2 bd-content " role="main" style="display: flex">
			    	<%@ include file="fr_sidebar.jsp" %>
 				<form action="ask_register.to" method="post" >

	                    <div class="d-md-flex flex-md-row-reverse align-items-center justify-content-between">			      
				       	  <a class="btn btn-sm btn-bd-light my-2 my-md-0" href="#" ></a>
					      <h4 class="bd-title" id="content">문의사항</h4>
					    </div>
	                	<table>
	                    <tr>		
	                        <td><span class="textfield" style="width: 50px;">제목</span></td><td><textarea rows="2%" name="ask_title" class="textA"></textarea></td>	                            
	                    </tr> 
	                    <tr>
	                        <td><span class="textfield" style="width: 50px;">내용</span></td><td><textarea  rows="10%" name="ask_content"  class="textA"></textarea></td>
						</tr>
						</table>
						<br> 
						<table align="center">
							<tr>	
	                    	 <td><button type="submit" id="list1" >등록</button></td>
	                    	 <td><button type="button" id="list2" onclick="confirmModal3()">목록</button></td>
							</tr>
						</table>                   
                </form>
			</main>
			
			
			<!--  왼쪽 메뉴  -->
	  		<!-- Sidebar -->
			<!-- <div id="sidebar"></div> -->
			<!-- End of Sidebar -->  	
		<!-- 			
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
			
			</div>   -->			

		<!-- Content end--------------------------------------------------------------------->
		</div>
	</div>

    
</section>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>
    <script src="js/sb.js"></script>    
</body>
</html>