package com.team.alwiscruise.Activtiy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.team.alwiscruise.R;
import com.team.alwiscruise.Util.Constant;

public class DestinationDetailActivity extends AppCompatActivity {
    TextView title, ship, date, visiting;
    ImageView photo;
    String mId, mPhoto, mPrice, mTitle, mShip, mDate, mVisiting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_destination_detail );

        photo = (ImageView) findViewById( R.id.img_destination);
        title = (TextView) findViewById(R.id.title);
        ship = (TextView) findViewById(R.id.ship);
        date = (TextView) findViewById(R.id.date);
        visiting = (TextView) findViewById(R.id.visiting);

        mId = getIntent().getStringExtra( Constant.KEY_ID_DESTINATION );
        mPrice = getIntent().getStringExtra( Constant.KEY_PRICE);
        mTitle = getIntent().getStringExtra( Constant.KEY_TITLE );
        mShip = getIntent().getStringExtra( Constant.KEY_SHIP );
        mDate = getIntent().getStringExtra( Constant.KEY_DATE );
        mVisiting = getIntent().getStringExtra( Constant.KEY_VISITING);
        mPhoto = getIntent().getStringExtra( Constant.KEY_PHOTO );

        Glide.with( this )
                .asBitmap()
                .load( mPhoto )
                .into( photo );

        title.setText( mTitle );
        ship.setText( mShip );
        date.setText( mDate );
        visiting.setText( mVisiting );
    }
}
