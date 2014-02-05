package com.samsung.trailer.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.samsung.trailer.dao.TrailerDAO;
import com.samsung.trailer.dao.common.AbstractDAO;
import com.samsung.trailer.util.TrailerConstants;
import com.samsung.trailer.vo.Trailer;

@Repository
public class TrailerDAOImpl extends AbstractDAO<Trailer> implements TrailerDAO {
	
	private static final Logger log = Logger.getLogger(TrailerDAOImpl.class);
	
	public TrailerDAOImpl() {
		super(Trailer.class,TrailerConstants.TRAILER_COLLECTION);
	}
}