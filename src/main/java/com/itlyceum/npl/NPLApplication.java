
package com.itlyceum.npl;

import android.app.Application;
import com.itlyceum.npl.injection.CommonModule;
import org.acra.ACRA;
import org.acra.annotation.ReportsCrashes;
import roboguice.RoboGuice;

@ReportsCrashes(formKey = "YOUR_FORM_KEY")
public class NPLApplication
    extends Application
{


    @Override
    public void onCreate() {
        ACRA.init(this);
        super.onCreate();

        RoboGuice.setBaseApplicationInjector(
                this,
                RoboGuice.DEFAULT_STAGE,
                RoboGuice.newDefaultRoboModule(this),
                new CommonModule());
    }

}
