package com.team.alwiscruise.Activtiy;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.team.alwiscruise.R;

public class AccountFragment extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.fragment_account, container, false );

        Toolbar toolbar = (Toolbar) view.findViewById( R.id.toolbar );
        toolbar.setTitle( "Account" );
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        TextView txt_ubah_account = (TextView)view.findViewById(R.id.txt_ubah_account);
        txt_ubah_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), AccountEditActivity.class));
            }
        });

        LinearLayout ll_faq = (LinearLayout)view.findViewById( R.id.ll_faq );
        ll_faq.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( getContext(), FAQActivity.class ) );
            }
        } );

        return view;
    }

}
