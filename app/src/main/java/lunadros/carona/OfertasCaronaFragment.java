package lunadros.carona;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class OfertasCaronaFragment extends Fragment {

    //seguir o mesmo padrao do pedidosCaronaFragment
    //sugestao: desenvolver a interface e o controle do display de informacoes - puxa informacoes do servidor com a classe comunicadorserver (recebe um arraylist de infoholder) e mostra para o usuario
    //campo de arquivos: OfertasCaronaFragment.java,fragment_ofertas_carona.xml, MainActivity.java (area reservada), drawable folder, mipmap folder, values folder;

    public OfertasCaronaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ofertas_carona, container, false);
    }

}
