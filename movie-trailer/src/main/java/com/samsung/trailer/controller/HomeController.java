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
		/*coming soon*/
		List<Trailer> trailerList = trailerService.listAll();
		List<Trailer> acutalList = new ArrayList<Trailer>();
		while(acutalList.size()< 6) {
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
		model.addAttribute("comingSoonTrailerList", acutalList);
		
		/*most viewed*/
		List<Trailer> mostViewedTrailerList = trailerService.findByFilter("findmostviewed",null);
		List<Trailer> acutalListMostViewed = new ArrayList<Trailer>();
		while(acutalListMostViewed.size()< 6) {
			int random = ((int)(Math.random() * 100) % mostViewedTrailerList.size()) ;
			if(acutalListMostViewed.indexOf(mostViewedTrailerList.get(random))==-1) {
				acutalListMostViewed.add(mostViewedTrailerList.get(random));	
			}	
		}
	model.addAttribute("mostViewedTrailerList", acutalListMostViewed);
		
	/*recently added*/
	List<Trailer> recentlyAddedTrailerList = trailerService.listAll();
	List<Trailer> acutalListRecentlyViewed = new ArrayList<Trailer>();
	while(acutalListRecentlyViewed.size()<6) {
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
