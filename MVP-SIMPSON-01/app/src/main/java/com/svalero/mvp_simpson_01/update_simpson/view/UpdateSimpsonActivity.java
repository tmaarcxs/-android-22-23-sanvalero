package com.svalero.mvp_simpson_01.update_simpson.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.svalero.mvp_simpson_01.R;
import com.svalero.mvp_simpson_01.update_simpson.UpdateSimpsonContract;
import com.svalero.mvp_simpson_01.update_simpson.model.pojo.Simpson;
import com.svalero.mvp_simpson_01.update_simpson.presenter.UpdateSimpsonPresenter;

import java.util.ArrayList;

public class UpdateSimpsonActivity extends AppCompatActivity implements UpdateSimpsonContract.View {

    private UpdateSimpsonPresenter updateSimpsonPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_simpson);

        initComponets();
        initPresenter();
        initData();

        updateSimpsonPresenter.lstSimpson(null);
    }

    private void initData() {
        updateSimpsonPresenter.lstSimpson(null);
    }

    private void initComponets() {
    }

    private void initPresenter() {
        updateSimpsonPresenter = new UpdateSimpsonPresenter(this);
    }

    @Override
    public void successLstSimpson(ArrayList<Simpson> lstSimpson) {
        //adapter notify data set changed
    }

    @Override
    public void failureLstSimpson(String error) {
        Toast toast = Toast.makeText(this, error, Toast.LENGTH_SHORT);
    }
}