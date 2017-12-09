package suryakancana.kongkow.models

import com.google.gson.annotations.SerializedName



/**
 * Created by LIMS on 09/12/2017.
 */
class User(@field:SerializedName("id")
           var id: Int, @field:SerializedName("name")
           var name: String, @field:SerializedName("email")
           var email: String)