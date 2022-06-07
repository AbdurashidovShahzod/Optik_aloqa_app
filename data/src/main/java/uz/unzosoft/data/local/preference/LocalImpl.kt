package uz.unzosoft.data.local.preference

import android.content.SharedPreferences
import uz.unzosoft.data.di.AppCacheQualifier
import uz.unzosoft.data.util.pref.boolean
import uz.unzosoft.data.util.pref.stringNullable
import javax.inject.Inject


/**
 * Created by Abdurashidov Shahzod on 07/06/22 17:38.
 * company QQBank
 * shahzod9933@gmail.com
 */
class LocalImpl @Inject constructor(
    @AppCacheQualifier var pref: SharedPreferences
) : Local {
    override var isOnBoarding: Boolean by pref.boolean(defaultValue = false)

    override var token: String? by pref.stringNullable("")
}