package com.cy.recyclerviewadapter.activity.vr;

import android.os.Bundle;
import android.view.View;

import com.cy.cyrvadapter.adapter.RVAdapter;
import com.cy.cyrvadapter.recyclerview.VerticalRecyclerView;
import com.cy.recyclerviewadapter.BaseActivity;
import com.cy.recyclerviewadapter.R;
import com.cy.recyclerviewadapter.bean.VRHeadFootBean;

import java.util.ArrayList;
import java.util.List;

public class VRHeadFootActivity extends BaseActivity {

    private RVAdapter<VRHeadFootBean> rvAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vr);

        List<VRHeadFootBean> list = new ArrayList<>();
        for (int i=0;i<100;i++){
            list.add(new VRHeadFootBean("内容"+i));
        }
        rvAdapter=new RVAdapter<VRHeadFootBean>(list,true,true) {
            @Override
            public void bindDataToHeadView(RVViewHolder holder) {
                super.bindDataToHeadView(holder);
                holder.setText(R.id.tv,"head傻逼");
            }

            @Override
            public void bindDataToFootView(RVViewHolder holder) {
                super.bindDataToFootView(holder);
                holder.setText(R.id.tv,"foot傻逼");

            }

            @Override
            public void bindDataToView(RVViewHolder holder, int position, VRHeadFootBean bean, boolean isSelected) {
                holder.setText(R.id.tv, bean.getStr());

            }

            @Override
            public int getItemLayoutID(int position, VRHeadFootBean bean) {
                if (position==0){
                    return R.layout.head;

                }
                if (position==getItemCount()-1){
                    return R.layout.foot;

                }
                return R.layout.item_rv;

            }

            @Override
            public void onItemClick(int position, VRHeadFootBean bean) {

                showToast("点击"+position);
            }

            @Override
            public void onHeadClick() {
                showToast("点击head");

            }

            @Override
            public void onFootClick() {
                super.onFootClick();
                showToast("点击foot");

            }
        };
        ((VerticalRecyclerView) findViewById(R.id.vr)).setAdapter(rvAdapter);

    }

    @Override
    public void onClick(View v) {

    }
}
