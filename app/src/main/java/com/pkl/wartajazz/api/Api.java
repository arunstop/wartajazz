package com.pkl.wartajazz.api;

import com.pkl.wartajazz.models.EventDetail;
import com.pkl.wartajazz.models.EventDetailResponse;
import com.pkl.wartajazz.models.EventResponse;
import com.pkl.wartajazz.models.LoginResponse;
import com.pkl.wartajazz.models.Obj;
import com.pkl.wartajazz.models.SignupResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {


    @FormUrlEncoded
    @POST("Auth/register")
//    @POST("RegisterDevice.php")
    Call<SignupResponse> createUser(
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            @Field("fullname") String fullname,
            @Field("phone") String phone,
            @Field("address") String address,
            @Field("token") String token
    );

    @FormUrlEncoded
    @POST("Auth/edit")
    Call<SignupResponse> editUser(
            @Field("username") String username,
            @Field("fullname") String fullname,
            @Field("password") String password,
            @Field("phone") String phone,
            @Field("address") String address
    );

    @FormUrlEncoded
    @POST("Auth/login")
    Call<LoginResponse> userLogin(
            @Field("username") String username,
            @Field("password") String password,
            @Field("token") String token
    );

    @FormUrlEncoded
    @POST("Auth/googleAuth")
    Call<LoginResponse> googleAuth(
            @Field("providerId") String providerId,
            @Field("email") String email,
            @Field("displayName") String displayName,
            @Field("thumbnail") String thumbnail,
            @Field("token") String token
    );

    @FormUrlEncoded
    @POST("Auth/resetPass")
    Call<LoginResponse> resetPass(
            @Field("email") String email,
            @Field("password") String password,
            @Field("confirm_password") String confirm_password
    );

    @GET("Event")
    Call<EventResponse> showEvent();

    @GET("Event/detail/{event_id}")
    Call<EventDetailResponse> showDetailEvent(@Path("event_id") String event_id);

    @FormUrlEncoded
    @POST("Auth/updateToken")
    Call<LoginResponse> updateToken(
            @Field("username") String username,
            @Field("token") String token
    );


    //WARNING! : Only Call this method using RetrofitRssClient
    @GET("api.json")
    Call<Obj> getFeed(@Query("rss_url") String url);

}
