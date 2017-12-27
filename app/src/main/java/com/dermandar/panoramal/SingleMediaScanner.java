package com.dermandar.panoramal;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;

public class SingleMediaScanner implements MediaScannerConnectionClient {

	private MediaScannerConnection mMs;
	private String mPath;

	public SingleMediaScanner(Context context, String path) {
		mPath = path;
		mMs = new MediaScannerConnection(context, this);
		mMs.connect();
	}

	public void onMediaScannerConnected() {
		mMs.scanFile(mPath, null);
	}

	public void onScanCompleted(String path, Uri uri) {
		mMs.disconnect();
	}
}