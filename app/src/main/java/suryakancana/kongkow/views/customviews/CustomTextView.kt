package suryakancana.kongkow.views.customviews

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import suryakancana.kongkow.R


/**
 * Created by LIMS on 09/12/2017.
 */
class CustomTextView : TextView {

    constructor(context: Context) : super(context) {
        applyCustomFont(context, "font/Roboto-Regular.ttf") // default font
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        applyCustomFont(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        applyCustomFont(context, attrs)
    }

    fun applyCustomFont(context: Context, fontPath: String) {
        val customFont = FontCache.getTypeface(fontPath, context)
        typeface = customFont
    }

    fun applyCustomFont(context: Context, attrs: AttributeSet) {
        var fontPath: String? = "font/Roboto-Regular.ttf"
        val temp = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTextView, 0, 0)
        try {
            fontPath = temp.getString(R.styleable.CustomTextView_fontPath)
        } finally {
            applyCustomFont(context, fontPath!!)
            temp.recycle()
        }
    }
}