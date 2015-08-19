package com.mkyong.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkyong.common.dao.ICoordinates_UaDAO;
import com.mkyong.common.form.Coordinates_Ua;

/**
 * 
 * @author Sergey
 * @see Coordinates_Ua
 */
@Service
public class Coordinates_UaServiceImpl implements CoordinatesService {

	@Autowired
	private ICoordinates_UaDAO coorDAO;

	public List<Coordinates_Ua> listCoordinates() {
		return coorDAO.listCordinates();
	}

	public Coordinates_Ua getCoordinates_ua(Integer id) {
		return coorDAO.getCordinat(id);
	}

	public List<Coordinates_Ua> getSetiByCriteria(double x, double y, double r) {
		return coorDAO.getCordinatesByCriteria(x, y, r);
	}

}
