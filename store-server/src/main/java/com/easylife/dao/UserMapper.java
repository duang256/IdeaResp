package com.easylife.dao;

import com.easylife.pojo.User;
import com.easylife.util.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends MyMapper<User> {


    int checkUserphone(String userphone);

    int checkUsername(String username);

    int checkEmail(String email);

    User selectLogin(@Param("username") String username, @Param("password")String password);

    User selectLoginbytel(@Param("userphone")String userphone);

    String selectQuestionByUsername(String username);

    int checkAnswer(@Param("username")String username,@Param("question")String question,@Param("answer")String answer);

    int updatePasswordByUsername(@Param("username")String username,@Param("passwordNew")String passwordNew);

    int checkPassword(@Param(value="password")String password,@Param("userId")Integer userId);

    int checkEmailByUserId(@Param(value="email")String email,@Param(value="userId")Integer userId);



    //这里一定要用Integer，因为int无法为NULL，考虑到很多已经删除的情况。
    Integer selectyidouByUserId(Integer id);

    User addUserYidou(Integer userId);

}