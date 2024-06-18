<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>         
<!DOCTYPE html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	<meta http-equiv="Pragma" content="no-cache"/>
	<meta http-equiv="Expires" content="0"/>
	<meta http-equiv="Cache-Control" content="no-cache"/>        

    <title>사용자관리</title>

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        
    <link href="../css/comm.admin.css" rel="stylesheet">
    
    <style type="text/css">
    	.th0 { width:  5%; }
    	.th1 { width:  10%; }
    	.th2 { width:  10%; }
    	.th3 { width:  30%; }
    	.th4 { width:  10%; } 
    	.th5 { width:  10%; } 
    	.th6 { width:  10%; }
    	.th7 { width:  30%; }     	
    	
    	.custom-select{ width: 100px }
    	
    	}    	
    	
    	tr, td{
    		cursor: pointer;
    	}
    	
    	
    	tr:hover{    		
    		background-color: skyblue;    		
    	}
    	

    </style>
    
	<script type="text/javascript">
	
	
		function move(){		
			window.open('bk_user_detail.html', '_self');
		}
	
		
		function search(){

			//alert("sel1 : " +  document.frmGo.sel1.value + ", sel2 "  +  document.frmGo.sel2.value );
			//alert("4 : " +  document.frmGo.seaText.value);
			
			frmGo.action = "user.do";
			frmGo.submit();
			 
		}		
	
	</script>  
	
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

  		<!-- Sidebar -->
		<div id="sidebar"></div>
		<!-- End of Sidebar -->        

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Begin Page Content -->
                <div class="container-fluid">
					<br>
                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">사용자관리</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">					                    
                     <form action="user.do" method="post" name="frmGo">
                        <div class="card-header py-3 float-right">  
                        
							<select name="sel1" class="custom-select">
								<option value="">- 정렬 -</option>
								<option value="cnt">등록순</option>
								<option value="rcmCnt">추천순</option>
								<option value="goodCnt">관심순</option>
							</select>                         
							<select name="sel2" class="custom-select">
								<option value="">- 전체 -</option>
								<option value="user_name">성명</option>
								<option value="user_email">email</option>
							</select>		                    
		                  
		            		<div class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
		                        <div class="input-group">
		                            <input name="searchText" type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
		                                aria-label="Search" aria-describedby="basic-addon2">
		                            <div class="input-group-append">
		                            	<a href="javascript:search()">
		                                <button class="btn btn-primary" type="button" >
		                                    <i class="fas fa-search fa-sm"></i>
		                                </button>
		                                </a>
		                            </div>
		                        </div>
		                  	</div>                     
                        </div>
                        </form> 
                        
						<table class="table">
							<thead class="thead-dark">	
								<tr>
									<th class="th0" scope="col"></th>			      
									<th class="th1" scope="col">#</th>
									<th class="th2" scope="col">사용자</th>
									<th class="th3" scope="col">email</th>
									<th class="th4" scope="col">등록CNT</th>
									<th class="th5" scope="col">추천CNT</th>
									<th class="th6" scope="col">관심CNT</th>
									<th class="th7" scope="col">가입일자</th>									
								</tr>								
							</thead>
							<tbody>
 							
							<c:forEach var="user" items="${userlist}">  
								<tr onClick="move()">			
									<td scope="row"></td>      
									<td scope="row">1</td>
									<td scope="row">${user.user_id }</td>
									<td scope="row">${user.user_email }</td>
									<td scope="row">${user.cnt }</td>
									<td scope="row">${user.goodCnt }</td>
									<td scope="row">${user.rcmCnt }</td>
									<td scope="row">${user.user_date }</td>
								</tr>
							</c:forEach>
			    				    
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
					</div>
					
                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
			<div id="footer"></div>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/sb.js"></script>  
        
</body>

</html>