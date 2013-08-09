package com.fiap.vendas;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

// implementa interface para capturar ação do botão
public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // obtém um botão
        Button botao = (Button) findViewById(R.id.btnPesquisar);
        
        // indica o listener deste botão
        botao.setOnClickListener(this);
    }

    // captura ação do botão
	@Override
	public void onClick(View v) {

		// obtém valor digitado
		TextView codProduto =  (TextView) findViewById(R.id.txtCodigoProduto);
		TextView descricao =  (TextView) findViewById(R.id.txtDescricao);
		
		// retorna em forma de array de bytes
		if (codProduto.getText().toString().equals("1")) {
			descricao.setText("Blusa");
		} else {
			descricao.setText("Calça");
		}
		
		AlertDialog.Builder b = new AlertDialog.Builder(this);
		b.setTitle("Volte Sempre");
		b.setMessage("Promoção de liquidação na sexta");
		b.setPositiveButton("Ok", null);
		b.show();
	}

}
