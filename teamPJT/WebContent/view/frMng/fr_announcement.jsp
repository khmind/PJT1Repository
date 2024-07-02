<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
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

	function detail(noticeId){		// 이기능은 임시, DB 연결 후 로직변경
        document.frm.notice_id.value= noticeId
		document.frm.action="notice_detail.to"; 
        document.frm.submit(); 
	}
	
	function search(){
		
		frm.action = "notice.to";
		frm.page.value = 1;
		frm.submit();			 
	}
	
	function gotoPage(page){
		
		frm.action = "notice.to";
		frm.page.value = page;
		frm.submit();			 
	}
	
	function setValue(){

		frm.searchText.value = frm.h_searchText.value;
		 
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
			      <h4 class="bd-title" id="content">공지사항</h4>
			    </div>
			    
			    <form action="notice_datail.to" method="post" name ="frm">
			   	 <input type="hidden" name="notice_id" value="">  
			   	 <input type="hidden" name="notice_title" value=""> 
			   	 <input type="hidden" name="notice_content" value=""> 
			   	 <input type="hidden" name="h_searchText" value="${PageInfo.searchText }">          		
				<input type="search" placeholder="  Search" aria-label="Search">
            		<a href="javascript:search()" target="_blank" >
            			<i class="fas fa-search fa-2x"></i>
            		</a>
				<table class="table">
				  <thead>
				    <tr>				      
				      <th>순번</th>
					  <th>제목</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach var="notice" items="${noticelist}">
				    <tr>				      
						<th class="th1" scope="row" onclick="detail('${notice.notice_id}')">${notice.notice_id}</th>
						<td class="th2" onclick="detail('${notice.notice_id}')">${notice.notice_title}</td>
				    </tr>				  
				  </c:forEach>
				  </tbody>
				  
					<c:set var = "page" scope = "page" value = "${PageInfo.page  } "/>
					<c:set var = "endPage" scope = "page" value = "${PageInfo.endPage  } "/>							
					<c:set var = "limit" scope = "page" value = "${PageInfo.limit  } "/>
					<fmt:parseNumber var = "nowPage" value = "${page}"/>							
					<fmt:parseNumber var = "endPage1" value = "${endPage}"/>							
					<fmt:parseNumber var = "limit1" value = "${limit}"/>
				  
				  
				</table>
			
				<nav aria-label="Page navigation example">  
						  <ul class="pagination justify-content-center">
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
				</form>
			</main>
			
			
			<!--  왼쪽 메뉴  -->
	  		<!-- Sidebar -->
			<!-- <div id="sidebar"></div> -->
			<!-- End of Sidebar -->  	
			<%@ include file="fr_sidebar.jsp" %>
 			<!-- <div class="col-md-3 col-xl-2 bd-sidebar">
			
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
				        <a class="bd-toc-link" href="notice.to">
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
			
			</div>  			 -->

		<!-- Content end--------------------------------------------------------------------->
		</div>
	</div>

    
</section>

    
      
</body>
</html>