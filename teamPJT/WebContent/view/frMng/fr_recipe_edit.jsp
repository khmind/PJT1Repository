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
<script type="text/javascript">
	let imgFile=1;
	function addFile() {
		$("#d_file").append("<br>"+"<input type='file' name='file"+imgFile+"'/>");
		imgFile++;
	}
</script>
</head>
<body>
	<form action="">
		<section data-bs-version="5.1" class="features38 cid-ubxwyl9azq"
			id="features-66-ubxwyl9azq">
			<div class="container">
				<div class="row justify-content-center" style="flex-direction: row;">
					<div class="col-12 col-md-12 col-lg-6 image-wrapper">
						<h1 class="mbr-section-title mbr-fonts-style mb-4 display-5">
							<strong style="color: orange; font-size: 20px;">레시피 제목 :
								<input type="text" name="title" value="양배추계란밥"
								style="width: 400px; border-radius: 20px; text-align: center;">
							</strong>
						</h1>
						<div class="row">
							<strong style="color: orange; font-size: 20px;">사진 등록</strong>
							<div style="display: flex; justify-content: space-around">
								<div class="card" style="width: 18rem;">
									<div class="image_container1"
										style="width: 210px; height: 200px; border-right: 1px solid pink; border-left: 1px solid pink">
									<input type="file" name="upload" id="upload1" class="image" accept="image/*" />
									<img id="preview1" src="../img/recipe01.png" style="width: 100%; height: 100%">
									</div>
								</div>
								<div class="card" style="width: 18rem;">
									<div class="image_container2"
										style="width: 210px; height: 200px; border-right: 1px solid pink">
									<input type="file" name="upload" id="upload2" class="image" accept="image/*" />
									<img id="preview2" src="../img/recipe02.png" style="width: 100%; height: 100%">
									
									</div>
								</div>
								<div class="card" style="width: 18rem;">
									<div class="image_container3"
										style="width: 210px; height: 200px; border-right: 1px solid pink">
										<input type="file" name="upload" id="upload3" class="image" accept="image/*" />
									<img id="preview3" src="../img/recipe03.png" style="width: 100%; height: 100%">
										
									</div>
								</div>
							</div>
						</div>
						<p style="display: flex; justify-content: space-around; margin-top: 20px;">
							<strong style="color: orange; font-size: 20px;">난이도</strong> 
							<strong style="font-size: 20px;">상<input type="radio" name="level"></strong> 
							<strong style="font-size: 20px;">중<input type="radio" name="level"></strong> 
							<strong	style="font-size: 20px;">하<input type="radio" name="level" checked></strong>
						</p>
						<div style="margin-top: 30px;">
							<p>
								<strong style="color: orange; font-size: 20px;">재료등록</strong>
							</p>
						</div>
						<div style="text-align: center; padding-bottom: 30px;">
							<textarea rows="10" cols="60" >양배추 2줌,
																 간장 2T,
																 밥 1공기,
																 계란 1개,
																 참기름 (있어도 되고 없어도 됨)
							</textarea>
						</div>
					</div>
					<div class="col-12 col-md-12 col-lg">
						<div class="text-wrapper align-left">
							<div style="text-align: right">
								<input type="submit" value="수정"
									style="width: 90px; height: 40px; border-radius: 10px; background-color: #0dcaf0; color: white; border-style: none;">
								<input type="submit" value="비활성화"
									style="width: 90px; height: 40px; border-radius: 10px; background-color: #0dcaf0; color: white; border-style: none;">
								<input type="reset" value="삭제"
									style="width: 90px; height: 40px; border-radius: 10px; background-color: #0dcaf0; color: white; border-style: none;">
							</div>
							<div style="margin-top: 20px;">
								<p>
									<strong style="color: orange; font-size: 20px;">레시피등록</strong>
								</p>
							</div>
							<div style="text-align: center;">
								<textarea rows="26" cols="60">1. 계란과 양배추를 준비
																 2. 적당한 크기로 양배추를 썰기
																 3. 오목한 그릇에 밥 1공기 넣기
																 4. 썬 양배추를 위에 올리고 가운데에 자리를 만들어 날계란 넣기
																 5. 전자레인지에 넣을 수 있는 그릇이나 랩을 씌움
																 6. 전자레인지 3분 돌린후 간장과 참기름 넣어주기(입맛에 맞게 조절)
																 7. 맛있게 비비기
								</textarea>
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
	</form>
<script>

	var file1 = document.querySelector('#upload1');
	var file2 = document.querySelector('#upload2');
	var file3 = document.querySelector('#upload3');

	file1.onchange = function() {
		var fileList = file1.files;

		// 읽기
		var reader = new FileReader();
		reader.readAsDataURL(fileList[0]);

		//로드 한 후
		reader.onload = function() {
			document.querySelector('#preview1').src = reader.result;
		};
	};
	file2.onchange = function() {
		var fileList = file2.files;

		// 읽기
		var reader = new FileReader();
		reader.readAsDataURL(fileList[0]);

		//로드 한 후
		reader.onload = function() {
			document.querySelector('#preview2').src = reader.result;
		};
	};
	file3.onchange = function() {
		var fileList = file3.files;

		// 읽기
		var reader = new FileReader();
		reader.readAsDataURL(fileList[0]);

		//로드 한 후
		reader.onload = function() {
			document.querySelector('#preview3').src = reader.result;
		};
	};
</script>
</body>
</html>
