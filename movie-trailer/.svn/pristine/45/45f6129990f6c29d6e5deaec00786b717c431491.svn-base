package com.samsung.trailer.dao.common;

import java.util.List;

public interface BaseDAO<DTO> {
	public boolean insert(DTO target);
	public boolean update(String statement, DTO target);
	public boolean delete(String statement, DTO target);
	public List<DTO> aggregate(String statement, DTO target);
	public List<DTO> listAll();
	public List<DTO> findByFilter(final String statement, DTO target);
	
}