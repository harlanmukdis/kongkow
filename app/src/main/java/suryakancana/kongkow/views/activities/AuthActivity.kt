package suryakancana.kongkow.views.activities

import android.Manifest
import android.os.Bundle
import android.support.annotation.NonNull
import android.widget.Toast
import pub.devrel.easypermissions.EasyPermissions
import suryakancana.kongkow.R
import suryakancana.kongkow.utils.constants.I
import suryakancana.kongkow.utils.constants.S
import suryakancana.kongkow.views.fragments.BlankFragment
import suryakancana.kongkow.views.fragments.LoginFragment


/**
 * Created by LIMS on 09/12/2017.
 */
class AuthActivity : BaseActivity(), EasyPermissions.PermissionCallbacks {

    var fm = supportFragmentManager
    var ft = fm.beginTransaction()
    var loginFragment = LoginFragment()
    var blankFragment = BlankFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        //request location permission early
        if (!EasyPermissions.hasPermissions(applicationContext, Manifest.permission.ACCESS_FINE_LOCATION)) {
            EasyPermissions
                    .requestPermissions(this@AuthActivity, S.location_permission_message, I.LOCATION_REQUEST_CODE,
                            Manifest.permission.ACCESS_FINE_LOCATION)
        }

        // init first fragment
        ft = fm.beginTransaction()
        ft.add(R.id.fl_fragment_container, blankFragment)
        ft.commit()

    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, @NonNull permissions: Array<String>, @NonNull grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(I.LOCATION_REQUEST_CODE, permissions, grantResults, this)
    }

    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
        if (requestCode == I.LOCATION_REQUEST_CODE) {
            Toast.makeText(applicationContext, R.string.permission_granted, Toast.LENGTH_LONG).show()
            super.initLocationDetection()
        }
    }

    override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {
        if (requestCode == I.LOCATION_REQUEST_CODE) {
            Toast.makeText(applicationContext, R.string.permission_denied, Toast.LENGTH_LONG).show()
        }
    }

}