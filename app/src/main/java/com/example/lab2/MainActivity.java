package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static final private String TAG = "Umpire Buddy v2.0";
    private int strike_count = 0;
    private int ball_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Starting onCreate...");
        setContentView(R.layout.activity_main);

        View Strike = findViewById(R.id.Strike);
        Strike.setOnClickListener(this);
        updateStrikeCount();

        View Ball = findViewById(R.id.Ball);
        Ball.setOnClickListener(this);
        updateBallCount();

        View Reset = findViewById(R.id.Reset);
        Reset.setOnClickListener(this);

        View Exit = findViewById(R.id.Exit);
        Exit.setOnClickListener(this);

        View About = findViewById(R.id.About);
        About.setOnClickListener(this);
    }

    private void updateStrikeCount() {
        TextView t = findViewById(R.id.StrikeCount);
        t.setText(Integer.toString(strike_count));
    }

    private void updateBallCount() {
        TextView t = findViewById(R.id.BallCount);
        t.setText(Integer.toString(ball_count));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Strike:
                if (strike_count == 2) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Strikes");
                    builder.setMessage("Out!");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            strike_count = 0;
                            updateStrikeCount();
                            ball_count = 0;
                            updateBallCount();
                        }
                    });
                    builder.show();
                } else {
                    strike_count++;
                }
                break;

            case R.id.Ball:
                if (ball_count == 3) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Balls");
                    builder.setMessage("Walk!");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            strike_count = 0;
                            updateStrikeCount();
                            ball_count = 0;
                            updateBallCount();
                        }
                    });
                    builder.show();
                } else {
                    ball_count++;
                }
                break;

            case R.id.Reset:
                strike_count = 0;
                updateStrikeCount();
                ball_count = 0;
                updateBallCount();
                break;

            case R.id.About:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("About");
                builder.setMessage("Umpire Buddy 2.0, Brian Kang");
                builder.setCancelable(true);
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
                builder.show();
                break;

            case R.id.Exit:
                finish();
        }
        updateStrikeCount();
        updateBallCount();
    }
}