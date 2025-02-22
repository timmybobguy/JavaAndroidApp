package com.example.javaassignment;

import android.view.GestureDetector;
import android.view.MotionEvent;

import sokoban.Direction;

public class SwipeGestureDetector extends GestureDetector.SimpleOnGestureListener {

    private static int MIN_SWIPE_DISTANCE_X = 100;
    private static int MIN_SWIPE_DISTANCE_Y = 100;
    private static int MAX_SWIPE_DISTANCE_X = 1000;
    private static int MAX_SWIPE_DISTANCE_Y = 1000;

    private GameActivity activity = null;

    public GameActivity getActivity() {
        return activity;
    }

    public void setActivity(GameActivity activity) {
        this.activity = activity;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        float deltaX = e1.getX() - e2.getX();
        float deltaY = e1.getY() - e2.getY();

        float deltaXAbs = Math.abs(deltaX);
        float deltaYAbs = Math.abs(deltaY);

        if (deltaXAbs == MIN_SWIPE_DISTANCE_X && deltaXAbs <= MAX_SWIPE_DISTANCE_X) {
            if (deltaX > 0) {
                //this.activity.displayMessage("SWIPED TO LEFT");
                this.activity.game.move(Direction.LEFT);
            } else {
                //this.activity.displayMessage("SWIPED TO RIGHT");
                this.activity.game.move(Direction.RIGHT);
            }
        }

        if (deltaYAbs == MIN_SWIPE_DISTANCE_Y && deltaYAbs <= MAX_SWIPE_DISTANCE_Y) {
            if (deltaY > 0) {
                //this.activity.displayMessage("SWIPED TO UP");
                this.activity.game.move(Direction.UP);
            } else {
                //this.activity.displayMessage("SWIPED TO DOWN");
                this.activity.game.move(Direction.DOWN);
            }
        }

        return true;
    }
}

