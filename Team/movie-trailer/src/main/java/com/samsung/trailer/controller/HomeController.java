package com.samsung.trailer.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.samsung.trailer.service.TrailerService;
import com.samsung.trailer.vo.Trailer;



@Controller
@RequestMapping(value = "/home")
public class HomeController {
	

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private TrailerService trailerService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String home(Model model) throws Exception {		
		List<Trailer> trailerList = trailerService.listAll();
		List<Trailer> acutalList = new ArrayList<Trailer>();
		while(acutalList.size()< 3) {
			int random = ((int)(Math.random() * 100) % trailerList.size()) ;
			//System.out.println(random);
			if(acutalList.indexOf(trailerList.get(random))==-1) {
				acutalList.add(trailerList.get(random));	
				//System.out.println(trailerList.get(random).id);
			}	
		}
		int random1=(int)(Math.random()*10);
		Trailer defaultTrailerInfo= trailerList.get(random1);
		System.out.println(defaultTrailerInfo.id);	
		model.addAttribute("defaultTrailerInfo",defaultTrailerInfo );
		model.addAttribute("trailerList", acutalList);
		
		
		
		
		
		// most viewed movie trailers complete
		List<Trailer> mostViewedTrailerList = trailerService.findByFilter("viewsort", null);
		List<Trailer> acutalListMostViewed = new ArrayList<Trailer>();
		for(int i=0;i<10;i++){
			acutalListMostViewed.add(mostViewedTrailerList.get(i));
		}
	model.addAttribute("mostViewedTrailerList", acutalListMostViewed);
		
		
		
		
		
		
		
		
		
		

	
	List<Trailer> recentlyAddedTrailerList = trailerService.listAll();
	List<Trailer> acutalListRecentlyViewed = new ArrayList<Trailer>();
	while(acutalListRecentlyViewed.size()< 3) {
		int random = ((int)(Math.random() * 100) % recentlyAddedTrailerList.size()) ;
		if(acutalListRecentlyViewed .indexOf(recentlyAddedTrailerList.get(random))==-1) {
			acutalListRecentlyViewed .add(recentlyAddedTrailerList.get(random));	
		}	
	}
	model.addAttribute("recentlyAddedTrailerList", acutalListRecentlyViewed);
		return "home";
	}
	
	@RequestMapping(value="/try", method=RequestMethod.GET)
	public String trial(Model model) throws Exception{
/*		List<Trailer> ar = trailerService.findByFilter("search",null);
		System.out.println(ar);*/
		return "boot";
	}
	
	
	

}
