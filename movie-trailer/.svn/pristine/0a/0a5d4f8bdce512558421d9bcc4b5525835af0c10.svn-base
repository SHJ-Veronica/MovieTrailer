package com.samsung.trailer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsung.trailer.dao.TrailerDAO;
import com.samsung.trailer.service.TrailerService;
import com.samsung.trailer.vo.Trailer;

@Service
public class TrailerServiceImpl implements TrailerService {
	
	@Autowired
	private TrailerDAO trailerDAO;
	
	public boolean insert(Trailer trailer) throws Exception {
		return trailerDAO.insert(trailer);		
	}
	
	public List<Trailer> listAll() throws Exception{
		return trailerDAO.listAll();
	}
	
	public List<Trailer> findByFilter(final String statement, Trailer target){
		return trailerDAO.findByFilter(statement, target);
	}
    
	public List<Trailer> aggregate(String statement, Trailer target){
		return trailerDAO.aggregate(statement, target);
	}
	
	public boolean update(String statement, Trailer target){
		return trailerDAO.update(statement, target);
	}
	public boolean delete(String statement, Trailer target){
		return trailerDAO.delete(statement, target);
	}
}