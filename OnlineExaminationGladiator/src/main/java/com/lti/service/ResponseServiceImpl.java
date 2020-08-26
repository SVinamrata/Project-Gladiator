package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.ResponseDto;
import com.lti.model.Exam;
import com.lti.model.Question;
import com.lti.model.Response;
import com.lti.repo.ExamDao;
import com.lti.repo.QuestionDao;
import com.lti.repo.ResponseDao;

@Service
public class ResponseServiceImpl implements ResponseService {
	
	@Autowired
	private ResponseDao responseDao;
	
	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private ExamDao examDao;
	
	@Override
	public int addResponses(List<ResponseDto> responseDtoList) {
		int count = 0;
		for(ResponseDto resDto: responseDtoList) {
			List<Response> list = new ArrayList<Response>();
			Question question = questionDao.getQuestionByQuestion_id(resDto.getQuestionId());
			Exam exam = examDao.findExamById(resDto.getExamId());
			Response response = new Response();
			response.setResponseStatus(resDto.getResponseStatus());
			response.setStudentResponse(resDto.getStudentResponse());
			response.setExamDetails(exam);
			response.setQuestion(question);
			list.add(response);
			exam.setResponses(list);
			question.setResponseList(list);
			int id = responseDao.addResponse(response);
			if(id!=0)
				count++;
		}
		return count;
	}

}
