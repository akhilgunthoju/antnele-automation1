package appDelegate.java;

import io.appium.java_client.android.Activity;

public class mainActivity extends Activity {
	
	 public mainActivity(String appPackage, String appActivity) {
		super(appPackage, appActivity);
		// TODO Auto-generated constructor stub
	}

	@Override
	    protected void onResume() {
	        super.onResume();

	        // Start foreground service when MainActivity is resumed (app in foreground)
	        Intent serviceIntent = new Intent(this, SocketIOService.class);
	        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
	            startForegroundService(serviceIntent);
	        } else {
	            startService(serviceIntent);
	        }
	    }

}
