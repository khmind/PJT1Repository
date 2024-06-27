<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	function confirmModal3() {
		
		location = "recipe.do";
	
	
}
</script>
</head>
<body>
	<form action="recipe_edit.do" method="post" name="frmtt">
		<input type="hidden" name="recipe_id" value="${recipe.recipe_id }">
	
		<section data-bs-version="5.1" class="features38 cid-ubxwyl9azq"
			id="features-66-ubxwyl9azq">
			<div class="container">
				<div class="row justify-content-center" style="flex-direction: row;">
					<div class="col-12 col-md-12 col-lg-6 image-wrapper">
						<h1 class="mbr-section-title mbr-fonts-style mb-4 display-5">
							<strong style="color: orange; font-size: 20px;">레시피 제목 :
								<input type="text" name="reci_title" value="${recipe.recipe_title }"
								style="width: 400px; border-radius: 20px; text-align: center;">
							</strong>
						</h1>
						<div>
							<strong style="color: orange; font-size: 20px;">분류 : </strong> 
								<select	name="class_name" style="width: 20%; border-radius: 20px; text-align: center;">
								<option value="${recipe.class_id}" disabled selected>${recipe.class_name }</option>
								<c:forEach var="c" items="${class_name}">
									<option value="${c.class_id}">${c.class_name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="row">
							<strong style="color: orange; font-size: 20px;">사진 등록</strong>
							<div style="display: flex; justify-content: space-around">
								<div class="card" style="width: 18rem;">
									<div class="image_container1"
										style="width: 210px; height: 200px; border-right: 1px solid pink; border-left: 1px solid pink">
									<input type="file" name="upload1" id="upload1" class="image" accept="image/*" />
									<img id="preview1" src="${recipe.img_path_01 }" style="width: 100%; height: 100%">
									</div>
								</div>
								<div class="card" style="width: 18rem;">
									<div class="image_container2"
										style="width: 210px; height: 200px; border-right: 1px solid pink">
									<input type="file" name="upload2" id="upload2" class="image" accept="image/*" />
									<img id="preview2" src="${recipe.img_path_02 }" style="width: 100%; height: 100%">
									
									</div>
								</div>
								<div class="card" style="width: 18rem;">
									<div class="image_container3"
										style="width: 210px; height: 200px; border-right: 1px solid pink">
										<input type="file" name="upload3" id="upload3" class="image" accept="image/*" />
									<img id="preview3" src="${recipe.img_path_03 }" style="width: 100%; height: 100%">
										
									</div>
								</div>
							</div>
						</div>
						<p style="display: flex; justify-content: space-around; margin-top: 20px;">
							<strong style="color: orange; font-size: 20px;">난이도</strong> 
							<strong style="font-size: 20px;">상
								<input type="radio" name="level" value="A" <c:if test="${recipe.recipe_level eq 'A' }"> checked </c:if>>
							</strong> 
							<strong style="font-size: 20px;">중
								<input type="radio" name="level" value="B" <c:if test="${recipe.recipe_level eq 'B' }">checked</c:if>>
							</strong> 
							<strong	style="font-size: 20px;">하
								<input type="radio" name="level" value="C" <c:if test="${recipe.recipe_level eq 'C' }">checked</c:if>>
							</strong>
						</p>
						<div style="margin-top: 30px;">
							<p>
								<strong style="color: orange; font-size: 20px;">재료등록</strong>
							</p>
						</div>
						<div style="text-align: center; padding-bottom: 30px;">
							<textarea rows="10" name="stuff" cols="60" >${recipe.recipe_stuff }</textarea>
						</div>
					</div>
					<div class="col-12 col-md-12 col-lg">
						<div class="text-wrapper align-left">
							<div style="text-align: right">
								<input type="submit" value="수정"
									style="width: 90px; height: 40px; border-radius: 10px; background-color: #0dcaf0; color: white; border-style: none;">
								<input type="button" value="목록" onclick="confirmModal3()"
									style="width: 90px; height: 40px; border-radius: 10px; background-color: #0dcaf0; color: white; border-style: none;">
							</div>
							<div style="margin-top: 20px;">
								<p>
									<strong style="color: orange; font-size: 20px;">레시피등록</strong>
								</p>
							</div>
							<div style="text-align: center;">
								<textarea name="content" rows="26" cols="60">${recipe.recipe_content }</textarea>
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
					<%-- <c:forEach var="re" items="${recipe }"> --%>
					<tr style="display: flex; justify-content: space-around">
						<td>${recipe.user_name }</td>
						<td>${recipe.comment_content }</td>
						<td>${recipe.comment_date }</td>
					</tr>
					<%-- </c:forEach> --%>
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
