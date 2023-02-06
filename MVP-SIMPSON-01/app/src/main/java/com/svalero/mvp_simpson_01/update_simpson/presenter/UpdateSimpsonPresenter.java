package com.svalero.mvp_simpson_01.update_simpson.presenter;

import com.svalero.mvp_simpson_01.update_simpson.UpdateSimpsonContract;
import com.svalero.mvp_simpson_01.update_simpson.model.UpdateSimpsonModel;
import com.svalero.mvp_simpson_01.update_simpson.model.pojo.Simpson;

import java.util.ArrayList;

public class UpdateSimpsonPresenter implements UpdateSimpsonContract.Presenter {
    private UpdateSimpsonModel lstSimpsonModel;
    private UpdateSimpsonContract.View view;

    public UpdateSimpsonPresenter(UpdateSimpsonContract.View view) {
        lstSimpsonModel = new UpdateSimpsonModel();
        this.view = view;
    }

    @Override
    public void lstSimpson(Simpson simpson) {
        lstSimpsonModel.lstSimpsonWS(null, new UpdateSimpsonContract.Model.OnLstSimpsonListener() {
            @Override
            public void onSuccess(ArrayList<Simpson> lstSimpson) {
                view.successLstSimpson(lstSimpson);
            }

            @Override
            public void onFailure(String error) {
                view.failureLstSimpson(error);
            }
        });
    }
}
