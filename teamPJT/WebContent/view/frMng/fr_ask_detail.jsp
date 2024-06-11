<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
	#list1, #list2, #list3, #list4{
		float: right;
		height: 30px;
		width: 80px;        
        color: white;
       	padding-top: 7px;
       	padding-bottom :7px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
	}
	#list1{
		background-color: blue;
	}
	#list2{
		background-color: #ED0000;
	}
	#list3{
		background-color: #086A87;
	}
	#list4{
		background-color: #00B700;
	}
	
 	#list1:hover {
	    background-color: #00C6ED;
	}
 	#list2:hover {
	    background-color: #C90000;
	}
 	#list3:hover {
	    background-color: #0489B1;
	}
 	#list4:hover {
	    background-color: #006F00;
	}			
	
	.bd-sidebar{
		padding-top: 10px;
		padding-bottom: 152px;	
	} 
	.textA{
		margin-left: 20px;
		width: 600px;
	}   	
	input{
		margin-left: 40px;
		width: 600px;
	}

</style>
<script type="text/javascript">

	function list(){
		window.open('fr_ask.jsp', '_self'); // 이기능은 임시, DB 연결 후 로직변경
	}

</script>
</head>
<body>

<section data-bs-version="5.1" class="features38 cid-ubxwyl9azq" id="features-66-ubxwyl9azq">

	<div class="container">
	
  		<div class="row justify-content-center">
  		<!-- Content here ---------------------------------------------------------------->
		  
		  	<!--  오른쪽 메인  -->
	
			
            <!-- Main Content -->
			<main class=" col-xl-8 py-md-3  " role="main">
			
			    <div class="d-md-flex flex-md-row-reverse align-items-center justify-content-between">			      
		       	  <a class="btn btn-sm btn-bd-light my-2 my-md-0" href="#" ></a>
			      <h4 class="bd-title" id="content">문의사항</h4>
			    </div>
				<br>
				
				<table>
					<tr>
						<td>제목</td><td>	<textarea rows="1%" class="textA" readonly>문의사항1</textarea></td>					
					</tr>
					<tr>
						<td>내용</td><td>	<textarea rows="10%" class="textA" readonly>
문의사항 내용..
문의사항 내용..
문의사항 내용..
문의사항 내용..
문의사항 내용..
문의사항 내용..
문의사항 내용..
문의사항 내용..
문의사항 내용..
문의사항 내용..
문의사항 내용..
문의사항 내용..
문의사항 내용..
문의사항 내용..
문의사항 내용..
문의사항 내용..
문의사항 내용..
						</textarea></td>					
					</tr>
					<tr>	
						<td>사용자</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" value="동백이" disabled ></td>					
					</tr>
					<tr>
						<td>등록일자</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" value="2024:05:03 00:00:00" disabled></td>					
					</tr>		
					<tr>	
						<td>답변</td><td><textarea rows="3%" class="textA" disabled ></textarea></td>					
					</tr>
					<tr>
						<td>답변일자</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" value="2024:05:03 00:00:00" disabled></td>					
					</tr>
	
				</table>
				<br>
				<table align="center">
					<tr>
					<!-- 등록/수정/삭제 는 경우에 따라 활성화 비활성화 한다.  -->
						<td><a href="javascript:list()" id="list4">등록</a></td><td></td>
						<td><a href="javascript:list()" id="list3">수정</a></td><td></td>
						<td><a href="javascript:list()" id="list2">삭제</a></td><td></td>
						<td><a href="javascript:list()" id="list1">목록</a></td><td></td>
					</tr>
				</table>
				
			</main>     
            <!-- End of Main Content -->
			
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