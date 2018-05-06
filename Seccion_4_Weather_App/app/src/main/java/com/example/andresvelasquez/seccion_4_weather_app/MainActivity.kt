package com.example.andresvelasquez.seccion_4_weather_app

import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.andresvelasquez.seccion_4_weather_app.api.DARK_SKY_API_KEY
import com.example.andresvelasquez.seccion_4_weather_app.api.DARK_SKY_URL
import com.example.andresvelasquez.seccion_4_weather_app.api.JSONParser
import com.example.andresvelasquez.seccion_4_weather_app.models.Weather
import kotlinx.android.synthetic.main.activity_main.img_weather_icon
import kotlinx.android.synthetic.main.activity_main.txt_temp
import kotlinx.android.synthetic.main.activity_main.txt_weather
import kotlinx.android.synthetic.main.activity_main.txt_weather_percent
import org.json.JSONObject
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
  val TAG = MainActivity::class.java.simpleName
  val jsonParser = JSONParser()
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val latitude = 4.6097100
    val longitude: Double = -74.0817500
    val language = "es"
    val units = "si"
    val url =
      "$DARK_SKY_URL/$DARK_SKY_API_KEY/$latitude,$longitude?lang=$language&units=$units"

    val textView = findViewById<TextView>(R.id.text)
    // ...

    // Instantiate the RequestQueue.
    val queue = Volley.newRequestQueue(this)

    // Request a string response from the provided URL.
    val stringRequest = StringRequest(
        Request.Method.GET, url,
        Response.Listener<String> { response ->
          val responseJson = JSONObject(response)
          val currentWeather = jsonParser.getCurrentWeatherFromJSON(response = responseJson)
          bindCurrentWeather(currentWeather)

        },
        Response.ErrorListener { Log.d(TAG, "That didn't work!") })

    // Add the request to the RequestQueue.
    queue.add(stringRequest)
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

}
