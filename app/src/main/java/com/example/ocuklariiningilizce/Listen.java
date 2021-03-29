package com.example.ocuklariiningilizce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import static com.example.ocuklariiningilizce.Utility.ANIMALS;
import static com.example.ocuklariiningilizce.Utility.COLOURS;

public class Listen extends AppCompatActivity {
    private ImageButton imgCevap1,imgCevap2,imgCevap3,imgCevap4;
    private ImageView imgGeri,imgMusic;
    private TextView tvZaman,tvSayac,tvOkunus;
    private List<Integer> imageViewList=new ArrayList<Integer>();
    private List<String> textViewList=new ArrayList<>();
    private List<Integer>  opList=new ArrayList<>();
    int index=0;
    int kategori;
    int op;
    int trueAnswer=0;
    int falseAnswer=0;
    int answer;
    Random random;
    TextToSpeech t1;
    String toSpeak;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen);
        findView();
        Intent intent = getIntent();
        kategori = intent.getIntExtra("listen", 1);
        setKategory();
        setFillScreen();

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                t1.setLanguage(Locale.ENGLISH);
                t1.setSpeechRate(0.8f);
            }
        });

        imgCevap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    private void setKategory() {
        switch (kategori){
            case Utility.ALPHABET:
                NUMBER();
                break;
            case Utility.NUMBERS:
                NUMBER();
                break;
            case COLOURS:
                NUMBER();
                break;
            case ANIMALS:
                NUMBER();
                break;
            case Utility.FRUITS:
                NUMBER();
                break;
            case Utility.VEGETABLES:
                NUMBER();
                break;
        }
    }
    private void NUMBER() {
        imageViewList.add(R.drawable.ic_numbers_one);
        imageViewList.add(R.drawable.ic_numbers_two);
        imageViewList.add(R.drawable.ic_numbers_three);
        imageViewList.add(R.drawable.ic_numbers_four);
        imageViewList.add(R.drawable.ic_numbers_five);
        imageViewList.add(R.drawable.ic_numbers_six);
        imageViewList.add(R.drawable.ic_numbers_seven);
        imageViewList.add(R.drawable.ic_numbers_eight);
        imageViewList.add(R.drawable.ic_numbers_nine);
        imageViewList.add(R.drawable.ic_numbers_zero);
        textViewList.add("One");
        textViewList.add("Two");
        textViewList.add("Three");
        textViewList.add("Four");
        textViewList.add("Five");
        textViewList.add("Six");
        textViewList.add("Seven");
        textViewList.add("Eight");
        textViewList.add("Nine");
        textViewList.add("Zero");
        setFillScreen();


    }

    public void onSpeakClick(View view){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            t1.speak(textViewList.get(trueAnswer),0,null,null);
        }
    }

    private void setFillScreen() {
        trueAnswer=random.nextInt(4);
        falseAnswer=random.nextInt(imageViewList.size());
        answer=trueAnswer;
        opList.clear();
        opList.add(0);
        opList.add(1);
        opList.add(2);
        opList.add(3);
        op=random.nextInt(4);
        opList.remove(op);
        imageViewList.get(op).toString(answer);
        imgCevap1.setImageResource(imageViewList.get(answer+1));
        imgCevap2.setImageResource(imageViewList.get(answer+2));
        imgCevap3.setImageResource(imageViewList.get(answer+3));
        imgCevap4.setImageResource(imageViewList.get(answer));



    }

    public void onButtonClick(View view){

    }

    private void ALPHABET() {
        imageViewList.add(R.drawable.ic_alphabet_a);
        imageViewList.add(R.drawable.ic_alphabet_b);
        imageViewList.add(R.drawable.ic_alphabet_c);
        imageViewList.add(R.drawable.ic_alphabet_d);
        setFillScreen();
    }


    private void findView() {
        imgGeri=findViewById(R.id.imgGeri);
        imgMusic=findViewById(R.id.imgMusic);
        imgCevap1=findViewById(R.id.imgCevap1);
        imgCevap2=findViewById(R.id.imgCevap2);
        imgCevap3=findViewById(R.id.imgCevap3);
        imgCevap4=findViewById(R.id.imgCevap4);
        tvOkunus=findViewById(R.id.tvOkunus);
        random=new Random();

    }
}