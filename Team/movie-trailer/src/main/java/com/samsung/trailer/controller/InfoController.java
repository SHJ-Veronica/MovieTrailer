package com.samsung.trailer.controller;

import java.util.ArrayList;
import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.samsung.trailer.service.TrailerService;
import com.samsung.trailer.vo.Trailer;



@Controller
@RequestMapping(value = "/info")
public class InfoController {
	

	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private TrailerService trailerService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String home(Model model) throws Exception {		
		List<Trailer> trailerList = trailerService.listAll();
		List<Trailer> acutalList = new ArrayList<Trailer>();
		while(acutalList.size()< 3) {
			int random = ((int)(Math.random() * 10) % trailerList.size()) ;
			
			if(acutalList.indexOf(trailerList.get(random))==-1) {
				acutalList.add(trailerList.get(random));	
			
			}	
		}
		List<Trailer> trailerList1 = trailerService.findByFilter("select1", null);
		Trailer defaultTrailerInfo= trailerList1.get(((int)(Math.random() * 100) % 30));
		System.out.println(defaultTrailerInfo.id);
		
		model.addAttribute("defaultTrailerInfo",defaultTrailerInfo );
		model.addAttribute("trailerList", acutalList);
		return "trailer-info";
	}
	

	@RequestMapping(value="/getTrailer", method=RequestMethod.GET)
	public String getTrailer(@RequestParam("trailerId") long id,Model model) throws Exception{
		List<Trailer> trailerList = trailerService.listAll();
		List<Trailer> acutalList = new ArrayList<Trailer>();
		while(acutalList.size()< 5) {
			int random = ((int)(Math.random() * 10) % trailerList.size()) ;
			
			if(acutalList.indexOf(trailerList.get(random))==-1) {
				acutalList.add(trailerList.get(random));	
				
			}
			
		}
		/*end of while*/
		
		Trailer defaultTrailerInfo=new Trailer();
		defaultTrailerInfo.setId(id);
		List<Trailer> trailer=trailerService.findByFilter("select2",defaultTrailerInfo);
		trailerService.update("incview",defaultTrailerInfo);
		System.out.println(trailer.get(0).movieTitle+"get TRaile Method");
		model.addAttribute("defaultTrailerInfo",trailer.get(0));
		model.addAttribute("trailerList", acutalList);
		return "trailer-info";
	}
	
	
	
}
