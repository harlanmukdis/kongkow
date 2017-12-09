package suryakancana.kongkow.views.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.inputmethod.InputMethodManager


/**
 * Created by LIMS on 09/12/2017.
 */
abstract class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /**
     * method used for first UI initialization & manipulation
     */
    internal abstract fun initUI()

    /**
     * method used for first event initialization & manipulation
     */
    internal abstract fun initEvent()

    protected fun hideKeyboard() {
        val view = getActivity().getCurrentFocus()
        if (view != null) {
            (getActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                    .hideSoftInputFromWindow(view!!.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }

}