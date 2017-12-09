package suryakancana.kongkow.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import suryakancana.kongkow.R


/**
 * Created by LIMS on 09/12/2017.
 */
public class LoginFragment : BaseFragment() {

    private var mView : View? = null

    fun LoginFragment() {
        // Required empty public constructor
        arguments = Bundle()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val mView = LayoutInflater.from(context).inflate(R.layout.fragment_login, container, false)

        initUI()
        initEvent()

        return mView
    }

    override fun initUI() {
    }

    override fun initEvent() {
    }

}
