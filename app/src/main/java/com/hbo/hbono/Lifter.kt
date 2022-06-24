package com.hbo.hbono

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.orhanobut.hawk.Hawk
import kotlinx.coroutines.*

class Lifter  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifter)
        val txtEr: TextView = findViewById(R.id.inviteTxt)
        runBlocking {

            val job: Job = GlobalScope.launch(Dispatchers.IO) {
                getAsync(applicationContext)
            }
            job.join()
            val jsoup: String? = Hawk.get(Constants.asyncResult, "")
            Log.d("cora", "cora $jsoup")

            txtEr.text = jsoup

            if (jsoup == "l9xG") {
                Intent(applicationContext, GameItself::class.java).also { startActivity(it) }
            } else {
                Intent(applicationContext, FATIv::class.java).also { startActivity(it) }
            }
            finish()
        }
    }
    private suspend fun getAsync(context: Context) {
        val asyncKey = Async(context)
        val asyncResult = asyncKey.getDocSecretKey()
        Hawk.put(Constants.asyncResult, asyncResult)
    }
}