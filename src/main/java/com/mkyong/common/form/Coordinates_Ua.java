package com.mkyong.common.form;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * coordinate latitude , longitude on map
 * 
 * @author Sergey
 *
 */

@Entity
@Table(name = "coordinates_ua")
public class Coordinates_Ua implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 133L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "X_LATITUDE")
	private Double x_latitude;

	@Column(name = "Y_LONGITUDE")
	private Double y_longitude;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Atms_Info_Ua atms_info_ua;

	@ManyToOne
	@JoinColumn(name = "ID_BANK")
	private Banks_Ua bank_coord;

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
	 * @return the x_latitude
	 */
	public double getX_latitude() {
		return x_latitude;
	}

	/**
	 * @param x_latitude
	 *            the x_latitude to set
	 */
	public void setX_latitude(Double x_latitude) {
		this.x_latitude = x_latitude;
	}

	/**
	 * @return the y_longitude
	 */
	public double getY_longitude() {
		return y_longitude;
	}

	/**
	 * @param y_longitude
	 *            the y_longitude to set
	 */
	public void setY_longitude(Double y_longitude) {
		this.y_longitude = y_longitude;
	}

	/**
	 * @return the atms_info_ua
	 */
	public Atms_Info_Ua getAtms_info_ua() {
		return atms_info_ua;
	}

	/**
	 * @param atms_info_ua
	 *            the atms_info_ua to set
	 */
	public void setAtms_info_ua(Atms_Info_Ua atms_info_ua) {
		this.atms_info_ua = atms_info_ua;
	}

	/**
	 * @return the bank_coord
	 */
	public Banks_Ua getBank_coord() {
		return bank_coord;
	}

	/**
	 * @param bank_coord
	 *            the bank_coord to set
	 */
	public void setBank_coord(Banks_Ua bank_coord) {
		this.bank_coord = bank_coord;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		super.toString();
		return new String("id \t" + id + "X_LATITUDE\t" + x_latitude + "");

	}
}
