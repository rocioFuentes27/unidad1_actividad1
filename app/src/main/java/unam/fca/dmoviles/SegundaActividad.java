package unam.fca.dmoviles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class SegundaActividad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);

        // obtenemos el mensaje del mainActivity
        Intent intent = getIntent();
        String msj = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView tv = findViewById(R.id.tv);
        tv.setText(msj); // cambiamos el texto de tv
    }

}
