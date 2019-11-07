package com.team.alwiscruise.Activtiy;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.team.alwiscruise.Adapter.RecyclerRegionGridAdapter;
import com.team.alwiscruise.Adapter.RecyclerTicketVerticalAdapter;
import com.team.alwiscruise.Model.Region;
import com.team.alwiscruise.Model.Ticket;
import com.team.alwiscruise.R;

import java.util.ArrayList;
import java.util.List;

public class MyBookingFragment extends Fragment {
    View view;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.fragment_my_booking, container, false );

        Toolbar toolbar = (Toolbar) view.findViewById( R.id.toolbar );
        toolbar.setTitle( "My Booking" );
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_mybooking_ticket);
        mRecyclerView.setHasFixedSize( true );
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerTicketVerticalAdapter( TicketList());
        mRecyclerView.setAdapter(mAdapter);

        Button btn_pilih_cruise = (Button) view.findViewById( R.id.btn_pilih_cruise );
        btn_pilih_cruise.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( getContext(), DestinationAllActivtiy.class ) );
            }
        } );

        return view;
    }

    private List<Ticket> TicketList() {
        ArrayList<Ticket> TicketList = new ArrayList<>(  );
        TicketList.add( new Ticket( "1","Indonesia", "15.000.000", "Harmony of The Seas", "1 Januari 2020","5 Januari 2020") );
        return TicketList;
    }

}
