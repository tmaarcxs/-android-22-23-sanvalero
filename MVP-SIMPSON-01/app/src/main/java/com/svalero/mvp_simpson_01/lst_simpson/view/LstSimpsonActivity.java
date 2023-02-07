package com.svalero.mvp_simpson_01.lst_simpson.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.svalero.mvp_simpson_01.R;
import com.svalero.mvp_simpson_01.lst_simpson.LstSimpsonContract;
import com.svalero.mvp_simpson_01.entities.Simpson;
import com.svalero.mvp_simpson_01.lst_simpson.presenter.LstSimpsonPresenter;

import java.util.ArrayList;

public class LstSimpsonActivity extends AppCompatActivity implements LstSimpsonContract.View {

    private LstSimpsonPresenter lstSimpsonPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_simpson);

        initComponets();
        initPresenter();
        initData();

        lstSimpsonPresenter.lstSimpson(null);
    }

    private void initData() {
        lstSimpsonPresenter.lstSimpson(null);
    }

    private void initComponets() {
    }

    private void initPresenter() {
        lstSimpsonPresenter = new LstSimpsonPresenter(this);
    }

    @Override
    public void successLstSimpson(ArrayList<Simpson> lstSimpson) {
        //adapter notify data set changed

        Toast toast = Toast.makeText(this, lstSimpson.get(0).toString(), Toast.LENGTH_SHORT);
    }

    @Override
    public void failureLstSimpson(String error) {
        Toast toast = Toast.makeText(this, error, Toast.LENGTH_SHORT);
    }
}