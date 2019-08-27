package com.masahiro.jan_kenapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    companion object{
        val TAG : String = MainActivity::class.java.simpleName
    }

    enum class Janken{
        GU,CHOKI,PA
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        gu.setOnClickListener {
            playterImageView.setImageResource(R.drawable.gu)
            execJanken(Janken.GU);
        }
        choki.setOnClickListener {
            playterImageView.setImageResource(R.drawable.choki)
            execJanken(Janken.CHOKI)
        }
        pa.setOnClickListener {
            playterImageView.setImageResource(R.drawable.pa)
            execJanken(Janken.PA)
        }
    }

    fun execJanken(te: Janken){
        val computerTe = calcComputerTe()
        when(computerTe){
            Janken.GU -> {
                resultImageView.setImageResource(R.drawable.gu)
                when(te){
                    Janken.GU -> resultTextBox.text = "あいこ"
                    Janken.CHOKI -> resultTextBox.text = "あなたの負け"
                    Janken.PA -> resultTextBox.text = "あなたの勝ち"
                }
            }
            Janken.CHOKI -> {
                resultImageView.setImageResource(R.drawable.choki)
                when(te){
                    Janken.GU -> resultTextBox.text = "あなたの勝ち"
                    Janken.CHOKI -> resultTextBox.text = "あいこ"
                    Janken.PA -> resultTextBox.text = "あなたの負け"
                }
            }
            Janken.PA -> {
                resultImageView.setImageResource(R.drawable.pa)
                when(te){
                    Janken.GU -> resultTextBox.text = "あなたの負け"
                    Janken.CHOKI -> resultTextBox.text = "あなたの勝ち"
                    Janken.PA -> resultTextBox.text = "あいこ"
                }
            }
        }
    }

    fun calcComputerTe(): Janken{
        // get 0-2 number
        val randomInt = Random.nextInt(3)
        Log.d(TAG, "random: ${randomInt}")
        when(randomInt){
            0 -> return Janken.GU
            1 -> return Janken.CHOKI
            2 -> return Janken.PA
        }
        //error表示したい
        return Janken.GU
    }
}
