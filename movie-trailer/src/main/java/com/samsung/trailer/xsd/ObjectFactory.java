//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.01.27 at 11:10:43 AM IST 
//


package com.samsung.trailer.xsd;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.samsung.trailer.xsd package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.samsung.trailer.xsd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MongoSql }
     * 
     */
    public MongoSql createMongoSql() {
        return new MongoSql();
    }

    /**
     * Create an instance of {@link MongoSql.Select }
     * 
     */
    public MongoSql.Select createMongoSqlSelect() {
        return new MongoSql.Select();
    }

    /**
     * Create an instance of {@link MongoSql.Update }
     * 
     */
    public MongoSql.Update createMongoSqlUpdate() {
        return new MongoSql.Update();
    }

    /**
     * Create an instance of {@link MongoSql.Delete }
     * 
     */
    public MongoSql.Delete createMongoSqlDelete() {
        return new MongoSql.Delete();
    }

    /**
     * Create an instance of {@link MongoSql.Aggregate }
     * 
     */
    public MongoSql.Aggregate createMongoSqlAggregate() {
        return new MongoSql.Aggregate();
    }

}
