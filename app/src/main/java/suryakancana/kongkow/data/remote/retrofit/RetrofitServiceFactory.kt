package suryakancana.kongkow.data.remote.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import suryakancana.kongkow.data.DataManager


/**
 * Created by LIMS on 09/12/2017.
 */
public class RetrofitServiceFactory {
    // TODO: define your own base url
    private val BASE_URL = "https://jsonplaceholder.typicode.com"
    private val httpClient = OkHttpClient.Builder()
    private val gson = GsonBuilder().registerTypeAdapterFactory(DataTypeAdapterFactory()).create()
    private val sBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))

    var sRetrofit: Retrofit? = null

    fun <S> createService(serviceClass: Class<S>): S {
        var sRetrofit: Retrofit? = null
        val authHeader: String
        if (DataManager().can().getUserToken() != null) {
            authHeader = "Bearer " + DataManager().can().getUserToken()
        } else {
            authHeader = ""
        }

        httpClient.addInterceptor(ResponseInterceptor())
        //add authorization header
        httpClient.addInterceptor { chain ->
            val lOriginalRequest = chain.request()
            val lRequest = lOriginalRequest.newBuilder().header("Authorization", authHeader)
                    .method(lOriginalRequest.method(), lOriginalRequest.body()).build()

            chain.proceed(lRequest)
        }

        val lClient = httpClient.build()
        sRetrofit = sBuilder.client(lClient).build()
        return sRetrofit.create(serviceClass)
    }
}