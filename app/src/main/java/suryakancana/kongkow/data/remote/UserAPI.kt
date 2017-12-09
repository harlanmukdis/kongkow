package suryakancana.kongkow.data.remote

import io.reactivex.Maybe
import suryakancana.kongkow.data.remote.constracts.CRUDContract
import suryakancana.kongkow.models.User






/**
 * Created by LIMS on 09/12/2017.
 */
class UserAPI : BaseAPI(), CRUDContract<User, Int> {
    override fun getList(): Maybe<List<User>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun create(obj: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun read(id: Int): Maybe<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(obj: User, id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}