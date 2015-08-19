package com.mkyong.common.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.common.form.Seti;

@Repository
public class SetiDAOImpl implements SetiDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Seti> listSeti() {
		List<Seti> result;
		try {
			result = sessionFactory.getCurrentSession()
					.createCriteria(Seti.class).list();

		} catch (Exception ex) {
			result = new ArrayList<Seti>(0);
		}
		return result;
	}

	public Seti getSeti(Integer id) {
		Seti result;
		try {
			result = (Seti) sessionFactory.getCurrentSession().get(Seti.class,
					id);

		} catch (Exception ex) {
			result = null;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Seti> getSetiByCriteria(String field, String value) {
		List<Seti> result;
		try {
			switch (field) {
			case "seti":
			case "country":
				result = sessionFactory.getCurrentSession()
						.createCriteria(Seti.class)
						.add(Restrictions.eq(field, value)).list();
				break;
			case "id":
				result = sessionFactory.getCurrentSession()
						.createCriteria(Seti.class)
						.add(Restrictions.eq(field, Integer.parseInt(value)))
						.list();
				break;
			default:
				result = new ArrayList<Seti>(0);
				break;
			}

		} catch (Exception ex) {
			result = new ArrayList<Seti>(0);
		}
		return result;
	}
}
