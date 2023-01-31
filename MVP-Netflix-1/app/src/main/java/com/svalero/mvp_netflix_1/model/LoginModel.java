package com.svalero.mvp_netflix_1.model;

import com.svalero.mvp_netflix_1.contract.LoginContract;
import com.svalero.mvp_netflix_1.model.pojo.User;

public class LoginModel implements LoginContract.Model{

    @Override
    public void findUserWS(User username, OnLoginUserListener onLoginUserListener) {

    }
}
