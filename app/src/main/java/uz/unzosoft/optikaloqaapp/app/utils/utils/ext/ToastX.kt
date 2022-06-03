package uz.unzosoft.optikaloqaapp.app.utils.utils.ext


import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment


fun Context.toast(res: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, res, duration).show()
}


fun Context.toast(mes: Any?, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, mes?.toString(), duration).show()
}

fun Fragment.toast(mes: Any?, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this.context, mes?.toString(), duration).show()
}

fun View.toast(mes: Any?, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this.context, mes?.toString(), duration).show()
}