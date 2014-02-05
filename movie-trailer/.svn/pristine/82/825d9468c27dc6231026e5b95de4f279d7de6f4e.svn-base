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
import org.springframework.web.bind.annotation.ResponseBody;

import com.samsung.trailer.service.TrailerService;
import com.samsung.trailer.vo.Trailer;



@Controller
@RequestMapping(value = "/search")
public class SearchController {
	

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private TrailerService trailerService;
	List<Trailer> trailerList1= new ArrayList<Trailer>();

	
	public void giveList(List<Trailer> abc)
	   {
		  trailerList1=abc;
	   }
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getTrailer(Model model) throws Exception{
	
		List<Trailer> trailerList = trailerService.listAll();
        model.addAttribute("trailerList", trailerList);
        trailerList1 = trailerService.findByFilter("select1", null);
        giveList(trailerList1);

		
		return "search";
	}/*
	*/
	
	
	@RequestMapping(value="/sear", method=RequestMethod.GET)
	public String getTrailer1(@RequestParam("searchString") String search,Model model) throws Exception{
	
		/*List<Trailer> trailerList = trailerService.listAll();
        model.addAttribute("trailerList", trailerList);*/
		logger.info(search+"hello world");
        trailerList1 = trailerService.findByFilter("select1", null);
        giveList(trailerList1);
        Trailer trailer=new Trailer();
		List<Trailer> searchList = new ArrayList<Trailer>();
		trailer.setMovieTitle(search+".*");
		searchList=trailerService.findByFilter("search",trailer);
		int x=searchList.size();
		 model.addAttribute("trailerList", searchList);
		 model.addAttribute("extra", ":- "+x+" Result Found");

		
		return "search";
	}
	
	@RequestMapping(value = "/getTags", method = RequestMethod.GET)
	public @ResponseBody
	List<Trailer> getTags(@RequestParam String tagName) {
		return simulateSearchResult(tagName);

	}

	private List<Trailer> simulateSearchResult(String tagName) {

		List<Trailer> result = new ArrayList<Trailer>();

		
		// iterate a list and filter by tagName
		for (Trailer tag : trailerList1) {
			if (tag.getMovieTitle().contains(tagName)) {
				result.add(tag);
			}
		}

		return result;
	}
	
}
