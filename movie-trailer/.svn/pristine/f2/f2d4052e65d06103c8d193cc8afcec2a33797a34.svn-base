package com.samsung.trailer.util;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.samsung.trailer.xsd.MongoSql;

public class MongoSQLConfigurer {
	
	private static final MongoSQLConfigurer MONGO_SQL_CONFIGURER = new MongoSQLConfigurer();
	private static MongoSql mongoSql;
	private MongoSQLConfigurer() {
		System.setProperty("DB.TRACE", "true");
		System.setProperty("DEBUG.MONGO", "true");
		
		JAXBContext jc;
		Unmarshaller u;
		try {
			jc = JAXBContext.newInstance("com.samsung.trailer.xsd");
			u = jc.createUnmarshaller();
			mongoSql = (MongoSql)u.unmarshal(Thread.currentThread().getContextClassLoader().
					getResourceAsStream("META-INF/mongo/mongo-sql.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private MongoSQLConfigurer getInstance() {
		return MONGO_SQL_CONFIGURER;
		
	}
	public static MongoSql.Select findSelectSqlById(String id) {
		MongoSql.Select select = null;
		List<MongoSql.Select> selectList =  mongoSql.getSelect();
		for(MongoSql.Select sqlSelect : selectList) {
			if(id.equals(sqlSelect.getId())) {
				select = sqlSelect;
				break;
			}
		}
		return select;
	}
	public static MongoSql.Update findUpdateSqlById(String id) {
		MongoSql.Update update = null;
		List<MongoSql.Update> updateList =  mongoSql.getUpdate();
		for(MongoSql.Update sqlUpdate : updateList) {
			if(id.equals(sqlUpdate.getId())) {
				update = sqlUpdate;
				break;
			}
		}
		return update;
	}
	public static MongoSql.Delete findDeleteSqlById(String id) {
		MongoSql.Delete delete = null;
		List<MongoSql.Delete> deleteList =  mongoSql.getDelete();
		for(MongoSql.Delete sqlDelete : deleteList) {
			if(id.equals(sqlDelete.getId())) {
				delete = sqlDelete;
				break;
			}
		}
		return delete;
	}
	public static MongoSql.Aggregate aggregateSqlById(String id) {
		MongoSql.Aggregate aggregate = null;
		List<MongoSql.Aggregate> aggregateList =  mongoSql.getAggregate();
		for(MongoSql.Aggregate sqlAggregate : aggregateList) {
			if(id.equals(sqlAggregate.getId())) {
				aggregate = sqlAggregate;
				break;
			}
		}
		return aggregate;
	}
	protected Object readResolve() {			
		return getInstance();		
	}
}