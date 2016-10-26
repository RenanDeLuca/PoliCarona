package lunadros.carona;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity {

    //sugestao: lidar com as preferencias do usuario, mudanca de informacoes, controle das informacoes da conta (estabelecer somente a interface, por enquanto, pois teremos que construir novos metodos de
    // comunicacao com o servidor quando tudo o que estiver aqui dentro for definido)
    // Campo de arquivos: SettingsActivity.java, activity_settings.xml, values folder, drawable folder, mipmap folder.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
}
