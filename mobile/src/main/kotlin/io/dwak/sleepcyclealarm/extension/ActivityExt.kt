@file:JvmName("ActivityUtils")

package io.dwak.sleepcyclealarm.extension

import android.app.Activity
import android.content.Context
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import io.dwak.sleepcyclealarm.R

@JvmOverloads
fun Activity.toast(message : String, length : Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show();
}

@JvmOverloads
fun Activity.toast(@StringRes message : Int, length : Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show();
}

