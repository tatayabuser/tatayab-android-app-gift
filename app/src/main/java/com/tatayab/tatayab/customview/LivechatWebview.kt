package com.tatayab.tatayab.customview

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.inputmethod.BaseInputConnection
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import android.webkit.WebView
import com.tatayab.tatayab.listener.OnKeyboardListener

class LivechatWebview @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : WebView(context, attrs, defStyleAttr) {
    // Other details code here.
    // (as per section 2 and 3 below)
    var callback:OnKeyboardListener?=null

    fun setKeyboardListener(listener: OnKeyboardListener){
        this.callback=listener
    }

    override fun onCreateInputConnection(outAttrs: EditorInfo): InputConnection {
        val inputConnection = BaseInputConnection(this, false)
        outAttrs.imeOptions = EditorInfo.IME_ACTION_DONE
        return inputConnection
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        val dispatchFirst = super.dispatchKeyEvent(event)
        if (event.action == KeyEvent.ACTION_UP) {
            when (event.keyCode) {
                KeyEvent.KEYCODE_ENTER -> {
                    callback?.onEnter()
                }
            }
        }
        return dispatchFirst
    }
}

