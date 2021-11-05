package com.vika.projectmp1

import android.app.DownloadManager
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    companion object {
        const val REQUEST_CODE = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_profile = findViewById<Button>(R.id.btn_profile)
        val btn_product = findViewById<Button>(R.id.btn_product)
        val btn_detail_product = findViewById<Button>(R.id.btn_detail_product)
        val btn_implicit_intent = findViewById<Button>(R.id.btn_implicit_intent)
        val btn_intent_result = findViewById<Button>(R.id.btn_intent)


        btn_profile.setOnClickListener {
            val profile = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(profile)
        }

        btn_product.setOnClickListener {
            val product = Intent(this@MainActivity, ProductActivity::class.java)
            startActivity(product)
        }

        btn_detail_product.setOnClickListener {
            val detail_product = Intent(this@MainActivity, DetailProductActivity::class.java)
            startActivity(detail_product)
        }

        btn_implicit_intent.setOnClickListener {
            val phoneNumber = "089522071515"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(intent)
        }

        btn_intent_result.setOnClickListener {
            val intent = Intent (this@MainActivity, ResultActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 500) {
            val color = data?.getStringExtra(ResultActivity.EXTRA_COLOR)
            Log.d("color", color.toString())
            val view_content = findViewById<View>(R.id.view_content)
            view_content.setBackgroundColor(Color.parseColor(color.toString()))
        }
    }
}