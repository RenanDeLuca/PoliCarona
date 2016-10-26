package lunadros.carona;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.TabLayout;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    Context context = this;
    private Toolbar barra;
    TabLayout tabLayout;
    ViewPager viewPagerc;
    ViewPagerAdapter viewPagerAdapter;

    Fragment Pedidos = new PedidosCaronaFragment(), Ofertas = new OfertasCaronaFragment(), Criar = new CriarOfertaPedidoFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barra = (Toolbar) findViewById(R.id.toolbar_aulas);
        //barra.setLogo(R.mipmap.ic_extra);
        //barra.setBackgroundColor(ContextCompat.getColor(context, R.color.ColorAccent));
        barra.setTitle("Carona");
        barra.setSubtitle("Main");
        barra.setFitsSystemWindows(true);
        setSupportActionBar(barra);

        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPagerc = (ViewPager)findViewById(R.id.viewPager);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(Pedidos, "Pedidos");
        viewPagerAdapter.addFragments(Ofertas, "Ofertas");
        viewPagerAdapter.addFragments(Criar, "Criar");

        viewPagerc.setAdapter(viewPagerAdapter);
        tabLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary));
        tabLayout.setupWithViewPager(viewPagerc);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        final Intent intent;

        switch(item.getItemId())
        {


            case R.id.action_login:

                intent = new Intent(context,LoginActivity.class);
                startActivity(intent);

                break;

            case R.id.action_configs:

                intent = new Intent(context,SettingsActivity.class);
                startActivity(intent);

                break;

            case R.id.action_requisicoes:

                intent = new Intent(context,GerenciarRequisicoesActivity.class);
                startActivity(intent);

                break;


        }
        return true;
    }


    private void checkFirstRun()
    {

        final String PREFS_NAME = "MyPrefsFile";
        final String PREF_VERSION_CODE_KEY = "version_code";
        final int DOESNT_EXIST = -1;


        // Get current version code
        int currentVersionCode = 0;
        try {
            currentVersionCode = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            // handle exception
            e.printStackTrace();
            return;
        }

        // Get saved version code
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int savedVersionCode = prefs.getInt(PREF_VERSION_CODE_KEY, DOESNT_EXIST);

        // Check for first run or upgrade
        if (currentVersionCode == savedVersionCode) {
            // This is just a normal run
            return;

        } else if (savedVersionCode == DOESNT_EXIST) {

            // This is a new install (or the user cleared the shared preferences)

        } else if (currentVersionCode > savedVersionCode) {

            // This is an upgrade
        }

        // Update the shared preferences with the current version code
        prefs.edit().putInt(PREF_VERSION_CODE_KEY, currentVersionCode).commit();

    }


    //////////////***************** AREA PARA ESCREVER FUNCOES DE METODOS ONCLICK ADVINDOS DE FRAGMENTS SUBJACENTES ***********************//////////////////////////









    //////////////***************** fim AREA PARA ESCREVER FUNCOES DE METODOS ONCLICK ADVINDOS DE FRAGMENTS SUBJACENTES fim ***********************//////////////////////////

}
