package com.team.alwiscruise.Activtiy;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import com.team.alwiscruise.Adapter.RecyclerRegionGridAdapter;
import com.team.alwiscruise.Adapter.RecyclerDestinationHorizontalAdapter;
import com.team.alwiscruise.Model.Destination;
import com.team.alwiscruise.Model.DestinationResponse;
import com.team.alwiscruise.Model.Region;
import com.team.alwiscruise.R;
import com.team.alwiscruise.Util.Api.ApiClient;
import com.team.alwiscruise.Util.Api.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    ProgressDialog loading;
    View view;
    private RecyclerView mRecyclerView, mRecyclerViewRegion;
    private RecyclerView.Adapter mAdapter, mAdapterRegion;
    private RecyclerView.LayoutManager mLayoutManager, mLayoutManagerRegion;

    CarouselView carouselView;
    int[] sampleImages = {R.drawable.slider1, R.drawable.slider2, R.drawable.slider4, R.drawable.slider5};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.fragment_home, container, false );

        Toolbar toolbar = (Toolbar) view.findViewById( R.id.toolbar );
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        carouselView = view.findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_destination);
        mRecyclerView.setHasFixedSize( true );
        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false );
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerViewRegion = (RecyclerView) view.findViewById(R.id.rv_region);
        mRecyclerViewRegion.setHasFixedSize( true );
        mLayoutManagerRegion = new GridLayoutManager(getContext(), 4);
        mRecyclerViewRegion.setLayoutManager(mLayoutManagerRegion);
        mAdapterRegion = new RecyclerRegionGridAdapter(RegionList());
        mRecyclerViewRegion.setAdapter(mAdapterRegion);

        TextView txt_viewall = (TextView) view.findViewById(R.id.txt_viewall);
        txt_viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DestinationAllActivtiy.class));
            }
        });
        
        loadDestination();

        return view;
    }

    private ArrayList<Region> RegionList() {
        ArrayList<Region> RegionList = new ArrayList<>(  );
        RegionList.add( new Region( "1","Asia", R.drawable.circle_asia) );
        RegionList.add( new Region( "2","Africa", R.drawable.circler_africa) );
        RegionList.add( new Region( "3","Europe", R.drawable.circle_europe) );
        RegionList.add( new Region( "4","America", R.drawable.circle_america) );
        RegionList.add( new Region( "5","Pacific", R.drawable.circle_asia) );
        RegionList.add( new Region( "6","Oceania", R.drawable.circler_africa) );
        RegionList.add( new Region( "7","Australia", R.drawable.circle_europe) );
        RegionList.add( new Region( "8","Antarctica", R.drawable.circle_america) );
        return RegionList;
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    private void loadDestination() {
        loading = new ProgressDialog(getContext());
        loading.setCancelable( false );
        loading.setTitle( null );
        loading.setMessage( "Harap Tunggu ..." );
        loading.setProgressStyle( ProgressDialog.STYLE_SPINNER );
        loading.setIndeterminate( true );
        loading.setIndeterminateDrawable( getResources().getDrawable( R.drawable.progress_icon ) );
        loading.show();

        ApiService service = ApiClient.getRetrofit().create( ApiService.class );
        Call<DestinationResponse> destinations = service.getDestination();
        destinations.enqueue( new Callback<DestinationResponse>() {
            @Override
            public void onResponse(Call<DestinationResponse> call, Response<DestinationResponse> response) {
                if (response.isSuccessful()){
                    loading.dismiss();
                    List<Destination> DestinationList =response.body().getDestinations();
                    Log.d("Retrofit Get", "Jumlah data Destination: " +
                            String.valueOf(DestinationList.size()));
                    mAdapter = new RecyclerDestinationHorizontalAdapter( DestinationList );
                    mRecyclerView.setAdapter( mAdapter );
                }else {
                    loading.dismiss();
                    Toast.makeText(getContext(), "Gagal mengambil data ", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<DestinationResponse> call, Throwable t) {
                loading.dismiss();
                Log.e("Retrofit Get", t.toString());
            }
        } );
    }
}
