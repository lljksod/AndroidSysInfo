package com.rburch.sysinfo;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.system.Os;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.PrintWriter;

import static android.os.Build.VERSION_CODES.N;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button get_info_reference = findViewById(R.id.get_info_button);
        final TextView info_textbox = findViewById(R.id.infoTextBox);
        final Button clear_button_reference = findViewById(R.id.clear_button);

        get_info_reference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myBootloaderVersion, myDeviceName, myManufacturer, myModel, myFingerprint;
                String mySerialNumber;
                myBootloaderVersion = Build.BOOTLOADER;
                myDeviceName = Build.DEVICE;
                myManufacturer = Build.MANUFACTURER;
                myModel = Build.MODEL;
                myFingerprint = Build.FINGERPRINT;
                try {
                    mySerialNumber = Build.getSerial();
                }
                catch(NoSuchMethodError nom) {
                    mySerialNumber = "Not Available";
                }
                catch(SecurityException sec) {
                    mySerialNumber = "Not Available";
                };

                String fullSysInfo = "Bootloader: " + myBootloaderVersion + "\n" + "Device Name: "
                        + myDeviceName + "\n" + "Manufacturer: " + myManufacturer + "\n" + "Model: "
                        + myModel + "\n" + "Fingerprint: " + myFingerprint + "\n" + "Serial No.: "
                        + mySerialNumber + "\n";

                info_textbox.setText(fullSysInfo);

                Log.w("SysInfo", fullSysInfo);



            }
        });

        clear_button_reference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info_textbox.setText("");
            }
        });


    }
}
