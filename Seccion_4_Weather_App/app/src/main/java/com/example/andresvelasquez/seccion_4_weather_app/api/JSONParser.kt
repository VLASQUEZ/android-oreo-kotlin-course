package com.example.andresvelasquez.seccion_4_weather_app.api

import com.example.andresvelasquez.seccion_4_weather_app.extensions.iterator
import com.example.andresvelasquez.seccion_4_weather_app.models.Day
import com.example.andresvelasquez.seccion_4_weather_app.models.Hour
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
  val timeZone = response.getString("timezone")

  for (jsonDay in dayJSONArray) {

    val minTemp = jsonDay.getDouble("temperatureLow")
    val maxTemp = jsonDay.getDouble("temperatureHigh")
    val time = jsonDay.getLong("time")

    days.add(Day(time, minTemp, maxTemp, timeZone))
  }

  return days
}

fun getHourlyWeatherFromJSON(response: JSONObject): ArrayList<Hour> {
  val hourlyJSON = response.getJSONObject("hourly")
  val hourlyJSONArray = hourlyJSON.getJSONArray("data")
  val timeZone = response.getString("timezone")
  val hours = ArrayList<Hour>()

  for (jsonHour in hourlyJSONArray) {
    val time = jsonHour.getLong("time")
    val temp = jsonHour.getDouble("temperature")
    val precip = jsonHour.getDouble("precipProbability")

    hours.add(Hour(time, temp, precip, timeZone))
  }

  return hours
}
