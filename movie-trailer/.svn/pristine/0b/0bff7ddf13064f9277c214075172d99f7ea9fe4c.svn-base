<jsp:directive.include file="/WEB-INF/views/common/common.jsp"/>
<html>
<head>
	<title>Search</title>
<script>
/* function search(obj)
{
	homeProxy.ajaxTest(obj,function(result){
		alert(result);
		
	});
	
	} */

	
	var trailer = "<div id='list'>"+
	"		<img id='img-search' src='${trailer.imageurl }' class='img-rounded'>"+
	"		<div id='detail'>"+
	"   	<a  href='#'>${trailer.movieTitle}</a>"+
	"  	<br>"+
	"    	<p>${trailer.description}</p>"+
	"    	</div>"+
	"	</div> ";	
	
function search()
	
	{
		var x= document.getElementById("w-input-search");
		homeProxy.ajaxSearch(x.value,function(result){

			var trailer="";
			for(var i=0;i<result.length;i++) {
				trailer += "<div id='list'>"+
				"		<img id='img-search' src='" + result[i].imageurl +"' class='img-rounded'>"+
				"		<div id='detail'>"+
				"   	<p  id='moviename'>" + result[i].movieTitle +"</p>"+
				"    	<p>" + result[i].description + "</p>"+
				"    	</div>"+
				"	</div> ";	
			}
			document.getElementById('populate').innerHTML = trailer;
			$("#result-label").text("Search Result "+":- "+result.length+ " Result Found"); 

		//	window.location.replace("${contextpath}/search/?trailerList=result")
			
			 /* document.getElementById("populate").trailer = result; */
		});
		
	}
	
function homesearch(){
	var x= document.getElementById("w-input-search").value;
    window.location.replace('${contextpath}/movie-trailer/search/sear?searchString='+x);
}
	
</script>
</head>
<body style="background: url(${contextPath}/images/back2.jpg) no-repeat center center fixed; background-size: cover; 
background-color: rgb(30, 52, 67); height: 685px; 
background-repeat: no-repeat no-repeat;">

	<div class="navbar navbar-inverse" role="navigation" style="filter:alpha(opacity=50); 
  opacity:0.7;background-color:rgba(0, 0, 0, 0.388235); box-shadow:rgba(0, 0, 0, 0.701961) 0px 0px 5px 0px;">
      <div class="container">
        <div class="navbar-header">
          <label class="head">MOVIE TRAILER</label>
        </div>
        <div class="navbar-collapse collapse">
          <form class="navbar-form navbar-right" role="form" method="get" action="/">
            <!-- <div class="form-group">
              <input type="text" placeholder="Email" class="form-control">
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" class="form-control">
            </div> -->
            <!-- <button type="submit" class="btn btn-inverse">Sign Out</button> -->
            <a href="#" class="signout">Sign Out</a>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </div>
    
      <div class="search-bar">
        <div class="input-group">
          <input type="text" id="w-input-search" placeholder="Search" class="form-control" >
          <span class="input-group-btn">
	         <button class="btn btn-default" type="button" onclick="homesearch()">Go</button>
	      </span>
        </div>        
      </div>
      
      
      
      <div class="container" id="container" style="padding-bottom:4%;">
      	<label id="result-label" style="color:white;">Search Result ${extra}</label>
     			
     	        	<div id="populate">
     	        		<c:forEach var="trailer" items="${requestScope['trailerList']}">
     	        		<div id="list">
     	        	    			<a href="${contextPath}/info/getTrailer?trailerId=${trailer.id}"><img id="img-search" src="${trailer.imageurl }" class="img-rounded"></a>
     	        	    			<div id="detail">
     	        	      	     	<a href="${contextPath}/info/getTrailer?trailerId=${trailer.id}"><p id="moviename">${trailer.movieTitle}</p></a>
     	        	      	     	<p>${trailer.description}</p>
     	        	      	     	
     	        	      	     
     	        	      	     	</div>
     	        	      	     	
    	        		</div>          						
	           			</c:forEach> 
	           			
	           	        
	            	</div>  	
  	  <div>

      
      <br>


      <!-- Footer -->
     
<div class="navbar navbar-inverse navbar-fixed-bottom" style="filter:alpha(opacity=50); opacity:0.7; background-color:rgba(0, 0, 0, 0.388235); box-shadow:rgba(0, 0, 0, 0.701961) 0px 0px 5px 0px;">
     <p style="color:white; padding-top: 15px;text-align: center">
    &copy; Done by Samsung Research India Bangalore</p>
      
</div>

	</div>
   

</body>
</html>