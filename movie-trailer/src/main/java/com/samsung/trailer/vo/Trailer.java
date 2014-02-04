package com.samsung.trailer.vo;


public class Trailer extends BaseVO {

	public String movieTitle;
	String year;
	String rating;
	String description;
	String director;
	String duration;
	//String StarCast[];
	public String url;
	String imageurl;
	String searchString;
	
	
	 public String getSearchString() {
		return searchString;
	}


	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}


	public String getImageurl() {
		return imageurl;
	}


	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}


	public String getMovieTitle() {
		return movieTitle;
	}


	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	@Override
	   public String toString() {
	     return "MovieTrailer [id=" + id  + ", name=" + movieTitle + ", year=" + year +", rating="+rating+",description="+description+",director="+director+",duration="+duration+",URLlink="+url +"]";
	   }
    
}
