package com.example.andresvelasquez.seccion_3_android_o_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.btn_press
import kotlinx.android.synthetic.main.activity_main.txt_title

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    btn_press.setOnClickListener {
      val randomColor = getRandomColor()
      val randomPhrase = getRandomPhrase()

      txt_title.setText(randomPhrase)
      txt_title.setTextColor(randomColor)

    }
  }

  private fun getRandomColor(): Int {
    val colors = resources.getIntArray(R.array.phrasesColors)
    val random = getRandomNum(colors.size)

    return colors[random]
  }

  private fun getRandomPhrase(): String {
    val phrase = resources.getStringArray(R.array.phrases)
    val random = getRandomNum(phrase.size)
    return phrase[random]
  }

  private fun getRandomNum(size: Int) = (Math.random() * size).toInt()

}
