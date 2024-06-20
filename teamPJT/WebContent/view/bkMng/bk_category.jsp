<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Cache-Control" content="no-cache" />

<title>SB Admin 2 - Tables</title>
<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
<!-- Custom fonts for this template -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/sb-admin-2.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">

<style type="text/css">
.th1 {
	width: 4%;
}

.th2 {
	width: 10%;
}

.th3 {
	width: 10%;
}

.th4 {
	width: 10%;
}

.th5 {
	width: 10%;
}

.th6 {
	width: 10%;
}

.custom-select {
	width: 100px
}

#add_btn {
	text-align: right;
}

input {
	width: 50%;
}
</style>



<script type="text/javascript">
	function move(cate_id) {
	    document.frmgo.vv.value = cate_id;
	    document.frmgo.action="cate_edit.do"; 
	    document.frmgo.submit();
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
					<h1 class="h3 mb-2 text-gray-800">메뉴조회</h1>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3 float-right">
							<!-- <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6> -->

							<button class="success btn btn-outline-secondary"
								onclick="add_tr()">추가</button>
							<form action="cate_delete.do" method="post" name="frmgo">
							<input type="hidden" name="vv" value="">
								<button type="submit" name="btn" value="delete"
									class="btn btn-outline-secondary">삭제</button>
						</div>
						<table id="calculator_table" class="table">
							<thead class="thead-dark">
								<tr>
									<th class="th1"><input type="checkbox" id="chkAll"
										class="chkGrp"></th>
									<!-- <th class="th1" scope="col">no</th> -->
									<th scope="col">메뉴코드</th>
									<th scope="col">메뉴명</th>
									<th scope="col">메뉴순서</th>
									<th scope="col">위치</th>
									<th scope="col">생성날짜</th>
								</tr>
							</thead>
							<tbody id="table_body">

								<c:forEach var="list" items="${cateList }">
									<tr>
										<th class="th1" scope="row"><input type="checkbox"
											name="del_id" id="chk" class="chkGrp"
											value="${list.cate_id }" /></th>
										<%--<td class="th2" scope="row"><a href="cate_edit.do?cate_id=${list.cate_id }">${list.cate_id } --%>
										<td class="th2" scope="row">
											<a href="javascript:move('${list.cate_id }')">${list.cate_id }</a>
										</td>
										<td class="th3" scope="row">${list.cate_name }</td>
										<td class="th4" scope="row">${list.cate_order }</td>
										<td class="th5" scope="row">${list.cate_place }</td>
										<td class="th6" scope="row">${list.cate_date }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						</form>
						<table id="calculator_table" class="table">
							<tbody id="table_body">
								<tr id="add_btn" style="display: none;" align="left">
									<form action="cate_add.do" method="post">
										<td class="th2" scope="row" align="center"><input
											type="text" name="cate_id" placeholder="메뉴코드"></td>
										<td class="th3" scope="row" align="center"><input
											type="text" name="cate_name" placeholder="메뉴명"></td>
										<td class="th4" scope="row" align="center"><input
											type="text" name="cate_order" placeholder="메뉴순서"></td>
										<td class="th5" scope="row" align="left"><select
											name="cate_place">
												<option value="" disabled selected>=선택=</option>
												<option value="F">F</option>
												<option value="B">B</option>
												<option value="B_F">BF</option>
										</select></td>
										<td class="th6" scope="row" align="left">
											<button class="add_btn btn btn-outline-secondary"
												type="submit">등록</button>
										</td>
									</form>
								</tr>
							</tbody>
						</table>
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
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
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
	<script type="text/javascript">
		function add_tr() {
			$('#add_btn').hide();
			$('#add_btn').show();
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
		/* $(function() {
			$(".add_btn").click( function() {
				let input = $("input");
				let tr = $("<tr></tr>");
				let select=$("select");
		 */
		/* input=키, function(i, item)=키값 */
		/*		$.each(input, function(i, item) {
					let td = $("<td class='th2' scope='row'></td>").html($(item).val());
					$(tr).append(td);
				});
				$.each(select, function(i, item) {
					let td = $("<td class='th5' scope='row'></td>").html($(item).val());
					$(tr).append(td);
				});
				$("table").append(tr);
				$(input).val();
				$(select).val();
			});
		}); 
		 */
	</script>
</body>

</html>