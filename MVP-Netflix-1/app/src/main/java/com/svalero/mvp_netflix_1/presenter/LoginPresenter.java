package com.svalero.mvp_netflix_1.presenter;

import com.svalero.mvp_netflix_1.contract.LoginContract;
import com.svalero.mvp_netflix_1.model.pojo.Film;
import com.svalero.mvp_netflix_1.model.pojo.User;

public class LoginPresenter implements LoginContract.Presenter, LoginContract.Model.OnLoginUserListener
{
    @Override
    public void login(User username) {

    }

    @Override
    public void listFilms(Film film) {

    }
}
