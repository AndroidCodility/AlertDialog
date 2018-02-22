package com.codility.alertdialog

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

/**
 * Created by Govind on 2/22/2018.
 */
class CustomAlertDialog(context: Context) : AlertDialog(context) {

    fun alertDefault() {
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setTitle("Default Alert Dialog")
        alertDialog.setMessage("Sample for Alert Dialog example..!!")
        alertDialog.setIcon(R.mipmap.ic_launcher_round)
        alertDialog.setPositiveButton("YES") { _, _ ->
            Toast.makeText(context, "You clicked on YES", Toast.LENGTH_SHORT).show()
        }

        alertDialog.setNegativeButton("NO") { dialog, _ ->
            Toast.makeText(context, "Default dialog closed..!!", Toast.LENGTH_SHORT).show()
            dialog.cancel()
        }
        alertDialog.show()
    }

    fun customAlertDialog() {
        val alertDialog = AlertDialog.Builder(context).create()
        val inflater = LayoutInflater.from(context)
        val dialogView = inflater.inflate(R.layout.custom_alert, null)
        alertDialog.setTitle("Custom Alert Dialog")
        alertDialog.setCancelable(false)
        alertDialog.setView(dialogView)

        val edTitle = dialogView.findViewById(R.id.edTitle) as EditText
        val edMessage = dialogView.findViewById(R.id.edMessage) as EditText
        val btOk = dialogView.findViewById(R.id.btOk) as Button
        val btCancel = dialogView.findViewById(R.id.btCancel) as Button

        btOk.setOnClickListener(View.OnClickListener {
            if (isValidate(dialogView)) {
                alertDialog.dismiss()
                Toast.makeText(context, "Title : ".plus(edTitle.text.toString()).plus("\nMessage : ".plus(edMessage.text.toString())), Toast.LENGTH_SHORT).show()
            }
        })

        btCancel.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, "Custom dialog closed..!!", Toast.LENGTH_SHORT).show()
            alertDialog.dismiss()
        })

        alertDialog.show()
    }

    private fun isValidate(view: View): Boolean {
        val edTitle = view.findViewById(R.id.edTitle) as EditText
        val edDesc = view.findViewById(R.id.edMessage) as EditText
        if (edTitle.text.isEmpty()) {
            Toast.makeText(context, "Title name is empty..!!", Toast.LENGTH_SHORT).show()
            return false
        }
        if (edDesc.text.isEmpty()) {
            Toast.makeText(context, "Message is empty..!!", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}