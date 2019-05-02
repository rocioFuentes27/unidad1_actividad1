package unam.fca.dmoviles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private final static int IMAGE_WIDTH = 400;
    private final static String TEXT_VIEW_KEY = "TEXT_VIEW_KEY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Actividad 8 Creacion de una calculadora de porcentajes
        //En esta actividad crearas una aplicacion que calcule la diferencia relativa en porcentaje entre dos numeros.


        // El archivo del layout de la actividad se encuentra en la carpeta
        // res/layout/activity_main.xml
        setContentView(R.layout.activity_main);

        // Hacemos referencia a un componente del layout
        final EditText et1 = findViewById(R.id.editText);
        final EditText et2 = findViewById(R.id.editText2);
        final Button btn = findViewById(R.id.button);
        final TextView resultado = findViewById(R.id.textViewResult);

        // Llamamos al evento onclick
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                // Obtenemos los valores ingresados
                int num1 = Integer.parseInt(et1.getText().toString());
                int num2 = Integer.parseInt(et2.getText().toString());

                // Realizamos la operacion
                float absnum1 = Math.abs(num1);
                float res = ((num2 - num1) / absnum1) * 100;

                // Mostramos el resultado
                resultado.setText(""+res+" %");
            }
        });



        //Actividades
        //a) Ejecuta la aplicacion y familiarizate con el layout definido en R.layout.activity_main
        //b) Crea la logica para calcular la diferencia relativa en porcentaje entre dos numeros
        //c) La formula para calcular la diferencia relativa en porcentaje esta en: https://www.calculatorsoup.com/calculators/algebra/percent-change-calculator.php
        //d) La aplicacion debe calcular la diferencia relativa en porcentaje de los valores contenidos en "editText" y "editText2"
        //e) Al hacer click en el boton "button", la aplicacion debera calcular dicha diferencia y poner el resultado en el campo "textViewResult"
        //f) La aplicacion debera manejar adecuadamente el cambio de rotacion para el resultado y los campos de texto
        //e) Anota tus respuestas y las capturas de pantalla en un documento en Word
        //f) Sube tu codigo al repositorio.
        //g) Sube el documento Word a la plataforma Moodle. Incluye la liga a tu repositorio


    }
    @Override
    // Funcion para restaurar el estado de una actividad despues de ser destruida
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        final EditText et1 = findViewById(R.id.editText);
        //final EditText et2 = findViewById(R.id.editText2);
        final TextView tv = findViewById(R.id.textViewResult);
        et1.setText(savedInstanceState.getString(TEXT_VIEW_KEY));
        //et2.setText(savedInstanceState.getString(TEXT_VIEW_KEY));
        tv.setText(savedInstanceState.getString(TEXT_VIEW_KEY));
    }


    @Override
    // Funcion para guardar el estado de una interfaz
    public void onSaveInstanceState(Bundle outState) {
        final EditText et1 = findViewById(R.id.editText);
        final EditText et2 = findViewById(R.id.editText2);
        final TextView tv = findViewById(R.id.textViewResult);
        outState.putString(TEXT_VIEW_KEY, et1.getText().toString());
        outState.putString(TEXT_VIEW_KEY, et2.getText().toString());
        //outState.putString(TEXT_VIEW_KEY, tv.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
