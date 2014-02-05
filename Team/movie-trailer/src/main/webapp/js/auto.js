/**
 * 
 */
 $(document).ready(function() {
 
	$('#w-input-search').autocomplete({
		serviceUrl: 'http://localhost:8081/movie-trailer/search/getTags',
		paramName: "tagName",
		delimiter: ",",
	   transformResult: function(response) {
 
		return {      	
		  //must convert json to javascript object before process
		  suggestions: $.map($.parseJSON(response), function(item) {
 
		      return { value: item.movieTitle};
		   })
 
		 };
 
            }
 
	 });
 
  });