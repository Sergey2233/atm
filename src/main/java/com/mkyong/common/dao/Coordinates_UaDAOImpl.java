package com.mkyong.common.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mkyong.common.form.Coordinates_Ua;
import com.mkyong.common.radius.Coordinate;
import com.mkyong.common.radius.Radius;

@Repository
public class Coordinates_UaDAOImpl implements ICoordinates_UaDAO {
	private static final Logger logger = Logger
			.getLogger(Coordinates_UaDAOImpl.class);

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Override
	@SuppressWarnings("unchecked")
	public List<Coordinates_Ua> listCordinates() {
		List<Coordinates_Ua> result = null;
		try {
			result = (List<Coordinates_Ua>) hibernateTemplate
					.findByCriteria(DetachedCriteria
							.forClass(Coordinates_Ua.class));
			logger.info(result.size());

			logger.info("" + result.size());
		} catch (Exception ex) {

			logger.error(ex);
		}
		return result;
	}

	@Override
	public Coordinates_Ua getCordinat(Integer id) {
		Coordinates_Ua result = null;

		try {

			result = (Coordinates_Ua) hibernateTemplate
					.findByCriteria(DetachedCriteria.forClass(
							Coordinates_Ua.class)
							.add(Restrictions.eq("id", id)));

		}

		catch (Exception ex) {
			logger.error(ex.getStackTrace());
		}
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Coordinates_Ua> getCordinatesByCriteria(double x_latitude,
			double y_longitude, double radius) {
		List<Coordinates_Ua> result = null;
		Coordinate coord = Radius.coorRad(x_latitude, y_longitude, radius);
		Double x1 = coord.getX1();
		Double x2 = coord.getX2();
		Double y1 = coord.getY1();
		Double y2 = coord.getY2();
		try {
			result = (List<Coordinates_Ua>) hibernateTemplate
					.findByCriteria(DetachedCriteria
							.forClass(Coordinates_Ua.class)
							.add(Restrictions.between("x_latitude", x1, x2))
							.add((Restrictions.between("y_longitude", y1, y2))));
		}

		catch (Exception ex) {

			logger.error(ex.getStackTrace());
		}
		return result;
	}

}
