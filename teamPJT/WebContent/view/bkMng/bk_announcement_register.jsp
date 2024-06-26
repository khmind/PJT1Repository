<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Insert title here</title>
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    <style type="text/css">
     textarea {
    resize: none;
  	}
    </style>
<script type="text/javascript">
 /*   function confirmModal() {
		
		location = "notice.do"; 
	} */
	function confirmModal3() {
	
		location = "notice_delete.do";

	}
</script>
</head>
<body>
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
                <form action="notice_register.do" method="post">
                	<input type="hidden" name="notice_id">
	                <div class="container-fluid">
						<br>
	                    <!-- Page Heading -->
	                    <h1 class="h3 mb-2 text-gray-800">공지사항등록</h1>
	
	                    <!-- DataTales Example -->
	                    <div class="card mb-4">
	                        <div class=" card-body mb-4" style="display: flex;"> 
	                            <!-- <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6> -->
				
								<span class="textfield" >제목</span>
		              			<textarea rows="2%" name="notice_title" style=" margin-left: 70px; width:72%;"></textarea>	                            
	                        </div>
	                        <div style="display: flex;">
		                        <span class="textfield" style="margin-left:20px;">내용</span>
		      					<textarea  rows="10%" name="notice_content" style="margin-left: 70px; margin-bottom :20px; width:70%;"></textarea>
	                        </div>
							
	                    </div> 
	                    <div class="btn" style="display: flex; justify-content: end">
	                    	<button type="submit" class="btn btn-outline-primary" style="width:75px">등록</button>
	      					<button type="button" class="btn btn-outline-secondary ml-3" onclick="confirmModal3()" style="width:75px">삭제</button>
						</div>                           
	                </div>
                </form>
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