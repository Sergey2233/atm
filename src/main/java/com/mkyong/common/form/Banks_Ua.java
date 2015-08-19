package com.mkyong.common.form;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * information about bank
 * 
 * @author Sergey
 *
 */

@Entity
@Table(name = "banks_ua")
public class Banks_Ua implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 122L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "ID_SETI")
	private Seti seti;

	@Column(name = "BANK_NAME_RU")
	private String bank_name_ru;

	@Column(name = "BANK_NAME_EN")
	private String bank_name_en;

	@Column(name = "BANK_NAME_UA")
	private String bank_name_ua;

	@Column(name = "MOD_DATA")
	private Date mod_data;

	@Enumerated(EnumType.STRING)
	@Column(name = "ADD_REMOVE", columnDefinition = "enum('0','1','2')")
	private String add_ramove;

	@Column(name = "SITE")
	private String site;

	@Column(name = "TELEPHONE")
	private String telephone;

	@Column(name = "IMG_BANK")
	@javax.persistence.Lob
	private byte[] img_bank;

	@OneToMany(mappedBy = "bank_ua")
	private List<Atms_Info_Ua> atms_info_ua;

	@OneToMany(mappedBy = "bank_coord")
	private List<Coordinates_Ua> coordinates;

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
	 * @return the bank_name_ru
	 */
	public String getBank_name_ru() {
		return bank_name_ru;
	}

	/**
	 * @param bank_name_ru
	 *            the bank_name_ru to set
	 */
	public void setBank_name_ru(String bank_name_ru) {
		this.bank_name_ru = bank_name_ru;
	}

	/**
	 * @return the bank_name_en
	 */
	public String getBank_name_en() {
		return bank_name_en;
	}

	/**
	 * @param bank_name_en
	 *            the bank_name_en to set
	 */
	public void setBank_name_en(String bank_name_en) {
		this.bank_name_en = bank_name_en;
	}

	/**
	 * @return the bank_name_ua
	 */
	public String getBank_name_ua() {
		return bank_name_ua;
	}

	/**
	 * @param bank_name_ua
	 *            the bank_name_ua to set
	 */
	public void setBank_name_ua(String bank_name_ua) {
		this.bank_name_ua = bank_name_ua;
	}

	/**
	 * @return the mod_data
	 */
	public Date getMod_data() {
		return mod_data;
	}

	/**
	 * @param mod_data
	 *            the mod_data to set
	 */
	public void setMod_data(Date mod_data) {
		this.mod_data = mod_data;
	}

	/**
	 * @return the add_ramove
	 */
	public String getAdd_ramove() {
		return add_ramove;
	}

	/**
	 * @param add_ramove
	 *            the add_ramove to set
	 */
	public void setAdd_ramove(String add_ramove) {
		this.add_ramove = add_ramove;
	}

	/**
	 * @return the site
	 */
	public String getSite() {
		return site;
	}

	/**
	 * @param site
	 *            the site to set
	 */
	public void setSite(String site) {
		this.site = site;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the imgbank
	 */
	public byte[] getImgbank() {
		return img_bank;
	}

	/**
	 * @param imgbank
	 *            the imgbank to set
	 * @param img_bank
	 */
	public void setImgbank(byte[] img_bank) {
		this.img_bank = img_bank;
	}

	/**
	 * @return the seti
	 */
	public Seti getSeti() {
		return seti;
	}

	/**
	 * @param seti
	 *            the seti to set
	 */
	public void setSeti(Seti seti) {
		this.seti = seti;
	}

	/**
	 * @return the employees
	 */

	/**
	 * @return the coordinates
	 */
	public List<Coordinates_Ua> getCoordinates() {
		return coordinates;
	}

	/**
	 * @param coordinates
	 *            the coordinates to set
	 */
	public void setCoordinates(List<Coordinates_Ua> coordinates) {
		this.coordinates = coordinates;
	}

	/**
	 * @return the atms_info_ua
	 */
	public List<Atms_Info_Ua> getAtms_info_ua() {
		return atms_info_ua;
	}

	/**
	 * @param atms_info_ua
	 *            the atms_info_ua to set
	 */
	public void setAtms_info_ua(List<Atms_Info_Ua> atms_info_ua) {
		this.atms_info_ua = atms_info_ua;
	}
}
