package com.example.quizerev.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quizerev.Config;
import com.example.quizerev.Model.User;
import com.example.quizerev.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class RegisterActivity extends AppCompatActivity {
    EditText edit_name,edit_email,edit_login,edit_password;
    Button btn_register;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edit_name=findViewById(R.id.edit_name_register);
        edit_email=findViewById(R.id.edit_email_register);
        edit_login=findViewById(R.id.edit_Login_register);
        edit_password=findViewById(R.id.edit_password_register);
        btn_register=findViewById(R.id.btn_register_register);
        mAuth = FirebaseAuth.getInstance();
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(edit_name.getText().toString())
                || TextUtils.isEmpty(edit_email.getText().toString())
                || TextUtils.isEmpty(edit_login.getText().toString())
                || TextUtils.isEmpty(edit_password.getText().toString()))
                {
                    Toast.makeText(RegisterActivity.this,"ERR",Toast.LENGTH_LONG).show();
                }else
                {
                    String name=edit_name.getText().toString();
                    String email=edit_email.getText().toString();
                    String login=edit_login.getText().toString();
                    String password=edit_password.getText().toString();
                    /*for (User usr :Config.users )
                    {
                        if(usr.getLogin().equals(login))
                        {
                            Toast.makeText(RegisterActivity.this,"User exist",Toast.LENGTH_LONG).show();
                            return;
                        }
                    }
                    User user=new User(name,email,login,password);
                    Config.users.add(user);*/
                    mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser fuser = mAuth.getCurrentUser();
                                mAuth.getCurrentUser();
                                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder().setDisplayName(edit_name.getText().toString()).build();
                                fuser.updateProfile(profileUpdates);
                                Toast.makeText(RegisterActivity.this,"User registered successfully",Toast.LENGTH_LONG).show();
                                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(RegisterActivity.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }
            }
        });

    }
}
