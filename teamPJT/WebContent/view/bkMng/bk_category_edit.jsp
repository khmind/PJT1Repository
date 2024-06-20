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

    <title>SB Admin 2 - Tables</title>
	<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
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
    	#menu_update{
    		width: 400px;
    		margin: 0 auto;
    	}
    	.row{
    		display: flex;
    		padding: 10px 0;
    	}
    	.title_content{
    		text-align: center;
    		display: flex;
    		align-items: center;
    		width: 100px;
    		height: 40px;
    		font-weight: bold;
		}
    	.btn{
    		display: flex;
    		justify-content: center;
    		margin: 10px;
    	}
    	
    </style>
    
    

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
                    <h1 class="h3 mb-2 text-gray-800">메뉴관리/수정</h1>
                    <div id="menu_update">
                    	<div class="row"><span class="title_content">메뉴코드 </span>
                    	<input class="textfield" name="cate_id" type="text" placeholder="${cateUp.cate_id }" disabled></div>
					<div class="row"><span class="title_content">메뉴명 </span>
                    	<input class="textfield" name="cate_name" type="text" value="${cateUp.cate_name }"></div>
					<div class="row"><span class="title_content">메뉴순서 </span>
                    	<input class="textfield" name="cate_order" type="text" value="${cateUp.cate_order }"></div>
					<div class="row"><span class="title_content">위치 </span>
                    	<select name="cate_place">
					      		<option value="" disabled selected>${cateUp.cate_place }</option>
					      		<option value="F">F</option>
					      		<option value="B">B</option>
					      		<option value="B_F">B_F</option>
					 </select></div>
					 <div class="btn">
					 <button class="update textfield btn btn-outline-secondary">수정</button>
					 <button class="delete textfield btn btn-outline-secondary">삭제</button>
					 </div>
					 </div>
                    <!-- DataTales Example -->
                    


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