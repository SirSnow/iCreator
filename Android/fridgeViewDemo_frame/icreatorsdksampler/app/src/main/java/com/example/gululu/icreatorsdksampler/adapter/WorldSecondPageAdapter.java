package com.example.gululu.icreatorsdksampler.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gululu.icreatorsdksampler.R;
import com.example.gululu.icreatorsdksampler.activity.ShowActivity;
import com.example.gululu.icreatorsdksampler.activity.WorldSecondPage;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Haku Hal on 2016/1/13.
 */
public class WorldSecondPageAdapter extends RecyclerView.Adapter<WorldSecondPageAdapter.WorldHolder> {

    private LayoutInflater mLayoutInflater;
    private Intent mIntent;


    /**
     * 传入的context和map的列表
     */
    private Context mContext;
    private List<String> mList;

    public WorldSecondPageAdapter(List<String> list, Context context) {
        mList = list;
        mContext = context;
        mLayoutInflater= LayoutInflater.from(context);
    }

   //导入collect item的功能
    @Override
    public WorldHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WorldHolder(mLayoutInflater.inflate(R.layout.item_world_model,null));
    }

    @Override
    public void onBindViewHolder(final WorldHolder holder, final int position) {
        /*数据的传入，之后肯定要做从网络数据得到的过程*/
        holder.txtModelName.setText(mList.get(position).toString());
        /*点击跳转*/
        holder.mLinearLayoutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转网页
                mIntent=new Intent(mContext, ShowActivity.class);

            }
        });


    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public static class WorldHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.txt_world__model_name)
        TextView txtModelName;
        @Bind(R.id.iv_world_model)
        ImageButton mLinearLayoutt;


        public WorldHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }

    }

   /* private void animatePhoto(PhotoViewHolder viewHolder) {
        if (!lockedAnimations) {
            if (lastAnimatedItem == viewHolder.getPosition()) {
                setLockedAnimations(true);
            }

            long animationDelay = PHOTO_ANIMATION_DELAY + viewHolder.getPosition() * 30;

            viewHolder.flRoot.setScaleY(0);
            viewHolder.flRoot.setScaleX(0);

            viewHolder.flRoot.animate()
                    .scaleY(1)
                    .scaleX(1)
                    .setDuration(200)
                    .setInterpolator(INTERPOLATOR)
                    .setStartDelay(animationDelay)
                    .start();
        }
    }*/
}
