package app.flow.job.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import app.flow.job.R
import app.flow.job.databinding.ActivitySplashBinding
import app.flow.job.ui.job.JobActivity
import app.flow.job.util.loadImage

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        R.mipmap.ic_launcher_round.loadImage(binding.logoIV)

        Handler(mainLooper).postDelayed({
            val intentSplash = Intent(this, JobActivity::class.java)
            intentSplash
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intentSplash)
        }, 750)
    }
}