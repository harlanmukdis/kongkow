package suryakancana.kongkow

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.location.Location
import android.net.ConnectivityManager
import com.google.android.gms.common.api.GoogleApiClient
import com.orhanobut.hawk.Hawk
import suryakancana.kongkow.data.remote.retrofit.RetrofitServiceFactory
import suryakancana.kongkow.data.remote.retrofit.ServicesAPI


/**
 * Created by LIMS on 09/12/2017.
 */
public class KongkowApp : Application() {

    private var sApp: KongkowApp? = null
    var mServiceAPI: ServicesAPI? = null
    var mGoogleApiClient: GoogleApiClient? = null
    var mLastLocation: Location? = null

    fun getInstance(): KongkowApp {
        if (sApp == null) {
            sApp = KongkowApp()
        }

        return sApp as KongkowApp
    }

    override fun onCreate() {
        super.onCreate()

        sApp = this
        mServiceAPI = RetrofitServiceFactory().createService(ServicesAPI::class.java)
        Hawk.init(applicationContext).build()
    }

    @SuppressLint("MissingPermission")
    fun isNetworkAvailable(): Boolean {
        val lConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val lNetworkInfo = lConnectivityManager.activeNetworkInfo
        return lNetworkInfo != null && lNetworkInfo.isConnected
    }
}