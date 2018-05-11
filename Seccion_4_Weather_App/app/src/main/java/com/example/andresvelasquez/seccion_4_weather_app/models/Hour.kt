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
 * @since 10/05/18
 */
class Hour(
  val time: Long,
  val temp: Double,
  val precip: Double,
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
    dest?.writeDouble(temp)
    dest?.writeDouble(precip)
    dest?.writeString(timeZone)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Creator<Hour> {
    override fun createFromParcel(parcel: Parcel): Hour {
      return Hour(parcel)
    }

    override fun newArray(size: Int): Array<Hour?> {
      return arrayOfNulls(size)
    }
  }

  fun getFormattedTime(): String {
    val formatter = SimpleDateFormat("h:mm a", Locale.US)
    formatter.timeZone = TimeZone.getTimeZone(timeZone)
    val date = Date(time * 1000)
    val dayOfWeek = formatter.format(date)
    return dayOfWeek
  }
}