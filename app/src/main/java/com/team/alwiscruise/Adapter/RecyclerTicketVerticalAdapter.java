package com.team.alwiscruise.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.team.alwiscruise.Activtiy.MyBookingTicketDetailActivity;
import com.team.alwiscruise.Model.Ticket;
import com.team.alwiscruise.R;
import com.team.alwiscruise.Util.Constant;

import java.util.List;

public class RecyclerTicketVerticalAdapter extends RecyclerView.Adapter<RecyclerTicketVerticalAdapter.MyViewHolder> {

    List<Ticket> mTicket;

    public RecyclerTicketVerticalAdapter(List<Ticket> TicketList){
        mTicket = TicketList;
    }

    @Override
    public RecyclerTicketVerticalAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.ticket_card, parent, false);
        RecyclerTicketVerticalAdapter.MyViewHolder holder = new RecyclerTicketVerticalAdapter.MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerTicketVerticalAdapter.MyViewHolder holder, final int position) {

        holder.tv_departure.setText(mTicket.get(position).getDeparture());
        holder.tv_price.setText(mTicket.get(position).getPrice());
        holder.tv_ship.setText(mTicket.get(position).getShip());
        holder.tv_start_date.setText(mTicket.get(position).getStart_date());
        holder.tv_end_date.setText(mTicket.get(position).getEnd_date());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = mTicket.get(position).getId();
                String departure = mTicket.get(position).getDeparture();
                String price = mTicket.get(position).getPrice();
                String ship = mTicket.get(position).getShip();
                String start_date = mTicket.get(position).getStart_date();
                String end_date = mTicket.get(position).getEnd_date();


                Intent intent = new Intent(view.getContext(), MyBookingTicketDetailActivity.class);
                intent.putExtra( Constant.KEY_ID_REGION, id);
                intent.putExtra(Constant.KEY_DEPARTURE, departure);
                intent.putExtra(Constant.KEY_PRICE, price);
                intent.putExtra(Constant.KEY_SHIP, ship);
                intent.putExtra(Constant.KEY_START_DATE, start_date);
                intent.putExtra(Constant.KEY_END_DATE, end_date);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mTicket.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout item_card;
        TextView tv_departure, tv_price, tv_ship, tv_start_date, tv_end_date;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_departure = (TextView) itemView.findViewById(R.id.tv_departure);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);
            tv_ship = (TextView) itemView.findViewById(R.id.tv_ship);
            tv_start_date = (TextView) itemView.findViewById(R.id.tv_start_date);
            tv_end_date = (TextView) itemView.findViewById(R.id.tv_end_date);
        }

    }
}