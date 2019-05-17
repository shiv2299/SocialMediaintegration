package com.example.shivam.socialmediaintegration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;

public class Profile extends AppCompatActivity {

    ImageView profile;
    TextView uname,uemail;
    LoginButton loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profile=findViewById(R.id.profile);
        uname=findViewById(R.id.name);
        uemail=findViewById(R.id.email);
        loginButton=findViewById(R.id.login_button);

        String name=getIntent().getStringExtra("name");
        String email=getIntent().getStringExtra("email");
        String photo=getIntent().getStringExtra("photo");
        uname.setText(name);
        uemail.setText(email);
        Glide.with(this).load("http://graph.facebook.com/"+photo+"/picture?type=large").into(profile);
        if (AccessToken.getCurrentAccessToken() != null && com.facebook.Profile.getCurrentProfile() != null){
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    LoginManager.getInstance().logOut();
                    startActivity(new Intent(Profile.this,MainActivity.class));
                }
            });
        }

    }
}
