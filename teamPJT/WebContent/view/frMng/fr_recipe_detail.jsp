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
</head>
<body>
	<section data-bs-version="5.1" class="features38 cid-ubxwyl9azq" id="features-66-ubxwyl9azq">
		<div class="container">
			<div class="row justify-content-center" style="flex-direction: row;">
				<div class="col-12 col-md-12 col-lg-6 image-wrapper">
					<h1 class="mbr-section-title mbr-fonts-style mb-4 display-5">
						<strong>양배추달걀밥</strong>
					</h1>
					<div class="row">
						<div style="display: flex; justify-content: space-around">
							<div class="card" style="width: 18rem;">
								<img src="../img/frMng/recipe01.png" class="card-img-top" alt="..."
									style="width: 200px; height: 200px;">
							</div>
							<div class="card" style="width: 18rem;">
								<img src="../img/frMng/recipe02.png" class="card-img-top" alt="..."
									style="width: 200px; height: 200px;">
							</div>
							<div class="card" style="width: 18rem;">
								<img src="../img/frMng/recipe03.png" class="card-img-top" alt="..."
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
						<p><strong style="color: orange; font-size: 20px;">재료준비</strong></p>
					</div>
					<div style="text-align: left; line-height: 3.1">
						<!-- <textarea rows="10" cols="60" style="background-color: "> -->
							양배추 2줌<br>
							간장 2T<br>
							밥 1공기<br>
							계란 1개<br>
							참기름 (있어도 되고 없어도 됨)
						<!-- </textarea> -->
					</div>
				</div>
				<div class="col-12 col-md-12 col-lg">
					<div class="text-wrapper align-left">
						<div style="margin-top: 33px;">
							<p><strong style="color: orange; font-size: 20px;">레시피</strong></p>
						</div>
						<div style="text-align: left; line-height: 3.1">
							<!-- <textarea rows="26" cols="60" > -->
								1. 계란과 양배추를 준비<br>
								2. 적당한 크기로 양배추를 썰기<br>
								3. 오목한 그릇에 밥 1공기 넣기<br>
								4. 썬 양배추를 위에 올리고 가운데에 자리를 만들어 날계란 넣기<br>
								5. 전자레인지에 넣을 수 있는 그릇이나 랩을 씌움<br>
								6. 전자레인지 3분 돌린후 간장과 참기름 넣어주기(입맛에 맞게 조절)<br>
								7. 맛있게 비비기
							<!-- </textarea> -->
						</div>
					</div>
				</div>
				<hr>
				<table style="display: flex; justify-content: space-around; margin-bottom: 80px;">
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
					<tr style="display: flex; justify-content: space-around">
						<td>사용자2</td>
						<td>완전 쉬움</td>
						<td><%=formatter.format(c_time) %></td>
					</tr>
				</table>
			</div>
		</div>
	</section>
</body>
</html>