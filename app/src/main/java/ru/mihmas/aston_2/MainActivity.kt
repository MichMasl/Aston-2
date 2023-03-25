package ru.mihmas.aston_2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.mihmas.aston_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val bind: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)

        viewInit(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNTER_KEY, counter)
    }

    private fun viewInit(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(COUNTER_KEY)
        }
        bind.showCount.text = counter.toString()
        bind.buttonSayHello.setOnClickListener {
            startActivity(intentForHelloActivity())
        }
        bind.buttonCount.setOnClickListener {
            countUp()
        }
    }

    private fun intentForHelloActivity(): Intent {
        val intent = Intent(this, HelloActivity::class.java)
        intent.putExtra(INTENT_TAG, counter)
        return intent
    }

    private fun countUp() {
        counter++
        bind.showCount.text = counter.toString()
    }

    companion object {
        const val INTENT_TAG = "Intent Tag"
        const val COUNTER_KEY = "Counter key"
    }
}