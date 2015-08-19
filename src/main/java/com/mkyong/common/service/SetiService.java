package com.mkyong.common.service;

import java.util.List;

import com.mkyong.common.form.Seti;

public interface SetiService {
	public List<Seti> listSeti();

	public Seti getSeti(Integer id);

	public List<Seti> getSetiByCriteria(String field, String value);
}
