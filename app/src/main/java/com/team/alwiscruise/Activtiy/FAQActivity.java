package com.team.alwiscruise.Activtiy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.team.alwiscruise.R;

public class FAQActivity extends AppCompatActivity {

    LinearLayout expandableView, ll_first;
    ImageView arrowBtn;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_faq );

        Toolbar toolbar = (Toolbar)findViewById( R.id.toolbar );
        toolbar.setTitle( "Frequently Asked Questions" );
        setSupportActionBar(toolbar);

        expandableView = findViewById( R.id.expandableView );
        ll_first = findViewById( R.id.ll_first );
        arrowBtn = findViewById( R.id.arrowBtn );
        cardView = findViewById( R.id.cardView );

        ll_first.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.VISIBLE);
                    arrowBtn.setBackgroundResource( R.drawable.ic_arrow_down_blue);
                } else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.GONE);
                    arrowBtn.setBackgroundResource( R.drawable.ic_arrow_right_blue);
                }
            }
        });
    }
}
