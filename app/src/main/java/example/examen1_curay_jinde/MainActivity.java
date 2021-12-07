package example.examen1_curay_jinde;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private EditText editText_cantidad1;
    private EditText editText_cantidad2;

    private  TextView textView_resultado;

    private Button button_calcular;
    private Button button_siguiente;

    private List<String> listaValor1 =new ArrayList<String>();
    private List<String> listaValor2 =new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_calcular = findViewById(R.id.button_calcular);
        button_siguiente = findViewById(R.id.button_siguiente);

        editText_cantidad1 = findViewById(R.id.editText_cantidad);
        editText_cantidad2 = findViewById(R.id.editText_cantidad2);

       textView_resultado =findViewById(R.id.textView_resultado);



    }
    public void calcularSuma (View view){
        CargarValores(editText_cantidad1.getText().toString(),
                editText_cantidad2.getText().toString());
        sumar();

    }

    private void sumar() {
        int suma,auxiliarsuma=0;
        String [] resultado;
        int i;
        resultado=new String[listaValor2.size()];
        i= listaValor1.size()-1;
        while(i>=0){
            suma=0;
            suma=Integer.parseInt(listaValor1.get(i))+Integer.parseInt(listaValor2.get(i));
            if(auxiliarsuma==1){
                suma=suma+1;
            }

            if(suma>=10){
                auxiliarsuma=1;
                resultado[i]=String.valueOf(String.valueOf(suma).charAt(1));
            }else{
                auxiliarsuma=0;
                resultado[i]=String.valueOf(suma);
            }



            i--;

        }


        i=0;
        String armarResultado="";
        if(auxiliarsuma==1){
            armarResultado="1";
        }
        while(i<resultado.length){
            armarResultado+=resultado[i];
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
    public  void  onClick (View view){
        Intent intent = new Intent(this, RestarActivity.class);

        startActivity(intent);
    }


}