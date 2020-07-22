package kiwi.app

import android.app.Application
import kiwi.app.util.SP


/**Declaration of private constructor in Kotlin.*/
class App private constructor(): Application() {
    lateinit var instance: App

    override fun onCreate() {
        super.onCreate()
        App.instance
        SP.instance
    }

    /**An OBJECT is just a data type with a thread-safe singleton implementation.*/
    private object HOLDER {
        val INSTANCE = App()
    }

    /**The BY LAZY{} indicates it will be computed on the first access only. The evaluation of lazy
    properties is synchronized, the value is computed only in one thread, and all threads will
    see the same value.

    If you need a function or a property to be tied to a class rather than to instances of it,
    you can declare it inside a companion object. The companion object is a singleton, and its
    members can be accessed directly via the name of the containing class */
    companion object {
        val instance: App by lazy { HOLDER.INSTANCE }
    }
}