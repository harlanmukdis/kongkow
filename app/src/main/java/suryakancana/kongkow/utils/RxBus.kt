package suryakancana.kongkow.utils

import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.subjects.PublishSubject



/**
 * Created by LIMS on 09/12/2017.
 */
class RxBus {
    private val bus = PublishSubject.create<Any>()

    fun send(@NonNull o: Any) {
        bus.onNext(o)
    }

    //when activity destroyed, disposable is also removed
    fun subscribe(@NonNull action: Consumer<Any>): Disposable {
        return bus.subscribe(action)
    }

    fun hasObservers(): Boolean {
        return bus.hasObservers()
    }

}