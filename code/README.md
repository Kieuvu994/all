
# Spring WebMVC	based coding
> spring-04 까지의 설정 이후


# File upload

##@see WEB-INF/spring/appServlet/servlet-context.xml

> dependency : commons.fileupload with commons.io
<beans:bean id="multipartResolver" 
	class="org.springframework.web.multipart.commons.CommonsMultipartResolver">

CommonsMultipartResolver 는 commons.fileupload 의존 추가 필요하지만,

아래는 필요없음
<beans:bean id="multipartResolver" 
	class="org.springframework.web.multipart.support.StandardServletMultipartResolver">

단 @see WEB-INF/web.xml 
> DispatcherServlet 에 multipart-config 로 임시 저장 경로와 size 설정 필요

## Spring Multipart Filter 를 반드시 다른 Spring Filter 보다 먼저 설정해야 함 ( CSRF token 인식 문제 )
> @see web.xml
	<filter-class>org.springframework.web.multipart.support.MultipartFilter</filter-class>


# Rest File Upload
@see /src/main/resources/application.properties
> file upload 기준 경로 설정

@see .config.ApplicationProperty
> application.properties 에서 읽어들일 fileUploadpath field 추가
> @see WEB-INF/spring/appServlet/servlet-context.xml 에 Property Configuer 설정
- .properties file 을 read 하는 class

@see .service.FileStorageService
> ApplicationProperty.fileUploadpath 로 읽어온 경로에 file 저장

@see .exception.FileStorageException
> file 처리 중 예외

@see .restcontroller.FileRestController
> file up/download 를 위한 controller -> /api/file

@see .dto.UploadFileResponse
> api 응답


# client 에게 응답할 Response body 를 먼저 server 측에서 출력하거나 log 로 남기기
> HttpServletRequest 그대로 request.getReader 함수를 호출하거나 안에 있는 데이터는 한번만 읽을 수 있도록 톰캣에서 설정되어 있다.
> Response도 동일하게, 안에 있는 Body값을 한번만 읽을 수 있게 해두었기 때문에 Filter 로 다시 읽을 수 있는 클래스로 복사하지 않으면 사용자가 response값을 받지 못할 수 있다.

## @see com.coeding.sprigmvc.interceptor.WrapperFilter and web.xml
> Filter 는 설정 순서대로 동작하므로 최초 요청을 받아 최종(마지막)으로 응답을 거치기 위해 가장 먼저 설정되어야 한다.

## @see com.coeding.sprigmvc.interceptor.LoggerInterceptor
> 추가로 실행 중 logging 을 위한 interceptor 도 등록하여 비교한다.

## @see com.coeding.springmvc.advice.RestControllerAdvisor
> Advice 를 이용하여 Controller 실행 후 응답 전의 data 를 먼저 확인 할 수 있다.

