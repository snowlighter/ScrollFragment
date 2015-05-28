package com.xuguang.scrollfragment;

import com.xuguang.scrollfragment.R;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.Window;

public class MainActivity extends FragmentActivity {

	private Bundle bundle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		bundle = savedInstanceState;
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			try {
				getSupportFragmentManager()
						.beginTransaction()
						.add(R.id.data_correct_fl,
								TabContentActivity
										.getInstance(savedInstanceState))
						.commit();
			} catch (Exception e) {
				
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	 @Override
	    public void onConfigurationChanged(Configuration newConfig) {
	        super.onConfigurationChanged(newConfig);
	    }

}
