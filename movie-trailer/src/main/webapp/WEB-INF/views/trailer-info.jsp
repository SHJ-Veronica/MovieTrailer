<jsp:directive.include file="/WEB-INF/views/common/common.jsp"/>
<html>
<head><meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Trailer-Info</title>
	<script type="text/javascript">
        
        function homesearch(){
        	var x= document.getElementById("w-input-search").value;
            window.location.replace('${contextpath}/movie-trailer/search/sear?searchString='+x);        	
            
        }
        
        </script> 
</head>
<body style="background: url(${contextPath}/images/back2.jpg) no-repeat center center fixed; background-size: cover; 
background-color: rgb(30, 52, 67); height: 685px; 
background-repeat: no-repeat no-repeat;">

<!-- Header Start -->
<div class="navbar navbar-inverse" role="navigation" style="filter:alpha(opacity=50);
opacity:0.7;background-color:rgba(0, 0, 0, 0.388235); box-shadow:rgba(0, 0, 0, 0.701961) 0px 0px 5px 0px;">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <label class="head">MOVIE TRAILER</label>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class=""><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a class="signout" href="#">Sign Out</a></li>
          </ul>
        </div>
      </div>
</div>


<div class="container">
	<div class="row">
    	<div class="col-md-7"  id="col-md-7">
          <div class="input-group" id="input-group">
              <input type="text" placeholder="Search" id="w-input-search" class="form-control">
              <span class="input-group-btn">
                  <button class="btn btn-default" type="button" onclick="homesearch()">Go</button>
              </span>
         </div>
<br>	
    		 <div  class="flex-video widescreen well well-lg" style="margin: 0 auto;text-align:center;border:solid 1px">
             	<iframe id="myFrame" allowfullscreen="" frameborder="0" src="${defaultTrailerInfo.url}"></iframe>
        	</div>
        	
        	<br>
        	<p id="name">${defaultTrailerInfo.movieTitle}</p>
        	<br>
        	<br>
        	<img class="img-thumbnail" src="resources/image/like.jpg">
        	&nbsp;&nbsp;&nbsp;
        	<img class="img-thumbnail" src="resources/image/dislike.jpg">
        	<br>
        	<br>
        	<br>
    	</div>
    	
    	<div class="col-md-5" id="col-md-5">
    		<c:forEach var="trailer" items="${requestScope['trailerList']}">
	            <div class="row">
	               <div class="col-md-4" style="padding-bottom:10px;padding-left: 28px;padding-right: 0px;">
	      				<a href="${contextPath}/info/getTrailer?trailerId=${trailer.id}">
	      				<img id="${trailer.id }" class="img-rounded" src="${trailer.imageurl }"></a>
	      				
	               </div>
	               <div class="col-md-8" style="padding-right:10px;padding-right: 0px;">      
	      				<p id="name">${trailer.movieTitle}</p>
	      			
	      				<p>${trailer.description}</p>
	               </div>
	            </div>
            </c:forEach>			  	
    	</div>
    		
    	</div>
    </div>

<div class="navbar navbar-inverse navbar-fixed-bottom" style="filter:alpha(opacity=50); opacity:0.7; 
background-color:rgba(0, 0, 0, 0.388235); box-shadow:rgba(0, 0, 0, 0.701961) 0px 0px 5px 0px;">
     <p style="color:white; padding-top: 15px;text-align: center">
    &copy; Done by Samsung Research India Bangalore</p>
      
</div>


</body>
</html>
