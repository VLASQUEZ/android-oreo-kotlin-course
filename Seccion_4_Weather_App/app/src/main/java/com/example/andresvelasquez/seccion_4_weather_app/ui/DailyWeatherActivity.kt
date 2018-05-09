package com.example.andresvelasquez.seccion_4_weather_app.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.andresvelasquez.seccion_4_weather_app.R
import com.example.andresvelasquez.seccion_4_weather_app.adapters.DayAdapter
import com.example.andresvelasquez.seccion_4_weather_app.models.Day
import kotlinx.android.synthetic.main.activity_daily_weather.list_daily_summary

class DailyWeatherActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_daily_weather)

    intent
    //Optional binding (se ejecuta si el objeto no es null)
    intent.let {
      //fill listview
      //it hace referencia al objeto que esta llamando la funcion
      it.getParcelableArrayExtra(MainActivity.DAILY_WEATHER)
      val days: ArrayList<Day> = it.getParcelableArrayListExtra(MainActivity.DAILY_WEATHER)
      val adapter = DayAdapter(this, days)
      list_daily_summary.adapter = adapter
    }

  }
}
