package com.example.fragmentproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragmentproject.fragment.FirstFragment;
import com.example.fragmentproject.fragment.SecondFragment;

public class FragmentDinamis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_dinamis);

        Button btn1, btn2;
        btn1 = findViewById(R.id.btn_first);
        btn2 = findViewById(R.id.btn_second);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Configuration config = getResources().getConfiguration();

        if (config.orientation == Configuration.ORIENTATION_PORTRAIT) {
            //mode
            FirstFragment first = new FirstFragment();
            fragmentTransaction.replace(R.id.frame_fragment, first);
        }else {
            //mode
            SecondFragment second = new SecondFragment();
            fragmentTransaction.replace(R.id.frame_fragment, second);
        }
        fragmentTransaction.commit();

//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment frag = new FirstFragment();
//                //untuk menghapus fragment yang sedang ditampilkan
//                getSupportFragmentManager().popBackStackImmediate();
//                //panggil method untuk menampilkan fragment
//                loadFragment(frag);
//            }
//        });

//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment frag = new SecondFragment();
//                //untuk menghapus fragment yang sedang ditampilkan
//                getSupportFragmentManager().popBackStackImmediate();
//                //panggil method untuk menampilkan fragment
//                loadFragment(frag);
//            }
//        });
    }
    private void loadFragment (Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_fragment, fragment).commit();
    }
}