<html>
<head>
<jsp:directive.include file="/WEB-INF/views/common/common.jsp" />
<script>
    $(document).ready(function(){
    	  $('.slider4').bxSlider({
    	    slideWidth: 300,
    	    minSlides: 3,
    	    maxSlides: 3,
    	    moveSlides: 1,
    	    slideMargin: 10,
    	    pager:false,
    	  });
    	});
    </script>
<script type="text/javascript">
    
    function homesearch(){
    	var x= document.getElementById("w-input-search").value;
        window.location.replace('${contextpath}/movie-trailer/search/sear?searchString='+x);
    }
    
    </script>
</head>
<body>
	<!-- Header Start -->
	<div class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<button class="navbar-toggle" data-target=".navbar-collapse"
					data-toggle="collapse" type="button">
					<span class="sr-only">Toggle navigation</span>
				</button>
				<label class="head">MOVIE TRAILER</label>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Dropdown <b class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li class="dropdown-header">Nav header</li>
							<li><a href="#">Separated link</a></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#" class="signout">Sign In</a></li>
					<li><a href="#" class="signout">Sign Up</a></li>
				</ul>
			</div>
		</div>
	</div>


	<!--  Main Page -->


	<div class="container" style="padding-bottom: 5%;">
		<div class="row">
			<div class="col-md-6" id="col-md-6-left">
				<div class="input-group" id="input-group">
					<input type="text" placeholder="Search" id="w-input-search"
						class="form-control"> <span class="input-group-btn">
						<button class="btn btn-default" type="button"
							onclick="homesearch()">Go</button>
					</span>
				</div>
				<br>

				<div class="flex-video widescreen well well-lg"
					style="margin: 0 auto; text-align: center; border: solid 1px;">
					<iframe id="myFrame" allowfullscreen="" frameborder="0"
						src="${defaultTrailerInfo.url}"></iframe>
				</div>
				<br>
				<div class="navbar navbar-inverse navbar-static-top">
					<p class="category">Coming Soon</p>
				</div>

				<div class="slider4">
					<c:forEach var="trailer"
						items="${requestScope['comingSoonTrailerList']}">
						<div class="slide">
							<a href="${contextPath}/info/getTrailer?trailerId=${trailer.id}"><img
								class="img-rounded" onclick="change(${trailer.id})"
								id="${trailer.id}" src="${trailer.imageurl }"></a>
							<p id="title">${trailer.movieTitle}</p>
							<button class="btn btn-inverse"
								style="width: 120; text-align: center;">Add to
								Watchlist</button>
						</div>
					</c:forEach>
				</div>
			</div>


			<div class="col-md-6" id="col-md-6-right">
				<div class="navbar navbar-inverse navbar-static-top" id="r">
					<p class="category">Most Viewed</p>
				</div>

				<div class="slider4">
					<c:forEach var="trailer"
						items="${requestScope['mostViewedTrailerList']}">
						<div class="slide">
							<a href="${contextPath}/info/getTrailer?trailerId=${trailer.id}"><img
								class="img-rounded" onclick="change(${trailer.id})"
								id="${trailer.id}" src="${trailer.imageurl }"></a>
							<p id="title">${trailer.movieTitle}</p>
							<button class="btn btn-inverse" style="width: 120">Add
								to Watchlist</button>
						</div>
					</c:forEach>
				</div>

				<div class="navbar navbar-inverse navbar-static-top" id="r">
					<p class="category">Recently Added</p>
				</div>

				<div class="slider4">
					<c:forEach var="trailer"
						items="${requestScope['recentlyAddedTrailerList']}">
						<div class="slide">

							<a href="${contextPath}/info/getTrailer?trailerId=${trailer.id}"><img
								class="img-rounded" onclick="change(${trailer.id})"
								id="${trailer.id}" src="${trailer.imageurl }"></a>
							<p id="title">${trailer.movieTitle}</p>
							<button class="btn btn-inverse" style="width: 120">Add
								to Watchlist</button>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<!-- Main Page End -->
	<!-- <footer class="bs-footer footer-inverse"> <hr> <div class="container"> <p>@ S-Education </p> </div> </footer> -->
	<div class="navbar navbar-inverse navbar-fixed-bottom"
		style="filter: alpha(opacity = 50); opacity: 0.7; background-color: rgba(0, 0, 0, 0.388235); box-shadow: rgba(0, 0, 0, 0.701961) 0px 0px 5px 0px;">
		<p style="color: white; padding-top: 15px; text-align: center">
			&copy; Done by Samsung Research India Bangalore</p>

	</div>
</body>
</html>