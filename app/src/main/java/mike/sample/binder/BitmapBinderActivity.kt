package mike.sample.binder

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mike.sample.IBitmapBinder
import mike.sample.R

class BitmapBinderActivity : AppCompatActivity() {
    lateinit var bitmap: Bitmap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitmap_binder)
        intent.putExtra("aa", bitmap)

        val intent = Intent()
        intent.putExtra("bitmap", bitmap)


        val bundle = Bundle()
        bundle.putBinder("IBitmapBinder",
            object : IBitmapBinder.Stub() {
                override fun getBitmap(): Bitmap {
                    return bitmap
                }
            })
        intent.putExtra("bitmap", bundle)
//        object : I {
//
//        }
    }
}