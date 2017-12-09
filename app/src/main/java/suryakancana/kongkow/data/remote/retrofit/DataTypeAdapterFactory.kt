package suryakancana.kongkow.data.remote.retrofit

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.io.IOException


/**
 * Created by LIMS on 09/12/2017.
 */
class DataTypeAdapterFactory : TypeAdapterFactory {
    override fun <T> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T> {
        val lDelegate = gson.getDelegateAdapter(this, type)
        val lElementAdapter = gson.getAdapter(JsonElement::class.java)

        return object : TypeAdapter<T>() {
            @Throws(IOException::class)
            override fun write(out: JsonWriter, value: T) {
                lDelegate.write(out, value)
            }

            @Throws(IOException::class)
            override fun read(`in`: JsonReader): T {
                var lElement = lElementAdapter.read(`in`)
                if (lElement.isJsonObject) {
                    val lObject = lElement.asJsonObject
                    if (lObject.has("data")) {
                        lElement = lObject.get("data")
                    }
                }
                return lDelegate.fromJsonTree(lElement)
            }
        }
    }
}