package app.flow.job.util

import android.widget.ImageView
import com.bumptech.glide.Glide

fun String.loadImage(view: ImageView) {
    Glide.with(view.context).load(this).into(view)
}


fun Int.loadImage(view: ImageView) {
    Glide.with(view.context).load(this).into(view)
}
