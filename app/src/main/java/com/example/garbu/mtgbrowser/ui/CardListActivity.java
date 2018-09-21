package com.example.garbu.mtgbrowser.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;


import com.example.garbu.mtgbrowser.CardsViewModel;
import com.example.garbu.mtgbrowser.CardsViewModelFactory;
import com.example.garbu.mtgbrowser.R;
import com.example.garbu.mtgbrowser.adapters.CardListAdapter;
import com.example.garbu.mtgbrowser.model.Card;
import com.example.garbu.mtgbrowser.model.CardList;
import com.example.garbu.mtgbrowser.model.Set;
import com.example.garbu.mtgbrowser.remote.MTGInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CardListActivity extends AppCompatActivity implements CardListAdapter.CardListClickHandler{
    Set mSelectedSet;
    List <Card> mCards = new ArrayList<>();
    private RecyclerView cardsRV;
    private CardListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            if (intent == null) {
                finish();
            }

            mSelectedSet = intent.getParcelableExtra(MainActivity.SELECTED_SET_EXTRA);
        }

        final CardsViewModel cardsViewModel = ViewModelProviders.of(this, new CardsViewModelFactory(this.getApplication(),mSelectedSet.getCode())).get(CardsViewModel.class);

        //setup RV
        cardsRV= findViewById(R.id.card_grid_rv);
        mLayoutManager = new GridLayoutManager(this,2);
        cardsRV.setLayoutManager(mLayoutManager);

        mAdapter= new CardListAdapter(this);
        cardsRV.setAdapter(mAdapter);
        cardsRV.setHasFixedSize(true);
        readDB(cardsViewModel);

        //Retrofit code

/*        MTGInterface mtgInterface = MTGInterface.retrofit.create(MTGInterface.class);
        Call<CardList> call = mtgInterface.getCards(mSelectedSet.getCode(),1);
        //make an asynchronous API call to get recipe data from web resource
        call.enqueue(new Callback<CardList>() {
            @Override
            public void onResponse(Call<CardList> call, Response<CardList> response) {
                if (response.isSuccessful()) {
                    mCards = response.body().getCards();
                    mAdapter.setCards(mCards);
                } else {
                    int statusCode = response.code();
                    Log.d("retrofit", "error" + statusCode);
                }
            }

            @Override
            public void onFailure(Call<CardList> call, Throwable t) {
                Toast.makeText(CardListActivity.this, "There was an error connecting to retrieve the cards for this set", Toast.LENGTH_LONG).show();
            }
        });*/
    }

    public void readDB(CardsViewModel cardsViewModel){

        cardsViewModel.getCards().observe(this, new Observer<List<Card>>() {
            @Override
            public void onChanged(@Nullable List<Card> cards) {
                mAdapter.setCards(cards);
            }
        });
    }

    @Override
    public void onClick(Card card) {

    }
}
