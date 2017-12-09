package suryakancana.kongkow.utils

import suryakancana.kongkow.models.User



/**
 * Created by LIMS on 09/12/2017.
 */
class DummyDataFactory {
    fun createDummyUsers(): List<User> {
        val lUser = ArrayList<User>()
        for (i in 0..4) {
            lUser.add(User(i, String.format("nama user %d", i), String.format("email%d@email.com", i)))
        }
        return lUser
    }
}