package com.isoft.project.module.po;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysBbs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_bbs", catalog = "stocktest1")
public class SysBbs implements java.io.Serializable {

	// Fields

	private Integer bbsId;
	private Integer bbsStockid;
	private Integer bbsUserid;
	private String bbsContent;
	private Date bbsTime;

	// Constructors

	/** default constructor */
	public SysBbs() {
	}

	/** full constructor */
	public SysBbs(Integer bbsStockid, Integer bbsUserid, String bbsContent,
			Date bbsTime) {
		this.bbsStockid = bbsStockid;
		this.bbsUserid = bbsUserid;
		this.bbsContent = bbsContent;
		this.bbsTime = bbsTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Bbs_id", unique = true, nullable = false)
	public Integer getBbsId() {
		return this.bbsId;
	}

	public void setBbsId(Integer bbsId) {
		this.bbsId = bbsId;
	}

	@Column(name = "Bbs_stockid")
	public Integer getBbsStockid() {
		return this.bbsStockid;
	}

	public void setBbsStockid(Integer bbsStockid) {
		this.bbsStockid = bbsStockid;
	}

	@Column(name = "Bbs_userid")
	public Integer getBbsUserid() {
		return this.bbsUserid;
	}

	public void setBbsUserid(Integer bbsUserid) {
		this.bbsUserid = bbsUserid;
	}

	@Column(name = "Bbs_content")
	public String getBbsContent() {
		return this.bbsContent;
	}

	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}

	@Column(name = "Bbs_time", length = 19)
	public Date getBbsTime() {
		return this.bbsTime;
	}

	public void setBbsTime(Date bbsTime) {
		this.bbsTime = bbsTime;
	}

}