package com.bw.dukaibin2020106.presenter;

import com.bw.dukaibin2020106.base.BasePresenter;
import com.bw.dukaibin2020106.bean.OneBean;
import com.bw.dukaibin2020106.bean.TwoBean;
import com.bw.dukaibin2020106.contract.IContract;
import com.bw.dukaibin2020106.model.HomeModel;

public class HomePresenter extends BasePresenter<IContract.IView> implements IContract.IPresenter {


    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }

    @Override
    public void getDate(String i) {
        homeModel.getDate(i, new IContract.IModel.IModelConback() {
            @Override
            public void HomeSuccess(TwoBean twoBean) {
                view.HomeSuccess(twoBean);
            }

            @Override
            public void HomeFailure(Throwable throwable) {
                view.HomeFailure(throwable);
            }
        });
    }

    @Override
    public void getQuDate() {
        homeModel.getQuDate(new IContract.IModel.IModelQu() {
            @Override
            public void QuerySuccess(OneBean oneBean) {
                view.QuerySuccess(oneBean);
            }

            @Override
            public void QueryFailure(Throwable throwable) {
                view.QueryFailure(throwable);
            }
        });
    }
}
