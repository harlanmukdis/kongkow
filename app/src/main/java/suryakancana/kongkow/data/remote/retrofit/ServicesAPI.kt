package suryakancana.kongkow.data.remote.retrofit

import com.google.gson.JsonObject
import io.reactivex.Maybe
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url
import suryakancana.kongkow.models.User



/**
 * Created by LIMS on 09/12/2017.
 */
interface ServicesAPI {

    @get:GET("users/")
    val users: Maybe<List<User>>

    @GET
    fun dynamicRequest(@Url url: String):
            //dynamic URL
            Maybe<JsonObject>

    /*
    * below are dummy URLs. Please change it into your API endpoints
    * TODO: replace below URLs with your own
    */

    @GET("users/{id}")
    fun login(@Path("id") id: String): Maybe<JsonObject>

    @GET("users/{id}")
    fun forgotPassword(@Path("id") id: String): Maybe<JsonObject>

    @GET("users/{id}")
    fun getUser(@Path("id") id: String): Maybe<User>

    /* end dummy URLs */

}