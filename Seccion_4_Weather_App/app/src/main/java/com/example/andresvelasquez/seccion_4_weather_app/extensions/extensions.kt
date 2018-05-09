package com.example.andresvelasquez.seccion_4_weather_app.extensions

import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.json.JSONArray
import org.json.JSONObject

/**
 * @author <a href="avelasquez@clickdelivery.com">Andres Velasquez</a>
 * @since 8/05/18
 */
// Sobrecarga el operador iterator para poder usar funciones de extension
operator fun JSONArray.iterator(): Iterator<JSONObject> =
  (0 until length()).asSequence().map { get(it) as JSONObject }.iterator()

fun ViewGroup.inflate(layoutRes: Int): View = LayoutInflater.from(context)
    .inflate(layoutRes, this, false)

fun View.displaySnack(
  message: String,
  lenght: Int = Snackbar.LENGTH_SHORT,
  func: Snackbar.() -> Unit
) {
  val snackbar = Snackbar.make(this, message, lenght)
  snackbar.func()
  snackbar.show()
}

fun Snackbar.action(
  message: String,
  listener: (View) -> Unit
) {
  setAction(message, listener)
}