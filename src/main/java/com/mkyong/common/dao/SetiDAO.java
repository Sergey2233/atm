package com.mkyong.common.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mkyong.common.form.Seti;

/**
 * 
 * @author Sergey access entity Seti
 */
@Transactional
public interface SetiDAO {
	// initialized entity with Banks, Atms_Info_Ua,Coordinates
	public static final int INIT_BANK_ATMSIFO_COORDINAT = 3;
	// initialized entity with Banks, Atms_Info_Ua
	public static final int INIT_BANK_ATMSIFO = 2;
	// // initialized entity with Banks
	public static final int INIT_BANK = 1;

	/**
	 * return list entity Seti lazy initialize
	 * 
	 * @param lazyLoadLevel
	 * @return list Seti
	 */
	public List<Seti> listSeti();

	/**
	 * return entity Seti by id
	 * 
	 * @param id
	 *            id seti
	 * @param lazyLoadLevel
	 * @return Seti by id
	 */
	public Seti getSeti(Integer id);

	/**
	 * 
	 * @param field
	 * @param value
	 * @param lazyLoadLevel
	 * @return
	 */
	public List<Seti> getSetiByCriteria(String field, String value);

}