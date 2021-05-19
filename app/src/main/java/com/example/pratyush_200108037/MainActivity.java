package com.example.pratyush_200108037;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pratyush_200108037.databinding.ActivityMainBinding;
import com.example.pratyush_200108037.databinding.ActivitySignupBinding;
import com.example.pratyush_200108037.details.Users;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.jar.Attributes;


public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
FirebaseAuth firebaseAuth;
FirebaseDatabase mDatabase;
EditText editText;
EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    EditText editText7;

    ProgressDialog progressDialog;
    EditText here;
    String _name;

    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        auth = FirebaseAuth.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference mDb = mDatabase.getReference();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String userKey = user.getUid();
        editText=(EditText)findViewById(R.id.Name1);
        editText1=(EditText)findViewById(R.id.College1);
        editText2=(EditText)findViewById(R.id.course1);
        editText3=(EditText)findViewById(R.id.current_year1);
        editText4=(EditText)findViewById(R.id.roll_number1);
        editText5=(EditText)findViewById(R.id.emailid1);
        editText6=(EditText)findViewById(R.id.contactno1);
        editText7=(EditText)findViewById(R.id.pass1);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Getting Info ");
        progressDialog.setMessage("Please Wait!");


        mDb.child("Users").child(userKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressDialog.show();
                String userID="--";

                if(dataSnapshot.hasChild("name"))
                 userID = dataSnapshot.child("name").getValue(String.class);

                editText.setText(userID);
                userID="--";
                if(dataSnapshot.hasChild("college"))
                    userID = dataSnapshot.child("college").getValue(String.class);

                editText1.setText(userID);
                userID="--";
                if(dataSnapshot.hasChild("course"))
                {
                    userID = dataSnapshot.child("course").getValue(String.class);
                    count=1;
//                    Toast.makeText(MainActivity.this, "lmaoooooo", Toast.LENGTH_SHORT).show();
                }
                else if(count==0)
                {
                    mDatabase.getReference().child("Users").child(user.getUid()).child("college").setValue("College Not Yet Entered");
                    mDatabase.getReference().child("Users").child(user.getUid()).child("course").setValue("Course Not Yet Entered");
                    mDatabase.getReference().child("Users").child(user.getUid()).child("year").setValue("Year Not Yet Entered");
                    mDatabase.getReference().child("Users").child(user.getUid()).child("roll").setValue("Roll Number Not Yet Entered");
//                    mDatabase.getReference().child("Users").child(user.getUid()).child("emailid").setValue("E-mailNot Yet Entered");
                    mDatabase.getReference().child("Users").child(user.getUid()).child("phoneno").setValue("Phone No. Not Yet Entered");
                        count++;
                }


                editText2.setText(userID);
                userID="--";
                if(dataSnapshot.hasChild("year"))
                    userID = dataSnapshot.child("year").getValue(String.class);
                editText3.setText(userID);
                userID="--";
                if(dataSnapshot.hasChild("roll"))
                    userID = dataSnapshot.child("roll").getValue(String.class);
                editText4.setText(userID);
                userID="--";
                if(dataSnapshot.hasChild("emailid"))
                    userID = dataSnapshot.child("emailid").getValue(String.class);
                editText5.setText(userID);
                userID="--";
                if(dataSnapshot.hasChild("phoneno"))
                    userID = dataSnapshot.child("phoneno").getValue(String.class);
                editText6.setText(userID);

                if(dataSnapshot.hasChild("pass"))
                {     userID = dataSnapshot.child("pass").getValue(String.class);
                editText7.setText(userID);}



            progressDialog.dismiss();
//                Toast.makeText(MainActivity.this, userID, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });



            binding.update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = editText.getText().toString();
                    String college=editText1.getText().toString();
                    String course=editText2.getText().toString();
                    String year=editText3.getText().toString();
                    String roll=editText4.getText().toString();
                    String mail=editText5.getText().toString();
                    String contact=editText6.getText().toString();
                    String pass=editText7.getText().toString();


                    mDb.child("Users").child(userKey).child("name").setValue(name);
                    mDb.child("Users").child(userKey).child("college").setValue(college);
                    mDb.child("Users").child(userKey).child("course").setValue(course);
                    mDb.child("Users").child(userKey).child("year").setValue(year);
                    mDb.child("Users").child(userKey).child("roll").setValue(roll);
                    mDb.child("Users").child(userKey).child("emailid").setValue(mail);
                    mDb.child("Users").child(userKey).child("phoneno").setValue(contact);
//                    mDb.child("Users").child(userKey).child("name").setValue(name);

                    Toast.makeText(MainActivity.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();

                }
            });





//       showalluserdata();




    }

//    private void showalluserdata()
//    {
//        Intent intent=getIntent();
//        _name=intent.getStringExtra("name");
//        textView.setText(_name);
//
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.logout :
                firebaseAuth.signOut();
                Intent intent = new Intent(MainActivity.this, Signin.class);
                startActivity(intent);
            case R.id.DeleteAccount:
                final FirebaseUser user =FirebaseAuth.getInstance().getCurrentUser();
                user.delete();
                mDatabase.getReference().child("Users").child(user.getUid()).removeValue();




                Intent intent2 = new Intent(MainActivity.this, Signin.class);
                startActivity(intent2);




                break;
        }

        return true;
    }
}