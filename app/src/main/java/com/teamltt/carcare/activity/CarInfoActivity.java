/*
 * Copyright 2017, Team LTT
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.teamltt.carcare.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.teamltt.carcare.R;
import com.teamltt.carcare.database.DbHelper;
import com.teamltt.carcare.database.contract.VehicleContract;
import com.teamltt.carcare.model.Vehicle;

public class CarInfoActivity extends BaseActivity {

    private static final String TAG = "CarInfoActivity";

    static final String EXTRA_VEHICLE_ID = "vehicle_id";

    private DbHelper dbHelper;
    private long vehicleId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        activityContent = R.layout.activity_car_info;
        includeDrawer = false;
        super.onCreate(savedInstanceState);
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
        //grab info from database or whatever and put it on the text views
        dbHelper = new DbHelper(CarInfoActivity.this);

        vehicleId = 1;
        Vehicle vehicle = dbHelper.getVehicle(vehicleId);
        if (vehicle == null) {
            //HACK auto populates the database with 1 vehicle
            vehicleId = dbHelper.createNewVehicle(new Vehicle("", "", "", "", "", "", ""));
        }

        vehicle = dbHelper.getVehicle(vehicleId);

        updateUi(vehicle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.action_help):
                //TODO Add toast
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Launches a new activity CarInfoEditActivity to edit fields seen in this activity
     * @param view The R.id.carInfoEdit button in the layout
     */
    public void editInfo(View view) {
        //go to the car info edit screen
        Intent intent = new Intent(this, CarInfoEditActivity.class);
        intent.putExtra(EXTRA_VEHICLE_ID, vehicleId);
        startActivity(intent);
    }

    private void updateUi(Vehicle vehicle) {
        ((TextView) findViewById(R.id.field_year)).setText(vehicle.getYear());
        ((TextView) findViewById(R.id.field_VIN)).setText(vehicle.getVin());
        ((TextView) findViewById(R.id.field_make)).setText(vehicle.getMake());
        ((TextView) findViewById(R.id.field_model)).setText(vehicle.getModel());
        ((TextView) findViewById(R.id.field_color)).setText(vehicle.getColor());
        ((TextView) findViewById(R.id.field_nickname)).setText(vehicle.getNickname());
        ((TextView) findViewById(R.id.field_plate)).setText(vehicle.getPlateNumber());
    }
}
