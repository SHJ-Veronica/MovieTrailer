package com.samsung.trailer.service;

import java.util.List;

import com.samsung.trailer.vo.Trailer;

public interface TrailerService {
	
	public boolean insert(Trailer trailer) throws Exception;
	public List<Trailer> listAll() throws Exception;
	public List<Trailer> findByFilter(final String statement, Trailer target);
	public List<Trailer> aggregate(String statement, Trailer target);
	public boolean update(String statement, Trailer target);
	public boolean delete(String statement, Trailer target);

}