/*package com.samsung.trailer.controller;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;




@Component
public class TrailerJob {
	
	
	@Autowired
	private MongoTemplate mongoTemplate;

	WebDriver trailorDriver;
	WebElement nextPage;
	String serialnumber;
	String movietitle;
	String year;
    String rating;
    String description;
    String director;
    String duration;
	public TrailerJob() {

		
	}

	*//**
	 * following Extractor sub routine is strictly for the current state of IMDB web page. May need to
	 * alter if there are changes in the field element attributes.
	 *//*	MongoOperations mongoOperation = (MongoOperations)mongoTemplate;	
	public void extractInfo() {
		
		
		trailorDriver = new FirefoxDriver();
		trailorDriver
				.get("http://www.imdb.com/list/KnVCxQKcjjA/?start=1&view=detail&sort=listorian:asc");

		ArrayList<WebElement> eleList = (ArrayList<WebElement>) trailorDriver
				.findElements(By.className("list_item"));
		
			
		for (WebElement ele : eleList) {
			
			ArrayList<WebElement> infoList = (ArrayList<WebElement>) ele
					.findElements((By.tagName("div")));

			for (WebElement eleInfo : infoList) 
						{
				
				if(eleInfo.getAttribute("class").equalsIgnoreCase("number"))
				{
					serialnumber=eleInfo.getText();   //First Variable		
				}
					
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

				Trailer trailer = new Trailer(serialnumber, movietitle, year, rating,description,director,duration,null);
			
			
		}
		
		mongoOperation.updateMulti(  
				  new Query(Criteria.where("_id").is("1.")),  
				  Update.update("URLlink", "//www.youtube.com/embed/UFuFFdK7i44?feature=player_detailpage"), Trailer.class); 
		
		mongoOperation.updateMulti(  
				  new Query(Criteria.where("_id").is("2.")),  
				  Update.update("URLlink", "//www.youtube.com/embed/h2tY82z3xXU?feature=player_detailpage"), Trailer.class); 
		
		mongoOperation.updateMulti(  
				  new Query(Criteria.where("_id").is("3.")),  
				  Update.update("URLlink", "www.youtube.com/embed/DcsirofJrlM?feature=player_detailpage"), Trailer.class); 

		mongoOperation.updateMulti(  
				  new Query(Criteria.where("_id").is("4.")),  
				  Update.update("URLlink", "www.youtube.com/embed/8hP9D6kZseM?feature=player_detailpage"), Trailer.class); 
		
		mongoOperation.updateMulti(  
				  new Query(Criteria.where("_id").is("5.")),  
				  Update.update("URLlink", "www.youtube.com/embed/5iaYLCiq5RM?feature=player_detailpage"), Trailer.class); 
		
		mongoOperation.updateMulti(  
				  new Query(Criteria.where("_id").is("6.")),  
				  Update.update("URLlink", "www.youtube.com/embed/9ecW-d-CBPc?feature=player_detailpage"), Trailer.class); 
		
		mongoOperation.updateMulti(  
				  new Query(Criteria.where("_id").is("7.")),  
				  Update.update("URLlink", "www.youtube.com/embed/i0xO64icGSY?feature=player_detailpage"), Trailer.class); 

		mongoOperation.updateMulti(  
				  new Query(Criteria.where("_id").is("8.")),  
				  Update.update("URLlink", "www.youtube.com/embed/o4gHCmTQDVI?feature=player_detailpage"), Trailer.class);
		
		mongoOperation.updateMulti(  
				  new Query(Criteria.where("_id").is("9.")),  
				  Update.update("URLlink", "www.youtube.com/embed/5SoKPVAERgI?feature=player_detailpage"), Trailer.class);
		
		mongoOperation.updateMulti(  
				  new Query(Criteria.where("_id").is("10.")),  
				  Update.update("URLlink", "www.youtube.com/embed/yQ5U8suTUw0?feature=player_detailpage"), Trailer.class);
		
		mongoOperation.updateMulti(  
				  new Query(Criteria.where("_id").is("11.")),  
				  Update.update("URLlink", "www.youtube.com/embed/UoDKXozA0M4?feature=player_detailpage"), Trailer.class);		
		
		
		Query query2 = new Query();
		query2.addCriteria(Criteria.where("_id").is("1."));
		 
		Trailer userTest2 = mongoOperation.findOne(query2, Trailer.class);
		String abc=userTest2.URLlink;
		System.out.println("query2 - " + query2.toString());
		System.out.println("userTest2 - " + userTest2+abc);
		
		//navigatePage();
       
		System.out.println("Database Insert Done");
	}

	

	*//**
	 * Pagination support
	 *//*
	public void navigatePage() {
		try {
			nextPage = trailorDriver.findElement(By.linkText("Next �"));
		} catch (Exception ex) {
			trailorDriver.close();
			trailorDriver.quit();
		}
		if (nextPage != null) {
			nextPage.click();
			extractInfo();
		}
	}
	
	*//**
	 * Trigger the job
	 * @param args
	 *//*
	public static void main(String[] args) {
		new TrailerJob().extractInfo();

	}

	
	
}
*/