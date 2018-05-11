package com.example.andresvelasquez.seccion_4_weather_app.ui

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.android.volley.Request.Method
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.andresvelasquez.seccion_4_weather_app.R
import com.example.andresvelasquez.seccion_4_weather_app.R.layout
import com.example.andresvelasquez.seccion_4_weather_app.R.string
import com.example.andresvelasquez.seccion_4_weather_app.api.DARK_SKY_API_KEY
import com.example.andresvelasquez.seccion_4_weather_app.api.DARK_SKY_URL
import com.example.andresvelasquez.seccion_4_weather_app.api.getCurrentWeatherFromJSON
import com.example.andresvelasquez.seccion_4_weather_app.api.getDailyWeatherFromJSON
import com.example.andresvelasquez.seccion_4_weather_app.api.getHourlyWeatherFromJSON
import com.example.andresvelasquez.seccion_4_weather_app.extensions.action
import com.example.andresvelasquez.seccion_4_weather_app.extensions.displaySnack
import com.example.andresvelasquez.seccion_4_weather_app.models.Day
import com.example.andresvelasquez.seccion_4_weather_app.models.Hour
import com.example.andresvelasquez.seccion_4_weather_app.models.Weather
import kotlinx.android.synthetic.main.activity_main.btn_daily_weather
import kotlinx.android.synthetic.main.activity_main.btn_hourly_weather
import kotlinx.android.synthetic.main.activity_main.img_weather_icon
import kotlinx.android.synthetic.main.activity_main.mainActivity
import kotlinx.android.synthetic.main.activity_main.txt_temp
import kotlinx.android.synthetic.main.activity_main.txt_weather
import kotlinx.android.synthetic.main.activity_main.txt_weather_percent
import org.json.JSONObject
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
  val TAG = MainActivity::class.java.simpleName
  //inicializa la variable justo cuando esta va a ser usada
  lateinit var days: ArrayList<Day>
  lateinit var hours: ArrayList<Hour>

  companion object {
    val DAILY_WEATHER = "DAILY_WEATHER"
    val HOURLY_WEATHER = "HOURLY_WEATHER"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)

    getWeather()
    btn_hourly_weather.setOnClickListener {
      startHourlyActivity()
    }

    btn_daily_weather.setOnClickListener {
      startDailyActivity()
    }
  }

  private fun getWeather() {
    val latitude = 4.6097100
    val longitude: Double = -74.0817500
    val language = getString(string.languaje)
    val units = getString(string.units)
    val url =
      "$DARK_SKY_URL/$DARK_SKY_API_KEY/$latitude,$longitude?lang=$language&units=$units"

    // ...

    // Instantiate the RequestQueue.
    val queue = Volley.newRequestQueue(this)

    // Request a string response from the provided URL.
    val stringRequest = StringRequest(
        Method.GET, url,
        Response.Listener<String> {
          val responseJson = JSONObject(it)
          val currentWeather = getCurrentWeatherFromJSON(response = responseJson)

          days = getDailyWeatherFromJSON(responseJson)
          hours = getHourlyWeatherFromJSON(responseJson)
          bindCurrentWeather(currentWeather)

        },
        Response.ErrorListener {
          Log.d(TAG, "That didn't work!")
          showSnackbar()
        })

    // Add the request to the RequestQueue.
    queue.add(stringRequest)
  }

  private fun showSnackbar() {
    mainActivity.displaySnack(
        getString(R.string.network_error), Snackbar.LENGTH_INDEFINITE
    ) {
      action(getString(R.string.retry)) {
        getWeather()
      }
    }
  }

  private fun bindCurrentWeather(weather: Weather) {
    val precipProbability = (weather.precip * 100).roundToInt()

    txt_temp.text = getString(R.string.celcius_temp, weather.temp.toInt())

    txt_weather_percent.text = getString(R.string.weather_percent, precipProbability)


    txt_weather.text = weather.summary

    img_weather_icon.setImageDrawable(
        ResourcesCompat.getDrawable(resources, weather.getIconResource(), null)
    )

  }

  fun startHourlyActivity() {
    val intent = Intent(this, HourlyWeatherActivity::class.java).apply {
      putParcelableArrayListExtra(HOURLY_WEATHER, hours)

    }
    startActivity(intent)

  }

  fun startDailyActivity() {
    val intent = Intent(this, DailyWeatherActivity::class.java).apply {
      putParcelableArrayListExtra(DAILY_WEATHER, days)
    }
    startActivity(intent)

  }
}
