package eu.thedarken.wl.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import eu.thedarken.wl.R;

public class About extends Dialog {

    public About(Context context) {
        super(context);

        setTitle("Wake Lock");
        setCancelable(true);
        setCanceledOnTouchOutside(true);

        setContentView(R.layout.dialog_about);
        TextView version = (TextView) findViewById(R.id.version);
        version.setText("Version: 2.6");

        TextView about = (TextView) findViewById(R.id.about);
        about.setText("This app allows you to acquire wakelocks from Android's PowerManager.");
    }

}
