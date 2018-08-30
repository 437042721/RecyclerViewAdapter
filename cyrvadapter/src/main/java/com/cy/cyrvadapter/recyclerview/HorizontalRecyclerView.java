package com.cy.cyrvadapter.recyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by cy on 2017/7/2.
 */

public class HorizontalRecyclerView extends RecyclerView {
    private Context context;
    public HorizontalRecyclerView(Context context) {
        this(context, null);
    }

    public HorizontalRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);


        this.context=context;
        setOverScrollMode(OVER_SCROLL_NEVER);

    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        setLayoutManager(linearLayoutManager);

        addOnScrollListener(new OnCYScrollListener(context));


    }
    public void setAdapter(Adapter adapter, OnRVScrollListener onRVScrollListener){
        setAdapter(adapter);

        setOnScrollListener(onRVScrollListener);
    }


}
