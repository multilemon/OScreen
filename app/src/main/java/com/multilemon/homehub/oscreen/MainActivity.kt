package com.multilemon.homehub.oscreen

import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.v7.app.AppCompatActivity
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setupWebView()
        setupChromeCustomTabs()
    }

    fun setupWebView() {
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return false
            }
        }
        webView.webChromeClient = WebChromeClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://www.google.com/intl/en/chrome/demos/speech.html")
    }

    fun setupChromeCustomTabs() {
        val url = "https://www.google.com/intl/en/chrome/demos/speech.html"
        val builder = CustomTabsIntent.Builder().apply {
            enableUrlBarHiding()
            setShowTitle(false)
        }
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(url))
        finish()
    }
}
