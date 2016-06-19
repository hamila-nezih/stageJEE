package com.hc.stage.dao.upload;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hc.stage.dao.base.GenericJpaDao;
import com.hc.stage.entities.upload.upload;

public class ImpDaoUpload extends GenericJpaDao<upload, Long> implements InterfaceDaoUpload {

	@PersistenceContext
	private EntityManager em;

	public ImpDaoUpload() {
		super(upload.class);
	}

	public ImpDaoUpload(Class<upload> persistentClass) {
		super(persistentClass);
	}

	

}
