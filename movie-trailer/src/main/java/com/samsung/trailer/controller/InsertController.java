package com.samsung.trailer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.samsung.trailer.service.TrailerService;
import com.samsung.trailer.vo.Trailer;


@Controller
@RequestMapping(value = "/insert")
public class InsertController {

	@Autowired
	private TrailerService trailerService;
	

    WebDriver trailorDriver;
    WebElement nextPage;
	String movietitle;
	String year;
    String rating;
    String description;
    String director;
    String duration;
    String imageurl;
	
@RequestMapping(value="/data", method=RequestMethod.GET)
public String insertDatabase() throws Exception {		
		
	  		trailorDriver = new FirefoxDriver();
	  		trailorDriver
	  				.get("http://www.imdb.com/list/KnVCxQKcjjA/?start=1&view=detail&sort=listorian:asc");

	  		ArrayList<WebElement> eleList = (ArrayList<WebElement>) trailorDriver
	  				.findElements(By.className("list_item"));
	  		
	  			
	  		for (WebElement ele : eleList) 
	  		
	  		{
	  			
	  			imageurl=ele.findElement(By.tagName("img")).getAttribute("src");
	  			ArrayList<WebElement> infoList = (ArrayList<WebElement>) ele
	  					.findElements((By.tagName("div")));

	  			for (WebElement eleInfo : infoList) 
	  						{
	  				
	  			if (eleInfo.getAttribute("class").equalsIgnoreCase("info"))	
	  			
	  			   {
	  					
	  					movietitle = eleInfo.findElement(By.tagName("a")).getText();
	  					year=eleInfo.findElement(By.className("year_type")).getText();
	  					rating=eleInfo.findElement(By.className("value")).getText();
	  					description=eleInfo.findElement(By.className("item_description")).getText();
	  					director=eleInfo.findElement(By.className("secondary")).findElement(By.tagName("a")).getText();
	  					duration=eleInfo.findElement(By.className("item_description")).findElement(By.tagName("span")).getText();
	  			    }
	  				        
	  						}

	  				Trailer trailer = new Trailer();
	  				trailer.setDescription(description);
	  				trailer.setYear(year);
	  				trailer.setMovieTitle(movietitle);
	  				trailer.setRating(rating);
	  				trailer.setDirector(director);
	  				trailer.setDuration(duration);
	  				trailer.setUrl("");
	  				trailer.setImageurl(imageurl);
	  				trailerService.insert(trailer);
	  			
	  		}
	  		
	  		
	         
	  		System.out.println("Database Insert Done");
	  	
	
	
	
	
	
		return "show";
	}

@RequestMapping(value="/show1", method=RequestMethod.GET)
public String showMethod(Locale locale,Model model) throws Exception
{
	/*List<Trailer> b=trailerService.aggregate("agree3",null);
	model.addAttribute("b", b);*/
	return "new";
	
}
	
}
