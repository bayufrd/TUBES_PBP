package com.example.tubes_pbp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tubes_pbp.api.ApiRegisterData;
import com.example.tubes_pbp.api.Retroserver;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_Panel extends Home_Panel {
    private final String TAG = "LoginActivity";
    public static final String BASE_URL = "http://bayufarid.dx.am/tubespbp/";
    // UI references.
    private EditText mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private TextView failedLoginMessage;
    View focusView = null;
    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panel_login);
// Set up the login form.
        mEmailView = (EditText) findViewById(R.id.edtEmail);
        failedLoginMessage = (TextView)findViewById(R.id.failed_login);
        mPasswordView = (EditText) findViewById(R.id.edtPassword);
        TextView linkDaftar = (TextView) findViewById(R.id.linkDaftar);
        Button mEmailSignInButton = (Button) findViewById(R.id.btnLogin);

        linkDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Panel.this, Register_Panel.class);
                startActivity(intent);
            }
        });

        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.btnLogin || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                failedLoginMessage.setText("Login Gagal!");
                attemptLogin();
            }
        });
    }
    private void attemptLogin(){
        boolean mCancel = this.loginValidation();
        if (mCancel) {
            focusView.requestFocus();
        } else {
            loginProcessWithRetrofit(email, password);
        }
    }
    private boolean loginValidation() {
        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);
        // Store values at the time of the login attempt.
        email = mEmailView.getText().toString();
        password = mPasswordView.getText().toString();
        boolean cancel = false;
        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }
        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }
        return cancel;
    }
    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }
    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }
    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    private void loginProcessWithRetrofit(final String email, String password){
        ApiRegisterData mApiService = Retroserver.getClient().create(ApiRegisterData.class);
        Call<Login> mService = mApiService.authenticate(email, password);
        mService.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                Login mLoginObject = response.body();
                String returnedResponse = mLoginObject.isLogin;
                Toast.makeText(Login_Panel.this, "Returned " + returnedResponse, Toast.LENGTH_LONG).show();
                showProgress(false);
                if(returnedResponse.trim().equals("1")){
                    // redirect to Main Activity page
                    Intent loginIntent = new Intent(Login_Panel.this, HomeAfter_Panel.class);
                    loginIntent.putExtra("EMAIL", email);
                    startActivity(loginIntent);
                }
                if(returnedResponse.trim().equals("0")){
                    // use the registration button to register
                    failedLoginMessage.setText(getResources().getString(R.string.registration_message));
                    mPasswordView.requestFocus();
                }
            }
            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                call.cancel();
                Toast.makeText(Login_Panel.this, "Please check your network connection and internet permission", Toast.LENGTH_LONG).show();
            }
        });
    }
}
