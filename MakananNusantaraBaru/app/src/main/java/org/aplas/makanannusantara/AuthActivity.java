package org.aplas.makanannusantara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

import com.google.android.material.snackbar.Snackbar;

import org.aplas.makanannusantara.model.User;

public class AuthActivity extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup, signin;
    DBHelper DB;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        signup = (Button) findViewById(R.id.btnsignup);
        signin = (Button) findViewById(R.id.btnsignin);
        DB = new DBHelper(this);
        user = new User();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String et_user = username.getText().toString().trim();
                String et_pass = password.getText().toString().trim();
                String et_repass = repassword.getText().toString().trim();

                if (et_user.equals("") || et_pass.equals("") || et_repass.equals(""))
                    Toast.makeText(AuthActivity.this, "Please enter all the fields",
                            Toast.LENGTH_SHORT).show();
                else {
                    if (et_pass.equals((et_repass))) {
                        Boolean checkuser = DB.checkUser(et_user, et_pass);
                        if (checkuser == false) {
                            user.setName(et_user);
                            user.setPassword(et_pass);

                            DB.addUser(user);

                            // Snack Bar to show success message that record saved successfully
                            Toast.makeText(AuthActivity.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                            emptyInputEditText();
                        } else {
                            Toast.makeText(AuthActivity.this, "User already exists! Please Sign In", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(AuthActivity.this, "Password not matching!", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);

            }
        });

    }

    private void emptyInputEditText() {
        username.setText(null);
        password.setText(null);
        repassword.setText(null);
    }
}
