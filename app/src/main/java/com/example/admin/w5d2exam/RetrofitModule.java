package com.example.admin.w5d2exam;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 11/15/2016.
 */

@Module
public class RetrofitModule {

    private String BASE_URL;

    public RetrofitModule(String url) {
        this.BASE_URL = url;
    }

    @Provides
    public Retrofit provideRetroFit(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public ResultAPIService provideBatManService(Retrofit retrofit){
        return retrofit.create(ResultAPIService.class);
    }
}
