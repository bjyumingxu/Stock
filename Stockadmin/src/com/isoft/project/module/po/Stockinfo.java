package com.isoft.project.module.po;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Stockinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "stockinfo")
public class Stockinfo implements java.io.Serializable {

	// Fields

	private Integer stockinfoId;
	private String symbol;
	private String name;
	
	private Long amount;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date ticktime;
	private Integer status;
	
//	private  List<Stockdata> stockdatas; 

	// Constructors

	/** default constructor */
	public Stockinfo() {
	}

	/** full constructor */

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "stockinfo_id", unique = true, nullable = false)
	public Integer getStockinfoId() {
		return this.stockinfoId;
	}

	public void setStockinfoId(Integer stockinfoId) {
		this.stockinfoId = stockinfoId;
	}

	
	@Column(name = "stockinfo_symbol")
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Column(name = "stockinfo_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "stockinfo_amount")
	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}
	@Column(name = "stockinfo_ticktime")
	public Date getTicktime() {
		return ticktime;
	}

	public void setTicktime(Date ticktime) {
		this.ticktime = ticktime;
	}
	
	
	@Column(name = "stockinfo_status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
	
	
	
	
}