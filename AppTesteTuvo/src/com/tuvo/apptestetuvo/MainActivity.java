package com.tuvo.apptestetuvo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Button button = (Button) findViewById(R.id.botaoLogar);
    	button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // chamar uma nova tela
            	setContentView(R.layout.tela);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    //teste consumir webservice
    /*Webservice ws = new Webservice(this, "http://www.endereco.com.br/CalculadoraWS");
    ws.consumir(xml); */
 
}
