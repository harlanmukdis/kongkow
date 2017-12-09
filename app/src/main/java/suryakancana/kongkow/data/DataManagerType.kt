package suryakancana.kongkow.data

import com.google.gson.JsonObject
import io.reactivex.Maybe
import suryakancana.kongkow.models.User




/**
 * Created by LIMS on 09/12/2017.
 */
interface DataManagerType {

    fun login(id: String, password: String): Maybe<JsonObject>

    fun logout()

    fun forgotPassword(id: String): Maybe<JsonObject>

    fun getUserList(): Maybe<List<User>>

    fun getUser(id: Int?): Maybe<User>

    fun getUserToken(): String
}