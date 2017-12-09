package suryakancana.kongkow.data

import com.google.gson.JsonObject
import io.reactivex.Maybe
import io.reactivex.functions.Consumer
import suryakancana.kongkow.data.local.UserStorage
import suryakancana.kongkow.data.remote.AuthAPI
import suryakancana.kongkow.data.remote.UserAPI
import suryakancana.kongkow.models.User








/**
 * Created by LIMS on 09/12/2017.
 */
 class DataManager : DataManagerType {

    private var dm: DataManager? = null

    fun can() // or use, or call (?)
            : DataManager {
        if (dm == null) {
            dm = DataManager()
        }
        return dm as DataManager
    }

    private val sAuthAPI = AuthAPI()
    private val sUserAPI = UserAPI()
    private val sUserStorage = UserStorage()

    override fun login(id: String, password: String): Maybe<JsonObject> {
        return sAuthAPI.login(id, password)
    }

    override fun logout() {
        sAuthAPI.logout()
    }

    override fun forgotPassword(id: String): Maybe<JsonObject> {
        return sAuthAPI.forgotPassword(id)
    }

    override fun getUserList(): Maybe<List<User>> {
        return Maybe.concat(sUserStorage.list, sUserAPI.getList().doOnSuccess(object : Consumer<List<User>> {
            @Throws(Exception::class)
            override fun accept(users: List<User>) {
                sUserStorage.addAll(users)
            }
        })).firstElement()
    }

    override fun getUser(id: Int?): Maybe<User> {
        return Maybe.concat(sUserStorage.get(id!!), sUserStorage.get(id).doOnSuccess { user -> sUserStorage.add(user) }).firstElement()
    }

    override fun getUserToken(): String {
        return sUserStorage.getToken()
    }

}