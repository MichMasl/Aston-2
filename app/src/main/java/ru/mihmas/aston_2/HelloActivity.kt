package ru.mihmas.aston_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.mihmas.aston_2.databinding.ActivityHelloBinding

class HelloActivity : AppCompatActivity() {
    private val bind: ActivityHelloBinding by lazy { ActivityHelloBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)

        bind.counterTextView.text =
            intent.getIntExtra(MainActivity.INTENT_TAG, 0).toString()
    }
}