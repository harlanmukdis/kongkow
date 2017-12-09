package suryakancana.kongkow.views.activities

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationServices
import pub.devrel.easypermissions.EasyPermissions
import suryakancana.kongkow.KongkowApp





/**
 * Created by LIMS on 09/12/2017.
 */
abstract class BaseActivity : AppCompatActivity(),
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    val  mKongkowApp = KongkowApp().getInstance();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (mKongkowApp.mGoogleApiClient != null) {
            mKongkowApp.mGoogleApiClient!!.connect() //try to reconnect on new activity
        }
    }

    @SuppressLint("MissingPermission")
    override fun onConnected(@Nullable bundle: Bundle?) {
        //check for location permission
        if (EasyPermissions.hasPermissions(applicationContext, Manifest.permission.ACCESS_FINE_LOCATION)) {
            mKongkowApp.mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mKongkowApp.mGoogleApiClient)
        }

    }

    override fun onConnectionSuspended(i: Int) {
        // TODO: add warning on connection suspended
    }

    override fun onConnectionFailed(@NonNull result: ConnectionResult) {
        // TODO: add error message on connection failed
    }

    fun initLocationDetection() {
        if (mKongkowApp.mGoogleApiClient == null) {
            //check for location permission
            if (EasyPermissions.hasPermissions(applicationContext, Manifest.permission.ACCESS_FINE_LOCATION)) {
                mKongkowApp.mGoogleApiClient = GoogleApiClient.Builder(this).addConnectionCallbacks(this)
                        .addOnConnectionFailedListener(this)
                        .addApi(LocationServices.API)
                        .build()
            }
        } else {
            mKongkowApp.mGoogleApiClient!!.connect()
        }
    }
}