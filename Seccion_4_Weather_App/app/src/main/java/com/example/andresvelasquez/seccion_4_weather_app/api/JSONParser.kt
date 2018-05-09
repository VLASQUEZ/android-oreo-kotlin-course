package com.example.andresvelasquez.seccion_4_weather_app.api

import com.example.andresvelasquez.seccion_4_weather_app.extensions.iterator
import com.example.andresvelasquez.seccion_4_weather_app.models.Day
import com.example.andresvelasquez.seccion_4_weather_app.models.Weather
import org.json.JSONObject

/**
@autor Andrés Velasquez
@since 6/05/18
 **/

fun getCurrentWeatherFromJSON(response: JSONObject): Weather {
  val currentWeather = response.getJSONObject("currently")

  with(currentWeather) {
    val weather = Weather(
        icon = getString("icon"),
        summary = getString("summary"),
        temp = getDouble("temperature"),
        precip = getDouble("precipProbability")
    )

    return weather
  }

}

fun getDailyWeatherFromJSON(response: JSONObject): ArrayList<Day> {
  val dailyJSON = response.getJSONObject("daily")
  val dayJSONArray = dailyJSON.getJSONArray("data")
  val days = ArrayList<Day>()

  for (jsonDay in dayJSONArray) {

    val minTemp = jsonDay.getDouble("temperatureLow")
    val maxTemp = jsonDay.getDouble("temperatureHigh")
    val time = jsonDay.getLong("time")

    days.add(Day(time, minTemp, maxTemp))
  }

  return days
}
