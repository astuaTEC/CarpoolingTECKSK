package com.example.dell.driverapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileManager;
import com.facebook.ProfileTracker;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Clase que maneja la pantalla principal de la app
 */
public class MainActivity extends AppCompatActivity {

    //Atributos
    private CallbackManager callbackManager;
    private AccessTokenTracker accessTokenTracker;
    private ProfileTracker profileTracker;
    LoginButton  loginButton;
    TextView nombre;

    ////////////////////////////////////////////

    /**
     * Metodo para iniciar la ventana
     * @param savedInstanceState la instancia
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppEventsLogger.activateApp(getApplication());
        callbackManager = CallbackManager.Factory.create();
        loginButton = findViewById(R.id.login);
        loginButton.setReadPermissions(Arrays.asList("public_profile","email"));


        if(AccessToken.getCurrentAccessToken() != null){
            goDriverScreen();
        }
        /**
         * Metodo para validar el registro con Facebook
         */
        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                goDriverScreen();

            }
            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "Inicio de sesión Cancelado",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException exception) {
                Toast.makeText(getApplicationContext(), "Ha ocurrido un error",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * Método para dirigirse al menú principal de la app
     */
    private void goDriverScreen() {
        Intent intent = new Intent(this, Driver.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
