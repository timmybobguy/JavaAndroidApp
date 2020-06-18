package com.example.javaassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import sokoban.Game;

public class MainActivity extends AppCompatActivity {

    private TextView testTextView;
    private GestureDetectorCompat gestureDetectorCompat = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Game game = new Game();

        game.addLevel("Test1", 5, 6,"######" +"#+x+.#" +"#..w.#" +"#....#" +"######");

        testTextView = findViewById(R.id.testText);
        //tv1.setText(game.toString());

        SwipeGestureDetector gestureListener = new SwipeGestureDetector();
        gestureListener.setActivity(this);
        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);

        //Adding grid layout testing
        TableLayout.LayoutParams params = new TableLayout.LayoutParams(100,100);

        TableLayout table = findViewById(R.id.testTable);

        TableRow row = new TableRow(this);
        row.setLayoutParams(params);

        ImageView image = new ImageView(this);
        image.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        image.setLayoutParams(params);

        row.addView(image);

        table.addView(row);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return true;
    }


    public void displayMessage(String message) {
        testTextView.setText(message);
    }

}
