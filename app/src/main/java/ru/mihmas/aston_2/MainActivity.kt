package ru.mihmas.aston_2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import ru.mihmas.aston_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val bind: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)
        initViews()
    }

    private fun initViews() {
        bind.openWebsiteButton.setOnClickListener {
            openWebSite()
        }
        bind.openLocationButton.setOnClickListener {
            openLocation()
        }
        bind.shareTextButton.setOnClickListener {
            shareText()
        }
        bind.cameraButton.setOnClickListener {
            startCamera()
        }
    }

    private fun openWebSite() {
        val url = bind.websiteEdittext.text.toString()
        val webpage = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this!")
        }
    }

    private fun openLocation() {
        val loc = bind.locationEdittext.text.toString()
        val addressUri = Uri.parse("geo:0,0?q=$loc")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this!")
        }
    }
    private fun shareText() {
        val txt = bind.shareEdittext.text.toString()
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder
            .from(this)
            .setType(mimeType)
            .setChooserTitle("Share this text with: ")
            .setText(txt)
            .startChooser()
    }

    private fun startCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivity(intent)
    }
}