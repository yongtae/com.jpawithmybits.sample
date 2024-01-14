package jpawithmybatis.jpasrc;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;



@Configuration
@PropertySources({
	@PropertySource("classpath:/egovframework/egovProps/globals.properties")
}) //CAUTION: min JDK 8
@EnableJpaRepositories(
	    basePackages="jpawithmybatis.jpasrc",  //repository를 관리할 패키지 명시
	    entityManagerFactoryRef = "entityManagerFactory", //EntityManagerFactory
	    transactionManagerRef = "transactionManager") // transactionManager
public class JpaConfigAppDatasource {
	
	@Autowired
	Environment env;

	private String dbType;

	private String className;

	private String url;

	private String userName;

	private String password;

	@PostConstruct
	void init() {
		dbType = env.getProperty("Globals.DbType");
		//Exception 처리 필요
		className = env.getProperty("Globals." + dbType + ".DriverClassName");
		url = env.getProperty("Globals." + dbType + ".Url");
		userName = env.getProperty("Globals." + dbType + ".UserName");
		password = env.getProperty("Globals." + dbType + ".Password");
	}
	
	/**
	 * @return [dataSource 설정] HSQL 설정
	 */
	private DataSource dataSourceHSQL() {
		return new EmbeddedDatabaseBuilder()
			.setType(EmbeddedDatabaseType.HSQL)
			.setScriptEncoding("UTF8")
//			.addScript("classpath:/db/shtdb.sql")
			//			.addScript("classpath:/otherpath/other.sql")
			.build();
	}
	
	private DataSource basicDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(className);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(userName);
		basicDataSource.setPassword(password);
		return basicDataSource;
	}
	
	/**
	 * @return [DataSource 설정]
	 */
	@Bean(name = {"dataSourceJpa"})
	@Primary //해당 Bean을 우선적으로 선택하도록 하는 annotation
	public DataSource dataSource() {
//		return dataSourceHSQL();
		return basicDataSource();
	}

	private static final String DEFAULT_NAMING_STRATEGY
	= "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy";

//	jpa 엔티티 관련 셋팅
	@Bean(name = "entityManagerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
	    EntityManagerFactoryBuilder builder) {
	
	  Map<String, String> propertiesHashMap = new HashMap<>();
	  propertiesHashMap.put("hibernate.physical_naming_strategy",DEFAULT_NAMING_STRATEGY);
	  propertiesHashMap.put("hibernate.show_sql","true");
	  propertiesHashMap.put("hibernate.hbm2ddl.auto", "create"); // 엔터티 생성 셋팅
	  
	  LocalContainerEntityManagerFactoryBean rep =
	  builder.dataSource(dataSource())
	    .packages("jpawithmybatis.jpasrc")
        //domain을 관리할 패키지 경로 명시 (domain = DO 파일)
	    .properties(propertiesHashMap)
	    .build();
	 
	  return rep;
	}
	
	@Primary
	@Bean(name = "transactionManager")
	PlatformTransactionManager transactionManager(
	    EntityManagerFactoryBuilder builder) {
	  return new JpaTransactionManager(entityManagerFactory(builder).getObject());
	}
}
