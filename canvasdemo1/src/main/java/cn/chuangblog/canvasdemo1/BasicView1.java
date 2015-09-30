package cn.chuangblog.canvasdemo1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author : created by chuangWu
 * @version : 0.01
 * @email : chuangwu127@gmail.com
 * @created time : 2015-09-29 11:39
 * @description : none
 * @for your attention : none
 * @revise : none
 */
public class BasicView1 extends View {

    Paint paint;

    public BasicView1(Context context) {
        super(context);
    }

    public BasicView1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    /**
     * canvas获取方式,new Canvas/SurfaceHolder.lockCanvas/onDraw
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //背景色
        paint.setColor(Color.WHITE);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        drawStokeShape(canvas);
        drawFillShape(canvas);
        drawShaderShape(canvas);
    }

    private void drawShaderShape(Canvas canvas) {
        Shader mShader = new LinearGradient(0, 0, 100, 100, new int[] {
                Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW }, null,
                Shader.TileMode.REPEAT);
        paint.setShader(mShader);

        //圆
        canvas.drawCircle(200, 40, 30, paint);
        //正方形
        canvas.drawRect(170, 90, 230, 150, paint);
        //长方形
        canvas.drawRect(170, 170, 230, 200, paint);
        //椭圆
        RectF re3 = new RectF(170, 220, 230, 250);
        canvas.drawOval(re3, paint);
        //三角形
        Path path4 = new Path();
        path4.moveTo(170, 330);
        path4.lineTo(230, 330);
        path4.lineTo(200, 270);
        path4.close();
        canvas.drawPath(path4, paint);
        //梯形
        Path path5 = new Path();
        path5.moveTo(170, 410);
        path5.lineTo(230, 410);
        path5.lineTo(215, 350);
        path5.lineTo(185, 350);
        path5.close();
        canvas.drawPath(path5, paint);

        //写字
        paint.setTextSize(24);
        canvas.drawText(getResources().getString(R.string.str_text1), 240, 50,paint);
        canvas.drawText(getResources().getString(R.string.str_text2), 240, 120,paint);
        canvas.drawText(getResources().getString(R.string.str_text3), 240, 190,paint);
        canvas.drawText(getResources().getString(R.string.str_text4), 240, 250,paint);
        canvas.drawText(getResources().getString(R.string.str_text5), 240, 320,paint);
        canvas.drawText(getResources().getString(R.string.str_text6), 240, 390,paint);
    }

    /**
     * 画实心形状
     * @param canvas
     */
    private void drawFillShape(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        //圆
        canvas.drawCircle(120, 40, 30, paint);
        //正方形
        canvas.drawRect(90, 90, 150, 150, paint);
        //长方形
        canvas.drawRect(90, 170, 150, 200, paint);
        ///椭圆
        RectF re2 = new RectF(90, 220, 150, 250);
        canvas.drawOval(re2, paint);
        //三角形
        Path path2 = new Path();
        path2.moveTo(90, 330);
        path2.lineTo(150, 330);
        path2.lineTo(120, 270);
        path2.close();
        canvas.drawPath(path2, paint);
        //梯形
        Path path3 = new Path();
        path3.moveTo(90, 410);
        path3.lineTo(150, 410);
        path3.lineTo(135, 350);
        path3.lineTo(105, 350);
        path3.close();
        canvas.drawPath(path3, paint);
    }

    /**
     * 画空心形状
     * @param canvas
     */
    private void drawStokeShape(Canvas canvas) {
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        //圆
        canvas.drawCircle(40, 40, 30, paint);
        //正方形
        canvas.drawRect(10, 90, 70, 150, paint);
        //长方形
        canvas.drawRect(10, 170, 70, 200, paint);
        //椭圆形
        RectF re = new RectF(10, 220, 70, 250);
        canvas.drawOval(re, paint);
        //三角形
        Path path = new Path();
        path.moveTo(10, 330);
        path.lineTo(70, 330);
        path.lineTo(40, 270);
        path.close();//记得要close
        canvas.drawPath(path, paint);
        //梯形
        Path path1 = new Path();
        path1.moveTo(10, 410);
        path1.lineTo(70, 410);
        path1.lineTo(55, 350);
        path1.lineTo(25, 350);
        path1.close();
        canvas.drawPath(path1, paint);
    }
}
