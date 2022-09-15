package com.coeding.springmvc.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * @ControllerAdvice 설정
 * 	-	RestController 인 경우 @RestControllerAdvice 추가
 * ResponseBodyAdvice를 구현
 *  -	supports 와 beforeBodyWrite 을 overriding
 */
@ControllerAdvice
@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvisor<T> implements ResponseBodyAdvice<T> {
	protected Logger log = LoggerFactory.getLogger(RestControllerAdvisor.class);

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		//	supports 에서 현재 Controller 작업이 끝난 response 를 beforeBodyWrite 로 보낼 것인지 판단
		//	request 가 어느 Controller 에서 왔는지 확인
		Class<?> clazz = returnType.getExecutable().getDeclaringClass();
		return true;
	}

	@Override
	public T beforeBodyWrite(T body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		//	supports 에서 확인 후 beforeBodyWrite 에서는 원하는 작업을 하도록 하는 수행 후 body 반환
		//	Controller 끝난 뒤 반환된 body data 를 json이나 xml 등의 기타 형식으로 HttpMessageConverter 거쳐 변환하기 직전에 호출
		if (log.isDebugEnabled()) {
			try {
				ObjectMapper mapper = new ObjectMapper();
				// Converting the Object to JSONString
				String jsonString;
				jsonString = mapper.writeValueAsString(body);
				log.debug("{}", jsonString);
			} catch (JsonProcessingException e) {
				log.debug("{}", e.getMessage());
			}
		}
		
		//	body data 를 추가/변경/삭제 등의 작업을 진행한 후 반환하면 HttpMessageConverter 가 변환 후 client 에게 최종 응답
		return body;
	}
}
