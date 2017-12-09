package suryakancana.kongkow.data.remote.retrofit

import android.content.Context
import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import suryakancana.kongkow.KongkowApp
import java.io.IOException

/**
 * Created by LIMS on 09/12/2017.
 */
class ResponseInterceptor : Interceptor {
    private var mApplication: KongkowApp? = null
    private var mContext: Context? = null

    constructor() {
        mApplication = KongkowApp().getInstance()
        mContext = null
    }

    constructor(context: Context) {
        mApplication = KongkowApp().getInstance()
        mContext = context
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val lResponse = chain.proceed(chain.request())
        // TODO: implement your intercept logic below

        if (lResponse.code() === 401) {
            // unauthorized
            Log.d("interceptor", "401")
        } else if (lResponse.code() === 403) {
            // forbidden
            Log.d("interceptor", "403")
        } else if (lResponse.code() === 404) {
            // endpoint not found
            Log.d("interceptor", "404")
        } else if (lResponse.code() === 500) {
            // internal server error
            Log.d("interceptor", "500")
        } else if (lResponse.code() === 502) {
            // bad gateway
            Log.d("interceptor", "502")
        } else if (lResponse.code() === 503) {
            // service unavailable
            Log.d("interceptor", "503")
        } else if (lResponse.code() === 504) {
            // gateway timeout
            Log.d("interceptor", "504")
        }

        return lResponse
    }
}