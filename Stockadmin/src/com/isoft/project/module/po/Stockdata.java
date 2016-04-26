package com.isoft.project.module.po;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import net.sf.json.JSONArray;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isoft.stock.stockutils.JuheDataToBean;
import com.isoft.stock.stockutils.JuheStockData;

@Entity
@Table(name = "stockdata")
public class Stockdata implements java.io.Serializable {

	private Integer stockdataId;

	private String gid;// sh601009 , /*股票编号*/
	private Double increPer;// 9.91 , /*涨跌百分比*/
	private Double increase;// 43.99 , /*涨跌额*/
	private String name;// 南京银行 , /*股票名称*/
	private Double todayStartPri;// 8.26 , /*今日开盘价*/
	private Double yestodEndPri;// 8.26 , /*昨日收盘价*/
	private Double nowPri;// 8.37 , /*当前价格*/
	private Double todayMax;// 8.55 , /*今日最高价*/
	private Double todayMin;// 8.25 , /*今日最低价*/
	private Double competitivePri;// 8.37 , /*竞买价*/
	private Double reservePri;// 8.38 , /*竞卖价*/
	private Long traNumber;// 34501453 , /*成交量*/
	private Long traAmount;// 290889560 , /*成交金额*/
	private Long buyOne;// 10870 , /*买一*/
	private Double buyOnePri;// 8.37 , /*买一报价*/
	private Long buyTwo;// 177241 , /*买二*/
	private Double buyTwoPri;// 8.36 , /*买二报价*/
	private Long sellOne;// 47556 , /*卖一*/
	private Double sellOnePri;// 8.38 , /*卖一报价*/
	private Long sellTwo;// 103057 , /*卖二*/
	private Double sellTwoPri;// 8.39 , /*卖二报价*/

	@JsonFormat(pattern="yyyy-mmmm-dddd")
	private Date date;// 2012-12-11 , /*日期*/
	private String time;// 15;//03;//06 , /*时间*/

	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "stockdata_id", unique = true, nullable = false)
	public Integer getStockdataId() {
		return stockdataId;
	}

	public void setStockdataId(Integer stockdataId) {
		this.stockdataId = stockdataId;
	}

	@Column
	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	@Column
	public Double getIncrePer() {
		return increPer;
	}

	public void setIncrePer(Double increPer) {
		this.increPer = increPer;
	}
	@Column
	public Double getIncrease() {
		return increase;
	}

	public void setIncrease(Double increase) {
		this.increase = increase;
	}
	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column
	public Double getTodayStartPri() {
		return todayStartPri;
	}

	public void setTodayStartPri(Double todayStartPri) {
		this.todayStartPri = todayStartPri;
	}
	@Column
	public Double getYestodEndPri() {
		return yestodEndPri;
	}

	public void setYestodEndPri(Double yestodEndPri) {
		this.yestodEndPri = yestodEndPri;
	}
	@Column
	public Double getNowPri() {
		return nowPri;
	}

	public void setNowPri(Double nowPri) {
		this.nowPri = nowPri;
	}
	@Column
	public Double getTodayMax() {
		return todayMax;
	}

	public void setTodayMax(Double todayMax) {
		this.todayMax = todayMax;
	}
	@Column
	public Double getTodayMin() {
		return todayMin;
	}

	public void setTodayMin(Double todayMin) {
		this.todayMin = todayMin;
	}
	@Column
	public Double getCompetitivePri() {
		return competitivePri;
	}

	public void setCompetitivePri(Double competitivePri) {
		this.competitivePri = competitivePri;
	}
	@Column
	public Double getReservePri() {
		return reservePri;
	}

	public void setReservePri(Double reservePri) {
		this.reservePri = reservePri;
	}
	@Column
	public Long getTraNumber() {
		return traNumber;
	}

	public void setTraNumber(Long traNumber) {
		this.traNumber = traNumber;
	}
	@Column
	public Long getTraAmount() {
		return traAmount;
	}

	public void setTraAmount(Long traAmount) {
		this.traAmount = traAmount;
	}
	@Column
	public Long getBuyOne() {
		return buyOne;
	}

	public void setBuyOne(Long buyOne) {
		this.buyOne = buyOne;
	}
	@Column
	public Double getBuyOnePri() {
		return buyOnePri;
	}

	public void setBuyOnePri(Double buyOnePri) {
		this.buyOnePri = buyOnePri;
	}
	@Column
	public Long getBuyTwo() {
		return buyTwo;
	}

	public void setBuyTwo(Long buyTwo) {
		this.buyTwo = buyTwo;
	}
	@Column
	public Double getBuyTwoPri() {
		return buyTwoPri;
	}

	public void setBuyTwoPri(Double buyTwoPri) {
		this.buyTwoPri = buyTwoPri;
	}

	@Column
	public Long getSellOne() {
		return sellOne;
	}

	public void setSellOne(Long sellOne) {
		this.sellOne = sellOne;
	}
	@Column
	public Double getSellOnePri() {
		return sellOnePri;
	}

	public void setSellOnePri(Double sellOnePri) {
		this.sellOnePri = sellOnePri;
	}
	@Column
	public Long getSellTwo() {
		return sellTwo;
	}

	public void setSellTwo(Long sellTwo) {
		this.sellTwo = sellTwo;
	}
	@Column
	public Double getSellTwoPri() {
		return sellTwoPri;
	}

	public void setSellTwoPri(Double sellTwoPri) {
		this.sellTwoPri = sellTwoPri;
	}
	
	
	@Column
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	@Column
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public static void main(String[] args) {

		
		  JSONArray  jsonarray=(JSONArray) JuheStockData.selectHSStock("sh600000");
		    
		  
		  
		  Stockdata   s=   (Stockdata) JuheDataToBean.ToDanGuBean(jsonarray, Stockdata.class);
			
		
		

		System.out.println(s.getDate()+" / "+s.getTime());

	}

}