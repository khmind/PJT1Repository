<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>  
</head>

<body>

<%-- <%@ include file="../frMng/header.jsp"%> --%>
<%-- <%@ include file="../frMng/img/된장찌개.jpg"%> --%>

<!-- 
<section data-bs-version="5.1" class="features38 cid-ubxwyl9azq" id="features-66-ubxwyl9azq">
    <div class="container">
        <div class="row justify-content-center" style="flex-direction: row;">
            <div class="col-12 col-md-12 col-lg">
                <div class="text-wrapper align-left">
                    <h1 class="mbr-section-title mbr-fonts-style mb-4 display-5">
                        <strong>마라탕 레시피</strong>
                    </h1>
                    <p class="mbr-text align-left mbr-fonts-style mb-4 display-9">마라탕 레시피마라탕 레시피마라탕 레시피마라탕 레시피마라탕 레시피마라탕 레시피마라탕 레시피마라탕 레시피</p>
                    
                </div>
            </div>
            <div class="col-12 col-md-12 col-lg-6 image-wrapper">
                <img class="w-100" src="../assets/images/photo-1505935428862-770b6f24f629.jpeg" alt="" >
            </div>
        </div>
    </div>
</section>
 -->
 
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
                      <img src="${ran.img_main }" alt="" title="" height="300px">
                        <!-- <img src="../view/assets/images/된장찌개.jpg" alt="" title="" height="300px"> -->
                    </div>
                  </div>
                </div>
              </div>
              
              </c:forEach>
 <!--              
 
               <div class="embla__slide slider-image item" style="margin-left: 0rem; margin-right: 0rem;">
                <div class="slide-content">
                  <div class="item-img">
                    <div class="item-wrapper">
                      <img src="../view/assets/images/photo-1490818387583-1baba5e638af.jpeg" alt="" title="" height="300px">
                    </div>
                  </div>
                </div>
              </div>
 
              <div class="embla__slide slider-image item" style="margin-left: 0rem; margin-right: 0rem;">
                <div class="slide-content">
                  <div class="item-img">
                    <div class="item-wrapper">
                      <img src="../view/assets/images/photo-1714138667800-e93341a1792f.jpeg" alt="" title="">
                    </div>
                  </div>
                </div>
              </div>
              <div class="embla__slide slider-image item" style="margin-left: 0rem; margin-right: 0rem;">
                <div class="slide-content">
                  <div class="item-img">
                    <div class="item-wrapper">
                      <img src="../view/assets/images/photo-1496412705862-e0088f16f791.jpeg" alt="" title="">
                    </div>
                  </div>
                </div>
              </div>
              <div class="embla__slide slider-image item" style="margin-left: 0rem; margin-right: 0rem;">
                <div class="slide-content">
                  <div class="item-img">
                    <div class="item-wrapper">
                      <img src="../view/assets/images/photo-1495195134817-aeb325a55b65.jpeg" alt="" title="">
                    </div>
                  </div>
                </div>
              </div>
              <div class="embla__slide slider-image item" style="margin-left: 0rem; margin-right: 0rem;">
                <div class="slide-content">
                  <div class="item-img">
                    <div class="item-wrapper">
                      <img src="../view/assets/images/photo-1714138667501-5ff02866c4f2.jpeg" alt="" title="">
                    </div>
                  </div>
                </div>
              </div>
            </div>
           -->  
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