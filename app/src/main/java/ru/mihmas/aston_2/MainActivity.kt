package ru.mihmas.aston_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.mihmas.aston_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val bind: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)
        viewInit(savedInstanceState)
    }

    private fun viewInit(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(COUNTER_KEY)
        }
        bind.counterTextView.text = counter.toString()
        bind.counterButton.setOnClickListener {
            counter++
            bind.counterTextView.text = counter.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNTER_KEY, counter)
    }

    companion object {
        private const val COUNTER_KEY = "counter key"
    }
}