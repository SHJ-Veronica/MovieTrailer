<jsp:directive.include file="/WEB-INF/views/common/common.jsp"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- 
<div class="container">
	<div class="span8">
	<div id="i" class="carousel slide">
		<ol class="carousel-indicators">
			<li data-target="" data-slide-to="0" class=""></li>
			<li data-target="" data-slide-to="1" class="active"></li>
			<li data-target="" data-slide-to="2" class=""></li>
		</ol>
		<div class="carousel-inner">
			<div class="item">
				<img src="http://ia.media-imdb.com/images/M/MV5BMTgxNzY3MzUxOV5BMl5BanBnXkFtZTcwMDA0NjMyNA@@._V1._SX140_CR0,0,140,209_.jpg" alt="">
				<div class="carousel-caption">
					<h4>First Thumbnail label</h4>
					<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
				</div>
			</div>
			<div class="item active">
				<img src="http://ia.media-imdb.com/images/M/MV5BMTc4MjUxNDAwN15BMl5BanBnXkFtZTcwMDMwNDg3OA@@._V1._SY209_CR8,0,140,209_.jpg" alt="">
				<div class="carousel-caption">
					<h4>Second Thumbnail label</h4>
					<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
				</div>
			</div>
			<div class="item">
				<img src="http://ia.media-imdb.com/images/M/MV5BMTgzMzg4MDkwNF5BMl5BanBnXkFtZTcwODAwNDg3OA@@._V1._SY209_CR3,0,140,209_.jpg" alt="">
				<div class="carousel-caption">
					<h4>Third Thumbnail label</h4>
					<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#i" data-slide="prev">‹</a>
		<a class="right carousel-control" href="#i" data-slide="next">›</a>
	</div>
	</div>
</div>
 -->
 
 <script>
 $(document).ready(function(){
	  $('.slider1').bxSlider({
	    slideWidth: 200,
	    minSlides: 2,
	    maxSlides: 3,
	    slideMargin: 10
	  });
	});
 </script>
 
 
 <div class="slider1">
  <div class="slide"><img src="http://placehold.it/350x150&text=FooBar1"></div>
  <div class="slide"><img src="http://placehold.it/350x150&text=FooBar2"></div>
  <div class="slide"><img src="http://placehold.it/350x150&text=FooBar3"></div>
  <div class="slide"><img src="http://placehold.it/350x150&text=FooBar4"></div>
  <div class="slide"><img src="http://placehold.it/350x150&text=FooBar5"></div>
  <div class="slide"><img src="http://placehold.it/350x150&text=FooBar6"></div>
  <div class="slide"><img src="http://placehold.it/350x150&text=FooBar7"></div>
  <div class="slide"><img src="http://placehold.it/350x150&text=FooBar8"></div>
  <div class="slide"><img src="http://placehold.it/350x150&text=FooBar9"></div>
</div>
<div class="bx-controls-direction">
<a class="bx-prev" href="">Prev</a><a class="bx-next" href="">Next</a>
</div>


</body>

</html>