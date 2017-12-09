package suryakancana.kongkow.views.customviews

import android.content.Context
import android.graphics.Typeface



/**
 * Created by LIMS on 09/12/2017.
 */
object FontCache {
    private val fontCache = HashMap<String, Typeface>()

    fun getTypeface(fontpath: String, context: Context): Typeface? {
        var typeface = fontCache.get(fontpath)

        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), fontpath)
            } catch (e: Exception) {
                return null
            }

            fontCache.put(fontpath, typeface)
        }

        return typeface
    }
}