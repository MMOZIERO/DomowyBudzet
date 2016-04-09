package dziennik.domowybudzet;

import android.content.Intent;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import android.os.Handler;
/*


w android manifest przeniosłem <intent-filter> z mainactivity do splash screen, aplikacja odpala sie od tej
aktywnosci a po 3 sekundach odpala główną

*/

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            hideSystemUI();
        }


       animate();

        // Start the animation (looped playback by default).

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                startActivity(new Intent(SplashScreen.this, MainActivity.class));

                SplashScreen.this.finish();
            }
        },3000);

    }


    private void animate(){
        setContentView(R.layout.activity_splash_screen);

        final ImageView img = (ImageView) findViewById(R.id.imageView);
        img.setBackgroundResource(R.drawable.splash_animation);

        // Get the background, which has been compiled to an AnimationDrawable object.

        final AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
        frameAnimation.start();
    }

    private void hideSystemUI() {
        // Set the IMMERSIVE flag.
        // Set the content to appear under the system bars so that the content
        // doesn't resize when the system bars hide and show.
        View mDecorView = getWindow().getDecorView();
        mDecorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }

}
