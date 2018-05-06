package com.example.andresvelasquez.seccion_4_weather_app.api

import com.example.andresvelasquez.seccion_4_weather_app.models.Weather
import org.json.JSONObject

/**
@autor Andrés Velasquez
@since 6/05/18
 **/
class JSONParser {
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
}