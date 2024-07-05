<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 	#th4{		
		width: 50px;			
	} 
 	#th5{		
		width: 10px;
		padding-left: 0px;			
	}	
	i{
		float: left;
		padding-left: 5px;
		color: lightgray	
	}
/* 	i:hover, #i:active  {
		 color: gray		 
	}	 */	
	#submit{
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
	}
	#submit:hover {
	    background-color: #00C6ED;
	}
/*    	tbody tr{
   		cursor: pointer;
   	}   	    
    tbody tr:hover{    		
   		background-color: skyblue;    		
   	} */	
	.bd-sidebar{
		padding-top: 10px;
		padding-bottom: 400px;	
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
			      <h4 class="bd-title" id="content">관심레시피</h4>
			    </div>
			    
			   <!--  <form class="">	 -->		    
					<select name="sel1" class="custom-select">
						<option selected>- 전체 -</option>
						<option value="1">한식</option>
						<option value="2">중식</option>
						<option value="2">일식</option>
						<option value="2">간식</option>
					</select>
					<input type="search" placeholder="  Search" aria-label="Search">
					<a href="#" target="_blank" ><i class="fas fa-search fa-2x"></i></a>               			
							<form action="recipe_delete.do" method="post">
					<!-- <button type="button" class="btn btn-secondary btn-sm" type="submit">저장</button> -->
							<button type="submit" name="btn" value="delete" id="submit" style="font-size: 15px"
									class="btn btn-outline-secondary">삭제</button>
			    <!-- </form> -->
				
				<table class="table">
				  <thead>
				    <tr>				      
				      <th>순번</th>
				      <th>유형</th>
					  <th>레시피명</th>	
					  <!-- <th id="th4">관심</th> -->
					  <th id="th5"><input type="checkbox" id="chkAll"
										class="chkGrp"></th>					  
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach var="list1" items="${recipe_list1}">
				    <!-- <tr onClick="detail()"> -->
				    <tr>
				      <td>10</td>			      
				      <td class="text-muted">${list1.class_name }</td>
				      <td class="text-muted">${list1.recipe_title }</td>				      
				      <td id="th5"><input type="checkbox" name="del_id" id="chk" class="chkGrp"
											value="${list1.recipe_id }" /></td>
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
<script type="text/javascript">
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
    
      
</body>
</html>