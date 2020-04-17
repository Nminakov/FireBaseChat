package com.example.firebasechat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("messages");

    EditText text;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        button.findViewById(R.id.btn_send);
        text.findViewById(R.id.msg_inp);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = text.getText().toString();

                if (msg.length()==100){
                    Toast.makeText(getApplicationContext(),"Max length of a massage is 100 symbols!",Toast.LENGTH_SHORT).show();
                    return;
                }


                if (msg.equals("")){
                    Toast.makeText(getApplicationContext(),"Type massage, before sending!",Toast.LENGTH_SHORT).show();
                    return;
                }



                myRef.push().setValue(msg);
                text.setText("");
            }
        });





    }
}
