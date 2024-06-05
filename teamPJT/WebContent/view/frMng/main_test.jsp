<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
document.addEventListener("DOMContentLoaded", function() {

    var radioInputs = document.querySelectorAll('input[name="inlineRadioOptions"]');

    radioInputs.forEach(function(input) {
        input.addEventListener("change", function() {
            var selectedValue = this.value;

            document.querySelectorAll('.chk1, .chk2, .chk3').forEach(function(element) {
                element.style.display = 'none';
            });

            if (selectedValue === 'option1') {
                document.querySelector('.chk1').style.display = 'flex';
            } else if (selectedValue === 'option2') {
                document.querySelector('.chk2').style.display = 'flex';
            } else if (selectedValue === 'option3') {
                document.querySelector('.chk3').style.display = 'flex';
            }
        });
    });
});
</script>
</head>
<body>
<section data-bs-version="5.1" class="features38 cid-ubxwyl9azq" id="features-66-ubxwyl9azq">
      <div class="container" style="margin-top: 20px;">
        <div class="row justify-content-center">
            <div class="col-12 col-md-12 col-lg">
                <div class="text-wrapper align-left" style="height : 500px;
                 border-radius: 50px;background-image: url('../assets/images/photo-1496412705862-e0088f16f791.jpeg');
                 background-size: cover;">
                    <h1 style=" color: white;margin-top: 50px;">
                        <strong>맛있는 레시피</strong>
                    </h1>
                    <p style="color: white; margin-top: 30px;">
			                    당신의 요리 능력을 세계에 공개하고 싶다면,<br> 맛있는 레시피가 당신을 위한 완벽한 플랫폼입니다.<br>
			                    맛있는 레시피는 요리에 관심이 있는 사람들이 <br>레시피를 찾고 공유하는 공간이기도 합니다.<br>
			                    맛있는 레시피는 여러분의 요리를 세계와 공유하고,<br> 더 많은 쉐프들과 소통할 수 있는 기회를 제공합니다.
                    </p>
                </div>
            </div>
            <div class="col-12 col-md-12 col-lg-6 image-wrapper" style="height: 500px;">
            	<div style=" margin-left : 60px;width: 500px; display: flex; justify-content: space-around; background: #fffd9e; ">
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
	            	<div class="card" style="width: 500px;cursor: pointer; margin-top: 20px;" 
	            		onclick="location.href='fr_recipe_detail.jsp'">
						<img src="../img/피자.jpg" class="card-img-top" alt="..." style="width:100%; height: 300px;">
						<div class="card-body">
							<p class="card-text">
							맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자
							맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자
							맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자
							맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는 피자맛있는</p>
						</div>
					</div>
            	</div>
            	<div class="chk2" style="display: none; justify-content: center; ">
	            	<div class="card" style="width: 500px;cursor: pointer; margin-top: 20px;" 
	            		onclick="location.href='fr_recipe_detail.jsp'">
						<img src="../img/짜장면.jpg" class="card-img-top" alt="..." style="width:100%; height: 300px;">
						<div class="card-body">
							<p class="card-text">맛있는 짜장면</p>
						</div>
					</div>
            	</div>
            	<div class="chk3" style="display: none; justify-content: center;">
	            	<div class="card" style="width: 500px;cursor: pointer; margin-top: 20px;" 
	            		onclick="location.href='fr_recipe_detail.jsp'">
						<img src="../img/제육.jpg" class="card-img-top" alt="..." style="width:100%; height: 300px;">
						<div class="card-body">
							<p class="card-text">맛있는 제육</p>
						</div>
					</div>
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