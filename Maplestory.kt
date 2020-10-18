package com.example.maplestory

import android.graphics.*
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    // Displays image resources, for example Bitmap or Drawable resources, 레이아웃 위에 덮어씌우는 것도 가능
    lateinit var ourView: ImageView

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            // Buffer에 그림을 다 만들어놓고 화면에 출력할 것임

            draw()

            setContentView(ourView)

        }

    fun draw() {

        // canvas는 그림을 그리는 종이 역할임. blankBitmap으로 1000x1000짜리 공간을 만듬
        var blankBitmap: Bitmap
        blankBitmap = Bitmap.createBitmap(1000,1000, Bitmap.Config.ARGB_8888)

        // canvas 초기화 할때 blankBitmap을 인자로 넘겨주면 1000x1000짜리 종이 완성
        var canvas: Canvas
        canvas = Canvas(blankBitmap)

        // public ImageView (Context context) 형태로 넘겨줌, Context는 액티비티와 애플리케이션에 대한 정보를 얻기 위해서 쓰임
        // Context는 System Handle 과 비슷함.
        // 액티비티는 애플리케이션의 특정 리소스와 클래스, 그리고 애플리케이션 환경에 대한 정보에 대해 접근할 수 있음
        ourView = ImageView(this)
        ourView.setImageBitmap(blankBitmap)

        /* var paint: Paint
        paint = Paint()
        paint.setColor(Color.argb(255,26,128,182)) */

        // Bitmap을 생성해서 이미지를 불러옴
        // decodeResource는 Resource에 있는 이미지를 가져오는 메소드
        // createScaledBitmap 은 이미지 리사이즈 역할을 함
        var bitmap:Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maple_cow)
        bitmap = Bitmap.createScaledBitmap(bitmap, 2000, 3000, false)


        // 캐릭터를 움직이려면 좌우로 움직여야함 원본 이미지는 좌측만 보고 있음
        // 모든 이미지가 좌우대칭되는 matrix를 만듬
        var matrix: Matrix = Matrix()
        matrix.setScale(-1F, 1F); //좌우대칭 값 -1, 1

        // scaledBitmap에 원본이미지 + 좌우대칭 메트릭스를 합침
        var scaledBitmap: Bitmap
        scaledBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false)

        // bitmap, scaledBitmap을 canvas에 그려줌
        canvas.drawBitmap(scaledBitmap, Rect(1820,0,2000,400), Rect(100,100,500,800),null)
        canvas.drawBitmap(bitmap, Rect(0,0,180,400), Rect(500,100,900,800), null )

        // bitmap size 출력
        var bitmap_width: Int = bitmap.getWidth()
        var bitmap_height: Int = bitmap.getHeight()
        Log.d("bitmap_size", "bitmap_width : $bitmap_width, bitmap_height : $bitmap_height")
        //원 그림
        //canvas.drawCircle(350f,250f,100f,paint);
    }
}
