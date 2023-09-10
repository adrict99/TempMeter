package com.adrict99.weather.util

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window
import com.adrict99.weather.R
import com.google.android.material.snackbar.Snackbar

class DialogUtils {

    fun getLoadingDialog(
        activity: Activity
    ) : Dialog {
        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.loading_layout)
        return dialog
    }

}

fun Activity?.showCustomMessage(text: String, timeExpose: Int) {
    val view: View = this!!.findViewById(android.R.id.content)
    if (text.isNotEmpty()) {
        Snackbar.make(view, text , timeExpose).show()
    }
}