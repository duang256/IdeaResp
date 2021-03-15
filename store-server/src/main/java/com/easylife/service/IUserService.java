package com.easylife.service;


import com.easylife.common.ServerResponse;
import com.easylife.pojo.User;
import com.easylife.vo.UserVo;

/**
 * Created by HAL on 2018/12/20.
 */
public interface IUserService {


    ServerResponse<User> loginbytel(String userphone);

    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);

    ServerResponse<String> checkValid(String str, String type);

    ServerResponse selectQuestion(String username);

    ServerResponse<String> checkAnswer(String username, String question, String answer);

    ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken);

    ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user);

    ServerResponse<User> updateInformation(User user);

    ServerResponse<UserVo> getInformation(Integer userId);

    ServerResponse checkAdminRole(User user);

    ServerResponse<User> addUserYidou(Integer id);

}
