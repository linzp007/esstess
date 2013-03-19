package com.ailk.tess.dao;

import com.trg.dao.hibernate.GenericDAOImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * User: Administrator
 * Date: 13-2-13
 * Time: 下午1:47
 */
public class BaseDao<T, ID extends Serializable> extends GenericDAOImpl<T, ID> {
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
}
