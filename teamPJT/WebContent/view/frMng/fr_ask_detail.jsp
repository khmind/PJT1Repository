<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
	#list2, #list3{
		float: right;
		height: 30px;
		width: 80px;        
        color: white;
        text-align: center;
        text-decoration: none;
        display: inline-block;
	}
	 #list1{
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
		resize: none;
	}   	
	input{
		margin-left: 40px;
		width: 600px;
	}

</style>
<script type="text/javascript">


	function list(){
		window.open('ask.to', '_self'); 
	}
/* 	function update(askUpdate){
		document.frm.ask_update.value=askUpdate;
		document.frm.action = "ask_update.to";
		document.frm.submit();
	} */
	function delete1(askId){
		document.frm.ask_id.value=askId;
		document.frm.action = "ask_delete1.to";
		document.frm.submit();
	}
	
/* 	 function toggleButtons() {
	        var askTitle = "${ask.ask_title}"; 
	        
	        var regiBtn = document.getElementById("list4");
	        var updateBtn = document.getElementById("list3");
	        var deleteBtn = document.getElementById("list2");
	        var listBtn = document.getElementById("list1");

	        if (!askTitle) {
	            regiBtn.style.display = "inline-block"; 
	            listBtn.style.display = "inline-block"; 
	            updateBtn.style.display = "none"; 
	            deleteBtn.style.display = "none"; 
	        } else {
	            regiBtn.style.display = "none";
	            listBtn.style.display = "inline-block"; 
	            updateBtn.style.display = "inline-block"; 
	            deleteBtn.style.display = "inline-block"; 
	        }
	    }

	    // 문서가 로드되면 toggleButtons 함수를 호출하여 초기 상태 설정
	    window.onload = toggleButtons;
	 */
	
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
				<form action="ask_update.to" method="post" name="frm">
					<input type="hidden" name="ask_update" value="${ask.ask_update }">
					<input type="hidden" name="ask_id" value="${ask.ask_id }">
<%-- 					<input type="hidden" name="ask_title" value="${ask.ask_title}">
					<input type="hidden" name="ask_content" value="${ask.ask_content}">
					<input type="hidden" name="user_id" value="${ask.user_id }"> --%>
				<table>
					<tr>
						<td>제목</td><td><textarea rows="1%" class="textA" name="ask_title" value="${ask.ask_title }">${ask.ask_title }</textarea></td>					
					</tr>
					<tr>
						<td>내용</td><td><textarea rows="10%" class="textA" name="ask_content" value="${ask.ask_content }">${ask.ask_content }</textarea></td>					
					</tr>
					<tr>	
						<td>사용자</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" value="${ask.user_id }" disabled ></td>					
					</tr>
					<tr>
						<td>등록일자</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" value="${ask.ask_date}" disabled></td>					
					</tr>		
					<tr>	
						<td>답변</td><td><textarea rows="3%" class="textA" disabled >${ask.recomm_content }</textarea></td>					
					</tr>
					<tr>
						<td>답변일자</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" value="${ask.recomm_date }" disabled></td>					
					</tr>
	
				</table>
				<br>
				<table align="center">
					<tr>
					<!-- 등록/수정/삭제 는 경우에 따라 활성화 비활성화 한다.  -->
						<!-- <td><a href="javascript:regi()" id="list4">등록</a></td><td></td> -->
						<td><button type="submit" id="list3" >수정</button></td><td></td>
						<td><button  id="list2" onclick="delete1('${ask.ask_id }')">삭제</button></td><td></td>
						<td><a href="javascript:list()" id="list1">목록</a></td><td></td>
					</tr>
				</table>
				</form>
			</main>     
            <!-- End of Main Content -->
			
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
			
			</div>  			 -->

		<!-- Content end--------------------------------------------------------------------->
		</div>
	</div>

    
</section>


</body>
</html>