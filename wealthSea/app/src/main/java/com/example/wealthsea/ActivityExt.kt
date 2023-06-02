package com.example.wealthsea

import android.app.Activity
import android.os.Build
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class ActivityExt {

    // COMO ESCONDER E EXIBIR O SYSTEM STATUS BAR
    fun Activity.hideSystemBars() {//para versão atual ou mais novas
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            ViewCompat.getWindowInsetsController(window.decorView)?.apply {
                systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE //sumira, porem passando o dedo na tela de cima para baixo ela reaparece
                hide(WindowInsetsCompat.Type.systemBars())//para esconder
            }
        } else {
            @Suppress("DEPRECATION")//Para versões inferiores usaremos uma forma antiga
            window.decorView.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN //vai tentar apliar a tela, deixar em tela cheia para esconder a status bar
        }
    }
}