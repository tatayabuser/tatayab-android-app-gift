package com.tatayab.tatayab.util

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Build
import android.os.Handler
import android.text.Html
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.tatayab.tatayab.R


open class DialogUtil {


      fun showDialog(context: Context,
                           mesg: String?) {
          try {
              var dialog = AlertDialog.Builder(context)
                  .setTitle("")
                  .setMessage(mesg)
                  .setPositiveButton(android.R.string.yes,
                      DialogInterface.OnClickListener { dialog, which ->
                          dialog.dismiss()
                      })
                  .setIcon(android.R.drawable.ic_dialog_alert)
                  .show()
          }catch (e:java.lang.Exception){
              e.printStackTrace()
          }
    }

    fun showCustomDialog(
        context: Context,
        isToolbar: Boolean,
        mesg: String?,
        mMessageType: MessageType
    ) {
        if (mesg.isNullOrBlank() || mesg.contains("Requested store is not found")){
             return
        }
        var message = checkTheMessage(context,mesg)
        val dialog = Dialog(context, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen)
        dialog.setContentView(R.layout.dialog_custom)
        dialog.window!!.attributes.windowAnimations = R.style.DialogAnimation
        val titleTextView = dialog.findViewById<TextView>(R.id.tv_title)
        val statusImageView = dialog.findViewById<ImageView>(R.id.img_icon)
        statusImageView.setImageDrawable(context.resources.getDrawable(getIcon(mMessageType)))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            titleTextView.text = Html.fromHtml(message, Html.FROM_HTML_MODE_COMPACT)
        } else {
            titleTextView.text = Html.fromHtml(message)
        }
        setLayoutParamDialog(dialog, Gravity.TOP, context, isToolbar)
        dialog.setCancelable(true)
        dialog.show()
        hideDialogWithDelay(dialog)
    }

    fun showCustomSuccessDialog(
        context: Context,
        isToolbar: Boolean,
        mesg: String?,
        mMessageType: MessageType
    ) {
        var message = checkTheMessage(context,mesg)
        val dialog = Dialog(context, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen)
        dialog.setContentView(R.layout.dialog_custom)
        dialog.window!!.attributes.windowAnimations = R.style.DialogAnimation
        val item = dialog.findViewById<LinearLayout>(R.id.item)
        item.setBackgroundColor(context?.resources!!.getColor(R.color.green))
        val titleTextView = dialog.findViewById<TextView>(R.id.tv_title)
        titleTextView.setTextColor(context?.resources!!.getColor(R.color.white))
         val statusImageView = dialog.findViewById<ImageView>(R.id.img_icon)
        statusImageView.setImageDrawable(context.resources.getDrawable(getIcon(mMessageType)))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            titleTextView.text = Html.fromHtml(message, Html.FROM_HTML_MODE_COMPACT)
        } else {
            titleTextView.text = Html.fromHtml(message)
        }
        setLayoutParamDialog(dialog, Gravity.TOP, context, isToolbar)
        dialog.setCancelable(true)
        dialog.show()
        hideDialogWithDelay(dialog)
    }

    private fun checkTheMessage(
        context: Context,
        message: String?
    ): String {
        if (message.isNullOrEmpty()) {
            return ""
        }
        if (message.contains("timed out") || message.contains("TIMEDOUT")) {
            return context.getString(R.string.no_connection)
        } else {
            return message
        }
    }

    private fun getIcon(mMessageType: MessageType): Int {
        when (mMessageType) {
            MessageType.ERROR -> {
                return R.drawable.ic_message_error_icon
            }
            MessageType.SUCCESS -> {
                return R.drawable.ic_correct_icon
            }
            MessageType.INFO,
            MessageType.WARRING -> {
                return R.drawable.ic_message_info_icon
            }
            else -> {
                return R.drawable.ic_message_info_icon
            }
        }
    }


    private fun getDialogStyle(mMessageType: MessageType): Int {

        return R.style.ErrorDialogTopTheme
//        when (mMessageType) {
//            MessageType.ERROR -> {
//                return R.style.ErrorDialogTopTheme
//            }
//            MessageType.SUCCESS -> {
//                return R.style.SuccessDialogTopTheme
//            }
//            MessageType.INFO,
//            MessageType.WARRING -> {
//                return R.style.InfoDialogTopTheme
//            }
//            else -> {
//                return R.style.InfoDialogTopTheme
//            }
//        }
    }

    /**
     * Set layout parameter.
     *
     * @param dialog    dialog "
     * @param gravity   int top or bottom
     * @param context
     * @param isToolbar
     */
    private fun setLayoutParamDialog(
        dialog: Dialog,
        gravity: Int,
        context: Context,
        isToolbar: Boolean
    ) {
        val lp = WindowManager.LayoutParams()
        val window = dialog?.window
        lp.copyFrom(window?.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        lp.gravity = gravity
        val tv = TypedValue()
        if (context.theme.resolveAttribute(android.R.attr.actionBarSize, tv, true) && isToolbar) {
            lp.y = TypedValue.complexToDimensionPixelSize(tv.data, context.resources.displayMetrics)
        }
        if (window != null) {
            window.attributes = lp
        }
    }

    /**
     * Hide dialog  with a delay.
     *
     * @param dialog dialog "no internet"
     */
    private fun hideDialogWithDelay(dialog: Dialog) {
        try {
            if (dialog == null) return
            val handler = Handler()
            val runnable = {
                if (dialog?.isShowing!!) {
                    dialog?.dismiss()
                }
            }
            dialog?.setOnDismissListener { dialog1 -> handler.removeCallbacks(runnable) }
            handler.postDelayed(runnable, 2300)
        } catch (e: Exception) {
            Log.d("Exception in Dialog", e.toString())
        }
        // Hide after some seconds

    }

    enum class MessageType {
        SUCCESS,
        ERROR,
        INFO,
        WARRING
    }
}