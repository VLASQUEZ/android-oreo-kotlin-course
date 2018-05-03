package com.example.andresvelasquez.seccion_4_weather_app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.andresvelasquez.seccion_4_weather_app.api.DARK_SKY_API_KEY
import com.example.andresvelasquez.seccion_4_weather_app.api.DARK_SKY_URL

class MainActivity : AppCompatActivity() {
  val TAG = MainActivity::class.java.simpleName

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val latitude = 4.6097100
    val longitude: Double = -74.0817500

    val url = "$DARK_SKY_URL/$DARK_SKY_API_KEY/$latitude/$longitude"

  }
}
