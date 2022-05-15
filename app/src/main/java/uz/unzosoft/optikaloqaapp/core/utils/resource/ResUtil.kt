package uz.unzosoft.optikaloqaapp.core.utils.resource

import android.graphics.drawable.Drawable

interface ResUtil {

    fun getColor(id: Int): Int
    fun getString(id: Int): String
    fun getResId(path: String): Int
    fun getIntArray(id: Int): IntArray
    fun getDrawable(id: Int): Drawable?
    fun getDrawableId(name: String): Int
    fun getStringUpperCase(id: Int): String
    fun getStringArray(id: Int): Array<String>
}