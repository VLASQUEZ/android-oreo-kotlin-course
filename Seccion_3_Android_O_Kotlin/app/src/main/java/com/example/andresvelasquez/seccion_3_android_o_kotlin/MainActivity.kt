package com.example.andresvelasquez.seccion_3_android_o_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.btn_press
import kotlinx.android.synthetic.main.activity_main.txt_title

class MainActivity : AppCompatActivity() {
  val color = "color"
  val text = "texto"
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    btn_press.setOnClickListener {
      /*val randomColor = getRandomColor()
      val randomPhrase = getRandomPhrase()*/
      val phrase = resources.getStringArray(R.array.phrases)
      val colors = resources.getIntArray(R.array.phrasesColors)

      txt_title.text = phrase.getRandomElement()
      txt_title.setTextColor(colors.getRandomElement())

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

  /**
   * Funciones de extension
   */
  private fun IntArray.getRandomElement(): Int {
    val random = getRandomNum(this.size)

    return this[random]
  }

  private fun Array<String>.getRandomElement(): String {
    val random = getRandomNum(this.size)
    return this[random]
  }

  override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)

    outState.putInt(color, txt_title.currentTextColor)
    outState.putString(text, txt_title.text.toString())
  }

  override fun onRestoreInstanceState(savedInstanceState: Bundle) {
    with(savedInstanceState) {
      txt_title.text = getString(text)
      txt_title.setTextColor(getInt(color))
    }

    super.onRestoreInstanceState(savedInstanceState)
  }
}
