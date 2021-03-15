package com.easylife.service.impl;

import com.easylife.common.ServerResponse;
import com.easylife.dao.QuestionMapper;
import com.easylife.pojo.Question;
import com.easylife.service.IQuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by geely
 */
@Service("iQuestionService")
@Slf4j
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public ServerResponse<List<Question>> selectQuestionById(int id) {
        List<Question> questionList = questionMapper.selectQuestionById(id);

        return ServerResponse.createBySuccess(questionList);
    }

    @Override
    public ServerResponse<List<Question>> selectList() {
        List<Question> questionList = questionMapper.selectAll();
        return ServerResponse.createBySuccess(questionList);
    }
}
