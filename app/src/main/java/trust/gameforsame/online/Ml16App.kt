package trust.gameforsame.online

import android.app.Application
import com.appsflyer.AppsFlyerLib
import com.my.tracker.MyTracker
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import dagger.hilt.android.HiltAndroidApp
import pro.userx.UserX
import trust.gameforsame.online.data.APPS_FLYER
import trust.gameforsame.online.data.APP_METRICA
import trust.gameforsame.online.data.MY_TRACKER
import trust.gameforsame.online.data.USER_X

@HiltAndroidApp
class Ml16App: Application() {
    override fun onCreate() {
        super.onCreate()

        val config = YandexMetricaConfig.newConfigBuilder(APP_METRICA).build()


        MyTracker.initTracker(MY_TRACKER, this)
        YandexMetrica.activate(applicationContext, config)
        YandexMetrica.enableActivityAutoTracking(this)
        AppsFlyerLib.getInstance().init(APPS_FLYER, null, this)
        AppsFlyerLib.getInstance().start(this)
        UserX.init(USER_X)
    }
}