<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html lang="en">
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
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    
    <style type="text/css">
        .th1 { width:  5%; }
        .th2 { width:  50%; }
        .th3 { width:  20%; }
        .th4 { width:  20%; }
        
        .custom-select{ width: 100px }
        
        tr:hover{            
            background-color: skyblue;    
        }
    </style>
    <script type="text/javascript">

    function move(noticeId) {
        document.frmtt.notice_id.value = noticeId;
        document.frmtt.action="notice_update.do"; 
        document.frmtt.submit();
    }
	
	$(function() {
		$("#chkAll").click(function() {
			$(".chkGrp").attr("checked", this.checked);
		});
	}); 
	function deleteChk() {
		let groupList = "";
		
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
                    <h1 class="h3 mb-2 text-gray-800">공지사항</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">  
                            <!-- <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6> -->
                    
                            <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search float-right"
                            			id="search" action="">
                                <div class="input-group">
                                    <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                                        aria-label="Search" aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fas fa-search fa-sm"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>  
                                        
                            <select name="sel1" class="custom-select float-right">
                                <option selected>- 전체 -</option>
                                <option value="1">제목</option>
                                <option value="2">내용</option>
                            </select>    
                       	 <form action="notice_delete2.do" method="post" name="frmtt">  
                            <input type="hidden" name="notice_id" value="">
                           
                                <button type="submit" name="btn" value ="delete"class="btn btn-outline-danger float-right mr-1"  >
                                	삭제
                                </button>
                                   
                            
                            <a href="notice_register.do">
                                <button type="button" class="btn btn-outline-primary float-right mr-1">등록</button>
                            </a>
                        </div>
                            <table class="table">
                                <thead class="thead-dark">
                                    <tr>
                                        <th class="th1"><input type="checkbox" id="chkAll" ></th>
                                        <th class="th1" scope="col">no.</th>
                                        <th scope="col">제목</th>
                                        <th scope="col">작성자</th>
                                        <th scope="col">등록일자</th>
                                        <th scope="col">수정일자</th>
                                    </tr>
                                </thead> 
                                <tbody>
                                    <c:forEach var="notice" items="${noticelist}">                      
                                        <tr >
                                            <th class="th1"><input type="checkbox" name="del_id" class="chkGrp" id="chk" value="${notice.notice_id}"></th>
                                            <th class="th1" scope="row" onclick="move('${notice.notice_id}')">${notice.notice_id}</th>
                                            <td class="th2" onclick="move('${notice.notice_id}')">${notice.notice_title}</td>
                                            <td class="th1" onclick="move('${notice.notice_id}')">${notice.user_id}</td>
                                            <td class="th3" onclick="move('${notice.notice_id}')">${notice.notice_date}</td>
                                            <td class="th3"onclick="move('${notice.notice_id}')">${notice.notice_update}</td>
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
                    </div>
                </div>
            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <div id="footer"></div>
            <!-- End of Footer -->
        </div>
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
