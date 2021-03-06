package com.xyoye.dandanplay.net;

import com.xyoye.dandanplay.bean.AnimeBeans;
import com.xyoye.dandanplay.bean.AnimeDetailBean;
import com.xyoye.dandanplay.bean.AnimeFavoriteBean;
import com.xyoye.dandanplay.bean.BannerBeans;
import com.xyoye.dandanplay.bean.DanmuDownloadBean;
import com.xyoye.dandanplay.bean.DanmuMatchBean;
import com.xyoye.dandanplay.bean.PersonalBean;
import com.xyoye.dandanplay.bean.PlayHistoryBean;
import com.xyoye.dandanplay.bean.RegisterBean;
import com.xyoye.dandanplay.bean.UploadDanmuBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by YE on 2018/7/9.
 */


public interface RetrofitService {

    @FormUrlEncoded
    @POST("api/v2/match")
    Observable<DanmuMatchBean> matchDanmu(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("api/v2/comment/{episodeId}")
    Observable<UploadDanmuBean> uploadDanmu(@FieldMap Map<String, String> params, @Path("episodeId") String episodeId);

    @GET("api/v2/comment/{episodeId}?withRelated=true")
    Observable<DanmuDownloadBean> downloadDanmu(@Path("episodeId") String episodeId);

    @GET("api/v2/homepage/banner")
    Observable<BannerBeans> getBanner();

    @GET("api/v2/bangumi/shin")
    Observable<AnimeBeans> getAnimes();

    @GET("api/v2/bangumi/{animeId}")
    Observable<AnimeDetailBean> getAnimaDetail(@Path("animeId") String animaId);

    @FormUrlEncoded
    @POST("api/v2/login")
    Observable<PersonalBean> login(@FieldMap Map<String, String> params);

    @GET("api/v2/login/renew")
    Observable<PersonalBean> reToken();

    @GET("api/v2/favorite")
    Observable<AnimeFavoriteBean> getFavorite();

    @GET("/api/v2/playhistory")
    Observable<PlayHistoryBean> getPlayHistory();

    @FormUrlEncoded
    @POST("/api/v2/favorite")
    Observable<CommJsonEntity> addFavorite(@FieldMap Map<String, String> params);

    @DELETE("/api/v2/favorite/{animeId}")
    Observable<CommJsonEntity> reduceFavorite(@Path("animeId") String animaId);

    @FormUrlEncoded
    @POST("/api/v2/register")
    Observable<RegisterBean> register(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("/api/v2/user/password")
    Observable<CommJsonEntity> changePassword(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("/api/v2/register/resetpassword")
    Observable<CommJsonEntity> resetPassword(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("/api/v2/user/profile")
    Observable<CommJsonEntity> changeScreenName(@Field("screenName") String screenName);
}
