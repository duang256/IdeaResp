package com.easylife.dao;

import com.easylife.pojo.Question;
import com.easylife.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 2020.12.9
 * hua
 */

public interface QuestionMapper extends MyMapper<Question> {

    List<Question> selectList();

    List<Question> selectQuestionById(@Param("id") int id);
}