package com.bw.dukaibin2020106.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.dukaibin2020106.R;
import com.bw.dukaibin2020106.bean.OneBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QRecyAdapter extends RecyclerView.Adapter<QRecyAdapter.MyViewHolder> {
    List<OneBean> list;

    public QRecyAdapter(List<OneBean> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(View.inflate(parent.getContext(), R.layout.rr, null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        OneBean oneBean = list.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itlmClickListener.getItlmClickListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rr_tt)
        TextView rrTt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
 public    OnItlmClickListener itlmClickListener;

    public void setItlmClickListener(OnItlmClickListener itlmClickListener) {
        this.itlmClickListener = itlmClickListener;
    }

    public interface OnItlmClickListener {
        void getItlmClickListener(int i);
    }
}
