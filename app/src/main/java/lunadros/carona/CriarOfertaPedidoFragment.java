package lunadros.carona;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CriarOfertaPedidoFragment extends Fragment {

    //Sugestao: desenvolver a interface e puxar a informacao de entrada do usuario, enviando esses dados para o servidor por meio da classe comunicadorServer
    //campo de arquivos: criarOfertaPedidoFragment.java,fragment_criar_oferta_pedido.xml,drawable folder, mipmap folder, values folder.

    public CriarOfertaPedidoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_criar_oferta_pedido, container, false);
    }

}
