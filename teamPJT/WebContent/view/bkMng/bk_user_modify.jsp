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

    <title>사용자정보/관리자정보</title>

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
    	
    	table{
    		/* margin: 100px auto; */
    		margin-top: 100px;
    		margin-left: 50px;
    		margin-right: 0px;
    		padding-right: 0px;    	    		
    		width:  40%; 
    		font-weight: bold;
    	}
    	
    	.td0 { width:  100px; }
    	
    	p {
    		margin: 20px 50px 100px 100px;    		 
    	}
    	
    	button {
    		width: 75px;
    	}	
    	

    </style>
    
	<script type="text/javascript">
	
		function setValue(){	
			frmGo.user_role.value = frmGo.h_user_role.value;			 
		}
		
		
		function modify(){	
			frmGo.submit();			 
		}
		
		
		function random(){
			
			let ranValue1 = ['1','2','3','4','5','6','7','8','9','0'];
			let ranValue2 = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
			let ranValue3 = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'];
			let ranValue4 = ['!','@','#','$','%','^','&','*','(',')'];
			
			let temp_pw = "";
			
			for(i=0 ; i<2; i++) {
				let ranPick1 = Math.floor(Math.random() * ranValue1.length);
				let ranPick2 = Math.floor(Math.random() * ranValue2.length);
				let ranPick3 = Math.floor(Math.random() * ranValue3.length);
				let ranPick4 = Math.floor(Math.random() * ranValue4.length);
				temp_pw = temp_pw + ranValue1[ranPick1] + ranValue2[ranPick2] + ranValue3[ranPick3] + ranValue4[ranPick4];
			}
			
			//alert("임시 비밀번호는 " + temp_pw + " 입니다.");
			frmGo.user_pw.value = temp_pw;		
			
		}
	
	</script>  
	
</head>

<body id="page-top" onload="setValue()">

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
                    <h1 class="h3 mb-2 text-gray-800">사용자정보/관리자정보</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">	
						<form action="modify.do" method="post" name="frmGo">    
						<table>
							<tr>
								<td class="td0">사용자번호</td>
								<td>${getUser.user_id }</td>
								<input type="hidden" name="user_id"  value="${getUser.user_id }" >
							<tr>							
							<tr>
								<td>사용자</td>
								<td>${getUser.user_name }</td>
							</tr>
							<tr>
								<td>email</td>
								<td><input type="user_email" name="user_email" value="${getUser.user_email }"></td>
							</tr>
							<tr>
								<td>PW 초기화 </td>
								<td>
									<%-- <input type="text" name="user_pw"  value="${getUser.user_pw }" disabled> --%>
									<input type="text" name="user_pw"  value="${getUser.user_pw }" >
									<button type="button" class="btn btn-outline-success" onclick="random()">초기화</button>
								</td>
							</tr>
							<tr>
								<td>사용자역할</td>
								<td>
								<select name="user_role">									
									<option value="G">일반사용자</option>
									<option value="A">관리자</option>									
								</select>  
								<input type="hidden" name="h_user_role" value="${getUser.user_role }">
								</td>         
							</tr>
							<tr>
								<td class="td0">생성날짜</td>
								<td name="user_date" value="${getUser.user_date }">${getUser.user_date }</td></tr>
							<tr>															
 							<tr>
								<td colspan="2" ><hr><p><button type="submit" class="btn btn-outline-secondary" onclick="modify()">수정</button></p></td>
							</tr>												
						</table>
						</form>
		
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