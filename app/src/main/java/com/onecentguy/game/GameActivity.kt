package com.onecentguy.game

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import android.widget.TextView  // TextView の import ステートメントを追加
import androidx.appcompat.app.AppCompatActivity
import com.onecentguy.game.R

class GameActivity : AppCompatActivity() {

    private var score = 0
    private lateinit var countDownTimer: CountDownTimer
    private var gameStarted = false
    private val initialCountDown: Long = 5000
    private val countDownInterval: Long = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)

        val oneCentView = findViewById<ImageView>(R.id.one_cent)

        oneCentView.setOnClickListener {
            if(!gameStarted) {
                startGame()
            }
            incrementScore(scoreTextView)  // incrementScore 関数に scoreTextView を引数として渡す
        }

        countDownTimer = object : CountDownTimer(initialCountDown, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                // Update UI with the remaining time
            }

            override fun onFinish() {
                endGame()
            }
        }.start()

    }

    private fun startGame() {
        // startGame関数のコードはここに
    }

    private fun incrementScore(scoreTextView: TextView) {  // incrementScore 関数の引数に scoreTextView を追加
        score++
        scoreTextView.text = "$score"
    }

    // このメソッドは、ゲームが終了したときに呼び出されるものとします。
    private fun endGame() {
        val intent = Intent(this, EndActivity::class.java)
        intent.putExtra("SCORE", score)  // "SCORE"というキーでスコアをセット
        startActivity(intent)  // Intentを使ってEndActivityを開始
        finish()
    }
}
