<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	Date c_time=new Date();
	SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<html>
<head>
<meta charset="UTF-8">
<title>맛있는 레시피</title>
<style type="text/css">
	.container{
		margin-top: 20px; 
	}
	img{
		width: 3%;
	}
</style>
</head>
<body>
	<section data-bs-version="5.1" class="features38 cid-ubxwyl9azq" id="features-66-ubxwyl9azq">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-12 col-md-12 col-lg">
					<div class="text-wrapper align-left">
						<div style="margin-top: 33px;">
							<p><strong style="color: orange; font-size: 20px;">레시피등록</strong></p>
						</div>
						<div style="text-align: center;">
							<textarea rows="26" cols="60"></textarea>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-12 col-lg-6 image-wrapper">
					<h1 class="mbr-section-title mbr-fonts-style mb-4 display-5">
						<strong>양배추달걀밥</strong>
					</h1>
					<div class="row">
						<div style="display: flex; justify-content: space-around">
							<div class="card" style="width: 18rem;">
								<img src="../img/recipe01.png" class="card-img-top" alt="..."
									style="width: 200px; height: 200px;">
							</div>
							<div class="card" style="width: 18rem;">
								<img src="../img/recipe02.png" class="card-img-top" alt="..."
									style="width: 200px; height: 200px;">
							</div>
							<div class="card" style="width: 18rem;">
								<img src="../img/recipe03.png" class="card-img-top" alt="..."
									style="width: 200px; height: 200px;">
							</div>
						</div>
					</div>
					<p style="display: flex; justify-content: space-around">
						<strong style="color: orange; font-size: 20px;">난이도</strong>
						<strong style="font-size: 20px;">상<input type="radio"></strong>
						<strong style="font-size: 20px;">중<input type="radio"></strong>
						<strong style="font-size: 20px;">하<input type="radio" checked></strong>
					</p>
					<div style="margin-top: 30px;">
						<p><strong style="color: orange; font-size: 20px;">재료등록</strong></p>
					</div>
					<div style="text-align: center;">
						<textarea rows="10" cols="60"></textarea>
					</div>
				</div>
				<hr>
				<table style="display: flex; justify-content: space-around">
					<tr>
						<td colspan="3">
							<textarea rows="1" cols="80" placeholder="마음에 드셨나요? 댓글남겨주세요." 
							style="border-radius: 30px; text-align: center; font-size: 20px;"></textarea>
						</td>
						<td><input type="submit" value="등록" 
								style="width:70px; height:40px; background-color:skyblue;"></td>
					</tr>
					<tr style="display: flex; justify-content: space-around">
						<td>사용자1</td>
						<td>맛있어요</td>
						<td><%=formatter.format(c_time) %></td>
					</tr>
				</table>
			</div>
		</div>
	</section>
</body>
</html>