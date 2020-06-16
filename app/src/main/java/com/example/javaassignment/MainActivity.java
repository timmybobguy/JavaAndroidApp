package com.example.javaassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.view.MotionEvent;
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
