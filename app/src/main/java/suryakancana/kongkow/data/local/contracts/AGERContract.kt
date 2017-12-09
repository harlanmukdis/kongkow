package suryakancana.kongkow.data.local.contracts

import io.reactivex.Maybe



/**
 * Created by LIMS on 09/12/2017.
 */
interface AGERContract<T, U> {
    val list: Maybe<List<T>>

    operator fun get(id: U): Maybe<T>

    fun addAll(objs: List<T>)

    fun add(obj: T)

    fun edit(obj: T, id: U)

    fun delete(id: U)
}