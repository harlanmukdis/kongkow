package suryakancana.kongkow.utils

import android.util.Base64
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.io.UnsupportedEncodingException


/**
 * Created by LIMS on 09/12/2017.
 */
public class JwtUtils {
    fun getJwtToken(payload: String, signatureAlgorithm: SignatureAlgorithm, secretKey: String): String {
        try {
            return Jwts.builder()
                    .setPayload(payload)
                    .signWith(signatureAlgorithm, secretKey.toByteArray(charset("UTF-8")))
                    .compact()
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
            return ""
        }

    }

    fun getBase64JwtToken(payload: String, signatureAlgorithm: SignatureAlgorithm, secretKey: String): String {
        try {
            return Jwts.builder()
                    .setPayload(payload)
                    .signWith(signatureAlgorithm, Base64.encodeToString(secretKey.toByteArray(charset("UTF-8")), Base64.DEFAULT))
                    .compact()
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
            return ""
        }

    }
}