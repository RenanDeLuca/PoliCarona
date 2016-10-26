package lunadros.carona;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Renan Avila on 06/09/2016.
 */
public class ComunicadorServer {

    Context context;

    ComunicadorServer(Context context){

        //Context necessario para execucao dos metodos dessa classe: passar o contexto da classe em que se cria esse objeto;

        this.context = context;

    }

    //**************************************************************************************************
    //metodos principais dessa classe
    //ultimosNpedidos - fornece N e retorna os N ultimos pedidos que constam no servidor
    //ultimasNOfertas - "
    //insereOfertas - fornece o usuario, id, hora da criacao, destino e origem, e registra oferta na DB
    //inserePedidos - "
    //registraUsuario - fornece os dados do usuario e registra esse usuario na DB
    //ultimosNusuarios - fornece N e retorna os n ultimos usuarios registrados
    //***************************************************************************************************


    private JSONArray result;

    private ArrayList ultimosNPedidos(int N){

        //devolve N ultimos pedidos (no padrao da classe pedidoinfoholder) - N ainda a ser determinado

        final ArrayList pedidos = null;

        StringRequest stringRequest = new StringRequest("http://"+ R.string.serverIp +"/caronaApp/LastPedidos.php"+"?n="+N,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject j = null;
                        try {
                            j = new JSONObject(response);
                            result = j.getJSONArray("result");

                            for(int i=0;i<j.length();i++){
                                try {
                                    JSONObject json = result.getJSONObject(i);
                                    pedidos.add(new PedidoInfoHolder(json.getString("usuario"),json.getString("idusuario"),json.getString("horariocriacao"),json.getString("destino"),json.getString("origem")));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.e("ComunicadorServer","Ultimos N pedidos - error: Server does not respond or arraylist is not correctly constructed");

                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

        return pedidos;
    }

    private ArrayList ultimasNOfertas(int N){

        //devolve N ultimos pedidos (no padrao da classe ofertainfoholder) - N ainda a ser determinado

        final ArrayList ofertas = null;

        StringRequest stringRequest = new StringRequest("http://"+ R.string.serverIp +"/caronaApp/LastPedidos.php"+"?n="+N,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject j = null;
                        try {
                            j = new JSONObject(response);
                            result = j.getJSONArray("result");

                            for(int i=0;i<j.length();i++){
                                try {
                                    JSONObject json = result.getJSONObject(i);
                                    ofertas.add(new PedidoInfoHolder(json.getString("usuario"),json.getString("idusuario"),json.getString("horariocriacao"),json.getString("destino"),json.getString("origem")));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.e("ComunicadorServer","Ultimos N pedidos - error: Server does not respond or arraylist is not correctly constructed");

                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

        return ofertas;
    }

    private void InsereOfertaNaDB( String usuario, String idusuario, String horarioCriacao, String destino, String origem){

        BackGrndEntryRegTask backGrndEntryRegTask = new BackGrndEntryRegTask(context);
        backGrndEntryRegTask.execute(usuario,idusuario,horarioCriacao,destino,origem);

    }

    private void InserePedidoNaDB( String usuario, String idusuario, String horarioCriacao, String destino, String origem){

        BackGrndEntryRegTask backGrndEntryRegTask = new BackGrndEntryRegTask(context);
        backGrndEntryRegTask.execute(usuario,idusuario,horarioCriacao,destino,origem);

    }

    private void RegistraUsuario(String usuario, String nome, String senha, String email){

        BackGrndUserRegTask backGrndUserRegTask = new BackGrndUserRegTask(context);
        backGrndUserRegTask.execute(usuario,nome,senha,email);

    }

    private ArrayList ultimosNRegUsuarios(int N){

        //devolve N ultimos pedidos (no padrao da classe pedidoinfoholder) - N ainda a ser determinado

        final ArrayList usuarios = null;

        StringRequest stringRequest = new StringRequest("http://"+ R.string.serverIp +"/caronaApp/LastRegUsers.php"+"?n="+N,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject j = null;
                        try {
                            j = new JSONObject(response);
                            result = j.getJSONArray("result");

                            for(int i=0;i<j.length();i++){
                                try {
                                    JSONObject json = result.getJSONObject(i);
                                    usuarios.add(new UserInfoHolder(json.getString("usuario"),json.getString("idusuario"),json.getString("senha"),json.getString("email")));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.e("ComunicadorServer","Ultimos N pedidos - error: Server does not respond or arraylist is not correctly constructed");

                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

        return usuarios;
    }

}
