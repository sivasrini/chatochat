package chatochatbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import chatochatbackend.dao.RegisterDAOImple;
import chatochatbackend.dao.RegisterDAOInter;
import chatochatbackend.model.Register;

@Configuration
@EnableTransactionManagement
public class Config {
	
	
	
	@Bean(name="datasource")
	public DataSource getOracleDataSource()
	{
		
		BasicDataSource datasource=new BasicDataSource();
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		datasource.setUsername("siva");
		datasource.setPassword("siva");
		
		return datasource;
		
	}
	
	
	@Autowired
    @Bean(name ="sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    sessionBuilder.addProperties(getHibernateProperties());
    sessionBuilder.addAnnotatedClasses(Register.class);
 
    System.out.println("this is session");
   
      return sessionBuilder.buildSessionFactory();
    }

	
	public Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		
		properties.setProperty("hibernate.hbm2ddl.auto", "create");
		System.out.println("this is hibernate");
		return properties;
		
	}
	
	@Autowired
	@Bean(name="transactionmanager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		
		HibernateTransactionManager transactionmanager=new HibernateTransactionManager (sessionFactory);
		
		System.out.println("this is transactio manager");
		return transactionmanager;
		
		
	}
	
	@Autowired
	@Bean(name="registerdaoimple")
	public RegisterDAOInter getRegisterDAOImple(SessionFactory sessionFactory)
	{
	 return new RegisterDAOImple();
	}

}
