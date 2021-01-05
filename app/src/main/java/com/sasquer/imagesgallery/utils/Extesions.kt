package com.sasquer.imagesgallery.utils

import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

inline fun AppCompatActivity.setupToolbar(toolbar: Toolbar, appBarBlock: (ActionBar) -> Unit = {}) {
    setSupportActionBar(toolbar)
    supportActionBar?.also(appBarBlock)
}