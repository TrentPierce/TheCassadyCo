package com.TrentPierce.thecassadyco;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends Activity {
	
	private WebView myWebView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web_activity);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setDisplayShowTitleEnabled(true);
		
	    myWebView = (WebView) findViewById(R.id.webview);
		myWebView.loadUrl("http://www.TheCassadyCo.com");
		myWebView.setWebViewClient(new WebViewClient());
		myWebView.getSettings().setLoadWithOverviewMode(true);
		myWebView.getSettings().setUseWideViewPort(true);
		myWebView.getSettings().setBuiltInZoomControls(true);
		myWebView.getSettings().setJavaScriptEnabled(true);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_activity_actions, menu);
	    return super.onCreateOptionsMenu(menu);
	}
@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    // Respond to the action bar's Up/Home button
    case android.R.id.home:
    	if (myWebView.canGoBack())
    		myWebView.goBack();
    	else
	        finish();
	        return true;
   case R.id.action_new_email:
	   Intent intent = new Intent(Intent.ACTION_SEND);
	   intent.setType("plain/text");
	   intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "KPolifka@TheCassadyCo.com" });
	   intent.putExtra(Intent.EXTRA_SUBJECT, "Service Inquiry");
	   intent.putExtra(Intent.EXTRA_TEXT, "I recently found your Android application on the Google Play store. I would like more information on the services you provide to your clients.");
	   startActivity(Intent.createChooser(intent, ""));
	   return true;
   case R.id.action_call:
	   Intent callIntent = new Intent(Intent.ACTION_CALL);
	    callIntent.setData(Uri.parse("tel:2053490067"));
	    startActivity(callIntent);
	    return true;
    }
    return super.onOptionsItemSelected(item);
}
@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
        myWebView.goBack();
        return true;
    }
    else
    {
        finish();
    }
    return super.onKeyDown(keyCode, event);
   }
}




