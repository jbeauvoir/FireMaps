package com.example.jbeauvoir.firemaps

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_startup.*

/**
 * Created by tholland1 on 13/10/17.
 */

class StartupActivity : AppCompatActivity() {

    /*  Welcome to Kotlin!!

    I wanted to show you a small sample of this language developed by JetBrains.
    I think it's much better than Java for a lot of reasons, and it has a
    lot of cool built-in functionality that Java lacks.

    ... and it also compiles to the same byte-code that Java does! which means
    you can have both Kotlin and Java code in the same project without any issues

                https://kotlinlang.org/
                https://kotlinlang.org/docs/tutorials/koans.html
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startup)

        mapButton.setOnClickListener { view ->
            Toast.makeText(this@StartupActivity, "Link to MapActivity", Toast.LENGTH_SHORT)
                    .show()
        }

        chatButton.setOnClickListener { view ->
            Toast.makeText(this@StartupActivity, "Link to ChatActivity", Toast.LENGTH_SHORT)
                    .show()
        }
    }

}