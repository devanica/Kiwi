package kiwi.app.util

import android.app.Activity
import android.content.Context

class SP private constructor() {
    val IS_FIRST_TIME_LOADING = "is_first_loading"

    fun writeToSP(activity: Activity, isFirstLoading: Int){
        val sharedPref = activity.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putInt(IS_FIRST_TIME_LOADING, isFirstLoading)
            commit()
        }
    }

    fun readFromSP(activity: Activity): Int{
        val sharedPref = activity.getPreferences(Context.MODE_PRIVATE)
        return sharedPref.getInt(IS_FIRST_TIME_LOADING, 0)
    }

    private object HOLDER {
        val INSTANCE = SP()
    }

    companion object {
        val instance: SP by lazy { HOLDER.INSTANCE }
    }
}