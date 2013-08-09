package com.tuvo.apptestetuvo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class Webservice {
   
    private static final String CATEGORIA = "WebService";
   
    private static int CONNECTION_TIMEOUT = 3750;
    private static int SOCKET_TIMEOUT = 5000;
    private static String ENCODING = "UTF-8";
   
    private HttpClient cliente = null;
    private HttpPost post = null;
    private HttpResponse resposta  = null;
    private HttpEntity entity = null;
    private HttpParams httpParameters = null;
    private Context context = null;
   
    public Webservice(Context context, String URL){
        this.context = context;
        httpParameters = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParameters, CONNECTION_TIMEOUT);
        HttpConnectionParams.setSoTimeout(httpParameters, SOCKET_TIMEOUT);
        cliente = new DefaultHttpClient(httpParameters);
        post = new HttpPost(URL);
        post.setHeader("SOAPAction", "urn:execute"); //No meu caso usei este HEADER!
    }

    /**
     *
     * @param xml, XML que deverá ser enviado ao WS.
     * @return mensagem de retorno do WS.
     * @throws Exception 
     */
    public String consumirWebService(String xml) throws Exception {
        String retorno = "";
        try {
            entity = consumir(xml);
            if (entity != null) {
                retorno = entityToString(entity);
                //Pode ser tratado de várias maneiras aqui, usando DocumentBuilder       
            }
            return retorno;
        } catch (Exception e) {
            Log.d(CATEGORIA, e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
   
    private HttpEntity consumir(String xml) throws Exception {
        try {
            isConnected();           
            entity = new StringEntity(xml, ENCODING);       
            post.setEntity(entity);   
            resposta = cliente.execute(post);
            return resposta.getEntity();
        } catch (UnsupportedEncodingException e) {
            Log.e(CATEGORIA, "[3] " + e.getMessage());
            throw new Exception("Erro no arquivo XML.");
        } catch (ClientProtocolException e) {
            Log.e(CATEGORIA, "[2] " + e.getMessage());
            throw new Exception("Erro no protocolo.");
        } catch (IOException e) {
            Log.e(CATEGORIA, "[1] " + e.getMessage());
            throw new Exception("Erro ao baixar dados do Servidor.\nVerifique sua conexão com a Internet.");
        }
    }
   
    public void isConnected() throws Exception {
        NetworkInfo info = null;
        info = ((ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (info == null || !info.isConnected()) {
            throw new Exception("Verifique sua conexão com a Internet.");
        }
        if (info.isRoaming()) {
            throw new Exception("Verifique sua conexão com a Internet.");
        }
    }
   
    private String entityToString(HttpEntity entity) throws Exception {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            entity.writeTo(byteArrayOutputStream);
            return byteArrayOutputStream.toString();
        } catch (IOException e) {
            Log.d(CATEGORIA, e.getMessage());
            throw new Exception("Erro ao efetuar download.");
        }
       
    }   
   
}


/*<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ns="http://exemplo.com.br/WebService/SOAP">
<soapenv:Header/>
<soapenv:Body>
<ns:execute>
!! OS DADOS PARA O SEU WEBSERVICE !!</ns:execute>
</soapenv:Body>
</soapenv:Envelope>*/
