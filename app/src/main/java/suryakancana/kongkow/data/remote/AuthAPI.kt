package suryakancana.kongkow.data.remote

import com.google.gson.JsonObject
import io.reactivex.Maybe
import suryakancana.kongkow.data.remote.constracts.Authentication


/**
 * Created by LIMS on 09/12/2017.
 */
class AuthAPI : BaseAPI(), Authentication {

    override fun forgotPassword(id: String): Maybe<JsonObject> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun login(id: String, password: String): Maybe<JsonObject> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun logout() {}
}