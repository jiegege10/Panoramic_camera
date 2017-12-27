package com.dermandar.panoramal;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.RelativeLayout;

import com.dermandar.dmd_lib.CallbackInterfaceViewer;
import com.dermandar.dmd_lib.DMD_Viewer;

public class ViewerActivity extends Activity {
	private RelativeLayout mRelativeLayoutRoot;

	private DMD_Viewer mDMDViewer;
	private View mViewViewer;

	private Display mDisplay;
	private DisplayMetrics mDisplayMetrics;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//getting screen resolution
		mDisplay = getWindowManager().getDefaultDisplay();
		mDisplayMetrics = new DisplayMetrics();
		mDisplay.getMetrics(mDisplayMetrics);
		String panoramaName = getIntent().getStringExtra("PanoramaName");
		mRelativeLayoutRoot = new RelativeLayout(this);
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.MATCH_PARENT);
		mRelativeLayoutRoot.setLayoutParams(layoutParams);

		mDMDViewer = new DMD_Viewer();

		mViewViewer = null;
		mViewViewer = mDMDViewer.initViewer(this, mCallbackInterfaceViewer, getWindowManager().getDefaultDisplay().getRotation());
		mRelativeLayoutRoot.addView(mViewViewer);

		setContentView(mRelativeLayoutRoot);
	}

	@Override
	protected void onPause() {
		super.onPause();
		mDMDViewer.stopViewer();
	}

	@Override
	protected void onResume() {
		super.onResume();
		mDMDViewer.startViewer();
	}

	private CallbackInterfaceViewer mCallbackInterfaceViewer = new CallbackInterfaceViewer() {
		@Override
		public void onSingleTapConfirmed() {
            Log.d("TAG","onSingleTapConfirmed");
		}

		@Override
		public void onFinishLoadingPanorama() {
            Log.d("TAG","onFinishLoadingPanorama");

        }

		@Override
		public void onFinishGeneratingEqui() {
            Log.d("TAG","onFinishGeneratingEqui");

        }
	};
}
