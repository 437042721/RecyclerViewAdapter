package com.cy.cyrvadapter.refreshrv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.cy.cyrvadapter.recyclerview.OnRVScrollListener;
import com.cy.cyrvadapter.recyclerview.VerticalRecyclerView;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;

/**
 * Created by lenovo on 2017/12/31.
 */

public class VerticalRefreshLayout extends BaseRefreshLayout {
    private Context context;
    private VerticalRecyclerView verticalRecyclerView;

    public VerticalRefreshLayout(Context context) {
        super(context);
    }

    public VerticalRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        verticalRecyclerView = new VerticalRecyclerView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        verticalRecyclerView.setLayoutParams(layoutParams);
        addView(verticalRecyclerView);
    }

    public VerticalRecyclerView getRV() {
        return verticalRecyclerView;
    }
    public void setAdapter(RecyclerView.Adapter adapter) {
        verticalRecyclerView.setAdapter(adapter);
    }
    public void setAdapter(RecyclerView.Adapter adapter, int color,RefreshListenerAdapter refreshListenerAdapter){
        verticalRecyclerView.setAdapter(adapter, new OnRVScrollListener() {
            @Override
            public void rvStartLoadMore() {
                startLoadMore();
            }
            @Override
            public void onGlideShouldPauseRequests() {
                Glide.with(context).pauseRequests();

            }

            @Override
            public void onGlideShouldResumeRequests() {
                Glide.with(context).resumeRequests();

            }
        });
        setOnRefreshListener(refreshListenerAdapter,color);
    }
    public void setAdapter(RecyclerView.Adapter adapter,int color, OnCYRefreshListener onCYRefreshListener){
        verticalRecyclerView.setAdapter(adapter);
        setOnCYRefreshListener(onCYRefreshListener,color);
    }
    public void setAdapter(RecyclerView.Adapter adapter,int color, OnCYLoadMoreLister onCYLoadMoreLister){
        verticalRecyclerView.setAdapter(adapter, new OnRVScrollListener() {
            @Override
            public void rvStartLoadMore() {
                startLoadMore();
            }
            @Override
            public void onGlideShouldPauseRequests() {
                Glide.with(context).pauseRequests();

            }

            @Override
            public void onGlideShouldResumeRequests() {
                Glide.with(context).resumeRequests();

            }
        });
        setOnCYLoadMoreLister(onCYLoadMoreLister,color);
    }
}
