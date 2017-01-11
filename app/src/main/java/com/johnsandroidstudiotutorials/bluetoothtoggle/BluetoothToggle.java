package com.johnsandroidstudiotutorials.bluetoothtoggle;

import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class BluetoothToggle extends AppCompatActivity {

    // Declaring Variables
    BluetoothAdapter bluetoothAdapter;
    TextView bluetoothStatusTextView;
    Switch bluetoothSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_toggle);

        // Defining Variables
        bluetoothStatusTextView = (TextView) findViewById(R.id.bluetooth_status_text_view);
        bluetoothSwitch = (Switch) findViewById(R.id.bluetooth_switch_switch);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // Check if device has bluetooth
        if (bluetoothAdapter == null) {
            // Device does not support Bluetooth
        }


        /* Checking wifi state.
         * If wifi is enabled, display "wifi is on" and set toggle button to on position.
         * If Wifi is disabled, display "wifi is off" and set toggle button to off position.
         */
        if (wifiManager.isWifiEnabled()) {
            bluetoothStatusTextView.setText("Wifi is currently ON");
            bluetoothSwitch.setChecked(true);
        } else {
            bluetoothStatusTextView.setText("Wifi is currently OFF");
            bluetoothSwitch.setChecked(false);
        }

        /* adds listener to toggle button
         * If toggle is checked, wifi is enabled and "Wifi is on" is displayed.
         * If toggle is unchecked, wifi is enabled and "Wifi is off" is displayed.
         */
        bluetoothSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wifiManager.setWifiEnabled(true);
                    bluetoothStatusTextView.setText("Wifi is currently ON");
                    Toast.makeText(WifiToggle.this, "Wifi may take a moment to turn on", Toast.LENGTH_LONG).show();
                } else {
                    wifiManager.setWifiEnabled(false);
                    bluetoothStatusTextView.setText("Wifi is currently OFF");
                }
            }
        });
    }
}