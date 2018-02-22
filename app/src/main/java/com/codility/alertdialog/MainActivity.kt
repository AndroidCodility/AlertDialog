package com.codility.alertdialog

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btAlertDefault -> {
                CustomAlertDialog(this).alertDefault()
            }

            R.id.btAlertCustom -> {
                CustomAlertDialog(this).customAlertDialog()
            }

            R.id.btDialogDefault -> {
                CustomDialog(this).popUpWindow(linearLayout)
            }

            R.id.btDialogCustom -> {
                CustomDialog(this).customDialog()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btAlertDefault.setOnClickListener(this)
        btAlertCustom.setOnClickListener(this)
        btDialogDefault.setOnClickListener(this)
        btDialogCustom.setOnClickListener(this)

    }
}