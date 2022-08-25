package com.coeding.springmvc.vo;

public class News {

	private String title;
	private String article;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public News(String title, String article) {
		super();
		this.title = title;
		this.article = article;
	}
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}

}
