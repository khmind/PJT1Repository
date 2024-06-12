<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
document.addEventListener("DOMContentLoaded", function() {

   
    document.querySelectorAll('.chk1, .chk2, .chk3, .chk4, .chk5, .chk6').forEach(function(element) {
        element.style.display = 'none';
    });

   
    document.querySelector('.chk1').style.display = 'flex';
    document.querySelector('.chk4').style.display = 'flex';
    
    var radioInputs = document.querySelectorAll('input[name="inlineRadioOptions"]');
    radioInputs.forEach(function(input) {
        input.addEventListener("change", function() {
            var selectedValue = this.value;

           
            document.querySelectorAll('.chk1, .chk2, .chk3, .chk4, .chk5, .chk6').forEach(function(element) {
                element.style.display = 'none';
            });

           
            if (selectedValue === 'option1') {
                document.querySelector('.chk1').style.display = 'flex';
                document.querySelector('.chk4').style.display = 'flex';
            } else if (selectedValue === 'option2') {
                document.querySelector('.chk2').style.display = 'flex';
                document.querySelector('.chk5').style.display = 'flex';
            } else if (selectedValue === 'option3') {
                document.querySelector('.chk3').style.display = 'flex';
                document.querySelector('.chk6').style.display = 'flex';
            }
        });
    });
});
</script>
</head>
<body>
<section data-bs-version="5.1" class="features38 cid-ubxwyl9azq" id="features-66-ubxwyl9azq">
      <div class="container" style="margin-top: 20px;">
        <div class="row justify-content-center" style="flex-direction: row;">
            <div class="col-12 col-md-12 col-lg-6 image-wrapper" style="height: 500px;">
            	<div style=" width: 100%; display: flex; margin-top:30px;
            		justify-content: space-around; background: #fffd9e; ">
	         		<div class="form-check form-check-inline">
					  상<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1" checked>
					</div>
					<div class="form-check form-check-inline">
					  중<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
					</div>
					<div class="form-check form-check-inline">
					  하<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3" >
					</div> 
            	</div>
            	<div class="chk1" style="display: flex; justify-content: center; ">
	            	<div class="card" style="width:100%;cursor: pointer; margin-top: 20px;" 
	            		onclick="location.href='fr_recipe_detail.jsp'">
						<img src="../img/피자.jpg" class="card-img-top" alt="..." style="width:100%; height: 350px;">
						<div class="card-body">
							<p class="card-text">
							맛있는 피자</p>
						</div>
					</div>
            	</div>
            	<div class="chk2" style="display: none; justify-content: center; ">
	            	<div class="card" style="width: 100%;cursor: pointer; margin-top: 20px;" 
	            		onclick="location.href='fr_recipe_detail.jsp'">
						<img src="../img/짜장면.jpg" class="card-img-top" alt="..." style="width:100%; height: 350px;">
						<div class="card-body">
							<p class="card-text">맛있는 짜장면</p>
						</div>
					</div>
            	</div>
            	<div class="chk3" style="display: none; justify-content: center;">
	            	<div class="card" style="width: 100%;cursor: pointer; margin-top: 20px;" 
	            		onclick="location.href='fr_recipe_detail.jsp'">
						<img src="../img/제육.jpg" class="card-img-top" alt="..." style="width:100%; height: 350px;">
						<div class="card-body">
							<p class="card-text">맛있는 제육</p>
						</div>
					</div>
            	</div>
            </div>
            <div class=" col-12 col-md-12 col-lg " style="margin-bottom: 150px; ">
            	<div style="margin-top: 30px; margin-left: 30px;">
					<p><strong style="color: orange; font-size: 20px;">재료준비</strong></p>
				</div>
                <div class="chk4 text-wrapper align-left"  style="text-align: left; line-height: 3.1;
                	border: 1px solid #fcd2fb; width: 100%;">
                	양배추 2줌1<br>
					간장 2T1<br>
					밥 1공기1<br>
					계란 1개1<br>
					참기름 (있어도 되고 없어도 됨)
                </div>
                <div class="chk5 text-wrapper align-left"  style="text-align: left; line-height: 3.1;
               	 	border: 1px solid #fcd2fb; width: 550px;">
                	양배추 2줌2<br>
					간장 2T2<br>
					밥 1공기2<br>
					계란 1개2<br>
					참기름 (있어도 되고 없어도 됨)
                </div>
                <div class="chk6 text-wrapper align-left"  style="text-align: left; line-height: 3.1;
               		border: 1px solid #fcd2fb; width: 550px;">
                	양배추 2줌3<br>
					간장 2T3<br>
					밥 1공기3<br>
					계란 1개3<br>
					참기름 (있어도 되고 없어도 됨)
                </div>
            </div>
        </div>
    </div>
</section>
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
              <div class="embla__slide slider-image item" style="margin-left: 0rem; margin-right: 0rem;">
                <div class="slide-content">
                  <div class="item-img">
                    <div class="item-wrapper">
                      <img src="../assets/images/photo-1490818387583-1baba5e638af.jpeg" alt="" title="" height="300px">
                    </div>
                  </div>
                </div>
              </div>
              <div class="embla__slide slider-image item" style="margin-left: 0rem; margin-right: 0rem;">
                <div class="slide-content">
                  <div class="item-img">
                    <div class="item-wrapper">
                      <img src="../assets/images/photo-1714138667800-e93341a1792f.jpeg" alt="" title="">
                    </div>
                  </div>
                </div>
              </div>
              <div class="embla__slide slider-image item" style="margin-left: 0rem; margin-right: 0rem;">
                <div class="slide-content">
                  <div class="item-img">
                    <div class="item-wrapper">
                      <img src="../assets/images/photo-1496412705862-e0088f16f791.jpeg" alt="" title="">
                    </div>
                  </div>
                </div>
              </div>
              <div class="embla__slide slider-image item" style="margin-left: 0rem; margin-right: 0rem;">
                <div class="slide-content">
                  <div class="item-img">
                    <div class="item-wrapper">
                      <img src="../assets/images/photo-1495195134817-aeb325a55b65.jpeg" alt="" title="">
                    </div>
                  </div>
                </div>
              </div>
              <div class="embla__slide slider-image item" style="margin-left: 0rem; margin-right: 0rem;">
                <div class="slide-content">
                  <div class="item-img">
                    <div class="item-wrapper">
                      <img src="../assets/images/photo-1714138667501-5ff02866c4f2.jpeg" alt="" title="">
                    </div>
                  </div>
                </div>
              </div>
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