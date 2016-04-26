package com.isoft.project.module.po;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysUserinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_userinfo", catalog = "stocktest1")
public class SysUserinfo implements java.io.Serializable {

	// Fields

	private Integer userinfoId;
	private String userinfoName;
	private String userinfoSex;
	private String userinfoPwd;
	private Integer userinfoAccount;
	private double userinfoMoney;
	private double userinfoAssets;
	private Date userinfoActime;
	private Date userinfoIntime;

	// Constructors

	/** default constructor */
	public SysUserinfo() {
	}

	/** full constructor */
	public SysUserinfo(String userinfoName, String userinfoSex,
			String userinfoPwd, Integer userinfoAccount, double userinfoMoney,
			double userinfoAssets, Date userinfoActime, Date userinfoIntime) {
		this.userinfoName = userinfoName;
		this.userinfoSex = userinfoSex;
		this.userinfoPwd = userinfoPwd;
		this.userinfoAccount = userinfoAccount;
		this.userinfoMoney = userinfoMoney;
		this.userinfoAssets = userinfoAssets;
		this.userinfoActime = userinfoActime;
		this.userinfoIntime = userinfoIntime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Userinfo_id", unique = true, nullable = false)
	public Integer getUserinfoId() {
		return this.userinfoId;
	}

	public void setUserinfoId(Integer userinfoId) {
		this.userinfoId = userinfoId;
	}

	@Column(name = "Userinfo_name")
	public String getUserinfoName() {
		return this.userinfoName;
	}

	public void setUserinfoName(String userinfoName) {
		this.userinfoName = userinfoName;
	}

	@Column(name = "Userinfo_sex", length = 50)
	public String getUserinfoSex() {
		return this.userinfoSex;
	}

	public void setUserinfoSex(String userinfoSex) {
		this.userinfoSex = userinfoSex;
	}

	@Column(name = "Userinfo_pwd")
	public String getUserinfoPwd() {
		return this.userinfoPwd;
	}

	public void setUserinfoPwd(String userinfoPwd) {
		this.userinfoPwd = userinfoPwd;
	}

	@Column(name = "Userinfo_account")
	public Integer getUserinfoAccount() {
		return this.userinfoAccount;
	}

	public void setUserinfoAccount(Integer userinfoAccount) {
		this.userinfoAccount = userinfoAccount;
	}

	@Column(name = "Userinfo_money", precision = 22, scale = 0)
	public double getUserinfoMoney() {
		return this.userinfoMoney;
	}

	public void setUserinfoMoney(double userinfoMoney) {
		this.userinfoMoney = userinfoMoney;
	}

	@Column(name = "Userinfo_assets", precision = 22, scale = 0)
	public double getUserinfoAssets() {
		return this.userinfoAssets;
	}

	public void setUserinfoAssets(double userinfoAssets) {
		this.userinfoAssets = userinfoAssets;
	}

	@Column(name = "Userinfo_actime", length = 19)
	public Date getUserinfoActime() {
		return this.userinfoActime;
	}

	public void setUserinfoActime(Date userinfoActime) {
		this.userinfoActime = userinfoActime;
	}

	@Column(name = "Userinfo_intime", length = 19)
	public Date getUserinfoIntime() {
		return this.userinfoIntime;
	}

	public void setUserinfoIntime(Date userinfoIntime) {
		this.userinfoIntime = userinfoIntime;
	}

}