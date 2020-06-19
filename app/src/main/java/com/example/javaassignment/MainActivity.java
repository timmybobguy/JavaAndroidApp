package com.example.javaassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewGroup;
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

        //TableLayout.LayoutParams params = new TableLayout.LayoutParams(100,100);
        TableLayout table = findViewById(R.id.testTable);

        for (int y = 0; y < game.selectedLevel.getHeight(); y++) {

            TableRow row = new TableRow(this);
            row.setGravity(Gravity.CENTER);

            for (int x = 0; x < game.selectedLevel.getWidth(); x++) {

                // THIS GETS CHARACTER
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

        //TableRow row = findViewById(R.id.testRow1);
        //row.setLayoutParams(params);

        //ImageView image = new ImageView(this);



        //image.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        //image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //image.setAdjustViewBounds(true);
        //image.setImageResource(R.drawable.cake);
        //image.setLayoutParams(params);

        //row.addView(image);

        //table.addView(row);

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
