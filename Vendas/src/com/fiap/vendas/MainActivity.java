package com.fiap.vendas;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

// implementa interface para capturar a��o do bot�o
public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // obt�m um bot�o
        Button botao = (Button) findViewById(R.id.btnPesquisar);
        
        // indica o listener deste bot�o
        botao.setOnClickListener(this);
    }

    // captura a��o do bot�o
	@Override
	public void onClick(View v) {

		// obt�m valor digitado
		TextView codProduto =  (TextView) findViewById(R.id.txtCodigoProduto);
		TextView descricao =  (TextView) findViewById(R.id.txtDescricao);
		
		// retorna em forma de array de bytes
		if (codProduto.getText().toString().equals("1")) {
			descricao.setText("Blusa");
		} else {
			descricao.setText("Cal�a");
		}
		
		AlertDialog.Builder b = new AlertDialog.Builder(this);
		b.setTitle("Volte Sempre");
		b.setMessage("Promo��o de liquida��o na sexta");
		b.setPositiveButton("Ok", null);
		b.show();
	}

}
