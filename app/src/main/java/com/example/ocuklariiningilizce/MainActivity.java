package com.example.ocuklariiningilizce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {
    private LinearLayout lnrAlphabet,lnrNumbers,lnrColours,lnrAnimals,lnrFruits,lnrVegetables,lnrDinle,lnrOgren;
    int kategori=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.lnrAlphabet:
                kategori=Utility.ALPHABET;
                break;
            case R.id.lnrNumbers:
                kategori=Utility.NUMBERS;
                break;
            case R.id.lnrColours:
                kategori=Utility.COLOURS;
                break;
            case R.id.lnrAnimals:
                kategori=Utility.ANIMALS;
                break;
            case R.id.lnrFruits:
                kategori=Utility.FRUITS;
                break;
            case R.id.lnrVegetables:
                kategori=Utility.VEGETABLES;
                break;
        }
        showBottomSheetDialog();
    }

    public void showBottomSheetDialog(){
        final BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(
                MainActivity.this,R.style.bottomSheetDialog
        );
        final View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(
                R.layout.layout_bottom_sheet,
                (LinearLayout)findViewById(R.id.lnrButtomSheet));
        bottomSheetView.findViewById(R.id.lnrOgren).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Pratice.class);
                intent.putExtra("kategori",kategori);
                startActivity(intent);
                bottomSheetDialog.dismiss();
            }
        });

        bottomSheetView.findViewById(R.id.lnrDinle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Listen.class);
              intent.putExtra("kategori",kategori);
                startActivity(intent);
                bottomSheetDialog.dismiss();
            }
        });

        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
    private void findView() {
        lnrAlphabet=findViewById(R.id.lnrAlphabet);
        lnrNumbers=findViewById(R.id.lnrNumbers);
        lnrColours=findViewById(R.id.lnrColours);
        lnrAnimals=findViewById(R.id.lnrAnimals);
        lnrFruits=findViewById(R.id.lnrFruits);
        lnrVegetables=findViewById(R.id.lnrVegetables);
        lnrOgren=findViewById(R.id.lnrOgren);
        lnrDinle=findViewById(R.id.lnrDinle);

    }
}