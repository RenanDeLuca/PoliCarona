package lunadros.carona;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    // Sugestao: desenvolver o conteudo de interface, puxar informacoes da entrada do usuario e manda-las para o servidor por meio da classe comunicadorserver
    // campo de arquivos: LoginActivity.java, activity_login.xml, drawable folder, mipmap folder e values folder

    private CheckBox rememberMe;
    private EditText userName, password;
    private Button enter;
    private TextView register;
    private UserInfoHolder user;
    private String accountInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intent = this.getIntent();
        accountInfo = "";
        if(intent.hasExtra("accountInfo"))
            accountInfo = intent.getStringExtra("accountInfo");

        init();
    }

    protected void init()
    {
        this.rememberMe = (CheckBox) findViewById(R.id.rememberMe);
        this.userName = (EditText) findViewById(R.id.userName);
        this.password = (EditText) findViewById(R.id.password);
        this.enter = (Button)findViewById(R.id.enter);
        this.register = (TextView)findViewById(R.id.register);

        this.enter.setOnClickListener(this);
        this.rememberMe.setOnClickListener(this);
        this.register.setOnClickListener(this);
        String[] info;
        /*user = Account.getAccountInfoFromMemory();
        if(this.user.checkRemember())
        {
            info = this.user.getLogin().split(" ");
            this.userName.setText(info[0]);
            this.password.setText(info[1]);
            this.rememberMe.setChecked(true);
            Intent intent = this.getIntent();
        }
        if(accountInfo.length() > 1)
        {
            info = accountInfo.split(" ");
            this.userName.setText(info[0]);
            this.password.setText(info[1]);
            this.rememberMe.setChecked(true);
        }*/
    }

    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.register:
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.enter:
                String userN = this.userName.getText().toString();
                String pword = this.password.getText().toString();
                if(userN.length() == 0 || pword.length() == 0)
                {
                    this.userName.setText("");
                    this.password.setText("");
                    Toast.makeText(getApplicationContext(),
                            "Preencha TODOS os campos de login!",
                            Toast.LENGTH_SHORT).show();
                    break;
                }
                // Checar se usuário existe no banco de dados
                if(1 == 1)
                {
                    Toast.makeText(getApplicationContext(),
                            "Logado!",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),
                            "Usuário Inexistente",
                            Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.rememberMe:
                //this.user.setRememberMe(this.rememberMe.isChecked());

                break;
        }
    }
}