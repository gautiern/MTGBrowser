package com.example.garbu.mtgbrowser.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.garbu.mtgbrowser.R;
import com.example.garbu.mtgbrowser.model.Card;
import com.example.garbu.mtgbrowser.model.Set;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by garbu on 9/3/2018.
 */

public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.ViewHolder>{
    private Set mSet;
    private List<Card> mCards = new ArrayList();
    private final CardListClickHandler mClickHandler;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.card_iv)
        ImageView cardImage;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int selectedSet = getAdapterPosition();
            //mSet = mSets.get(selectedSet);
            //mClickHandler.onClick(mSet);
        }
    }

    @NonNull
    @Override
    public CardListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_grid_layout, parent, false);
        CardListAdapter.ViewHolder viewHolder = new CardListAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardListAdapter.ViewHolder holder, int position) {
        Card card = mCards.get(position);

        Picasso.get()
                .load(card.getImageUrl())
                .into(holder.cardImage);
    }

    @Override
    public int getItemCount() {

        if (mCards.isEmpty()) {
            return 0;
        } else {
            return mCards.size();
        }

    }
    public void setCards(List<Card> cards) {
        mCards = cards;
        notifyDataSetChanged();
    }


    public interface CardListClickHandler {
        void onClick(Card card);
    }

    public CardListAdapter(CardListClickHandler clickHandler) {
        //default constructor
        mClickHandler = clickHandler;
    }



}
