/*
 * Copyright 2017, Team LTT
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.teamltt.carcare.model;

public class Vehicle {
    private String vin, make, model, year, color, nickname, plateNumber;

    public Vehicle(String vin, String make, String model, String year, String color,
                   String nickname, String plateNumber) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.nickname = nickname;
        this.plateNumber = plateNumber;
    }

    public String getVin() {
        return vin;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPlateNumber() {
        return plateNumber;
    }
}
