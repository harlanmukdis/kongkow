package suryakancana.kongkow.data.remote.constracts

import io.reactivex.Maybe
import suryakancana.kongkow.models.User





/**
 * Created by LIMS on 09/12/2017.
 */
interface CRUDContract<T, U> {
    fun getList(): Maybe<List<User>>

    fun create(obj: T)

    fun read(id: U): Maybe<User>

    fun update(obj: T, id: U)

    fun delete(id: U)
}