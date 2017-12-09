package suryakancana.kongkow.data.local

import io.reactivex.Maybe
import suryakancana.kongkow.data.local.contracts.AGERContract
import suryakancana.kongkow.data.local.contracts.CacheContract
import suryakancana.kongkow.models.User


/**
 * Created by LIMS on 09/12/2017.
 */
class UserStorage : AGERContract<User, Int>, CacheContract {
    override val isCacheValid: Boolean
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val list: Maybe<List<User>>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun addAll(objs: List<User>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun add(obj: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(id: Int): Maybe<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun edit(obj: User, id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}