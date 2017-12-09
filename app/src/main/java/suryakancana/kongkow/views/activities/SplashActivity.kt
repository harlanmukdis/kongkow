package suryakancana.kongkow.views.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import suryakancana.kongkow.utils.constants.I


/**
 * Created by LIMS on 09/12/2017.
 */
class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //wait time, simulate any data that you need to fetch before going into main activities
        Handler().postDelayed(Runnable {
            val mainIntent = Intent(this@SplashActivity, AuthActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, I.SPLASH_DISPLAY_LENGTH.toLong())
    }
}