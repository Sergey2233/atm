package com.mkyong.common.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mkyong.common.form.Coordinates_Ua;

@Transactional
/**
 * 
 * @author Sergey
 * 
 */
public interface ICoordinates_UaDAO {

	/**
	 * 
	 * all list coordinates
	 * 
	 * @return list coordinates
	 */
	public List<Coordinates_Ua> listCordinates();

	/**
	 * 
	 * @param id
	 *            coordinate
	 * @return one object Coordianates_Ua
	 */
	public Coordinates_Ua getCordinat(Integer id);

	/**
	 * return coordinates ATMS in point (x,y) and radius around
	 * 
	 * @param x
	 *            latitude
	 * @param y
	 *            longitude
	 * @param r
	 *            radius
	 * @return list object Coordinates_Ua
	 * @see Coordinates_Ua
	 */
	public List<Coordinates_Ua> getCordinatesByCriteria(double x, double y,
			double r);

}
