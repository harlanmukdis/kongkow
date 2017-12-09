package suryakancana.kongkow.data.local

import com.orhanobut.hawk.Hawk
import io.reactivex.Maybe
import suryakancana.kongkow.data.local.contracts.AGERContract
import suryakancana.kongkow.data.local.contracts.CacheContract
import suryakancana.kongkow.models.User
import suryakancana.kongkow.utils.constants.K










/**
 * Created by LIMS on 09/12/2017.
 */
class UserStorage : AGERContract<User, Int>, CacheContract {

    override val isCacheValid: Boolean
        get() = true

    override val list: Maybe<List<User>>
        get() = list

    override fun get(id: Int): Maybe<User> {
        return Maybe.just(if (isCacheValid) Hawk.get(String.format(K.USER_DETAIL, id), User(0, "", "")) else null)
    }

    override fun addAll(objs: List<User>) {
        Hawk.put(K.USER_LIST, objs)
    }

    override fun add(obj: User) {
        Hawk.put(String.format(K.USER_DETAIL, obj.id), obj);
    }

    override fun edit(obj: User, id: Int) {
        Hawk.put(String.format(K.USER_DETAIL, id), obj);
    }

    override fun delete(id: Int) {
        Hawk.delete(String.format(K.USER_DETAIL, id));
    }

    fun getToken(): String {
        return ""
    }
}