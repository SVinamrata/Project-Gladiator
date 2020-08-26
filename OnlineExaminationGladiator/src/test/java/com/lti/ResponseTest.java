package com.lti;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.lti.model.Exam;
import com.lti.model.Question;
import com.lti.model.Response;
import com.lti.repo.ExamDao;
import com.lti.repo.QuestionDao;
import com.lti.repo.ResponseDao;

@SpringBootTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
class ResponseTest {
	
	@Autowired
	ResponseDao responseDao;
	
	@Autowired
	QuestionDao questionDao;
	
	@Autowired
	ExamDao examDao;

	@Test
	void addResponsesTest() {
//		List<Response> multipleResponses = new ArrayList<Response>();
		List<Response> responses = new ArrayList<Response>();
		Response res1= new Response();
		res1.setResponseStatus("attempted");
		res1.setStudentResponse("Multiple");
		Question question = questionDao.getQuestionByQuestion_id(70);
		res1.setQuestion(question);
		Exam exam = examDao.findExamById(72);
		res1.setExamDetails(exam);
		responses.add(res1);
		question.setResponseList(responses);
		exam.setResponses(responses);
		System.out.println(responseDao.addResponse(res1)+" response for question id 70");
		
		responses.clear();
		Response res2= new Response();
		res2.setResponseStatus("attempted");
		res2.setStudentResponse("All of the above");
		Question question2 = questionDao.getQuestionByQuestion_id(71);
		res2.setQuestion(question2);
		res2.setExamDetails(exam);
		responses.add(res2);
		question2.setResponseList(responses);
		exam.setResponses(responses);
//		multipleResponses.add(res1);
//		multipleResponses.add(res2);
		System.out.println(responseDao.addResponse(res2)+" response for question id 71");
	}

}
