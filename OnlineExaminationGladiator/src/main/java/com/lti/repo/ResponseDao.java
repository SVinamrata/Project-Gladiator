package com.lti.repo;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lti.model.Response;

public interface ResponseDao {

	int addResponses(List<Response> responses);
	int addResponse(Response response);

}