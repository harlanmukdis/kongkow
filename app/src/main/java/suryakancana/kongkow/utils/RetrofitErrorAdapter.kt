package suryakancana.kongkow.utils

import com.google.gson.JsonObject
import retrofit2.adapter.rxjava2.HttpException
import java.io.IOException


/**
 * Created by LIMS on 09/12/2017.
 */
public class RetrofitErrorAdapter {
    private var error: Throwable? = null
    private var errorResponse: JsonObject? = null
    private var message: String? = null

    // constant variable. feel free to move these to S.java
    private val messageKey = "message"
    private val ioErrorMessage = "Input Output Error. Please Try Again"
    private val unknownErrorMessage = "Unknown Error. Please Try Again"

    fun convert() = if (error is HttpException) {
        val lHttpException = error as HttpException
        val lResponse = lHttpException.response()
//        val lConverter = RetrofitServiceFactory().sRetrofit!!.responseBodyConverter(JsonObject::class.java, arrayOfNulls<Annotation>(0))
        try {
            //errorResponse = lConverter.convert(lResponse.errorBody())
            message = String.valueOf(if (errorResponse!!.get(messageKey) == null) unknownErrorMessage else errorResponse!!.get(messageKey))
        } catch (e: IOException) {
            e.printStackTrace()
        }

    } else if (error is IOException) {
        message = ioErrorMessage
    } else {
        message = unknownErrorMessage
    }

    private fun String.Companion.valueOf(any: Any?): String? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun RetrofitErrorAdapter(error: Throwable) {
        this.error = error
        this.convert()
    }

    fun getError(): Throwable? {
        return error
    }

    fun getErrorResponse(): JsonObject? {
        return errorResponse
    }

    fun getMessage(): String? {
        return message
    }

    constructor(throwable: Throwable)
}

