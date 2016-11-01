package lunadros.carona;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button goBack, createAccount;
    private EditText emailField, userName, passField, numUSP, postalAdress, phone;
    private UserInfoHolder user;
    private View.OnClickListener btnListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }

    public void init()
    {
        this.goBack = (Button)findViewById(R.id.goBack);
        this.createAccount = (Button)findViewById(R.id.createAccount);

        this.emailField = (EditText) findViewById(R.id.emailField);
        this.passField = (EditText) findViewById(R.id.passField);
        this.userName = (EditText) findViewById(R.id.userName);
        this.numUSP = (EditText) findViewById(R.id.numUSP);
        this.postalAdress = (EditText) findViewById(R.id.postalAdress);
        this.phone = (EditText) findViewById(R.id.phone);

        this.goBack.setOnClickListener(this);
        this.createAccount.setOnClickListener(this);
        user = null;
    }

    public void onClick(View view)
    {
        Intent intent;
        switch (view.getId())
        {
            case R.id.goBack:
                intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.createAccount:
                String emailField = this.emailField.getText().toString();
                String passField = this.passField.getText().toString();
                String userName = this.userName.getText().toString();
                String numUSP = this.numUSP.getText().toString();
                String postalAdress = this.postalAdress.getText().toString();
                String phone = this.phone.getText().toString();
                user = new UserInfoHolder("batata", userName, passField, emailField);
                if(emailField.length() == 0 || userName.length() == 0 || passField.length() == 0 || numUSP.length() == 0)
                {
                    Toast.makeText(getApplicationContext(),
                            "Preencha TODOS os campos obrigatórios!",
                            Toast.LENGTH_SHORT).show();
                    break;
                }
                if(1 == 1)
                {
                    //user.registerAccount();
                    intent = new Intent(getApplicationContext(), LoginActivity.class);
                    //intent.putExtra("accountInfo", user.getLogin());
                    RegisterActivity.this.startActivity(intent);
                    finish();
                }
                else
                {

                }
                break;
        }

    }
}
