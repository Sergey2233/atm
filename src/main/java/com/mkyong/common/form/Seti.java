package com.mkyong.common.form;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Sergey
 *
 */

@Entity
@Table(name = "seti")
public class Seti implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 144L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@Column(name = "NAME_SETI_RU")
	private String name_seti_ru;

	@Column(name = "NAME_SETI_EN")
	private String name_setei_en;

	@Column(name = "NAME_SETI_UA")
	private String name_seti_ua;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "IMG_SETI")
	@javax.persistence.Lob
	private byte[] imgseti;
	// Getters and setters
	@OneToMany(mappedBy = "seti")
	private List<Banks_Ua> banks;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name_seti_ru
	 */
	public String getName_seti_ru() {
		return name_seti_ru;
	}

	/**
	 * @param name_seti_ru
	 *            the name_seti_ru to set
	 */
	public void setName_seti_ru(String name_seti_ru) {
		this.name_seti_ru = name_seti_ru;
	}

	/**
	 * @return the name_setei_en
	 */
	public String getName_setei_en() {
		return name_setei_en;
	}

	/**
	 * @param name_setei_en
	 *            the name_setei_en to set
	 */
	public void setName_setei_en(String name_setei_en) {
		this.name_setei_en = name_setei_en;
	}

	/**
	 * @return the name_seti_ua
	 */
	public String getName_seti_ua() {
		return name_seti_ua;
	}

	/**
	 * @param name_seti_ua
	 *            the name_seti_ua to set
	 */
	public void setName_seti_ua(String name_seti_ua) {
		this.name_seti_ua = name_seti_ua;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the imgseti
	 */
	public byte[] getImgseti() {
		return imgseti;
	}

	/**
	 * @param imgseti
	 *            the imgseti to set
	 */
	public void setImgseti(byte[] imgseti) {
		this.imgseti = imgseti;
	}

	/**
	 * @return the banks
	 */
	public List<Banks_Ua> getBanks() {
		return banks;
	}

	/**
	 * @param banks
	 *            the banks to set
	 */
	public void setBanks(List<Banks_Ua> banks) {
		this.banks = banks;
	}
}
