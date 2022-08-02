package com.coeding.springmvc.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coeding.springmvc.vo.News;

/**
 * 스프링 4 이후로 @Controller 와 @ResponseBody 를 결합하여
 * @RestController 를 지원 
 * 모든 메서드에 @ResponseBody 가 적용
 * 
 * @author coedplay
 *
 */
@RestController
public class ApiController {

	@GetMapping("/api/v1")
	public News doGet() {
		
		return new News("Worldcup","good fight");
	}

	@PostMapping("/api/v2")
	public ResponseEntity<News> doPost(@RequestBody News news) {
		System.out.println(news.getTitle());
		System.out.println(news.getArticle());
		return new ResponseEntity<News>(new News("Worldcup","good fight"), HttpStatus.OK);
	}

}
