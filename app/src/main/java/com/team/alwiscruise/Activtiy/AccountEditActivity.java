package com.team.alwiscruise.Activtiy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.team.alwiscruise.R;

public class AccountEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_edit);

        Toolbar toolbar = (Toolbar)findViewById( R.id.toolbar );
        toolbar.setTitle( "Ubah Profil" );
        setSupportActionBar(toolbar);
    }
}
