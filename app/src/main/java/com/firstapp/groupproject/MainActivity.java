package com.firstapp.groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class MainActivity extends AppCompatActivity {
    private EditText emailEt, passwordEt;
    private Button SignInButton;
    private TextView SignUpTv;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseauth = FirebaseAuth.getInstance();
        emailEt = findViewById(R.id.email);
        passwordEt = findViewById(R.id.password);
        SignInButton = findViewById(R.id.login);
        progressDialog = new ProgressDialog(this);
        SignUpTv = findViewById(R.id.signUpTv);
        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();

            }
        });
        SignUpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }


    private void Login() {
        String email = emailEt.getText().toString();
        String password = passwordEt.getText().toString();
        if (TextUtils.isEmpty(email)) {
            emailEt.setError("Enter you email-id");
            return;
        } else if (TextUtils.isEmpty(password)) {
            passwordEt.setError("Enter you password");
            return;
        }

        progressDialog.setMessage("Please Wait..");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseauth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Successfully signed in!",
                                    Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(MainActivity.this, "SignIn Failed!",
                                    Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }
                    }
                });

    }
}
