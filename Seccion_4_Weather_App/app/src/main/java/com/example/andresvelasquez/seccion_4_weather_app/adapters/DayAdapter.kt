package com.example.andresvelasquez.seccion_4_weather_app.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.andresvelasquez.seccion_4_weather_app.R
import com.example.andresvelasquez.seccion_4_weather_app.extensions.inflate
import com.example.andresvelasquez.seccion_4_weather_app.models.Day

/**
 * @author <a href="avelasquez@clickdelivery.com">Andres Velasquez</a>
 * @since 8/05/18
 */
class DayAdapter(
  val context: Context,
  val dataSource: ArrayList<Day>
) : BaseAdapter() {
  override fun getView(
    position: Int,
    convertView: View?,
    parent: ViewGroup
  ): View {
    val viewHolder: ViewHolder

    val view: View
    if (convertView == null) {
      view = parent.inflate(R.layout.daily_item)
      viewHolder = ViewHolder(view)
      view.tag = viewHolder
    } else {
      viewHolder = convertView.tag as ViewHolder
      view = convertView
    }
    val currentDay = dataSource[position]

    //utiliza la variable como contexto
    viewHolder.apply {
      dayTextView.text = currentDay.getFormattedTime()
      minTempTextView.text = "Min ${currentDay.minTemp} c"
      maxTempTextView.text = "Max ${currentDay.maxTemp} c"
    }

    return view
  }

  override fun getItem(position: Int): Any {
    return dataSource[position]
  }

  override fun getItemId(position: Int): Long {
    return 0
  }

  override fun getCount(): Int {
    return dataSource.size
  }

  private class ViewHolder(view: View) {
    val dayTextView = view.findViewById<TextView>(R.id.txt_day)
    val minTempTextView = view.findViewById<TextView>(R.id.txt_min_temp)
    val maxTempTextView = view.findViewById<TextView>(R.id.txt_max_temp)
  }
}