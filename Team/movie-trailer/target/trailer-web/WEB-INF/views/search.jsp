<jsp:directive.include file="/WEB-INF/views/common/common.jsp"/>
<html>
<head>
	<title>Search</title>
<script>
function search(obj)
{
	homeProxy.ajaxTest(obj,function(result){
		alert(result);
		
	});
	
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
	         <button class="btn btn-default" type="button" onclick="search(document.getElementById("w-input-search").getAttribute("data"))">Go!</button>
	      </span>
        </div>        
      </div>
      
      
      
      <div class="container" id="container" style="padding-bottom:4%;">
      	<label style="color:white;">Search Result</label>
     			
     	        	<div id="populate">
     	        		<c:forEach var="trailer" items="${requestScope['trailerList']}">
     	        		<div id="list">
     	        	    			<img id="img-search" src="${trailer.imageurl }" class="img-rounded">
     	        	    			<div id="detail">
     	        	      	     	<a  href="#">${trailer.movieTitle}</a>
     	        	      	     	<br>
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