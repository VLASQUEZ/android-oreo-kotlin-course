package com.example.andresvelasquez.seccion_4_weather_app.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.andresvelasquez.seccion_4_weather_app.R
import com.example.andresvelasquez.seccion_4_weather_app.extensions.inflate
import com.example.andresvelasquez.seccion_4_weather_app.models.Hour
import kotlinx.android.synthetic.main.hourly_item.view.txt_hour
import kotlinx.android.synthetic.main.hourly_item.view.txt_hourly_precip
import kotlinx.android.synthetic.main.hourly_item.view.txt_hourly_temp

/**
 * @author <a href="avelasquez@clickdelivery.com">Andres Velasquez</a>
 * @since 10/05/18
 */
class HourAdapter(val dataSource: ArrayList<Hour>) : RecyclerView.Adapter<HourAdapter.HourViewHolder>() {

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): HourViewHolder = HourViewHolder(parent.inflate(R.layout.hourly_item))

  override fun getItemCount(): Int = dataSource.size

  override fun onBindViewHolder(
    holder: HourViewHolder,
    position: Int
  ) {
    return holder.bind(dataSource[position])
  }

  class HourViewHolder(hourlyItemView: View) : RecyclerView.ViewHolder(hourlyItemView) {
    fun bind(hour: Hour) = with(itemView) {

      txt_hour.text = hour.getFormattedTime()
      txt_hourly_precip.text = "${hour.precip.toInt().toString()} %"
      txt_hourly_temp.text = "${hour.temp.toString()} C"
    }

  }
}