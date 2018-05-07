package com.example.andresvelasquez.seccion_4_weather_app.models

import com.example.andresvelasquez.seccion_4_weather_app.R

/**
@autor Andrés Velasquez
@since 6/05/18
 **/
class Weather(
  var icon: String,
  var summary: String,
  var temp: Double,
  var precip: Double
) {
  fun getIconResource(): Int {
    when (icon) {
      "clear-night" -> return R.drawable.clear_night
      "clear-day" -> return R.drawable.clear_day
      "cloudy" -> return R.drawable.cloudy
      "cloudy-night" -> return R.drawable.cloudy_night
      "fog" -> return R.drawable.fog
      "partly-cloudy" -> return R.drawable.partly_cloudy
      "partly-cloudy-night" -> return R.drawable.partly_cloudy_night
      "partly-cloudy-day" -> return R.drawable.cloudy
      "rain" -> return R.drawable.rain
      "sleet" -> return R.drawable.sleet
      "snow" -> return R.drawable.snow
      "sunny" -> return R.drawable.sunny
      "wind" -> return R.drawable.wind
      else -> return R.drawable.na
    }
  }
}