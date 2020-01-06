package com.bw.dukaibin2020106;

import com.bw.dukaibin2020106.bean.OneBean;
import com.bw.dukaibin2020106.bean.TwoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("findCommodityByCategory")
    Observable<TwoBean> commodity(@Query("categoryId") String categoryId, @Query("page") int page, @Query("count") int count);

    @GET("findCategory")
    Observable<OneBean> queryBend();
}
