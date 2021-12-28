package com.example.part18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class part18_4 extends AppCompatActivity{
    Button btn;
    CoordinatorLayout coordinatorLayout;
    BottomSheetBehavior<View> persistentBottomSheet;
    BottomSheetDialog modalBottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part184);

        coordinatorLayout = (findViewById(R.id.part18_4_coordinator));
        btn = findViewById(R.id.part18_4_modal);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDialog();
            }
        });
        initPersistentBottomSheet();
    }

    void createDialog(){

        View view = getLayoutInflater().inflate(R.layout.albis, null);
        modalBottomSheet = new BottomSheetDialog(this);
        modalBottomSheet.setContentView(view);
        modalBottomSheet.show();

    }

    void initPersistentBottomSheet(){
        View bootSheet = coordinatorLayout.findViewById(R.id.part18_4_bottom_shit);
        persistentBottomSheet = BottomSheetBehavior.from(bootSheet);
    }
}