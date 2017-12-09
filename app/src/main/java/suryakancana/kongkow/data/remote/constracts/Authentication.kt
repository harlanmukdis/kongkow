package suryakancana.kongkow.data.remote.constracts

import com.google.gson.JsonObject
import io.reactivex.Maybe



/**
 * Created by LIMS on 09/12/2017.
 */
interface Authentication {
    fun login(id: String, password: String): Maybe<JsonObject>

    fun logout()

    fun forgotPassword(id: String): Maybe<JsonObject>
}