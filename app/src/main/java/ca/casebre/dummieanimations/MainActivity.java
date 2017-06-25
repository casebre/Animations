package ca.casebre.animations;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final long DEFAULT_ANIMATION_DURATION = 2500L;
    private LinearLayout layout;
    private EditText editText;
    private TextView textView, money;
    private String source = "";
    private int count = 0;
    private Button btnSpin;
    private NumberPicker picker;

    private ImageView needle;
    private FrameLayout mFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_base_animation);
        needle = (ImageView) findViewById(R.id.image_needle);
        mFrameLayout = (FrameLayout) findViewById(R.id.container);
        /*layout = (LinearLayout) findViewById(R.id.layout);
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.hello);
        btnSpin = (Button) findViewById(R.id.spin);
        money = (TextView) findViewById(R.id.money);
        picker = (NumberPicker) findViewById(R.id.numberPicker);
        */

        mFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*count = textView.length();
                editText.setText("");
                source = "";*/
                ValueAnimator animator = ValueAnimator.ofFloat(0, 180); // 1/2 circumference
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float value = (float) animation.getAnimatedValue();
                        // 2
                        Log.d("DEBUG", "X " + needle.getPivotX());
                        Log.d("DEBUG", "Y " + needle.getPivotY());
                        needle.setPivotX(94);
                        needle.setPivotY(4);
                        //needle.setPivotY(needle.getHeight()/2);

                        needle.setRotation(value);


                        /*float value = (float)animation.getAnimatedValue();
                        editText.setTranslationX(value);
                        editText.setText(source);
                        source = source + textView.getText().charAt(count-1);
                        count--;
                        if(count == 0)
                            animation.cancel();
                            */
                    }
                });
                animator.setInterpolator(new LinearInterpolator());
                animator.setDuration(DEFAULT_ANIMATION_DURATION);
                animator.start();
            }
        });

        /*btnSpin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ValueAnimator spinAnimator = ValueAnimator.ofFloat(0, money.getHeight());
                spinAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {

                    }
                });
                picker.setValue(100);
            }
        });
        */

    }
}
