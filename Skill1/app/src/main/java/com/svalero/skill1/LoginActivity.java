package com.svalero.skill1;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LoginActivity extends MainActivity {
    ImageView backBtn = (ImageView) findViewById(R.id.backBtn);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}

