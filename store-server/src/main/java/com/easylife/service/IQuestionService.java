package com.easylife.service;


import com.easylife.common.ServerResponse;
import com.easylife.pojo.Question;

import java.util.List;

/**
 * Created by geely
 */
public interface IQuestionService {

    ServerResponse<List<Question>> selectQuestionById(int id);
    ServerResponse<List<Question>> selectList();

}
