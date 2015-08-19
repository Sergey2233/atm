package com.mkyong.json.parse;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.mkyong.common.form.Coordinates_Ua;
import com.mkyong.common.form.Seti;
import com.mkyong.common.service.CoordinatesService;
import com.mkyong.common.service.SetiService;

/**
 * class include date in Json
 * 
 * @author Sergey
 *
 */
@Component("ParseJson")
public class ParseJson {

	/**
	 * Injection SetiService object
	 * 
	 * @see SetiService
	 */
	@Autowired
	SetiService setiService;
	/**
	 * Injection CoordinatesService object
	 * 
	 * @see CoordinatesService
	 */
	@Autowired
	private CoordinatesService coordinate;

	/**
	 * 
	 * @param field
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getSetiByCriteria(String field, String value) {
		List<Seti> seti = setiService.getSetiByCriteria(field, value);
		JSONArray arr = new JSONArray();
		JSONObject res = new JSONObject();
		if (seti != null) {
			for (int i = 0; i < seti.size(); i++) {
				JSONObject obj = new JSONObject();
				obj.put("id", seti.get(i).getId());
				obj.put("seti", seti.get(i).getName_seti_ru());
				obj.put("country", seti.get(i).getCountry());
				arr.add(obj);
			}
			res.put("size", seti.size());
		}

		res.put("array", arr);
		res.put("field", field);
		res.put("value", value);

		return res.toString();
	}

	/**
	 * method return all atms and discription (seti, bank, info atm, coordinates
	 * place atm)
	 * 
	 * @return string format json
	 */
	@SuppressWarnings("unchecked")
	public String getCoordinatesALL() {
		List<Coordinates_Ua> coordin = coordinate.listCoordinates();
		// logger.info(""+coordin.size());
		JSONArray arr = new JSONArray();
		JSONObject res = new JSONObject();
		if (coordin != null) {
			for (int i = 0; i < coordin.size(); i++) {
				JSONObject obj = new JSONObject();
				obj.put("id", coordin.get(i).getId());
				obj.put("getX", coordin.get(i).getX_latitude());
				obj.put("gety", coordin.get(i).getY_longitude());
				arr.add(obj);
			}

			res.put("size", coordin.size());
		}
		res.put("array", arr);
		return res.toString();
	}

	/**
	 * return data atm format json (seti,banks,coordinates)
	 * 
	 * @param x_latitude
	 *            latitude
	 * @param y_longitude
	 *            longitude
	 * @param radius
	 *            all atm in radius
	 * @return string json format
	 */
	@SuppressWarnings("unchecked")
	public String getCoordinatesiByCriteria(String x_latitude,
			String y_longitude, String radius) {
		Double x = Double.parseDouble(x_latitude);
		Double y = Double.parseDouble(y_longitude);
		Double r = Double.parseDouble(radius);
		List<Coordinates_Ua> coordin = coordinate.getSetiByCriteria(x, y, r);
		JSONArray arr = new JSONArray();
		JSONObject res = new JSONObject();
		if (coordin != null) {
			for (int i = 0; i < coordin.size(); i++) {
				JSONObject obj = new JSONObject();
				obj.put("id", coordin.get(i).getId());
				obj.put("getX", coordin.get(i).getX_latitude());
				obj.put("gety", coordin.get(i).getY_longitude());
				obj.put("sity", coordin.get(i).getAtms_info_ua().getCity());
				obj.put("street", coordin.get(i).getAtms_info_ua().getAddress());
				arr.add(obj);
			}
			res.put("size", coordin.size());
		}
		res.put("array", arr);
		res.put("main", " 4");

		return res.toString();
	}

}
