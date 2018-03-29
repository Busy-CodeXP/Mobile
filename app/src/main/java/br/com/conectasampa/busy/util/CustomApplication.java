package br.com.conectasampa.busy.util;

import android.app.Application;

import br.com.conectasampa.busy.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initTextType();
    }

    public static void initTextType() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Roboto-Light.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }

}
