package kiet.nguyentuan;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import kiet.nguyentuan.MainActivity;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		RelativeLayout relativeLayout=new RelativeLayout(this);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		//initialize(new MainActivity(), config);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
							 WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

		View gameView = initializeForView(new MainActivity(),config);
		AdView adView=new AdView(this);
		adView.setAdUnitId("ca-app-pub-3231970295071818/7619873883");
		adView.setAdSize(AdSize.BANNER);
		RelativeLayout.LayoutParams adParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		adParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		adParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

		AdRequest request=new AdRequest.Builder().build();
		adView.loadAd(request);


		relativeLayout.addView(gameView);
		relativeLayout.addView(adView,adParams);


		adView.bringToFront();

		setContentView(relativeLayout);

	}
}
