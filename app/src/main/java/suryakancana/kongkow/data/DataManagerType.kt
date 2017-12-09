package suryakancana.kongkow.data

import com.google.gson.JsonObject
import io.reactivex.Maybe
import suryakancana.kongkow.models.User


/**
 * Created by LIMS on 09/12/2017.
 */
interface DataManagerType {

    val userList: Maybe<List<User>>

    val userToken: String
    /**
     * IMPORTANT !
     * ALL METHODS INSIDE DATAMANAGER MUST BE DEFINED HERE.
     * GROUP THE METHODS BASED ON THE MODULE.
     */

    fun login(id: String, password: String): Maybe<JsonObject>

    fun logout()

    fun forgotPassword(id: String): Maybe<JsonObject>

    fun getUser(id: Int?): Maybe<User>
}