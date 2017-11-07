package com.example.root.ewallet.util;

import com.example.root.ewallet.app.login.model.LoginModel;
import com.example.root.ewallet.app.paynow.model.CreatePay_Respose;
import com.example.root.ewallet.app.paynow.model.ModelGet;
import com.example.root.ewallet.app.paynow.model.ModelPost;
import com.example.root.ewallet.common.WalletResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by root on 10/23/17.
 */

public interface ApiService {
    @FormUrlEncoded
    @POST(Constants.LOG_IN)
    Observable<LoginModel> login(@Header("Content-Type") String contentType,
                                 @Header(Constants.X_API_KEY) String apiKey,
                                 @Field("Login") String login,
                                 @Field("Password") String password);

    @GET(Constants.ApiCreateInstantPayment)
    Observable<WalletResponse<ModelGet>> fillpay(@Header(Constants.X_User_Token) String xuserToken,
                                                 @Header(Constants.X_API_KEY) String apiKey);

    @POST(Constants.ApiCreateInstantPayment)
    Observable<CreatePay_Respose> createpay(@Header(Constants.X_User_Token) String xuserToken,
                                            @Header(Constants.X_API_KEY) String apiKey,
                                            @Header("Content-Type") String contentType,
                                            @Body ModelPost post);

}
