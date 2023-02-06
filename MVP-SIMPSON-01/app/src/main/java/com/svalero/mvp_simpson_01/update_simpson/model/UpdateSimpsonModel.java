package com.svalero.mvp_simpson_01.update_simpson.model;

import com.svalero.mvp_simpson_01.update_simpson.UpdateSimpsonContract;
import com.svalero.mvp_simpson_01.update_simpson.model.pojo.Simpson;

public class UpdateSimpsonModel implements UpdateSimpsonContract.Model{
    @Override
    public void lstSimpsonWS(Simpson simpson, OnLstSimpsonListener onLstSimpsonListener) {
        //si ha ido bien
        onLstSimpsonListener.onSuccess(null);
        //si ha ido mal
        onLstSimpsonListener.onFailure(null);
    }
}
