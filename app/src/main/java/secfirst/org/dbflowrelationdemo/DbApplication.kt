package secfirst.org.dbflowrelationdemo

import android.app.Application
import com.facebook.stetho.Stetho
import com.raizlabs.android.dbflow.config.FlowConfig
import com.raizlabs.android.dbflow.config.FlowManager

class DbApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FlowManager.init(FlowConfig.Builder(this).build())
        Stetho.initializeWithDefaults(this);
    }

    override fun onTerminate() {
        super.onTerminate()
        FlowManager.destroy()
    }
}