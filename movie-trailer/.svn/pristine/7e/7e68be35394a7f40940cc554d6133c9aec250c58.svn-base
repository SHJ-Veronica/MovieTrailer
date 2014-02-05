package com.samsung.trailer.dao.common;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.DbCallback;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;
import com.samsung.trailer.util.MongoSQLConfigurer;
import com.samsung.trailer.xsd.MongoSql;

public abstract class AbstractDAO<DTO> implements BaseDAO<DTO> {
	
	@Autowired    
	private MongoTemplate mongoTemplate; 
	
	private String COLLECTION_NAME;
	
	private static final Logger logger = LoggerFactory.getLogger(AbstractDAO.class);
	
	private Class<DTO> dto;
	
	private final char START_DELIMITER  = '(';
	private final char END_DELIMITER  = ')';
	
	public AbstractDAO(Class<DTO> dtoClass, String collectionName)
	{
		this.dto = dtoClass;
		this.COLLECTION_NAME = collectionName;
	}
	private void createCollection() {
		mongoTemplate.createCollection(COLLECTION_NAME);
	}
	public synchronized boolean insert(DTO object) {
		boolean status = false;
		if(!mongoTemplate.collectionExists(COLLECTION_NAME) ) {
			createCollection();
		}
		
		long count = mongoTemplate.executeCommand("{ 'count' : '" + COLLECTION_NAME + "'}" 
		            ).getLong( "n" );
		try {
			updatePrimaryKey(count+1,object);
			mongoTemplate.insert(object, COLLECTION_NAME);
			status = true;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return status;
	}
	/**
	 * Example: condition = {_id : 53}
	 * updateValue = {$set : { 'subject' : [1,2,3]  } }
	 */
	public boolean update(String statement, DTO target) {
		MongoSql.Update update = MongoSQLConfigurer.findUpdateSqlById(statement);
		WriteResult result = mongoTemplate.getCollection(COLLECTION_NAME).update(
				(BasicDBObject)JSON.parse(parameterMapping(update.getFindSql(),target)), 
				(BasicDBObject)JSON.parse(parameterMapping(update.getUpdateField(),target)),false,
				update.getMultiUpdate() == null ? false : Boolean.valueOf(update.getMultiUpdate()));
		logger.info("No. of Document updated=" + result.getN());
		return result.getN() > 0;
	}
	public boolean delete(String statement,DTO target) {
		MongoSql.Delete delete = MongoSQLConfigurer.findDeleteSqlById(statement);
		WriteResult result = mongoTemplate.getCollection(COLLECTION_NAME).remove(
				(BasicDBObject)JSON.parse(parameterMapping(delete.getFindSql(),target)));
		logger.info("No. of Document deleted=" + result.getN());
		return result.getN() > 0;
	}
	public List<DTO> listAll() {
		return mapFields(mongoTemplate.getCollection(COLLECTION_NAME).find());
	}
	private List<DTO> mapFields(DBCursor cursor) {
		
		List<DTO> dtoList = new ArrayList<DTO>();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			while(cursor.hasNext()) {
				dtoList.add(mapRow(cursor.next(),objectMapper));
/*				DTO object = objectMapper.readValue(JSON.serialize(record), dto);
				if(record.get("_id") != null) {
					updatePrimaryKey(Long.parseLong(record.get("_id").toString()),object);
				}
*/				
				//dtoList.add(object);
			}
		}catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return dtoList;
	}
	private DTO mapRow(DBObject row, ObjectMapper objectMapper) throws Exception {
		DTO object = objectMapper.readValue(JSON.serialize(row), dto);
		if(row.get("_id") != null) {
			updatePrimaryKey(Long.parseLong(row.get("_id").toString()),object);
		}
		return object;
	}
			
	public List<DTO> findByFilter(final String statement, final DTO target) {
		final MongoSql.Select select = MongoSQLConfigurer.findSelectSqlById(statement);
		return mongoTemplate.execute(
				new DbCallback<List<DTO>>() {
					public List<DTO> doInDB(DB db) throws MongoException, DataAccessException {
						DBCursor cursor = null;
						if(select.getFields() == null) {
							cursor = db.getCollection(COLLECTION_NAME).find((BasicDBObject)JSON.parse(parameterMapping(select.getFindSql(),target)));
						} else {
							cursor = db.getCollection(COLLECTION_NAME).find((BasicDBObject)JSON.parse(parameterMapping(select.getFindSql(),target)),
									(BasicDBObject)JSON.parse(select.getFields()));
						}
						if(select.getSort() != null) {
							cursor.sort((BasicDBObject)JSON.parse(select.getSort()));
						}
						if(select.getLimit() >0) {
							cursor.limit(select.getLimit());
						}
						if(select.getSkip() >0) {
							cursor.skip(select.getSkip());
						}
						return mapFields(cursor);
					}
				}
		);
	}
	/*
	 * String matchProj ="{"+
								"	$match : { '_id' : { '$gt' : 13} }"+
								"}, ";
		String disProj = 
				"{"+
				"	$project : { "+
				"		className: 1,"+
				"		id: '$_id',"+
				"		_id:0,"+
				"		subject : 1"+
				"	}"+
				"}";
	 */
	public List<DTO> aggregate(String statement, final DTO target) {
		final MongoSql.Aggregate aggregate = MongoSQLConfigurer.aggregateSqlById(statement);
		final List<DTO> aggregations = new ArrayList<DTO>();
		return mongoTemplate.execute(
				new DbCallback<List<DTO>>() {
					@Override
					public List<DTO> doInDB(DB db) throws MongoException, DataAccessException {
						ObjectMapper objectMapper = new ObjectMapper();
						List<BasicDBObject> dbObjectsList = new ArrayList<BasicDBObject>();
						
						for(int i=1;i<aggregate.getPiplineSql().size();i++) {
							dbObjectsList.add((BasicDBObject)JSON.parse(parameterMapping(aggregate.getPiplineSql().get(i),target)));
						}
						
						AggregationOutput aggregationOutput = db.getCollection(COLLECTION_NAME).aggregate(
								(BasicDBObject)JSON.parse(parameterMapping(aggregate.getPiplineSql().get(0),target)), 
								dbObjectsList.toArray(new BasicDBObject[dbObjectsList.size()]));
						Iterator<DBObject> iterator = aggregationOutput.results().iterator();
						while(iterator.hasNext()) {
							try {
								aggregations.add(mapRow(iterator.next(),objectMapper));
							} catch (Exception e) {
								logger.error(e.getMessage());
							}
						}
						return aggregations;
					}
				}
		);
	
	}
	private String parameterMapping(String findSql,Object target) {
		try {
			
			while(findSql.indexOf(START_DELIMITER)!=-1) {
				String xmlFieldName = findSql.substring(findSql.indexOf(START_DELIMITER)+1,findSql.indexOf(END_DELIMITER));
				String fieldName = Character.toUpperCase(xmlFieldName.charAt(0)) + xmlFieldName.substring(1);
				Object value = dto.getMethod("get" +fieldName).invoke(target);
				findSql = findSql.replaceAll("\\(" +xmlFieldName + "\\)" , 
						(value instanceof String) ? ("'" + String.valueOf(value) + "'") : String.valueOf(value));
			}
		} catch(Exception ex) {
			logger.error(ex.getMessage());
		}
		return findSql;
	}
	private void updatePrimaryKey(long id,Object target) throws Exception {
		dto.getMethod("setId", Long.class).invoke(target,id);
		
	}
}