package com.example.pratyush_200108037;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pratyush_200108037.databinding.ActivitySignupBinding;
import com.example.pratyush_200108037.details.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class Signup extends AppCompatActivity {

    ActivitySignupBinding binding;
    private FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        binding = ActivitySignupBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();

        progressDialog = new ProgressDialog(Signup.this);
        progressDialog.setTitle("Creating Right Now");
        progressDialog.setMessage("Creating RN");

        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            progressDialog.show();
                    auth.createUserWithEmailAndPassword(binding.emailid.getText().toString(),
                            binding.pass.getText().toString()).
                            addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull  Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if(task.isSuccessful())
                            {
                                Users user=new Users(binding.Name.getText().toString() , binding.College.getText().toString() , binding.course.getText().toString() , binding.currentYear.getText().toString(), binding.rollNumber.getText().toString(), binding.emailid.getText().toString(),binding.contactno.getText().toString(),binding.pass.getText().toString());
                                String id=task.getResult().getUser().getUid();
                                database.getReference().child("Users").child(id).setValue(user);


                                Toast.makeText(Signup.this, "User created!", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(Signup.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });




            }
        });
        binding.already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Signup.this , Signin.class);
                startActivity(intent);

            }
        });


    }
}