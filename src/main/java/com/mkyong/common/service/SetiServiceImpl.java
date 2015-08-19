package com.mkyong.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkyong.common.dao.SetiDAO;
import com.mkyong.common.form.Seti;

@Service
public class SetiServiceImpl implements SetiService {

	@Autowired
	private SetiDAO setiDAO;

	public List<Seti> listSeti() {
		return setiDAO.listSeti();
	}

	public Seti getSeti(Integer id) {
		return setiDAO.getSeti(id);
	}

	public List<Seti> getSetiByCriteria(String field, String value) {
		return setiDAO.getSetiByCriteria(field, value);
	}

}
