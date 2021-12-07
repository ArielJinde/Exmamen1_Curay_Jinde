package example.examen1_curay_jinde;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RestarActivity extends AppCompatActivity {
    private EditText editText_cantidad1;
    private EditText editText_cantidad2;

    private TextView textView_resultado;

    private Button button_calcular;

    private List<String> listaValor1 =new ArrayList<String>();
    private List<String> listaValor2 =new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restar);


        button_calcular = findViewById(R.id.button_calcular);

        editText_cantidad1 = findViewById(R.id.editText_cantidad);
        editText_cantidad2 = findViewById(R.id.editText_cantidad2);

        textView_resultado =findViewById(R.id.textView_resultado);
    }
    public void calcularResta(View view){
        CargarValores(editText_cantidad1.getText().toString(),
                editText_cantidad2.getText().toString());
        restar();

    }
    private void restar() {
        int resta;
        String[] resultado;
        int i;
        resultado = new String[listaValor2.size()];

        String aux = "";
        String cadenaAux="";
        int llevo = 0;
        if (Integer.parseInt(listaValor1.get(0)) >=Integer.parseInt(listaValor2.get(0))) {
            i = listaValor1.size() - 1;
            while (i >= 0) {
                resta = 0;

                if (Integer.parseInt(listaValor1.get(i)) >= Integer.parseInt(listaValor2.get(i)) + llevo) {
                    if(Integer.parseInt(listaValor2.get(i)) + llevo==0){
                        resta=0;
                        llevo=0;
                    }else{
                        resta = Integer.parseInt(listaValor1.get(i)) -
                                (Integer.parseInt(listaValor2.get(i)) + llevo);
                        llevo = 0;
                    }


                }
                if (Integer.parseInt(listaValor1.get(i)) < Integer.parseInt(listaValor2.get(i)) + llevo) {
                    cadenaAux="1"+ listaValor1.get(i);

                    resta = Integer.parseInt(cadenaAux) -
                            (Integer.parseInt(listaValor2.get(i)) + llevo);
                    llevo = 1;

                }

                resultado[i] = String.valueOf(resta);


                i--;
            }

        }

        if (Integer.parseInt(listaValor1.get(0)) < Integer.parseInt(listaValor2.get(0))) {
            i = listaValor2.size() - 1;
            while (i >= 0) {
                resta = 0;

                if (Integer.parseInt(listaValor2.get(i)) >= Integer.parseInt(listaValor1.get(i)) + llevo)
                {
                    if(Integer.parseInt(listaValor2.get(i)) + llevo==0){
                        resta=0;
                        llevo=0;
                    }else {
                        resta = Integer.parseInt(listaValor2.get(i)) -
                                (Integer.parseInt(listaValor1.get(i)) + llevo);
                        llevo = 0;
                    }

                }
                if (Integer.parseInt(listaValor2.get(i)) < Integer.parseInt(listaValor1.get(i)) + llevo) {
                    aux = "1" + listaValor2.get(i);
                    resta = Integer.parseInt(aux) -
                            Integer.parseInt(listaValor1.get(i));
                    llevo = 1;

                }


                resultado[i] = String.valueOf(resta);



                i--;

            }
        }


        i = 0;
        String armarResultado = "";
        if(resultado[i]=="0"&&resultado.length!=1)
            i=1;

        while (i < resultado.length) {

            armarResultado += resultado[i];
            i++;
        }
        textView_resultado.setText(armarResultado);

    }
    private void CargarValores(String Valor1, String Valor2) {
        listaValor1.clear();
        listaValor2.clear();
        int i=0,cer=0;

        String ceros="";
        if(Valor1.length()>Valor2.length()){
            cer=Valor1.length()-Valor2.length();
            while(i<cer){
                ceros+="0";
                i++;
            }
            Valor2=ceros+Valor2;

        }


        if(Valor2.length()>Valor1.length()){
            cer=Valor2.length()-Valor1.length();
            while(i<cer){
                ceros+="0";
                i++;
            }
            Valor1=ceros+Valor1;

        }


        i=0;
        while (i<Valor1.length()){
            listaValor1.add(Character.toString(Valor1.charAt(i)));
            i++;
        }
        i=0;
        while (i<Valor2.length()){
            listaValor2.add(Character.toString(Valor2.charAt(i)));
            i++;
        }

    }
}