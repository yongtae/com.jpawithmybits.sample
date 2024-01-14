package egovframework.com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import jpawithmybatis.jpasrc.JpaConfigAppDatasource;

@Configuration
@Import({
	EgovConfigAppAspect.class,
	EgovConfigAppCommon.class,
	EgovConfigAppDatasource.class,
	EgovConfigAppIdGen.class,
	EgovConfigAppProperties.class,
	EgovConfigAppMapper.class,
	EgovConfigAppTransaction.class,
	EgovConfigAppValidator.class,
	EgovConfigAppWhitelist.class
	,JpaConfigAppDatasource.class // jpa 설정
})
public class EgovConfigApp {

}
