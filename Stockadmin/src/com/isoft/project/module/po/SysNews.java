package com.isoft.project.module.po;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysNews entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_news", catalog = "stocktest1")
public class SysNews implements java.io.Serializable {

	// Fields

	private Integer newsId;
	private String newsTitle;
	private String newsContent;
	private Date newsTime;

	// Constructors

	/** default constructor */
	public SysNews() {
	}

	/** full constructor */
	public SysNews(String newsTitle, String newsContent, Date newsTime) {
		this.newsTitle = newsTitle;
		this.newsContent = newsContent;
		this.newsTime = newsTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "News_id", unique = true, nullable = false)
	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	@Column(name = "News_title")
	public String getNewsTitle() {
		return this.newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	@Column(name = "News_content")
	public String getNewsContent() {
		return this.newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	@Column(name = "News_time", length = 19)
	public Date getNewsTime() {
		return this.newsTime;
	}

	public void setNewsTime(Date newsTime) {
		this.newsTime = newsTime;
	}

}