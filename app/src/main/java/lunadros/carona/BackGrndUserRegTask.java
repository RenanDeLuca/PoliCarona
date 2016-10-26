package lunadros.carona;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Renan Avila on 24/04/2016.
 */
public class BackGrndUserRegTask extends AsyncTask<String,Void,String>{

    Context ctx;
    AlertDialog alertDialog;

    BackGrndUserRegTask(Context ctx)
    {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {

        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Event Information");
    }

    @Override
    protected String doInBackground(String... params) {

        String reg_url = "http://"+ R.string.serverIp +"/caronaApp/RegisterUser.php";

        String resultado = "nada";

            Log.e("backgroundregtask","entrou no register_event");

            String usuario = params[0], nome = params[1], senha = params[2], email = params[3];

            try{
                Log.e("backgroundregtask","conseguiu formar a url e se conectar");

                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

                String data =
                             URLEncoder.encode("usuario","UTF-8") + "=" + URLEncoder.encode(usuario,"UTF-8")+"&"+
                                     URLEncoder.encode("nome","UTF-8") + "=" + URLEncoder.encode(nome,"UTF-8")+"&"+
                                     URLEncoder.encode("senha","UTF-8") + "=" + URLEncoder.encode(senha,"UTF-8")+"&"+
                                     URLEncoder.encode("email","UTF-8") + "=" + URLEncoder.encode(email,"UTF-8")+"&";

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();

                Log.e("BackgroundRegTask","setou resultado criado!");

                resultado = "Criado";

            }catch (MalformedURLException e){
                Log.e("backgroundregtask","caiu na excecao de malformed url");
                e.printStackTrace();
            }catch (IOException e){
                Log.e("backgroundregtask","caiu na excecao de IOexception");
                e.printStackTrace();
            }

        return resultado;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {

        Log.e("backgriundregtask","entrou no post execute com result = "+ result);

        if(result.matches("Criado!"))
        {
            Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
        }

        else if(result.matches("nada"))
        {
            Toast.makeText(ctx,"Nada Ocorreu, pois nenhuma das implementacoes abrange a solicitacao",Toast.LENGTH_LONG).show();
        }
        else{
            alertDialog.setMessage(result);
            alertDialog.show();
        }


    }
}
