<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
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

    <title>SB Admin 2 - Tables</title>

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    
    <style type="text/css">
    	.th1 { width:  2%; }
    	.thn { width:  10%; }
    	
    	.custom-select{ width: 100px }
    	.th3 img{
    		width: 70px;
    		height: 50px;
    	}
    </style>
	<script type="text/javascript">
    function move(id) {
        document.frmtt.recipe_id.value = id;
        document.frmtt.action="recipe_edit.do"; 
        document.frmtt.submit();
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
                    <h1 class="h3 mb-2 text-gray-800">레시피관리</h1>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3 float-right">
							<!-- <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6> -->
							<select name="sel1" class="custom-select">
								<option selected>- 메뉴 -</option>
								<option value="1">전체</option>
								<option value="2">한식</option>
								<option value="2">양식</option>
								<option value="2">중식</option>
								<option value="2">일식</option>
								<option value="2">베이킹</option>
							</select> 
							<select name="sel1" class="custom-select">
								<option selected>- 정렬 -</option>
								<option value="1">등록순</option>
								<option value="2">추천순</option>
								<option value="2">관심순</option>
							</select>

							<!-- Topbar Search -->
							<select name="sel1" class="custom-select">
								<option selected>-전체 -</option>
								<option value="1">제목</option>
								<option value="2">내용</option>
							</select>
							<form
								class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">

								<div class="input-group">

									<input type="text" class="form-control bg-light border-0 small"
										placeholder="Search for..." aria-label="Search"
										aria-describedby="basic-addon2">
									<div class="input-group-append">
										<button class="btn btn-primary" type="button">
											<i class="fas fa-search fa-sm"></i>
										</button>

									</div>
								</div>
							</form>
							<button type="button" class="btn btn-outline-secondary">비활성화</button>
							<button type="button" class="btn btn-outline-secondary">삭제</button>

						</div>

						<form action="" method="post" name="frmtt">
							<input type="hidden" name="recipe_id">
						</form>
						<table class="table">
							<thead class="thead-dark">
								<tr>
									<th class="th1"><input type="checkbox"></th>
									<th class="th1" scope="col">순번</th>
									<th scope="col">분류</th>
									<th scope="col">사진</th>
									<th scope="col">레시피명</th>
									<th scope="col">글쓴이</th>
									<th scope="col">추천수</th>
									<th scope="col">관심수</th>
									<th scope="col">활성화</th>
									<th scope="col">등록일자</th>
								</tr>
							</thead>
							<tbody>
							
							<c:forEach var="list" items="${recipe_list}">
								<tr>
									<th class="th1"><input type="checkbox"></th>
									<th class="th1" scope="row">${list.recipe_id }</th>
									<td class="th2 thn" scope="row">${list.class_name} </td>
									<td class="th3 thn" scope="row"><img alt=""
										src="${list.img_main }"></td>
									<td class="th4 thn" scope="row">
										<a href="#" onclick="move('${list.recipe_id }')">${list.recipe_title}</a>
									</td>
									<td class="th5 thn" scope="row">${list.user_name}</td>
									<td class="th6 thn" scope="row">${list.recipe_rcm}</td>
									<td class="th7 thn" scope="row">${list.recipe_good}</td>
									<td class="th8 thn" scope="row">${list.recipe_show}</td>
									<td class="th9 thn" scope="row">${list.recipe_date}</td>
								</tr>
								</c:forEach>
								
							</tbody>
						</table>


						<nav aria-label="Page navigation example">
							<ul class="pagination justify-content-center">
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
								<li class="page-item"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
							<form action="recipe_add.do" method="get">
							<ul class="pagination justify-content-center">
								<li>
									<input type="submit" value="레시피등록"	
									style="width: 90px; height: 40px; border-radius: 10px; background-color: #0dcaf0; color: white; border-style: none;">
								</li>
							</ul>
							</form>
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