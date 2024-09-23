package dev.tomco.a24c_10357_w07

import android.app.Application
import dev.tomco.a24c_10357_w07.utilities.ImageLoader

class App :Application() {

    override fun onCreate() {
        super.onCreate()
        ImageLoader.init(this)
    }
}