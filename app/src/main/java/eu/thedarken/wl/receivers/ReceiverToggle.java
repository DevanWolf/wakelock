package eu.thedarken.wl.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import eu.thedarken.wl.BuildConfig;
import eu.thedarken.wl.MainActivity;
import eu.thedarken.wl.WakeLockService;
import eu.thedarken.wl.locks.Lock.Type;

public class ReceiverToggle extends BroadcastReceiver {
    private final String TAG = ReceiverToggle.class.getCanonicalName();
    public static final String TOGGLE_SERVICE = BuildConfig.APPLICATION_ID + ".action.TOGGLE_SERVICE";

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent svc = new Intent(context, WakeLockService.class);
        if (WakeLockService.isMyServiceRunning(context)) {
            context.stopService(svc);
        } else {
            SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
            if (!settings.getString("current_lock", Type.NO_LOCK.name()).equals(Type.NO_LOCK.name())) {
                context.startService(svc);
            } else {
                Intent i = new Intent(context, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        }
    }
}
