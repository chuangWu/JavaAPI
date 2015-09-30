package cn.chuangblog.canvasdemo1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

/**
 * @author : created by chuangWu
 * @version : 0.01
 * @email : chuangwu127@gmail.com
 * @created time : 2015-09-29 12:45
 * @description : none
 * @for your attention : none
 * @revise : none
 */
public class BasicView2 extends View {
    Paint paint;
    Bitmap bitmap;

    public BasicView2(Context context) {
        super(context);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
    }

    private Bitmap createBitmap1() {
        Bitmap bitmap1 = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        canvas.drawColor(Color.BLUE);
//          canvas.drawARGB(0, 0, 0, 0);// 透明色
        canvas.drawBitmap(bitmap, 0, 0, paint);
        paint.setColor(Color.RED);
        canvas.drawText("Hello Android", 25, 55, paint);
        return bitmap1;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 绘制位图
        // 1.绘制位图在（10，10）位置上
        canvas.drawBitmap(createBitmap1(), 10, 10, paint);
        // 2.   canvas.drawBitmap(Bitmap bitmap,Rect src,Rect dest,Paint paint);
        //      canvas.drawBitmap(Bitmap bitmap,Rect src,RectF dest,Paint paint);
        //  绘制位图到一个指定的矩形dest中，位图会自动进行平移和缩放等操作，如果src的参数不为null
        // 则会裁剪位图的部分区域来进行绘制
        Rect rect = new Rect(10, 10, 50, 60);
        RectF rectF1 = new RectF(180.0f, 20.0f, 240.0f, 80.0f);
        RectF rectF2 = new RectF(180.0f, 100.0f, 240.0f, 160.0f);
        canvas.drawBitmap(createBitmap1(), null, rectF1, paint);
        canvas.drawBitmap(createBitmap1(), rect, rectF2, paint);

        // 点
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(5.0f);
        paint.setColor(Color.BLACK);
        canvas.drawPoints(new float[]{120, 120, 140, 140, 160, 160, 180, 180}, paint);

        // 线
        paint.reset();// 重置画笔
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);
        canvas.drawLine(30, 30, 130, 40, paint);
        paint.setColor(Color.RED);
        canvas.drawLines(new float[]{40, 40, 140, 40, 50, 50, 90, 90}, paint);

        // 矩形
        paint.setColor(Color.CYAN);
        canvas.drawRect(10, 150, 150, 250, paint);
        paint.setColor(Color.GRAY);
        canvas.drawRect(new Rect(10, 260, 150, 280), paint);
        paint.setColor(Color.DKGRAY);
        canvas.drawRect(new RectF(20.2f, 290.9f, 120.2f, 300.3f), paint);

        // 绘制文本
          paint.setTextSize(20);
          paint.setColor(0x40ffffff);// 半透明白色
          paint.setTextAlign(Paint.Align.RIGHT);// 对齐方向
          canvas.drawText("Cool Android", 250, 180, paint);// 这里注意，坐标(180,180)是文本的左下点坐标

        // 画布平移：
        // 平移的单位是像素，分别是在x,y轴上平移的像素点
        // 正数代表的正方向，x轴为平面的右侧，y轴为平面的下方，相应的，负数则向反方向平移
//          canvas.translate(30.0f, 30.0f);

        // 画布缩放：
        // 参数分别是在想x，y轴上放大或缩小的倍数，大雨1为放大，小于1为缩小，
        // 缩放的原点默认为画布的原点(0,0)，也可以指定缩放的原点
//          canvas.scale(2.0f, 1.5f);
//          canvas.scale(0.5f, 0.5f, 100.0f, 100.0f);// 指定坐标(100.0f,100.0f)为缩放原点
        // 这里剖析一下第二个缩放方法，其实系统为我们做的事情是这样的
            /*
               scale(float sx, float sy, float px, float py){
                    translate(px,py);
                    scale(sx,sy);
                    translate(-px,-py);
                }
            */

        // 画布旋转
        // 1.以画布为原点，顺时针旋转40.0f度
//          canvas.rotate(40.0f);
        // 2.以(100.11f, 100.22f)为原点，顺时针旋转50.0f度
//          canvas.rotate(50.0f, 100.11f, 100.22f);
        // 相应的，为了加深理解，我们再剖析一下第二个旋转方法
        // ，其实系统为我们做的事情是这样的
            /*
               rotate(float degrees, float px, float py){
                    translate(px,py);
                    rotate(degrees);
                    translate(-px,-py);
                }
            */

        // 画布倾斜
        // skew(float sx,float xy);将画布在x及y轴方向上倾斜相应的角度，sx或sy为倾斜角度的tan值，
        // 如canvas.skew(1,0);为在x方向上倾斜45度 >> tan(45) = 1
//          canvas.skew(1,0);
    }

}
