package unam.fca.dmoviles;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private final static int IMAGE_WIDTH = 400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Actividad 7 Ejecucion de tareas en segundo plano
        //Hasta ahora, hemos ejecutado el codigo en primer plano o en lo que se conoce como
        //el hilo de interfaz de usuario (UI thread)

        //El UI thread se utiliza para modificar los componentes visuales de Android (animaciones, cambiar valores de controles, transiciones de pantallas...), si tratamos de hacer esto
        //en segundo plano, la aplicacion dejara de funcionar.

        //El metodo onCreate se ejecuta en el UI thread

        //Pero si hacemos tareas que puedan tardar mucho, como consultar un servidor Web, o modificar
        //el tamano de una imagen de gran tamano, el UI thread se puede trabar esperando por estos procesos y
        //la aplicacion se mostrara poco responsiva.

        //Una de las manera de evitar esto, es mover el codigo que pudiera demandar mas recursos
        //a un proceso en segundo plano.
        //
        //En esta actividad exploramos el uso de AsyncTask
        //Referencias
        //https://developer.android.com/guide/components/processes-and-threads
        //https://developer.android.com/reference/android/os/AsyncTask

        // El archivo del layout de la actividad se encuentra en la carpeta
        // res/layout/activity_main.xml
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        final ImageView iv = findViewById(R.id.iv);


        //Cuando nuestra aplicacion sea iniciada por otra  aplicacion, type no sera nulo
        if (Intent.ACTION_SEND.equals(action) && type != null) {

            //Verificamos que el mime type del dato sea de una imagen
            //https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types
            if (type.startsWith("image/")) {

                Uri imageUri = intent.getParcelableExtra(Intent.EXTRA_STREAM);
                if (imageUri != null) {
                    //Se ejecuta el proceso de reduccion de la imagen en segundo plano
                    //y no interrumpir
                    new Worker(iv).execute(imageUri);
                }
            }
        }


        //Actividades
        //a) Revisa la urls de referencia, que metodos se ejecutan en el UI Thread en la actividad?
        //b) Ejecuta la aplicacion en modo de depuracion, coloca un breakpoint en el metodo doInBackground y otro en el onPostExecute
        //c) Que ocurre si intentas asignar el bitmap al image view en doInBackground?
        //  con :  this.imageView.get().setImageBitmap(bitmap);
        //d) Revisa la urls de referencia, que procesos se pueden ejecutar en segundo plano?
        //e) Anota tus respuestas y las capturas de pantalla en un documento en Word
        //f) Sube tu codigo al repositorio.
        //g) Sube el documento Word a la plataforma Moodle. Incluye la liga a tu repositorio


    }
}
