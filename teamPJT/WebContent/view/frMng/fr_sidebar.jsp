<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
</head>
<body>

			<!--  왼쪽 메뉴  -->
 			<div class="col-md-3 col-xl-2 bd-sidebar">
			
				<div class="collapse d-md-block row" id="bd-docs-nav">
				  <nav class="bd-links" aria-label="Main navigation">				
				      <div class="bd-toc-item">				        
				        <a class="bd-toc-link" href="userInfo.to">
				          	개인정보
				        </a>
				      </div>
				
				      <div class="bd-toc-item">
				        <a class="bd-toc-link" href="frMng/fr_myRecipe.jsp">
				          	나의레시피
				        </a>
				      </div>
				
				      <div class="bd-toc-item">
				        <a class="bd-toc-link" href="frMng/fr_interest_recipe.jsp">
				          	관심레시피
				        </a>
				      </div>
				
				      <div class="bd-toc-item">
				        <a class="bd-toc-link" href="frMng/fr_recommend_recipe.jsp">
				          	추천레시피
				        </a>
				      </div>
				
				      <div class="bd-toc-item">
				        <a class="bd-toc-link" href="notice.to">
				          	공지사항
				        </a>
				      </div>
				
				      <div class="bd-toc-item">
				        <a class="bd-toc-link" href="frMng/fr_ask.jsp">
				          	문의사항
				        </a>
				      </div>
				  </nav>
				</div>
			
			</div>  	
			
</body>
</html>