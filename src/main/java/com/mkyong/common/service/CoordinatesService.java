package com.mkyong.common.service;

import java.util.List;

import com.mkyong.common.form.Coordinates_Ua;

/**
 * 
 * @author Sergey
 * @see Coordinates_ua
 */
public interface CoordinatesService {
	/**
	 * 
	 * @param lazyLoadLevel
	 *            initializes
	 * @return
	 */
	/**
	 * 
	 * @return all list coordinates
	 */
	public List<Coordinates_Ua> listCoordinates();

	/**
	 * 
	 * @param id
	 *            id coordinates
	 * @return Cordinate_Ua by id
	 */
	public Coordinates_Ua getCoordinates_ua(Integer id);

	/**
	 * 
	 * @param x
	 *            latitude
	 * @param y
	 *            longitude
	 * @param r
	 *            radius
	 * @return list Coordinates_UA in radius start point (x,y)
	 */
	public List<Coordinates_Ua> getSetiByCriteria(double x, double y, double r);

}
