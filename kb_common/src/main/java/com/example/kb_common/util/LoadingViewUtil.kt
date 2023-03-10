package com.example.kb_common.util

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.graphics.drawable.ColorDrawable

object LoadingViewUtil {
    private var dialog: AlertDialog? = null

    fun showLoadingDialog(context: Context, isCancel: Boolean) {
        if (context is Activity) {
            if (context.isFinishing) {
                return
            }
        }

        if (dialog == null) {
            val b = AlertDialog.Builder(context)
            b.setView()

            b.setCancelable(isCancel)
            dialog = b.create()

            if (dialog?.window == null) {
                return
            }
            dialog?.window?.setBackgroundDrawable(ColorDrawable(0))
        }

        if (dialog != null && !(dialog!!.isShowing)) {
            dialog!!.show()
        }
    }

}