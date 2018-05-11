package com.example.andresvelasquez.seccion_4_weather_app.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.andresvelasquez.seccion_4_weather_app.R
import com.example.andresvelasquez.seccion_4_weather_app.adapters.HourAdapter
import com.example.andresvelasquez.seccion_4_weather_app.models.Hour
import kotlinx.android.synthetic.main.activity_hourly_weather.recycler_daily_weather

class HourlyWeatherActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_hourly_weather)
    recycler_daily_weather.layoutManager = LinearLayoutManager(this)

    intent.let {
      val hours: ArrayList<Hour> = it.getParcelableArrayListExtra(MainActivity.HOURLY_WEATHER)
      recycler_daily_weather.adapter = HourAdapter(hours)
    }
  }
}
