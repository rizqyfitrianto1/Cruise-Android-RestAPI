package com.team.alwiscruise.Util.Api;

import com.team.alwiscruise.Model.DestinationDetailResponse;
import com.team.alwiscruise.Model.DestinationResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("destination/search")
    Call<DestinationResponse> getDestination();

    @GET("destination/search/{ship}")
    Call<DestinationResponse> getDestination(@Path("ship") String ship);

    @GET("destination/{id)")
    Call<DestinationDetailResponse> getDestinationDetail(@Path("id") String id);

}
