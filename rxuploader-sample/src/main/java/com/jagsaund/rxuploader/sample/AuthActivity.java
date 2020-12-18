package com.jagsaund.rxuploader.sample;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import timber.log.Timber;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        SampleApplication
                .authorize()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    Timber.d("auth complete: token=%s token_secret=%s",
                            SampleApplication.getToken(), SampleApplication.getSecret());
                    Toast.makeText(this, "Auth complete", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                }, error -> {
                    Timber.e(error, "Failed to complete auth");
                    Toast.makeText(this, "Auth failed", Toast.LENGTH_LONG).show();
                    finish();
                });
    }
}
