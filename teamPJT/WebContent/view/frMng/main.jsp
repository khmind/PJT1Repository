<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>  
</head>

<body>
 
<br><br><br><br><br>
<section data-bs-version="5.1" class="slider4 mbr-embla cid-ubxwyl8tSX" id="gallery-5-ubxwyl8tSX">
  <div class="container">
    <div class="row mb-5 justify-content-center">
      <div class="col-12 content-head">
        <h5 class="mbr-section-subtitle mbr-fonts-style align-center mb-0 mt-4 display-7">
         	 오늘의 추천 레시피
        </h5>
      </div>
    </div>
    <div class="row">
      <div class="col-12">
        <div class="embla position-relative" data-skip-snaps="true" data-align="center" data-contain-scroll="trimSnaps" data-loop="true" data-auto-play="true" data-auto-play-interval="2">
          <div class="embla__viewport">
            <div class="embla__container">
            
              <c:forEach var="ran" items="${random }" varStatus="status">
				<div class="embla__slide slider-image item" style="margin-left: 0rem; margin-right: 0rem;">                            
	                <div class="slide-content">
	                  <div class="item-img">
	                    <div class="item-wrapper">                    	                      
	                      <img src="${ran.img_main }" alt="" title="" width="500px" height="300px">                       
	                    </div>
	                  </div>
	                </div>
 				</div>              
              </c:forEach>
            </div>           
          </div>
          
          <button class="embla__button embla__button--prev">
            <span class="mobi-mbri mobi-mbri-arrow-prev" aria-hidden="true"></span>
            <span class="sr-only visually-hidden visually-hidden">Previous</span>
          </button>
          <button class="embla__button embla__button--next">
            <span class="mobi-mbri mobi-mbri-arrow-next" aria-hidden="true"></span>
            <span class="sr-only visually-hidden visually-hidden">Next</span>
          </button> 
          
        </div>
      </div>
    </div>
  </div>
</section>

</body>
</html>