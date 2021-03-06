package com.isoft.project.module.po;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Stockindex entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "stockindex")
public class Stockindex implements java.io.Serializable {

	// Fields

	private Integer stockindexId;
	private String name;
	private Long dealNum;
	private Long dealPri;
	private Double highPri;
	private Double lowpri;
	private Double nowpri;
	private Double openPri;
	private Double yesPri;
	private Double increPer;
	private Double increase;
	private Date time;

	// Constructors

	/** default constructor */
	public Stockindex() {
	}

	/** full constructor */
	public Stockindex(String name, Long dealNum, Long dealPri, Double highPri,
			Double lowpri, Double nowpri, Double openPri, Double yesPri,
			Double increPer, Double increase, Timestamp time) {
		this.name = name;
		this.dealNum = dealNum;
		this.dealPri = dealPri;
		this.highPri = highPri;
		this.lowpri = lowpri;
		this.nowpri = nowpri;
		this.openPri = openPri;
		this.yesPri = yesPri;
		this.increPer = increPer;
		this.increase = increase;
		this.time = time;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "stockindex_id", unique = true, nullable = false)
	public Integer getStockindexId() {
		return this.stockindexId;
	}

	public void setStockindexId(Integer stockindexId) {
		this.stockindexId = stockindexId;
	}

	@Column(name = "name", length = 64)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "dealNum")
	public Long getDealNum() {
		return this.dealNum;
	}

	public void setDealNum(Long dealNum) {
		this.dealNum = dealNum;
	}

	@Column(name = "dealPri")
	public Long getDealPri() {
		return this.dealPri;
	}

	public void setDealPri(Long dealPri) {
		this.dealPri = dealPri;
	}

	@Column(name = "highPri", precision = 22, scale = 0)
	public Double getHighPri() {
		return this.highPri;
	}

	public void setHighPri(Double highPri) {
		this.highPri = highPri;
	}

	@Column(name = "lowpri", precision = 22, scale = 0)
	public Double getLowpri() {
		return this.lowpri;
	}

	public void setLowpri(Double lowpri) {
		this.lowpri = lowpri;
	}

	@Column(name = "nowpri", precision = 22, scale = 0)
	public Double getNowpri() {
		return this.nowpri;
	}

	public void setNowpri(Double nowpri) {
		this.nowpri = nowpri;
	}

	@Column(name = "openPri", precision = 22, scale = 0)
	public Double getOpenPri() {
		return this.openPri;
	}

	public void setOpenPri(Double openPri) {
		this.openPri = openPri;
	}

	@Column(name = "yesPri", precision = 22, scale = 0)
	public Double getYesPri() {
		return this.yesPri;
	}

	public void setYesPri(Double yesPri) {
		this.yesPri = yesPri;
	}

	@Column(name = "increPer", precision = 22, scale = 0)
	public Double getIncrePer() {
		return this.increPer;
	}

	public void setIncrePer(Double increPer) {
		this.increPer = increPer;
	}

	@Column(name = "increase", precision = 22, scale = 0)
	public Double getIncrease() {
		return this.increase;
	}

	public void setIncrease(Double increase) {
		this.increase = increase;
	}

	@Column(name = "time", length = 19)
	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}