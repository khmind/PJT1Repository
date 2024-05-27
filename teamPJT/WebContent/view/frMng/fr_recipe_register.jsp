<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
<!-- <style type="text/css">
	.container{
		margin-top: 20px; 
	}
</style> -->
</head>
<body>
	<form action="">
		<section data-bs-version="5.1" class="features38 cid-ubxwyl9azq"
			id="features-66-ubxwyl9azq">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-12 col-md-12 col-lg">
						<div class="text-wrapper align-left">
							<div style="text-align: right">
								<input type="submit" value="등록"
									style="width: 90px; height: 40px; border-radius: 10px; background-color: #0dcaf0; color: white; border-style: none;">
							</div>
							<div style="margin-top: 20px;">
								<p>
									<strong style="color: orange; font-size: 20px;">레시피등록</strong>
								</p>
							</div>
							<div style="text-align: center;">
								<textarea rows="26" cols="60"></textarea>
							</div>
						</div>
					</div>
					<div class="col-12 col-md-12 col-lg-6 image-wrapper">
						<h1 class="mbr-section-title mbr-fonts-style mb-4 display-5">
							<strong style="color: orange; font-size: 20px;">레시피 제목 :
								<input type="text" name="title"
								style="width: 400px; border-radius: 20px;">
							</strong>
						</h1>
						<div class="row">
							<strong style="color: orange; font-size: 20px;">사진 등록</strong>
							<div style="display: flex; justify-content: space-around">
								<div class="card" style="width: 18rem;">
									<img src="" alt="이미지 삽입" 
										style="width: 200px; height: 200px; border: 1px solid pink;">
								</div>
								<div class="card" style="width: 18rem;">
									<img src="" alt="이미지 삽입"
										style="width: 200px; height: 200px; border: 1px solid pink;">
								</div>
								<div class="card" style="width: 18rem;">
									<img src="" alt="이미지 삽입"
										style="width: 200px; height: 200px; border: 1px solid pink;">
								</div>
							</div>
							<input type="button" value="파일추가" onclick="addFile()" style=" margin-top: 10px;">
							<div id="d_file"></div>

						</div>
						<p style="display: flex; justify-content: space-around;">
							<strong style="color: orange; font-size: 20px;">난이도</strong> <strong
								style="font-size: 20px;">상<input type="radio"
								name="level"></strong> <strong style="font-size: 20px;">중<input
								type="radio" name="level"></strong> <strong
								style="font-size: 20px;">하<input type="radio"
								name="level"></strong>
						</p>
						<div style="margin-top: 30px;">
							<p>
								<strong style="color: orange; font-size: 20px;">재료등록</strong>
							</p>
						</div>
						<div style="text-align: center; padding-bottom: 30px;">
							<textarea rows="10" cols="60"></textarea>
						</div>
					</div>
					<hr>
				</div>
			</div>
		</section>
	</form>
</body>
</html>