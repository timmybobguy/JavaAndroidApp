package com.example.javaassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import sokoban.Direction;
import sokoban.Game;

public class MainActivity extends AppCompatActivity {

    private TextView testTextView;
    private GestureDetectorCompat gestureDetectorCompat = null;
    private Game game = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new Game();

        game.addLevel("Test1", 5, 6,"######" +"#+x+.#" +"#..w.#" +"#....#" +"######");

        //testTextView = findViewById(R.id.testText);
        //tv1.setText(game.toString());

        SwipeGestureDetector gestureListener = new SwipeGestureDetector();
        gestureListener.setActivity(this);
        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);

        //Adding grid layout testing

        displayLevel();

        Button up = findViewById(R.id.up);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.move(Direction.UP);
                displayLevel();
            }
        });
        Button down = findViewById(R.id.down);
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.move(Direction.DOWN);
                displayLevel();
            }
        });
        Button left = findViewById(R.id.left);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.move(Direction.LEFT);
                displayLevel();
            }
        });
        Button right = findViewById(R.id.right);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.move(Direction.RIGHT);
                displayLevel();
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return true;
    }


    public void displayMessage(String message) {
        testTextView.setText(message);
    }

    public void displayLevel() {

        TableLayout table = findViewById(R.id.testTable);

        //Removing previous table
        int count = table.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = table.getChildAt(i);
            if (child instanceof TableRow) ((ViewGroup) child).removeAllViews();
        }


        for (int y = 0; y < game.selectedLevel.getHeight(); y++) {

            TableRow row = new TableRow(this);
            row.setGravity(Gravity.CENTER);

            for (int x = 0; x < game.selectedLevel.getWidth(); x++) {

                char icon = game.selectedLevel.getXY(x,y);

                ImageView cell = new ImageView(this);

                cell.setScaleType(ImageView.ScaleType.CENTER_CROP);
                cell.setAdjustViewBounds(true);

                switch (icon) {

                    case '+':
                        cell.setImageResource(R.drawable.goal);
                        break;
                    case '#':
                        cell.setImageResource(R.drawable.wall);
                        break;
                    case '.':
                        cell.setImageResource(R.drawable.floor);
                        break;
                    case 'w':
                    case 'W':
                        cell.setImageResource(R.drawable.player);
                        break;
                    case 'x':
                        cell.setImageResource(R.drawable.crate);
                        break;
                    case 'X':
                        cell.setImageResource(R.drawable.crate_ontarget);
                        break;
                }
                row.addView(cell);
            }
            table.addView(row);
        }
    }

}
