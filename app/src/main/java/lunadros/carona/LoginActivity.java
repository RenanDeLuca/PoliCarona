package lunadros.carona;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    // Sugestao: desenvolver o conteudo de interface, puxar informacoes da entrada do usuario e manda-las para o servidor por meio da classe comunicadorserver
    // campo de arquivos: LoginActivity.java, activity_login.xml, drawable folder, mipmap folder e values folder


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
