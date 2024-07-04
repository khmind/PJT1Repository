<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맛있는 레시피</title>
<script type="text/javascript">
	function confirmModal3() {
		
		location = "recipeSearch.to";
	}
	function move(args){	
		
		frmGo.recipe_id.value = args;
		frmGo.action = "recipe_edit.do";
		frmGo.submit();
		
	} 
</script>
</head>
<body>
	<form action="" method="post" name="frmGo" class="search-box" >
		<input type="hidden" value="" name="recipe_id" >
		
	</form>
	<section data-bs-version="5.1" class="features38 cid-ubxwyl9azq" id="features-66-ubxwyl9azq">
		<div class="container">
			<div class="row justify-content-center" style="flex-direction: row;">
				<div class="col-12 col-md-12 col-lg-6">
					<h1 class="mbr-section-title mbr-fonts-style mb-4 display-5">
						<strong>${recipeD.recipe_title }</strong>
					</h1>
					<div>
						<strong style="color: orange; font-size: 20px;">분류 : </strong> 
							<select	name="class_name" style="width: 20%; border-radius: 20px; text-align: center;">
							<option value="${recipeD.class_id}" disabled selected>${recipeD.class_name }</option>
							<c:forEach var="c" items="${classN}">
								<option value="${c.class_id}">${c.class_name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="row">
						<div style="display: flex; justify-content: space-around">
							<div class="card" style="width: 18rem;">
								<img src="${recipeD.img_path_01 }" class="card-img-top" alt="..."
									style="width: 200px; height: 200px;">
							</div>
							<div class="card" style="width: 18rem;">
								<img src="${recipeD.img_path_01 }" class="card-img-top" alt="..."
									style="width: 200px; height: 200px;">
							</div>
							<div class="card" style="width: 18rem;">
								<img src="${recipeD.img_path_01 }" class="card-img-top" alt="..."
									style="width: 200px; height: 200px;">
							</div>
						</div>
					</div>
					<p style="display: flex; justify-content: space-around; margin-top: 20px;">
						<strong style="color: orange; font-size: 20px;">난이도</strong> 
						<strong style="font-size: 20px;">상
							<input type="radio" name="level" value="A" <c:if test="${recipeD.recipe_level eq 'A' }"> checked </c:if>>
						</strong> 
						<strong style="font-size: 20px;">중
							<input type="radio" name="level" value="B" <c:if test="${recipeD.recipe_level eq 'B' }">checked</c:if>>
						</strong> 
						<strong	style="font-size: 20px;">하
							<input type="radio" name="level" value="C" <c:if test="${recipeD.recipe_level eq 'C' }">checked</c:if>>
						</strong>
					</p>
					<div style="margin-top: 30px;">
						<p><strong style="color: orange; font-size: 20px;">재료준비</strong></p>
					</div>
					<div style="text-align: left; line-height: 3.1">${recipeD.recipe_stuff }</div>
				</div>
				<div class="col-12 col-md-12 col-lg-6">
					<div class="text-wrapper align-left" style="padding-bottom: 115px">
						<div style="text-align: right;" >
							<c:if test="${sessionScope.loginVO != null && sessionScope.user_id == recipeD.user_id }">
							<input type="submit" value="수정" onclick="move('${recipeD.recipe_id }')"
								style="width: 90px; height: 40px; border-radius: 10px; background-color: #0dcaf0; color: white; border-style: none;">
							</c:if>
							<input type="button" value="목록" onclick="confirmModal3()"
								style="width: 90px; height: 40px; border-radius: 10px; background-color: #0dcaf0; color: white; border-style: none;">
						</div>
						<div style="margin-top: 33px;">
							<p><strong style="color: orange; font-size: 20px;">레시피</strong></p>
						</div>
						<div style="text-align: left; line-height: 3.1">
							${recipeD.recipe_content }
						</div>
					</div>
				</div>
				<hr>
				<table style="display: flex; justify-content: space-around; margin-bottom: 80px;">
					<form action="recipe_comment.to" method="post">
						<tr>
							<td colspan="3">
								<textarea rows="1" cols="80" placeholder="마음에 드셨나요? 댓글남겨주세요." name="recipe_reply"
								style="border-radius: 30px; text-align: center; font-size: 20px;"></textarea>
							</td>
							<td>
								<input type="submit" value="등록" 
									style="width:70px; height:40px; background-color:skyblue;">
							</td>
						</tr>
					</form>
					<tr style="display: flex; justify-content: space-around">
						<td>사용자1</td>
						<td>맛있어요</td>
						<td></td>
					</tr>
					<tr style="display: flex; justify-content: space-around">
						<td>사용자2</td>
						<td>완전 쉬움</td>
						<td></td>
					</tr>
				</table>
			</div>
		</div>
	</section>
</body>
</html>