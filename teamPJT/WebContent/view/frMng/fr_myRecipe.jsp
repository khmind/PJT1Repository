<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<style type="text/css">

	.custom-select{ 
		width: 100px;
		height: 33px; 
		margin-right: 3px;
		margin-bottom: 2px;
	}
/*     	#submit{
		float: right;
		height: 30px;
		width: 80px;
        background-color: blue;
        color: white;
       	padding-top: 7px;
       	padding-bottom :7px;
        padding-left:0;
        padding-right:0;
        text-decoration: none;
        display: inline-block;		
	} */
    select{
    	float: left;
    	width: 70px;
    }
     
	input{
		float: left;
		padding-left: 5px;	
		border-radius: 0em;		
		height: 33px; 
		border: 1px solid black;
	}
	
	i{
		float: left;
		padding-left: 5px;	
		color: lightgray	
	}
/* 	i:hover, #i:active  {
		 color: gray		 
	} */
/*    	tbody tr{
   		cursor: pointer;
   	}   */ 	    
/*     tbody tr:hover{    		
   		background-color: skyblue;    		
   	} */	
	.bd-sidebar{
		padding-top: 10px;
		padding-bottom: 300px;	
	}   		

</style>

<script type="text/javascript">

/* 	function detail(){		
		window.open('fr_recipe_detail.jsp', '_self'); // 이기능은 임시, DB 연결 후 로직변경
	}
 */
	function move(id) {
		document.frmtt.recipe_id.value = id;
		document.frmtt.action = "recipe_edit.do";
		document.frmtt.submit();
	}
 $(function() {
		$("#chkAll").click(function() {
			$(".chkGrp").attr("checked", this.checked);
		});
	});

	function deleteChk() {
		let groupList = "";
		
		/* 반복문 */
		$(".chkGrp:checked").each(function(idx, item) {
			if (idx == 0) {
				groupList = item.value;
			} else {
				groupList += "," + item.value;
			}
		});
	}
</script>   


</head>
<body>
<form action="" method="post" name="frmtt">
	<input type="hidden" name="recipe_id">
</form>
<section data-bs-version="5.1" class="features38 cid-ubxwyl9azq" id="features-66-ubxwyl9azq">

	<div class="container">
	
  		<div class="row justify-content-center">
  		<!-- Content here ---------------------------------------------------------------->
		  
		  	<!--  오른쪽 메인  -->
			<main class="col-md-9 col-xl-8 py-md-3 pl-md-2 bd-content " role="main">
			
			    <div class=" align-items-center ">			      
		       	  
			      <h4 class="bd-title" id="content">나의레시피</h4>
			    </div>
			    <div class="d-md-flex flex-md-row-reverse align-items-center ">	
			    <a class="btn btn-sm btn-bd-light my-2 my-md-0" href="recipe_add.do" >
		       	  	<input type="submit" value="레시피등록"
						style="width: 90px; height: 40px; border-radius: 10px; background-color: #0dcaf0; color: white; border-style: none;">
					</a>
					<form action="recipe_delete.do" method="post">
					<!-- <button type="button" class="btn btn-secondary btn-sm" type="submit">저장</button> -->
							<button type="submit" name="btn" value="delete" style="width: 90px; height: 40px; border-radius: 10px; background-color: #0dcaf0; color: white; border-style: none;"
									>삭제</button>
			    	 </div>	    
					<select name="sel1" class="custom-select">
						<option selected>- 전체 -</option>
						<option value="1">한식</option>
						<option value="2">중식</option>
						<option value="2">일식</option>
						<option value="2">간식</option>
					</select>
					<input type="search" placeholder="  Search" aria-label="Search">
					<a href="#" target="_blank" ><i class="fas fa-search fa-2x"></i></a>               			
			    
				
				<table class="table">
				  <thead>
				    <tr>
				      <th><input type="checkbox" id="chkAll"
										class="chkGrp"></th>
				      <th>유형</th>
					  <th>레시피명</th>
					  <th>관심</th>
					  <th>추천</th>
					  <th>등록일자</th>
				    </tr>
				  </thead>
				  <tbody>
				    <c:forEach var="list" items="${recipe_list}">
				   <!--  <tr onClick="detail()">	 -->
				   	<tr>
				      <td><input type="checkbox" name="del_id" id="chk" class="chkGrp"
											value="${list.recipe_id }" /></td>			      
				      <td class="text-muted">${list.class_name}</td>
				      <td class="text-muted">
				      	<a href="#" onclick="move('${list.recipe_id }')">${list.recipe_title}</a></td>
				      <td class="text-muted">${list.recipe_good}</td>
				      <td class="text-muted">${list.recipe_rcm}</td>
				      
				      <td class="text-muted">${list.recipe_date}</td>
				    </tr>
				    </c:forEach>
				    
				  </tbody>
				</table>
				</form>
				
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
					
 			<%@ include file="fr_sidebar.jsp" %> 			

		<!-- Content end--------------------------------------------------------------------->
		</div>
	</div>

    
</section>

    
      
</body>
</html>