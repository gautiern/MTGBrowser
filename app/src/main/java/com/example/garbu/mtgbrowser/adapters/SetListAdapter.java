package com.example.garbu.mtgbrowser.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.garbu.mtgbrowser.R;
import com.example.garbu.mtgbrowser.model.Set;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by garbu on 9/3/2018.
 */

public class SetListAdapter extends RecyclerView.Adapter<SetListAdapter.ViewHolder>{
    private List<Set> mSets = new ArrayList<>();
    private Set mSet;
    private final SetListClickHandler mClickHandler;

    public interface SetListClickHandler {
        void onClick(Set set);
    }

    public void setSets(List<Set> sets) {
        mSets= sets;
        notifyDataSetChanged();
    }

    public SetListAdapter(SetListClickHandler clickHandler) {
        //default constructor
        mClickHandler = clickHandler;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.set_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        mSet = mSets.get(position);
        holder.setName.setText(mSet.getName());
        holder.setReleaseDate.setText(mSet.getReleaseDate());
        holder.setType.setText(mSet.getType());

    }

    @Override
    public int getItemCount() {

        if (mSets.isEmpty()) {
            return 0;
        } else {
            return mSets.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.set_name_tv)
        TextView setName;
        @BindView(R.id.set_rd_tv)
        TextView setReleaseDate;
        @BindView(R.id.set_type_tv)
        TextView setType;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int selectedSet = getAdapterPosition();
            mSet = mSets.get(selectedSet);
            mClickHandler.onClick(mSet);
        }
    }

}
