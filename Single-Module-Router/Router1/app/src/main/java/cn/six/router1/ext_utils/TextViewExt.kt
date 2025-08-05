package cn.six.router1.ext_utils

import android.view.View.OnClickListener
import android.widget.TextView

fun TextView.config(msg: String, listener: OnClickListener) {
    this.text = msg
    this.setOnClickListener(listener)
}