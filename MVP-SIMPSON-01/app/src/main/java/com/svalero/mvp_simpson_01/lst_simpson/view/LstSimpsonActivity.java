package com.svalero.mvp_simpson_01.lst_simpson.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.svalero.mvp_simpson_01.R;
import com.svalero.mvp_simpson_01.lst_simpson.presenter.LstSimpsonPresenter;

public class LstSimpsonActivity extends AppCompatActivity {

    private LstSimpsonPresenter lstSimpsonPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_simpson);

        initComponets();
        initPresenter();
        lstSimpsonPresenter.lstSimpson(null);
    }

    private void initComponets() {
    }

    private void initPresenter() {
    }
}