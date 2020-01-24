package com.PassionPenguin.ExitGuide.GZMTR

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.*
import android.widget.*
import android.content.Intent



class StationSelector : AppCompatActivity() {
    var station=arrayOf(0,1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_station_selector)

        val back = findViewById<Button>(R.id.cs_back)
        back.setOnClickListener{
            back.setBackgroundColor(0x44000000)
//                startActivity(Intent(this@StationSelector,StationSelector::class.java))
        }
val isDarkMode = this.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK===Configuration.UI_MODE_NIGHT_YES

        val webView = findViewById<WebView>(R.id.sswebview)
        class WebAppInterface(private val mContext: Context) {
            @JavascriptInterface
            fun isDarkTheme(): Boolean {
                return isDarkMode
            }
            fun nextpage(num:Int,platnum:Int){
station=arrayOf(num,platnum)
                startActivity(Intent(this@StationSelector,StationInf::class.java))
            }
        }
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(WebAppInterface(this), "Android")
        webView.loadUrl("file:///android_asset/webview/choosestation.html")
    }

    public fun getStatoinNum():Array<Int>{
        return station
    }
}

