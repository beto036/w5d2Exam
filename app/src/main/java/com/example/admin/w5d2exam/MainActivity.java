package com.example.admin.w5d2exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.w5d2exam.model.ResultAPI;
import com.example.admin.w5d2exam.model.SearchResult;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://api.airbnb.com/";
    private static final String TAG = "MainActivityTAG_";
    @BindView(R.id.aMainEditTxt)
    public EditText clientID;

    @BindView(R.id.a_main_recycler)
    public RecyclerView recyclerView;

    @Inject
    public ResultAPIService resultAPIService;


    private ArrayList<SearchResult> mArrayList;
    private ResultAPIAdapter resultAPIAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        DaggerRetrofitComponent.builder().retrofitModule(new RetrofitModule(BASE_URL)).build().inject(this);

        mArrayList = new ArrayList<SearchResult>();

    }

    public void showResults(View view) {
        String clientID = this.clientID.getText().toString();
        Call<ResultAPI> call = this.resultAPIService.retrieveSearch(clientID);
        call.enqueue(new Callback<ResultAPI>() {
            @Override
            public void onResponse(Call<ResultAPI> call, Response<ResultAPI> response) {
                ResultAPI resultAPI = response.body();
                for (SearchResult searchResult : resultAPI.getSearchResults()){
                    Log.d(TAG, "onResponse: " + searchResult);
                }
                mArrayList.addAll(resultAPI.getSearchResults());
                resultAPIAdapter = new ResultAPIAdapter(mArrayList);
                recyclerView = (RecyclerView) findViewById(R.id.a_main_recycler);
                recyclerView.setAdapter(resultAPIAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

            }

            @Override
            public void onFailure(Call<ResultAPI> call, Throwable t) {

            }
        });
    }
}
