package com.example.ocuklariiningilizce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.example.ocuklariiningilizce.Utility.ANIMALS;
import static com.example.ocuklariiningilizce.Utility.COLOURS;
import static com.example.ocuklariiningilizce.Utility.VEGETABLES;

public class Pratice extends AppCompatActivity {
    private TextView tvText,tvSayac,tvOkunus;
    private ImageView imgLeft,imgBack,imgOynat,imgIleri,imgOgrenme;
    private List<Integer> imgViews=new ArrayList<>();
    private List<String> textViews=new ArrayList<>();
    int index=0;
    int kategori;
    TextToSpeech t1;
    String toSpeak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pratice);
        findView();
        Intent intent = getIntent();
        kategori = intent.getIntExtra("kategori", 1);
        setKategory();

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                t1.setLanguage(Locale.ENGLISH);
                t1.setSpeechRate(0.8f);
            }
        });
    }

    private void setKategory() {
        switch (kategori){
            case Utility.ALPHABET:
                ALPHABET();
                break;
            case Utility.NUMBERS:
               NUMBER();
                break;
            case COLOURS:
                COLOUR();
                break;
            case ANIMALS:
                ANIMAL();
                break;
            case Utility.FRUITS:
                FRUIT();
                break;
            case Utility.VEGETABLES:
                VEGETABLE();
                break;
        }
    }

    private void VEGETABLE() {
        imgViews.add(R.drawable.ic_vegetable_broccoli);
        imgViews.add(R.drawable.ic_vegetable_cabbage);
        imgViews.add(R.drawable.ic_vegetable_zucchini);
        imgViews.add(R.drawable.ic_vegetable_carrot);
        imgViews.add(R.drawable.ic_vegetable_eggplant);
        imgViews.add(R.drawable.ic_vegetable_onion);
        imgViews.add(R.drawable.ic_vegetable_potato);
        imgViews.add(R.drawable.ic_vegetable_radish);
        imgViews.add(R.drawable.ic_vegetable_tomato);
        imgViews.add(R.drawable.ic_vegetable_red_pepper);
        textViews.add("Broccoli");
        textViews.add("Cabbage");
        textViews.add("Zucchini");
        textViews.add("Carrot");
        textViews.add("Eggplant");
        textViews.add("Onion");
        textViews.add("Potato");
        textViews.add("Radish");
        textViews.add("Tomato");
        textViews.add("Red Pepper");
        setFillScreen();
    }

    private void FRUIT() {
        imgViews.add(R.drawable.ic_fruit_apple);
        imgViews.add(R.drawable.ic_fruit_orange);
        imgViews.add(R.drawable.ic_fruit_pomegranate);
        imgViews.add(R.drawable.ic_fruit_avakado);
        imgViews.add(R.drawable.ic_fruit_banana);
        imgViews.add(R.drawable.ic_fruit_grapefruit);
        imgViews.add(R.drawable.ic_fruit_grapes);
        imgViews.add(R.drawable.ic_fruit_hindistanceviz);
        imgViews.add(R.drawable.ic_fruit_pear);
        imgViews.add(R.drawable.ic_fruit_strawberry);
        textViews.add("Apple");
        textViews.add("Orange");
        textViews.add("Pomegranate");
        textViews.add("Avocado");
        textViews.add("Banana");
        textViews.add("Grapefruit");
        textViews.add("Grapes");
        textViews.add("Coconut");
        textViews.add("Pear");
        textViews.add("Strawberry");
        setFillScreen();
    }

    private void ANIMAL() {
        imgViews.add(R.drawable.ic_animal_ahtopot);
        imgViews.add(R.drawable.ic_animal_chicken);
        imgViews.add(R.drawable.ic_animal_dolphin);
        imgViews.add(R.drawable.ic_animal_elephan);
        imgViews.add(R.drawable.ic_animal_flamingo);
        imgViews.add(R.drawable.ic_animal_kangroo);
        imgViews.add(R.drawable.ic_animal_lion);
        imgViews.add(R.drawable.ic_animal_zebra);
        imgViews.add(R.drawable.ic_animal_bear);
        imgViews.add(R.drawable.ic_animal_giraffe);
        textViews.add("Octopus");
        textViews.add("Chicken");
        textViews.add("Dolphin");
        textViews.add("Elephant");
        textViews.add("Flamingo");
        textViews.add("Kangaroo");
        textViews.add("Lion");
        textViews.add("Zebra");
        textViews.add("Bear");
        textViews.add("Giraffe");
        setFillScreen();
    }

    private void COLOUR() {
      imgViews.add(R.drawable.ic_colors_blue);
      imgViews.add(R.drawable.ic_colors_purple);
      imgViews.add(R.drawable.ic_colors_turquoise);
      imgViews.add(R.drawable.ic_colors_white);
      imgViews.add(R.drawable.ic_colors_black);
      imgViews.add(R.drawable.ic_colors_gray);
      imgViews.add(R.drawable.ic_colors_green);
      imgViews.add(R.drawable.ic_colors_pink);
      imgViews.add(R.drawable.ic_colors_red);
      imgViews.add(R.drawable.ic_colors_yellow);
        textViews.add("Blue");
        textViews.add("Purple");
        textViews.add("Turqouise");
        textViews.add("White");
        textViews.add("Black");
        textViews.add("Gray");
        textViews.add("Green");
        textViews.add("Pink");
        textViews.add("Red");
        textViews.add("Yellow");
        setFillScreen();
    }

    private void ALPHABET(){
        tvText.setText("ALPHABET");
        imgViews.add(R.drawable.ic_alphabet_a);
        imgViews.add(R.drawable.ic_alphabet_b);
        imgViews.add(R.drawable.ic_alphabet_c);
        imgViews.add(R.drawable.ic_alphabet_d);
        imgViews.add(R.drawable.ic_alphabet_e);
        imgViews.add(R.drawable.ic_alphabet_f);
        imgViews.add(R.drawable.ic_alphabet_g);
        imgViews.add(R.drawable.ic_alphabet_h);
        imgViews.add(R.drawable.ic_alphabet_i);
        imgViews.add(R.drawable.ic_alphabet_j);
        imgViews.add(R.drawable.ic_alphabet_k);
        imgViews.add(R.drawable.ic_alphabet_l);
        imgViews.add(R.drawable.ic_alphabet_m);
        imgViews.add(R.drawable.ic_alphabet_n);
        imgViews.add(R.drawable.ic_alphabet_o);
        imgViews.add(R.drawable.ic_alphabet_p);
        imgViews.add(R.drawable.ic_alphabet_q);
        imgViews.add(R.drawable.ic_alphabet_r);
        imgViews.add(R.drawable.ic_alphabet_s);
        imgViews.add(R.drawable.ic_alphabet_t);
        imgViews.add(R.drawable.ic_alphabet_u);
        imgViews.add(R.drawable.ic_alphabet_v);
        imgViews.add(R.drawable.ic_alphabet_w);
        imgViews.add(R.drawable.ic_alphabet_y);
        imgViews.add(R.drawable.ic_alphabet_x);
        imgViews.add(R.drawable.ic_alphabet_z);
        textViews.add("A");
        textViews.add("B");
        textViews.add("C");
        textViews.add("D");
        textViews.add("E");
        textViews.add("F");
        textViews.add("G");
        textViews.add("H");
        textViews.add("I");
        textViews.add("J");
        textViews.add("K");
        textViews.add("L");
        textViews.add("M");
        textViews.add("N");
        textViews.add("O");
        textViews.add("P");
        textViews.add("Q");
        textViews.add("R");
        textViews.add("S");
        textViews.add("T");
        textViews.add("U");
        textViews.add("V");
        textViews.add("W");
        textViews.add("Y");
        textViews.add("X");
        textViews.add("Z");
        setFillScreen();
    }
    private void NUMBER(){
        tvText.setText("NUMBERS");
        imgViews.add(R.drawable.ic_numbers_zero);
        imgViews.add(R.drawable.ic_numbers_one);
        imgViews.add(R.drawable.ic_numbers_two);
        imgViews.add(R.drawable.ic_numbers_three);
        imgViews.add(R.drawable.ic_numbers_four);
        imgViews.add(R.drawable.ic_numbers_five);
        imgViews.add(R.drawable.ic_numbers_six);
        imgViews.add(R.drawable.ic_numbers_seven);
        imgViews.add(R.drawable.ic_numbers_eight);
        imgViews.add(R.drawable.ic_numbers_nine);
        textViews.add("Zero");
        textViews.add("One");
        textViews.add("Two");
        textViews.add("Three");
        textViews.add("Four");
        textViews.add("Five");
        textViews.add("Six");
        textViews.add("Seven");
        textViews.add("Eight");
        textViews.add("Nine");
        setFillScreen();
    }
    private void setFillScreen(){
        imgOgrenme.setImageResource(imgViews.get(index));
        tvOkunus.setText(textViews.get(index));
        tvSayac.setText(index+"/"+textViews.size());

    }

    public void onNextClick(View view){
        index++;
        setFillScreen();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            t1.speak(tvOkunus.getText().toString(),0,null,null);
        }
        if(index==imgViews.size()-1){
            index=0;
            tvSayac.setText(index+"/"+textViews.size());
        }

    }
    public void onPreviousClick(View view){
        index--;
        if(index==0){
            index=0;
        }
        setFillScreen();

    }

    public void onSpeakClick(View view){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            t1.speak(tvOkunus.getText().toString(),0,null,null);
        }
    }

    private void findView() {
        tvText=findViewById(R.id.tvText);
        tvSayac=findViewById(R.id.tvSayac);
        tvOkunus=findViewById(R.id.tvOkunus);

        imgLeft=findViewById(R.id.imgLeft);
        imgBack=findViewById(R.id.imgBack);
        imgOynat=findViewById(R.id.imgOynat);
        imgIleri=findViewById(R.id.imgIleri);
        imgOgrenme=findViewById(R.id.imgOgrenme);
    }
}