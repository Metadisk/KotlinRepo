package firatveral.com.kotlinrepo.adapter
import android.app.Application
import firatveral.com.kotlinrepo.R
import uk.co.chrisjenx.calligraphy.CalligraphyConfig


class App : Application() {


    override fun onCreate() {
        super.onCreate()

        CalligraphyConfig.initDefault(
            CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/ChronicaPro-Regular.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )
    }
}