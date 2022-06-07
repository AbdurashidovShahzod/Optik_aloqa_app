package uz.unzosoft.data.util.pref

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


fun SharedPreferences.string(
    defaultValue: String = "",
    key: (KProperty<*>) -> String = KProperty<*>::name
): ReadWriteProperty<Any, String> = object : ReadWriteProperty<Any, String> {
    override fun getValue(
        thisRef: Any,
        property: KProperty<*>
    ): String = getString(key(property).camelToSnakeCase(), defaultValue) ?: defaultValue

    override fun setValue(
        thisRef: Any,
        property: KProperty<*>,
        value: String
    ): Unit = edit().putString(key(property).camelToSnakeCase(), value).apply()
}

fun SharedPreferences.stringNullable(
    defaultValue: String? = null,
    key: (KProperty<*>) -> String = KProperty<*>::name
): ReadWriteProperty<Any, String?> = object : ReadWriteProperty<Any, String?> {
    override fun getValue(
        thisRef: Any,
        property: KProperty<*>
    ) = getString(key(property).camelToSnakeCase(), defaultValue)

    override fun setValue(
        thisRef: Any,
        property: KProperty<*>,
        value: String?
    ) = edit().putString(key(property).camelToSnakeCase(), value).apply()
}

fun SharedPreferences.int(
    defaultValue: Int = 0,
    key: (KProperty<*>) -> String = KProperty<*>::name
): ReadWriteProperty<Any, Int> = object : ReadWriteProperty<Any, Int> {
    override fun getValue(
        thisRef: Any,
        property: KProperty<*>
    ) = getInt(key(property).camelToSnakeCase(), defaultValue)

    override fun setValue(
        thisRef: Any,
        property: KProperty<*>,
        value: Int
    ): Unit = edit().putInt(key(property).camelToSnakeCase(), value).apply()
}

fun SharedPreferences.float(
    defaultValue: Float = 0f,
    key: (KProperty<*>) -> String = KProperty<*>::name
): ReadWriteProperty<Any, Float> = object : ReadWriteProperty<Any, Float> {
    override fun getValue(
        thisRef: Any,
        property: KProperty<*>
    ) = getFloat(key(property).camelToSnakeCase(), defaultValue)

    override fun setValue(
        thisRef: Any,
        property: KProperty<*>,
        value: Float
    ): Unit = edit().putFloat(key(property).camelToSnakeCase(), value).apply()
}


fun SharedPreferences.double(
    defaultValue: Double = 0.0,
    key: (KProperty<*>) -> String = KProperty<*>::name
): ReadWriteProperty<Any, Double> = object : ReadWriteProperty<Any, Double> {
    override fun getValue(
        thisRef: Any,
        property: KProperty<*>
    ): Double = getString(key(property).camelToSnakeCase(), defaultValue.toString())?.toDouble()
        ?: defaultValue

    override fun setValue(
        thisRef: Any,
        property: KProperty<*>,
        value: Double
    ): Unit = edit().putString(key(property).camelToSnakeCase(), value.toString()).apply()
}

fun SharedPreferences.boolean(
    defaultValue: Boolean = false,
    key: (KProperty<*>) -> String = KProperty<*>::name
): ReadWriteProperty<Any, Boolean> = object : ReadWriteProperty<Any, Boolean> {
    override fun getValue(
        thisRef: Any,
        property: KProperty<*>
    ): Boolean = getBoolean(key(property).camelToSnakeCase(), defaultValue)

    override fun setValue(
        thisRef: Any,
        property: KProperty<*>,
        value: Boolean
    ): Unit = edit().putBoolean(key(property).camelToSnakeCase(), value).apply()
}

inline fun <reified T : Enum<T>> SharedPreferences.enum(
    defaultValue: T,
    crossinline key: (KProperty<*>) -> String = KProperty<*>::name
): ReadWriteProperty<Any, T> = object : ReadWriteProperty<Any, T> {

    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        return enumValueOf(
            getString(key(property).camelToSnakeCase(), defaultValue.name) ?: defaultValue.name
        )
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        edit().putString(key(property).camelToSnakeCase(), value.name).apply()
    }
}
