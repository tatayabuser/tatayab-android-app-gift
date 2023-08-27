package com.tatayab.tatayab.util

import android.app.Activity
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Build
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


/**
 * The `fragment` is added to the container view with id `frameId`. The operation is
 * performed by the `fragmentManager`.
 */
object FragmentUtil {

    @JvmStatic
    private val BACK_STACK_ROOT_TAG = "root_fragment"

    @JvmStatic
    fun addFragmentToActivity(
        fragmentManager: FragmentManager,
        fragment: Fragment, frameId: Int, activity: Activity
    ) {
        fragmentManager.beginTransaction()
            .add(frameId, fragment)
            .addToBackStack(null)
            .commitAllowingStateLoss()

        closeKeyboard(activity)
    }


    @JvmStatic
    fun addFragmentToFragment(fragmentManager: FragmentManager, fragmentToHide:Fragment,fragmentToAdd: Fragment,id:Int) {
        val transaction = fragmentManager.beginTransaction()
        transaction.addToBackStack(null)
        transaction.hide(fragmentToHide)
        transaction.add(id, fragmentToAdd)
        transaction.commit()
    }

    @JvmStatic
    fun replaceFragmentToActivity(
        fragmentManager: FragmentManager,
        fragment: Fragment, frameId: Int, activity: Activity
    ) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(frameId, fragment)
        transaction.addToBackStack(null)
        transaction.commitAllowingStateLoss()

        closeKeyboard(activity)
    }

    @JvmStatic
    fun addFirstFragmentToActivity(
        fragmentManager: FragmentManager,
        fragment: Fragment, frameId: Int,
        activity: Activity
    ) {
        fragmentManager.beginTransaction()
            .replace(frameId, fragment)
            .commitAllowingStateLoss()

        closeKeyboard(activity)
    }

    @JvmStatic
    fun setRootView(
        currentView: Fragment,
        fragmentManager: FragmentManager,
        frameId: Int,
        tag: String, activity: Activity
    ) {
        // Pop off everything up to and including the current tab
        try {
            fragmentManager.popBackStackImmediate(
                BACK_STACK_ROOT_TAG, FragmentManager
                    .POP_BACK_STACK_INCLUSIVE
            )
        } catch (e: IllegalStateException) {
            fragmentManager.popBackStack(
                BACK_STACK_ROOT_TAG, FragmentManager
                    .POP_BACK_STACK_INCLUSIVE
            )
        }

        fragmentManager.beginTransaction()
            .replace(frameId, currentView, tag)
            .addToBackStack(BACK_STACK_ROOT_TAG)
            .commitAllowingStateLoss()

        closeKeyboard(activity)

    }

    //{activity which hold the current fragment close it's keyboard if it's opened in fragment transition
    @JvmStatic
    fun closeKeyboard(activity: Activity) {
        val v = activity.currentFocus
        if (v != null) {
            val inputManager = activity.getSystemService(
                INPUT_METHOD_SERVICE
            ) as InputMethodManager
            inputManager.hideSoftInputFromWindow(v.windowToken, 0)
        }
    }

    @JvmStatic
    fun setFullScreen(activity: Activity) {
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE)
        activity.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

    @JvmStatic
    fun setStatusBarColor(color: Int, activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = activity.window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(activity, color)
        }
    }
}