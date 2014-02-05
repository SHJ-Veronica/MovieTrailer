package com.samsung.trailer.controller;

import java.util.ArrayList;
import java.util.List;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.samsung.trailer.service.TrailerService;
import com.samsung.trailer.vo.Trailer;

@RemoteProxy(name="homeProxy")
@Component
public class ProxyExample {
	
	@Autowired
	private TrailerService trailerService;
	
	private static final Logger logger = LoggerFactory.getLogger(ProxyExample.class);
	@RemoteMethod
public String ajaxTest(String id) throws Exception {
		logger.info(id);
		return id;
	}
	
	@RemoteMethod
	public String giveDetails(long id) throws Exception {
		
		Trailer trailer = new Trailer();
		trailer.setId(id);
		List<Trailer> a=trailerService.findByFilter("select2", trailer);	
		return a.get(0).movieTitle;
	}
	
	@RemoteMethod
public List<Trailer> ajaxSearch(String search) throws Exception {
		
		Trailer trailer=new Trailer();
		List<Trailer> searchList = new ArrayList<Trailer>();
		trailer.setMovieTitle(search+".*");
		logger.info(trailer.movieTitle);
		/*trailer.setDescription(search);*/
		searchList=trailerService.findByFilter("search",trailer);
		//System.out.println(searchList);
		return searchList;
	}
	
}