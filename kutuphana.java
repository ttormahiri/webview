package com.example.eslamimbooks;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class kutuphana extends Activity {

	 final Activity activity = this;
		public WebView webView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
    super.onCreate(savedInstanceState);
    this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
    setContentView(R.layout.kutuphana);
    webView = (WebView) findViewById(R.id.webview);
    webView.getSettings().setJavaScriptEnabled(true);

    webView.setWebChromeClient(new WebChromeClient() {
        public void onProgressChanged(WebView view, int progress)
        {
            activity.setTitle("يۈكلىنىۋاتىدۇ..");
            
            activity.setProgress(progress * 100);

            if(progress == 100)
                activity.setTitle(R.string.app_name);
        }
    });

    webView.setWebViewClient(new WebViewClient() {
    
        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {


            // API level 5: WebViewClient.ERROR_HOST_LOOKUP
            if (errorCode == -2) {
              String summary = "<html><body style='background: white;'><p style='color: black;text-align:right;'>ھەي قىرىندىشىم ئاۋال تورغا ئۇلاڭ،ئاندىن ئەپنى نورمال ئىشلىتەلەيسىز</p></body></html>";    
              view.loadData(summary, "text/html; charset=utf-8",null);
              return;
            }

            // Default behaviour
            super.onReceivedError(view, errorCode, description, failingUrl);
          }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            if(Uri.parse(url).getHost().endsWith("c9.io")) {
                // getHost().equals() ni sinap bikixka bolidu
                return false;
            }
             
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            view.getContext().startActivity(intent);
            return true;
        }
    });
     
    webView.loadUrl("https://c9.io/tormahiri/eslamim/workspace/kutuphana/index.html");
		
	
		

	}


}
