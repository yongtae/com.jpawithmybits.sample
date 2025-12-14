# JPA, MyBatis와 동시 사용 셋팅 프로젝트 (DTO/엔티티 분리)
	etc
		....
	주요내용
	<<<<<<< HEAD
			[...] 테스트롤백 적용
			[...] dockerfile 적용
	=======
			[...] 테스트롤백 적용---
	>>>>>>> branch 'main' of https://github.com/yongtae/com.jpawithmybits.sample.git
		[완] 검증 api 생성, 참고파일: jpa+mybatis 동시 적용 확인.postman_collection.json 
		[완] github에 등록
		[완] 인메모리 hsqldb, hsqldb server 둘다 연결 가능 셋팅
		[완] jpa 설징 및 기반 query crud 적용
		[완] jpa기반 querydsl적용으로 조회
		[완] mybatis기반 query crud
		[완료] maven+lombock 추가(jpa 활용)
			참고자료
				https://baekh-93.tistory.com/59

	에러발생 목록
			- 에러내용
					ids for this class must be manually assigned before calling ...
				참고자료
					https://hangjastar.tistory.com/241

	참고파일
		- com.jpawithmybits.sample 프로젝트
		- jpawithmybits 패키지 전체
		- pom.xml

	참고자료
		- https://m.blog.naver.com/kim_jin_sol/221789017884
		https://jforj.tistory.com/91
		https://kimpaper.github.io/2015/10/05/spring-jpa-maven/
		https://herojoon-dev.tistory.com/135


# //////////////////////////////////////////
# //////////////////////////////////////////
# //////////////////////////////////////////
# //////////////////////////////////////////

# 표준프레임워크 심플홈페이지 BackEnd

## 환경 설정
java : 1.8
maven : 3.8.1

## BackEnd 구동

### CLI 구동 방법
> mvn spring-boot:run

### IDE 구동 방법
개발환경에서 프로젝트 우클릭 > Run As > Spring Boot App을 통해 구동한다.

## FrontEnd 구동 (React)

현재 FrontEnd는 React 관련 예제로 구성되어 있다.
[심플홈페이지FrontEnd](https://github.com/eGovFramework/egovframe-template-simple-react.git) 소스를 받아 구동한다.


## 변경 사항

###  1. [Java Config 변환](./Docs/JavaConfig_Convert.md)

#### 1) Web.xml -> WebApplicationInitializer 구현체로 변환 


#### 2) context-*.xml -> @Configuration 변환


#### 3) properties 변환(예정) boot 지원


### 2. API 변환
직접 View와 연결하던 방법에서 API 형식으로 변환 -> 다양한 프론트에서 적용 가능 하도록 예제 제공


