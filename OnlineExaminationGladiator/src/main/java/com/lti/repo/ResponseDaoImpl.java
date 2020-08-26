package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.Response;

@Repository
public class ResponseDaoImpl implements ResponseDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public int addResponses(List<Response> responses) {
		int count = 0;
		for(Response res: responses) {
			em.merge(res);
			count++;
		}
		return count;
	}
	
	@Transactional
	public int addResponse(Response response) {
		Response res= em.merge(response);
		return res.getCurrentResponseId();
	}

}
