package com.example.admin.w5d2exam;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.w5d2exam.model.ResultAPI;
import com.example.admin.w5d2exam.model.SearchResult;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 10/28/2016.
 */
public class ResultAPIAdapter extends RecyclerView.Adapter<ResultAPIAdapter.ViewHolder>{

    private ArrayList<SearchResult> mArrayList;

    public ResultAPIAdapter(ArrayList<SearchResult> mArrayList) {
        this.mArrayList = mArrayList;
    }

    @Override
    public ResultAPIAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View termView = inflater.inflate(R.layout.recycler_item, parent, false);

        return new ResultAPIAdapter.ViewHolder(termView);
    }

    @Override
    public void onBindViewHolder(ResultAPIAdapter.ViewHolder holder, int position) {
        SearchResult searchResult = mArrayList.get(position);

        TextView textViewName = holder.textViewName;
        textViewName.setText(searchResult.getListing().getCity());
        holder.searchResult = searchResult;
        holder.context = this;
        holder.position = position;
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private static final String TAG = "ResultAPIAdapterTAG_";
        @BindView(R.id.r_item_text)
        public TextView textViewName;

        public SearchResult searchResult;
        public ResultAPIAdapter context;
        public int position;


        public ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(v.getContext(), ResultAPI.getId() + " " + ResultAPI.getTitle() + " " + ResultAPI.getAuthor(), Toast.LENGTH_SHORT).show();
//                    ResultAPI.delete(ResultAPI);
//                    context.mArrayList.remove(position);
//                    context.notifyItemRemoved(position);
//                }
//            });

        }
    }
}
