package com.codility.alertdialog

import android.app.Dialog
import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.os.Build
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.*


/**
 * Created by Govind on 2/22/2018.
 */
class CustomDialog(context: Context) : Dialog(context) {

    fun popUpWindow(linearLayout: LinearLayout) {
        val inflater = context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val customView = inflater.inflate(R.layout.popup, null)
        val mPopupWindow = PopupWindow(customView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        // Set an elevation value for popup window & Call requires API level 21
        if (Build.VERSION.SDK_INT >= 21) {
            mPopupWindow.elevation = 5.0f
        }
        // Get a reference for the custom view close button
        val closeButton = customView.findViewById(R.id.ib_close) as ImageButton
        // Set a click listener for the popup window close button
        closeButton.setOnClickListener {
            // Dismiss the popup window
            mPopupWindow.dismiss()
        }
        // Finally, show the popup window at the Bottom location of root Linear layout
        mPopupWindow.showAtLocation(linearLayout, Gravity.BOTTOM, 0, 0)
    }

    fun customDialog() {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.custom_dialog)
        dialog.setTitle("Android Custom Dialog")
        dialog.setCancelable(false)
        // set the custom dialog components - text, image and button
        val textView = dialog.findViewById<View>(R.id.textView) as TextView
        textView.text = "Custom Dialog Kotlin Android!"
        val imageView = dialog.findViewById<View>(R.id.imageView) as ImageView
        imageView.setImageResource(R.mipmap.ic_launcher)

        val btDialog = dialog.findViewById(R.id.btDialog) as Button
        btDialog.setOnClickListener(View.OnClickListener {
            dialog.dismiss()
        })

        dialog.show()
    }
}