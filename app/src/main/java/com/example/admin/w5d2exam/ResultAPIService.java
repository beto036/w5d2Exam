package com.example.admin.w5d2exam;

import com.example.admin.w5d2exam.model.ResultAPI;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by admin on 11/15/2016.
 */

public interface ResultAPIService {

    @GET("v2/search_results")
    Call<ResultAPI> retrieveSearch(@Query("client_id") String client_id);

}
