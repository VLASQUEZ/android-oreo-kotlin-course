package com.example.andresvelasquez.seccion_4_weather_app.models

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

/**
 * @author <a href="avelasquez@clickdelivery.com">Andres Velasquez</a>
 * @since 8/05/18
 */
data class Day(
  val time: Long,
  val minTemp: Double,
  val maxTemp: Double,
  val timeZone: String
) : Parcelable {

  constructor(parcel: Parcel) : this(
      parcel.readLong(),
      parcel.readDouble(),
      parcel.readDouble(),
      parcel.readString()
  )

  override fun writeToParcel(
    dest: Parcel?,
    flags: Int
  ) {
    dest?.writeLong(time)
    dest?.writeDouble(minTemp)
    dest?.writeDouble(maxTemp)
    dest?.writeString(timeZone)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Creator<Day> {
    override fun createFromParcel(parcel: Parcel): Day {
      return Day(parcel)
    }

    override fun newArray(size: Int): Array<Day?> {
      return arrayOfNulls(size)
    }
  }

  fun getFormattedTime(): String {
    val formatter = SimpleDateFormat("EEEE", Locale.US)
    formatter.timeZone = TimeZone.getTimeZone(timeZone)
    val date = Date(time * 1000)
    val dayOfWeek = formatter.format(date)
    return dayOfWeek
  }
}