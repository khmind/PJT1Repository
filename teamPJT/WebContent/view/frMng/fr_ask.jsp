<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<style type="text/css">
     
	input, i{
		float: left;
		padding-left: 2px;
	}

	i{
		color: lightgray
	}
	i:hover, #i:active  {
		 color: gray		 
	}		
	#submit{
		float: right;
		height: 30px;
		width: 80px;
        background-color: #00B700;
        color: white;
       	padding-top: 7px;
       	padding-bottom :7px;
        text-align: center;
        text-decoration: none;
        display: inline-block;		
	}
	#submit:hover {
	    background-color: #006F00;
	}
	#del{
		float: right;
		height: 30px;
		width: 80px;
        background-color: #ED0000;
        color: white;
       	padding-top: 7px;
       	padding-bottom :7px;       	
        text-align: center;
        text-decoration: none;
        display: inline-block;		
	}
	#del:hover {
	    background-color: #C90000;
	}
   	tbody tr{
   		cursor: pointer;
   	}   	    
    tbody tr:hover{    		
   		background-color: skyblue;    		
   	}	
	.bd-sidebar{
		padding-top: 10px;
		padding-bottom: 300px;	
	}    	

</style>
<script type="text/javascript">

	function detail(){		
		window.open('fr_ask_detail.jsp', '_self'); // 이기능은 임시, DB 연결 후 로직변경
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
			      <h4 class="bd-title" id="content">문의사항</h4>
			    </div>
			    
			    <form class="">            		
            		<input type="search" placeholder="  Search" aria-label="Search">
            		<a href="#" target="_blank" ><i class="fas fa-search fa-2x"></i></a>            				
            		<a href="#" target="_blank" id="del">삭제</a>
            		<a href="#" target="_blank" id="submit"  onClick="detail()">등록</a>            		
			    </form>
				
				<table class="table">
				  <thead>				  
				    <tr>
				      <th><input type="checkbox"></th>
				      <th>순번</th>
					  <th>제목</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr onClick="detail()">
				      <td><input type="checkbox"></td>
				      <td class="text-muted">10</td>
				      <td class="text-muted">여섯 번째 문의사항 입니다.</td>
				    </tr>				  
				    <tr onClick="detail()">
				      <td><input type="checkbox"></td>
				      <td class="text-muted">9</td>
				      <td class="text-muted">여섯 번째 문의사항 입니다.</td>
				    </tr>
				    <tr onClick="detail()">
				      <td><input type="checkbox"></td>
				      <td class="text-muted">8</td>
				      <td class="text-muted">다섯 번째 문의사항 입니다.</td>
				    </tr>				  
				    <tr onClick="detail()">
				      <td><input type="checkbox"></td>
				      <td class="text-muted">7</td>
				      <td class="text-muted">여섯 번째 문의사항 입니다.</td>
				    </tr>				  
				    <tr onClick="detail()">
				      <td><input type="checkbox"></td>
				      <td class="text-muted">6</td>
				      <td class="text-muted">여섯 번째 문의사항 입니다.</td>
				    </tr>
				    <tr onClick="detail()">
				      <td><input type="checkbox"></td>
				      <td class="text-muted">5</td>
				      <td class="text-muted">다섯 번째 문의사항 입니다.</td>
				    </tr>
				    <tr onClick="detail()">
				      <td><input type="checkbox"></td>
				      <td class="text-muted">4</td>
				      <td class="text-muted">네 번째 문의사항 입니다.</td>
				    </tr>
				    <tr onClick="detail()">
				      <td><input type="checkbox"></td>
				      <td class="text-muted">3</td>
				      <td class="text-muted">세 번째 문의사항 입니다.</td>
				    </tr>
				    <tr onClick="detail()">
				      <td><input type="checkbox"></td>
				      <td class="text-muted">2</td>
				      <td class="text-muted">두 번째 문의사항 입니다.</td>
				    </tr>
				    <tr onClick="detail()">
				      <td><input type="checkbox"></td>
				      <td class="text-muted">1</td>
				      <td class="text-muted">첫 번째 문의사항 입니다.</td>
				    </tr>
				  </tbody>
				</table>
				
				<nav aria-label="Page navigation example">  
				  <ul class="pagination justify-content-center">
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