package com.svalero.mvp_netflix_1.contract;

import com.svalero.mvp_netflix_1.model.pojo.Film;
import com.svalero.mvp_netflix_1.model.pojo.User;

public interface LoginContract {
    public interface View {
        void successLogin(User user, String message);

        void failureLogin(String err);
    }

    public interface Presenter {
        void login(User username);
        void listFilms(Film film);
    }

    public interface Model {
        void findUserWS(User username, OnLoginUserListener onLoginUserListener);

        interface OnLoginUserListener {
            void onFinished(User user, String message);
            void onFailure(String err);
        }
    }
}
