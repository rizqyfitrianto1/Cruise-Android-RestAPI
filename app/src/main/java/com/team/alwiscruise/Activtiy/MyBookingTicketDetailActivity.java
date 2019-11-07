package com.team.alwiscruise.Activtiy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.team.alwiscruise.R;
import com.team.alwiscruise.Util.Constant;

public class MyBookingTicketDetailActivity extends AppCompatActivity {
    TextView tv_departure, tv_price, tv_ship, tv_start_date, tv_end_date;
    String mId, mDeparture, mPrice, mShip, mStartDate, mEndDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_my_booking_ticket_detail );

        tv_departure = findViewById( R.id.tv_departure );
        tv_price = findViewById( R.id.tv_price );
        tv_ship = findViewById( R.id.tv_ship );
        tv_start_date = findViewById( R.id.tv_start_date );
        tv_end_date = findViewById( R.id.tv_end_date );

        mId = getIntent().getStringExtra( Constant.KEY_ID_TICKET );
        mDeparture = getIntent().getStringExtra( Constant.KEY_DEPARTURE );
        mPrice = getIntent().getStringExtra( Constant.KEY_PRICE );
        mShip = getIntent().getStringExtra( Constant.KEY_SHIP );
        mStartDate = getIntent().getStringExtra( Constant.KEY_START_DATE );
        mEndDate = getIntent().getStringExtra( Constant.KEY_END_DATE );

        tv_departure.setText( mDeparture );
        tv_price.setText( mPrice );
        tv_ship.setText( mShip );
        tv_start_date.setText( mStartDate );
        tv_end_date.setText( mEndDate );


    }
}
