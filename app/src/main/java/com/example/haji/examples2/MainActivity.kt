package com.example.haji.examples2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.haji.examples2.boundservice.ServicesMain
import com.example.haji.examples2.fragments.CustomDialogFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.title = "Simple Layout"

        btn_frag_main.setOnClickListener({
            val dialog = CustomDialogFragment.newInstance()
            dialog.show(supportFragmentManager, null)
        })

        btn_services_main.setOnClickListener({
            startActivity(Intent(this@MainActivity, ServicesMain::class.java));
        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)

        menu.findItem(R.id.tom1).setOnMenuItemClickListener {
            val dialog = CustomDialogFragment()
            dialog.show(supportFragmentManager, null)
        true}

        return true
    }

}



