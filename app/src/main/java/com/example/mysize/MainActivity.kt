package com.example.mysize

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.putString
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = getSharedPreferences(
            "com.example.mysize.PREFERENCE_FILE_KEY", Context.MODE_PRIVATE
        )

        val editNeck = pref.getString("NECK", "")
        val editSleeve = pref.getString("SLEEVE", "")
        val editWaist = pref.getString("WAIST", "")
        val editInseam = pref.getString("INSEAM", "")

        neck.setText(editNeck)
        sleeve.setText(editSleeve)
        waist.setText(editWaist)
        inseam.setText(editInseam)

        save.setOnClickListener { onSaveTapped() }

        heightButton.setOnClickListener {
            val intent = Intent(this, HeightActivity::class.java)
            startActivity(intent)
        }
    }

    private fun onSaveTapped() {
        val pref = getSharedPreferences(
            "com.example.mysize.PREFERENCE_FILE_KEY", Context.MODE_PRIVATE
        )

        pref.edit {
            putString("NECK", neck.text.toString())
            putString("SLEEVE", sleeve.text.toString())
            putString("WAIST", sleeve.text.toString())
            putString("INSEAM", sleeve.text.toString())
        }

    }

}
