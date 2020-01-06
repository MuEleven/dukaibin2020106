package com.bw.dukaibin2020106.view;

import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.dukaibin2020106.R;
import com.bw.dukaibin2020106.adapter.QRecyAdapter;
import com.bw.dukaibin2020106.adapter.SpAdapters;
import com.bw.dukaibin2020106.base.BaseActivity;
import com.bw.dukaibin2020106.bean.OneBean;
import com.bw.dukaibin2020106.bean.TwoBean;
import com.bw.dukaibin2020106.contract.IContract;
import com.bw.dukaibin2020106.presenter.HomePresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<HomePresenter> implements IContract.IView {


    @BindView(R.id.m_qRecyclerView)
    RecyclerView mQRecyclerView;
    @BindView(R.id.m_sRecyclerView)
    RecyclerView mSRecyclerView;

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initDate() {
        mPresenter.getQuDate();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected HomePresenter protectedPresenter() {
        return new HomePresenter();
    }

    @Override
    public void HomeSuccess(TwoBean twoBean) {
        Log.e("TAG", "HomeSuccess: "+twoBean);
        List<TwoBean.DataBean> list = twoBean.getData();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mSRecyclerView.setLayoutManager(gridLayoutManager);
        SpAdapters spAdapters = new SpAdapters(list);
        mSRecyclerView.setAdapter(spAdapters);
    }

    @Override
    public void HomeFailure(Throwable throwable) {
        Toast.makeText(this, "00" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void QuerySuccess(OneBean oneBean) {

        mQRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void QueryFailure(Throwable throwable) {
        Toast.makeText(this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }
    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void getString(String s){
        mPresenter.getDate(s);
    }
}
