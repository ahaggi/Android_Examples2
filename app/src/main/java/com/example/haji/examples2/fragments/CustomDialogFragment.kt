package com.example.haji.examples2.fragments

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.haji.examples2.R

class CustomDialogFragment: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout = inflater.inflate(R.layout.custom_dialog_frag, null , false)
        val p1 = layout.findViewById(R.id.EditText_Pwd1) as EditText
        val p2 = layout.findViewById(R.id.EditText_Pwd2) as EditText
        val error = layout.findViewById(R.id.TextView_PwdProblem) as TextView
        p2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                val strPass1 = p1.text.toString()
                val strPass2 = p2.text.toString()
                if (strPass1 == strPass2) {
                    error.setText("Passwords match.")
                } else {
                    error.setText("Passwords do not match.")
                }
            }

            // ... other required overrides do nothing
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
        val builder = AlertDialog.Builder(activity)
        builder.setView(layout)
        // Now configure the AlertDialog
        builder.setTitle("Set Password")
        builder.setNegativeButton(android.R.string.cancel) { dialog, _ ->
            // We forcefully dismiss and remove the Dialog, so it
            // cannot be used again
            dialog.dismiss()
        }
        builder.setPositiveButton(android.R.string.ok) { dialog, _ ->
            val strPassword1 = p1.text.toString()
            val strPassword2 = p2.text.toString()
            if (strPassword1 == strPassword2) {
                Toast.makeText(activity, "Matching passwords=" + strPassword2, Toast.LENGTH_SHORT).show()
            }
            // We forcefully dismiss and remove the Dialog, so it
            // cannot be used again
            dialog.dismiss()
        }
        // Create the AlertDialog and show it
        return builder.create()
    }

    companion object {
        fun newInstance(): CustomDialogFragment {
            return CustomDialogFragment()
        }
    }
}
