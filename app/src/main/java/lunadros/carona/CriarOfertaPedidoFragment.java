package lunadros.carona;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class CriarOfertaPedidoFragment extends Fragment implements View.OnClickListener {

    //Sugestao: desenvolver a interface e puxar a informacao de entrada do usuario, enviando esses dados para o servidor por meio da classe comunicadorServer
    //campo de arquivos: criarOfertaPedidoFragment.java,fragment_criar_oferta_pedido.xml,drawable folder, mipmap folder, values folder.

    private Switch requisition;
    private View view;
    private float x1, x2;
    private Button createRequisition;

    public CriarOfertaPedidoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_criar_oferta_pedido, container, false);
        init();
        return view;
    }

    public void init(){
        this.requisition = (Switch) view.findViewById(R.id.requisition);
        this.createRequisition = (Button) view.findViewById(R.id.createRequisition);

        this.createRequisition.setOnClickListener(this);
        this.requisition.setOnClickListener(this);
        this.requisition.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Switch requisition = (Switch) view.findViewById(R.id.requisition);
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        x1 = event.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        x2 = event.getX();
                        float deltaX = x2 - x1;
                        if (deltaX < 0) {
                            requisition.setText("Pedir carona");
                        }else if(deltaX >0){
                            requisition.setText("Oferecer carona");
                        }
                        break;
                }

                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.requisition:
                if(this.requisition.isChecked())
                {
                    this.requisition.setText("Oferecer carona");
                }
                else
                {
                    this.requisition.setText("Pedir carona");
                }
                break;
            case R.id.createRequisition:
                Toast.makeText(getActivity(),
                        "Batata",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }



}
