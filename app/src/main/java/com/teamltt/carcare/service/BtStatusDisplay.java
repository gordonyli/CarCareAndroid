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

package com.teamltt.carcare.service;

/**
 * This interface the bluetooth service to activities about bluetooth related state.
 */
public interface BtStatusDisplay {
    /**
     * Called on an Activity in the BluetoothService instance when the bluetooth state changes.
     * Must be called on the made thread.
     * @param status the new state that the bluetooth adapter is ingit s
     */
    void displayStatus(String status);
}
