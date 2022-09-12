# Springfy

## Before Deploy

1. 배포시 application.yml에 ddl-auto 속성을 create나 update로 설정하면 안된다.(nest.js의 typeorm synchronized와 같은 기능)

## Learned - General

1. Entity Class에는 Setter 메소드를 만들지 않는다. 필요시에 의도를 나타내는 메소드를 따로 만든다.
2. Repository 패턴을 사용하기 위한 DB Layer 접근자를 Dao라고 부르기도 한다.
3. JpaRepository를 extends하면 기본적인 CRUD 메소드가 자동으로 생성된다.(Repository 데코레이터를 사용할 필요도 없다. 단 Entity 클래스와 기본 Entity Repository는
   함께 위치해야 한다.)
4. Date가 아닌 LocalDateTime을 사용하는 것이 좋다. Date는 deprecated 되었고 Month 설계, Immutability 보장 X(멀티스레드에서 문제발생) 등의 이유로
   LocalDateTime을 사용하는 것이 좋다. + Hibernate 5.2.10 버전 이상을 사용해야한다
5. Model -> 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장
6. application-xxx.yml 로 만들면 xxx라는 이름의 profile을 사용할 수 있다. application.yml에서 spring.profiles.include=xxx하면 설정값을 사용할 수 있다

## Learned - JPA Auditing

1. MappedSuperclass -> JPA Entity 클래스들이 abstract class를 상속할 경우 필드들의 칼럼도 인식하도록 만듬
2. EntityListeners(AuditingEntityListener.class) -> Entity에 Auditing 기능을 포함시킴
3. Auditing 기능은 Entity에서 자동으로 값을 넣어주는 기능이다. (ex. createdDate, modifiedDate)

## Learned - Spring Security

1. Spring Security는 권한 코드에 항상 ROLE_이 앞에 있어야 한다. (ex. ROLE_ADMIN, ROLE_USER)

## Learned - Tip

1. Entity 클래스를 직접 사용하는 것은 추후 JOIN을 염두했을때 좋지 않다. 필요한 정보만 따로 직렬화 기능을 가진 Dto로 빼서 사용하자

## Learned - TestCode

1. 별다른 설정 없이 @SpringBootTest 데코레이터를 사용하면 H2 데이터베이스를 자동으로 연결해준다
2. @WebMvcTest는 JPA 기능이 작동하지 않는다 -> @SpringBootTest와 TestRestTemplate 사용해야 한다.
