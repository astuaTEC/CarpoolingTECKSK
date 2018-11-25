package com.example.dell.driverapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.driverapp.Fragmentos.Fragmento1;
import com.example.dell.driverapp.Fragmentos.Fragmento2;
import com.example.dell.driverapp.Fragmentos.Fragmento3;
import com.example.dell.driverapp.Fragmentos.Fragmento4;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.parse.Parse;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

/**
 * Clase encargada de manejar todas las interfaces que pertencen al menú principal
 */
public class Driver extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //Atributos
    NavigationView navigationView;
    View header;
    String carnet1;
    String nombre;
    Boolean carpoolin = false;
    boolean pasarXmi;
    boolean amigoXmi;
    TextView txtCarnet;
    Fragmento1 fragmento1 = new Fragmento1();
    Fragmento2 fragmento2 = new Fragmento2();
    Fragmento3 fragmento3 = new Fragmento3();
    Fragmento4 fragmento4 = new Fragmento4();
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Metodo encargado de iniciar la ventana
     * @param savedInstanceState instancia
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //Se inicia la conexion con la API
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("MITnxoyZWtxjPvFbk8yYqljyYxLzgDMF7pT1Nf2x")
                .clientKey("Bqpb6Pu9PwqumuRCsWXQn8N6HRgYmldcQGUH0Je8")
                .server("https://parseapi.back4app.com/")
                .build()
        );

        //Se accede al nav view
        navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        header = navigationView.getHeaderView(0);
        final TextView txtUser =  header.findViewById(R.id.nombre);
        final TextView txtEmail = header.findViewById(R.id.correo);
        txtCarnet = header.findViewById(R.id.textView5);
        txtCarnet.setText(carnet1);

        //se accede a los atributos proporcionados por Facebook
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        GraphRequest request = GraphRequest.newMeRequest(
                accessToken,
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(
                            JSONObject object,
                            GraphResponse response) {
                        try {
                            String Name = object.getString("name");
                            txtUser.setText(Name);
                            String FEmail = object.getString("email");
                            txtEmail.setText(FEmail);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,link,email");
        request.setParameters(parameters);
        request.executeAsync();
        cargarFragmento(fragmento2);
        }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.driver, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Metodo para la navegacon en el menu
     * @param item el item que tocamos
     * @return true o false
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            actualizar();
            cargarFragmento(fragmento2);
        } else if (id == R.id.navegar) {
            actualizar();
            navegar();
        } else if (id == R.id.amigos) {
            cargarFragmento(fragmento1);
        } else if (id == R.id.sesion) {
            Logout();
        } else if (id == R.id.nav_send) {
            startActivity(new Intent(Driver.this,Pop.class));
        }
        else if(id == R.id.opciones){
            cargarFragmento(fragmento4);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Metodo encargado de la navegacion entre fragmentos
     * @param fragment el fragmento al que se quiere ir
     */
    private void cargarFragmento(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.Contenedor1, fragment).commit();
    }

    /**
     * Metodo encargado de ir a la pantalla principal
     */
    private void goMainScreen(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

    /**
     * Metodo encargado de cerrar la sesion de Facebook
     */
    private void Logout(){
        LoginManager.getInstance().logOut();
        goMainScreen();
    }

    /**
     * Metodo encargado de actualizar los datos mas necesarios para validaciones
     */
    public void actualizar(){
        Bundle bundle = getIntent().getExtras();
        if(carnet1 == null){
            carnet1 = bundle.getString("info");
            txtCarnet.setText(carnet1);
        }
        if(!Objects.equals(bundle.getString("car"), "")){
            carpoolin = true;
        }
        else{
            carpoolin= false;
        }

        if(bundle.getString("xmi") != null){
            pasarXmi = true;
        }
        else{
            pasarXmi = false;
        }
        if (bundle.getString("amigo")!= null){
            amigoXmi = true;
        }
        else {
            amigoXmi = false;
        }
    }
    /**
     * Metodo encargado de validar datos y dar la opción de abrir el mapa
     */
    public void navegar() {
        if (!txtCarnet.getText().equals("") && carpoolin) {
            Toast.makeText(getApplicationContext(), "Registro correcto", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Driver.this, MapsActivity.class));
        } else {
            if (txtCarnet.getText().equals("")) {
                Toast.makeText(getApplicationContext(), "Registra el Carnet", Toast.LENGTH_SHORT).show();
            }
            if (!carpoolin) {
                Toast.makeText(getApplicationContext(), "Activa el Carpooling", Toast.LENGTH_SHORT).show();
            }
            cargarFragmento(fragmento3);
        }
    }
}
