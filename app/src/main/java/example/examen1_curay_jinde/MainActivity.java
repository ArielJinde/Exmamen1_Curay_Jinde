package example.examen1_curay_jinde;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText editText_cantidad1;
    EditText editText_cantidad2;

    TextView textView_resultado;

    Button button_calcular;
    Button button_siguiente;

    int num1, num2;
   int  resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_calcular = findViewById(R.id.button_calcular);
        button_siguiente = findViewById(R.id.button_siguiente);



        button_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"jola",Toast.LENGTH_LONG).show();
                editText_cantidad1 = view.findViewById(R.id.editText_cantidad);
                editText_cantidad2 = view.findViewById(R.id.editText_cantidad2);
                /*textView_resultado = view.findViewById(R.id.textView_resultado);

                editText_cantidad1 = view.findViewById(R.id.editText_cantidad);
                editText_cantidad2 = view.findViewById(R.id.editText_cantidad2);
                num1 = Integer.valueOf(editText_cantidad1.getText().toString());
                num2 = Integer.valueOf(editText_cantidad2.getText().toString());

                resultado = num1 + num2;


                textView_resultado.setText(String.valueOf((resultado)));

*/

            }
        });



    }

    public  void  onClick (View view){
        Intent intent = new Intent(this, RestarActivity.class);

        startActivity(intent);
    }


}