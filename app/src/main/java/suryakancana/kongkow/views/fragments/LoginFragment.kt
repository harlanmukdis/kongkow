package suryakancana.kongkow.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.gson.JsonObject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.fragment_login.view.*
import suryakancana.kongkow.R
import suryakancana.kongkow.data.DataManager
import suryakancana.kongkow.utils.RetrofitErrorAdapter




/**
 * Created by LIMS on 09/12/2017.
 */
class LoginFragment : BaseFragment() {

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


        val email = mView.loginEtEmail.text
        val password = mView.loginEtPassword.text

        mView.loginBtnLogin.setOnClickListener {
            submitLogin(email.toString(), password.toString())
        }

        return mView
    }

    override fun initUI() {
    }

    override fun initEvent() {
    }

    fun getToas(message : String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    private fun submitLogin(email : String, password : String) {
        DataManager().can().login(email, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer<JsonObject> { getToas("Success") }, Consumer<Throwable> { throwable ->
                    val error = RetrofitErrorAdapter(throwable)
                    getToas(error.toString())
                })
    }

}
