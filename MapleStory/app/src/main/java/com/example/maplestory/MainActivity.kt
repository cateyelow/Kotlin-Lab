package com.example.maplestory

import android.graphics.*
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var ourView: ImageView

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            draw()

            setContentView(ourView)

        }

    fun draw() {
        var blankBitmap: Bitmap
        blankBitmap = Bitmap.createBitmap(1000,1000, Bitmap.Config.ARGB_8888)

        var canvas: Canvas
        canvas = Canvas(blankBitmap)

        ourView = ImageView(this)
        ourView.setImageBitmap(blankBitmap)

        var paint: Paint
        paint = Paint()
        paint.setColor(Color.argb(255,26,128,182))


        var bitmap:Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maple_cow)
        bitmap = Bitmap.createScaledBitmap(bitmap, 2000, 3000, false)

        var matrix: Matrix = Matrix()
        matrix.setScale(-1F, 1F); //좌우대칭 값 -1, 1

        var scaledBitmap: Bitmap
        scaledBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false)

        canvas.drawBitmap(scaledBitmap, Rect(1820,0,2000,400), Rect(100,100,500,800),paint)
        canvas.drawBitmap(bitmap, Rect(0,0,180,400), Rect(500,100,900,800),paint)


        var bitmap_width: Int = bitmap.getWidth()
        var bitmap_height: Int = bitmap.getHeight()
        Log.d("bitmap_size", "bitmap_width : $bitmap_width, bitmap_height : $bitmap_height")
        //원 그림
        //canvas.drawCircle(350f,250f,100f,paint);
    }
}
