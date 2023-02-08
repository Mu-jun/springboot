# 개발환경
- OS : Windows 10
- IDE : IntelliJ IDEA 2022.3.2 (Community Edition)

## start.spring.io
- java version : 11
- Build tool : Gradle - Groovy
- Packaging : jar
- Spring boot version : 2.7.8
- Dependencis
  - Spring Web

<br>

# 스프링 부트의 @Conditional
> 스프링 프레임워크의 @Profile도 @Conditional 애노테이션이다.

## Class Conditions
- @ConditionalOnClass
- @conditionalOnMissingClass  

지정한 클래스가 프로젝트내 존재를 확인해서 포함 여부를 결정한다.
> ```@Bean```메소드에도 적용 가능하지만,  
> 클래스 레벨의 검증 없이 ```@Bean```메소드에만 적용하면  
> 불필요하게 ```@Configuration```클래스가 빈으로 등록되기 때문에,  
> 클래스 레벨 사용을 우선해야 한다.

## Bean Conditions
- @ConditionalOnBean
- @ConditionalOnMissingBean  

빈의 존재 여부를 기준으로 포함여부를 결정한다.
> 커스톰 빈 구성 정보에 적용하는 건 피하는 것이 좋다.

## Property Conditions
- ```@ConditionalOnProperty```는 스프링의 환경 프로퍼티 정보를 이용한다.  
- 지정된 프로퍼티가 존재하고 값이 false가 아니면 포함 대상이 된다.  
- 프로퍼티의 존재를 확인해서 빈 오브젝트를 추가하고, 해당 빈 오브젝트에서 프로퍼티 값을 이용해서 세밀하게 빈 구성을 할 수도 있다.

## Resource Conditions
- ```@ConditionalOnResouce```는 지정된 리소스(파일)의 존재를 확인하는 조건이다.

## SpEL Expression Conditions
- ```@ConditionalOnExpression```은 스프링 SpEL(스프링 표현식)의 처리 결과를 기준으로 판단한다.
- 매우 상세한 조건 설정이 가능하다.

# 자동 구성 분석 방법
## JVM 옵션에 -Ddebug 또는 애플리케이션 인수에 --debug 추가
- 자동구성 클래스 Condition 결과 로그
- Condition을 통과한 정보와 실패한 정보들이 다 나온다. 

## ConditionEvaluationReport 코드로 확인
- 자동구성 클래스 Conditon 결과 빈
- 결과만 간단하게 나옴.

## ListableBeanFactory 코드로 확인
- 등록된 빈 확인

## 오픈소스 확인
### 자동 구성 클래스와 조건, 빈 확인
- @AutoConfiguration
- @Conditional
- Condition 클래스
- @Bean
### 프로퍼티 클래스와 바인딩
- Properties
- Bind
- Customizer
- Configurer

## SpringBoot Reference
- ***공식문서에서 관련 기술, 자동구성, 프로퍼티 확인***