package com.svalero.mvp_netflix_1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.svalero.mvp_netflix_1.R;
import com.svalero.mvp_netflix_1.contract.LoginContract;
import com.svalero.mvp_netflix_1.model.pojo.User;
import com.svalero.mvp_netflix_1.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginContract.View{
    private EditText edtUserLogin;
    private EditText edtPasswordLogin;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ativity);
        initComponents();
        initPresenter();

    }

    private void initComponents(){
        edtUserLogin = findViewById(R.id.edtUserLogin);
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin);
        btnLogin = findViewById(R.id.btnLogin);
    }

    private void initPresenter(){
        LoginPresenter loginPresenter = new LoginPresenter();
        loginPresenter.listFilms(null);
    }

    @Override
    public void successLogin(User user, String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failureLogin(String err) {

    }
}