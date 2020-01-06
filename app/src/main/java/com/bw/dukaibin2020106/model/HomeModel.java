package com.bw.dukaibin2020106.model;

import com.bw.dukaibin2020106.bean.OneBean;
import com.bw.dukaibin2020106.bean.TwoBean;
import com.bw.dukaibin2020106.contract.IContract;
import com.bw.dukaibin2020106.tools.Netutil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.observers.BlockingBaseObserver;
import io.reactivex.schedulers.Schedulers;

public class HomeModel implements IContract.IModel {

    @Override
    public void getDate(String i, IModelConback iModelConback) {
        Netutil.getInstance().getApi().commodity(i, 1, 5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BlockingBaseObserver<TwoBean>() {

                    @Override
                    public void onNext(TwoBean twoBean) {
                        iModelConback.HomeSuccess(twoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelConback.HomeFailure(e);
                    }
                });

    }

    @Override
    public void getQuDate(IModelQu iModelQu) {
        Netutil.getInstance().getApi().queryBend()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BlockingBaseObserver<OneBean>() {
                    @Override
                    public void onNext(OneBean oneBean) {
                        iModelQu.QuerySuccess(oneBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelQu.QueryFailure(e);
                    }
                });
    }
}
