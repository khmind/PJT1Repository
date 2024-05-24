<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<style type="text/css">

/*      #search:link, #search:visited {
         background-color: blue;
         color: white;
         padding: 15px 25px;
         text-align: center;
         text-decoration: none;
         display: inline-block;
     } */ 
     
	input{
		float: right;		
	}
    
	#search{
		background-color: blue;
		padding: 7px 0px;
		width: 60px;
		color: white;
		text-align: center;
		float: right;
		border-collapse:  collapse;
	}
	
	input:hover, #search:hover, #search:active {		
		box-shadow: 1px 1px 5px black;
	}

</style>
</head>
<body>

<section data-bs-version="5.1" class="features38 cid-ubxwyl9azq" id="features-66-ubxwyl9azq">

	<div class="container" id="div1">
  	
  	
  		<div class="row justify-content-center">
  		<!-- Content here ---------------------------------------------------------------->
  

		  
		  	<!--  오른쪽 메인  -->
			<main class="col-md-9 col-xl-8 py-md-3 pl-md-2 bd-content " role="main">			
			
			
			    <div class="d-md-flex flex-md-row-reverse align-items-center justify-content-between">
			      <!-- <a class="btn btn-sm btn-bd-light my-2 my-md-0" href="https://github.com/twbs/bootstrap/blob/v4.6.2/site/content/docs/4.6/layout/overview.md" title="View and edit this file on GitHub" target="_blank" rel="noopener">View on GitHub</a> -->
		       	  <a class="btn btn-sm btn-bd-light my-2 my-md-0" href="#" ></a>
			      <h1 class="bd-title" id="content">공지사항</h1>
			    </div>
<!-- 			    
			    <form class="form-inline my-0 my-lg-0">
			      <input class="form-control mr-sm-1" type="search" placeholder="Search" aria-label="Search">
			      <button class="btn btn-outline-success my-0 my-sm-0" type="submit">Search</button>
			      <button class="btn btn-primary btn-sm" type="submit">Search</button>
			      <button  type="submit" b>Search</button>
			    </form> -->
			    
			    <form class="">
			    	<!-- <img alt="" src="./img/search_icon.png" width="20px" height="20px"> -->			    	
            		<a href="#" target="_blank" id="search">Search</a>            		
            		<input type="search" placeholder="Search" aria-label="Search">		
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
				    <tr>
				      <td><input type="checkbox"></td>
				      <td class="text-muted">6</td>
				      <td class="text-muted">여섯 번째 공지사항 입니다.</td>
				    </tr>
				    <tr>
				      <td><input type="checkbox"></td>
				      <td class="text-muted">5</td>
				      <td class="text-muted">다섯 번째 공지사항 입니다.</td>
				    </tr>
				    <tr>
				      <td><input type="checkbox"></td>
				      <td class="text-muted">4</td>
				      <td class="text-muted">네 번째 공지사항 입니다.</td>
				    </tr>
				    <tr>
				      <td><input type="checkbox"></td>
				      <td class="text-muted">3</td>
				      <td class="text-muted">세 번째 공지사항 입니다.</td>
				    </tr>
				    <tr>
				      <td><input type="checkbox"></td>
				      <td class="text-muted">2</td>
				      <td class="text-muted">두 번째 공지사항 입니다.</td>
				    </tr>
				    <tr>
				      <td><input type="checkbox"></td>
				      <td class="text-muted">1</td>
				      <td class="text-muted">첫 번째 공지사항 입니다.</td>
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
			<div class="col-md-3 col-xl-2 bd-sidebar">
			
				<div class="collapse d-md-block row" id="bd-docs-nav">
				  <nav class="bd-links" aria-label="Main navigation">
				
				      <div class="bd-toc-item">
				        <a class="bd-toc-link" href="#">
				          	개인정보
				        </a>
				      </div>
				
				      <div class="bd-toc-item">
				        <a class="bd-toc-link" href="#">
				          	나의레시피
				        </a>
				      </div>
				
				      <div class="bd-toc-item">
				        <a class="bd-toc-link" href="#">
				          	관심레시피
				        </a>
				      </div>
				
				      <div class="bd-toc-item">
				        <a class="bd-toc-link" href="#">
				          	추천레시피
				        </a>
				      </div>
				
				      <div class="bd-toc-item">
				        <a class="bd-toc-link" href="#">
				          	공지사항
				        </a>
				      </div>
				
				      <div class="bd-toc-item">
				        <a class="bd-toc-link" href="#">
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