package com.bw.dukaibin2020106.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bw.dukaibin2020106.R;
import com.bw.dukaibin2020106.bean.TwoBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpAdapters extends RecyclerView.Adapter<SpAdapters.MyViewHolder> {
    private List<TwoBean.DataBean> list;

    public SpAdapters(List<TwoBean.DataBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(View.inflate(parent.getContext(), R.layout.ll, null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TwoBean.DataBean resultBean = list.get(position);
        holder.llTt.setText(resultBean.getGoods_english_name());
        Glide.with(holder.llIm)
                .load(resultBean.getCurrency_price())
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher_round)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(55)))
                .into(holder.llIm);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ll_im)
        ImageView llIm;
        @BindView(R.id.ll_tt)
        TextView llTt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
