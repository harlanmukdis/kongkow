package suryakancana.kongkow.data

import com.google.gson.JsonObject
import io.reactivex.Maybe
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

    override val userList: Maybe<List<User>>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val userToken: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun login(id: String, password: String): Maybe<JsonObject> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun logout() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun forgotPassword(id: String): Maybe<JsonObject> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUser(id: Int?): Maybe<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}