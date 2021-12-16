package android.example.sensoracceleron;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public abstract class MainActivity extends AppCompatActivity implements SensorEventListener {
    private  SensorEventListener lightlisstener;
    private Object View;
    private SensorManager sensorManager;
    TextView xCoor; // deklarasikan X axis object
    TextView yCoor; // deklarasikan Y axis object
    TextView zCoor; // deklarasikan Z axis object

    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xCoor = (TextView) findViewById(R.id.xcoor); // buat X axis object
        yCoor = (TextView) findViewById(R.id.ycoor); // buat Y axis object
        zCoor = (TextView) findViewById(R.id.zcoor); // buat Z axis object

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
// menambahkan listener. Listener untuk class ini adalah accelerometer_3axis
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL); // fungsi api yang dipakai untuk perubahan screen orientation
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void onSensorChanged(SensorEvent event) {

// cek jenis sensor
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

// tetapkan directions
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            xCoor.setText("X: " + x);
            yCoor.setText("Y: " + y);
            zCoor.setText("Z: " + z);
        }
    }

}