package com.hbspring.configuration;


import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.hbspring.model.Employee;
import com.mchange.v2.c3p0.DriverManagerDataSource;
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.hbspring")
public class WebConfig {
    @Bean
	public DriverManagerDataSource dbSource()
	{
		DriverManagerDataSource db=new DriverManagerDataSource();
		db.setDriverClass("com.mysql.jdbc.Driver");
		db.setJdbcUrl("jdbc:mysql://localhost/sakhadb1");
		db.setUser("harshitha");
		db.setPassword("harsh@123");
		return db;
	}
    @Bean
	public LocalSessionFactoryBean getSessionFactory()
	{
		LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
		sf.setDataSource(dbSource());
		Properties hbProperties=new Properties();
		hbProperties.put("hibernate.show_sql", true);
		hbProperties.put("hibernate.hbm2ddl.auto","update");
		hbProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		sf.setHibernateProperties(hbProperties);
		sf.setAnnotatedClasses(Employee.class);
		
		return sf;
		
	}
    @Bean
   public HibernateTransactionManager hbTrsansactionManager()
   {
	   HibernateTransactionManager hbt=new HibernateTransactionManager();
	   hbt.setSessionFactory(getSessionFactory().getObject());
	   return hbt;
   }
}
