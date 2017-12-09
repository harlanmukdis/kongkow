package suryakancana.kongkow.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by LIMS on 09/12/2017.
 */
class CalendarUtils {
    @Throws(ParseException::class)
    fun parseDate(date: String, format: String): Calendar {
        val lCalendar = Calendar.getInstance()
        val formatter = SimpleDateFormat(format)
        lCalendar.setTime(formatter.parse(date))
        return lCalendar
    }

    // get month name. Indonesian locale
    fun getMonthName(month: Int): String {
        val months = arrayOf("JAN", "FEB", "MAR", "APR", "MEI", "JUN", "JUL", "AUG", "SEPT", "OKT", "NOV", "DES")
        return months[month]
    }

    // get day name. Indonesian locale
    fun getDayName(dayOfWeek: Int): String {
        val days = arrayOf("Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu")
        return days[dayOfWeek]
    }
}