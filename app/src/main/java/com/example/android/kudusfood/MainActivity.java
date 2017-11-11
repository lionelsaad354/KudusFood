package com.example.android.kudusfood;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_profile) {
            startActivity(new Intent(getApplicationContext(), Profile.class));
            return true;
        }
        if (id == R.id.action_version) {
            startActivity(new Intent(getApplicationContext(), Version.class));
            return true;
        }
        if (id == R.id.action_quit) {
            showDialogExit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void sotoKudus(View view){
        startActivity(new Intent(getApplicationContext(), SotoKudus.class));
    }
    public void lentogTanjung(View view){
        startActivity(new Intent(getApplicationContext(), LentogTanjung.class));
    }
    public void nasiPindang(View view){
        startActivity(new Intent(getApplicationContext(), NasiPindang.class));
    }
    public void pecelPakisColo(View view){
        startActivity(new Intent(getApplicationContext(), PecelPakisColo.class));
    }
    public void garangAsem(View view){
        startActivity(new Intent(getApplicationContext(),GarangAsem.class));
    }
    public void showDialogExit(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Keluar dari Aplikasi Kudus Food?");
        alertDialogBuilder
                .setMessage("Tekan Ya untuk keluar")
                .setIcon(R.mipmap.ic_launcher_round)
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    public void onBackPressed(){
        super.onBackPressed();
        showDialogExit();
    }
}
