package com.team.alwiscruise.Activtiy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.team.alwiscruise.Adapter.RecyclerDestinationHorizontalAdapter;
import com.team.alwiscruise.Model.Destination;
import com.team.alwiscruise.Model.DestinationResponse;
import com.team.alwiscruise.R;
import com.team.alwiscruise.Util.Api.ApiClient;
import com.team.alwiscruise.Util.Api.ApiService;
import com.team.alwiscruise.Util.Constant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DestinationAllActivtiy extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    String ship = "";
    String id_region, name_region, image_region;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_all);

        id_region = getIntent().getStringExtra(Constant.KEY_ID_REGION);
        name_region = getIntent().getStringExtra(Constant.KEY_NAME);
        image_region = getIntent().getStringExtra(Constant.KEY_IMAGE);

        if (name_region == null){
            name_region = "All";
        }

        Toolbar toolbar = (Toolbar) findViewById( R.id .toolbar );
        toolbar.setTitle(name_region+" Destinations");
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_alldestination);
        mRecyclerView.setHasFixedSize( true );
        mLayoutManager = new GridLayoutManager(this,2 );
        mRecyclerView.setLayoutManager(mLayoutManager);

        final SearchView searchView = (SearchView) findViewById(R.id.sv_alldestination);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ship = searchView.getQuery().toString();
                loadDestinationAll(ship);
                return false;
            }
        });

        loadDestinationAll("");
    }

    private void loadDestinationAll(String ship) {

        ApiService service = ApiClient.getRetrofit().create( ApiService.class );
        Call<DestinationResponse> destinations = service.getDestination(ship);
        destinations.enqueue( new Callback<DestinationResponse>() {
            @Override
            public void onResponse(Call<DestinationResponse> call, Response<DestinationResponse> response) {
                if (response.isSuccessful()){
                    List<Destination> DestinationList =response.body().getDestinations();
                    Log.d("Retrofit Get", "Jumlah data Destination: " +
                            String.valueOf(DestinationList.size()));
                    mAdapter = new RecyclerDestinationHorizontalAdapter( DestinationList );
                    mRecyclerView.setAdapter( mAdapter );
                }else {
                    Toast.makeText(getApplication(), "Gagal mengambil data ", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<DestinationResponse> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        } );
    }
}
