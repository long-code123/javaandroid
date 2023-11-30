package com.example.logbook2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btnLeft, btnRight;
    ImageView ivDog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refView();
        ivDog.setImageResource(R.drawable.pic1);

        final int[] i = {1};

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i[0]--;
                if (i[0] == 0) {
                    i[0] = 3;
                }
                changeImage(i[0]);
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i[0]++;
                if (i[0] == 4) {
                    i[0] = 1;
                }
                changeImage(i[0]);
            }
        });


    }

    public void changeImage(int i) {
        switch (i) {
            case 1:
                ivDog.setImageResource(R.drawable.pic1);
                break;
            case 2:
                ivDog.setImageResource(R.drawable.pic2);
                break;
            case 3:
                ivDog.setImageResource(R.drawable.pic3);
                break;
            default:
                ivDog.setImageResource(R.drawable.pic1);
                break;
        }
    }

    private void refView() {
        btnLeft = findViewById(R.id.btnLeft);
        btnRight = findViewById(R.id.btnRight);
        ivDog = findViewById(R.id.ivDog);
    }
}