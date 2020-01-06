package com.bw.dukaibin2020106.contract;

import com.bw.dukaibin2020106.bean.OneBean;
import com.bw.dukaibin2020106.bean.TwoBean;

public class IContract {
    public interface IView {
        void HomeSuccess(TwoBean twoBean);

        void HomeFailure(Throwable throwable);

        void QuerySuccess(OneBean oneBean);

        void QueryFailure(Throwable throwable);
    }

    public interface IPresenter {
        void getDate(String i);

        void getQuDate();
    }

    public interface IModel {
        void getDate(String i, IModelConback iModelConback);

        void getQuDate(IModelQu iModelQu);

        interface IModelConback {
            void HomeSuccess(TwoBean twoBean);

            void HomeFailure(Throwable throwable);

        }

        interface IModelQu {
            void QuerySuccess(OneBean oneBean);

            void QueryFailure(Throwable throwable);

        }
    }
}
