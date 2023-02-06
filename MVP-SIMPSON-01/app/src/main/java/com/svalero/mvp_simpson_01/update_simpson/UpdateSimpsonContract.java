package com.svalero.mvp_simpson_01.update_simpson;

import com.svalero.mvp_simpson_01.update_simpson.model.pojo.Simpson;

import java.util.ArrayList;

public interface UpdateSimpsonContract {

    interface View {
        void successLstSimpson(ArrayList<Simpson> lstSimpson);

        void failureLstSimpson(String error);
    }

    interface Presenter {
        //caso de uso
        void lstSimpson(Simpson simpson);
    }

    interface Model {
        void lstSimpsonWS(Simpson simpson, OnLstSimpsonListener onLstSimpsonListener);

        interface OnLstSimpsonListener {
            void onSuccess(ArrayList<Simpson> lstSimpson);

            void onFailure(String error);
        }
    }
}
