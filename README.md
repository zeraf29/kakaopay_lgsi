# kakaopay_lgsi
Kakaopay Local Goverment Support Information

김진협(zeraf29@gmail.com) 
<지자체 협약 지원 API 개발>
========================================

1. 개발환경
   1. Java8
   2. Spring Boot
   3. JPA(Hibernate)
   4. H2 Database (인메모리)
   5. Spring Boot App
2. 과제 Github 주소: https://github.com/zeraf29/kakaopay_lgsi
3. 문제해결전략
   1. 최대한 기본 CURD를 통해 데이터 처리, H2 지원 제약에 따른 정렬 이슈는 Java 정렬로 해결
   2. 지자체 지원정보 엔티티와 지원 지자체 엔티티를 분리하여 상호 FK 처리 되도록 개발
   3. 지원한도 및 이차보전은 특정 문자열을 치환/분해 하여 숫자 변환 후 값 비교 처리
4. 빌드 및 실행 방법
   1. IDE(이클립스)에 import 후 Sping-Boot 기본 Web서비스로 구동(Spring Boot App)
   2. 또는 mvn package로 파일 패키징 및 war 파일 WAS 기동(mvn spring-boot:run )
   3. Postman 또는 브라우저 개발 툴을 통해 기능 확인
5. API Url
   1. http://localhost:8080/api/insert/csv/local : [GET] 로컬 static 경로상의 CSV를 DB로 insert(src/main/resources/static)
   2. http://127.0.0.1:8080/api/get/all : [GET] 전체 지원정보 데이터 조회
   3. http://127.0.0.1:8080/api/get/target/{지자체명} : [GET] 특정 지자체의 지원정보 출력 
   4. http://127.0.0.1:8080/api/get/limit/{제약수} : [GET] 지원금액 내림차순>이차보전 평균비율 적은 순서 출력, 제약수 만큼 지자체명 출력
   5. http://127.0.0.1:8080/api/get/rate : [GET] 이차보전 컬럼에서 보전 비율이 가장 작은 추천 기관명 출력
   6. http://127.0.0.1:8080/api/update/record : [POST] 지자체 지원정보 수정. 지자체 지원정보의 각 항목이 필수 포함 되어 있어야 함. 
   
6. 비고
   1. 미구현 사항
      1. 특정기사 분석 
         1.특정 단어 치환 또는 NLP를 통한 분석 처리 시도 --> 향후 재시도 예정
      2.JWT 처리
         1. Spring Boot Security로 구현 중 중단 --> 향후 재시도 예정
         
감사합니다. 
   
