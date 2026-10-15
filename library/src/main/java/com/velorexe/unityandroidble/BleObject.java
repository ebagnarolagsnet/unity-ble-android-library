package com.velorexe.unityandroidble;

import android.os.ParcelUuid;

import org.json.JSONException;
import org.json.JSONObject;

public class BleObject {
    public String command;

    public String address;

    public String uuid;
    public String serviceUuid;

    public String name;

    public String service;
    public String characteristic;

    public String base64Message;

    public boolean hasError = false;
    public String errorMessage;

    public int rssi;

    public int major;
    public int minor;

    public BleObject(String command) {
        this.command = command;
    }

    public void setError(String errorMessage) {
        hasError = true;
        this.errorMessage = errorMessage;
    }

    public String toJson() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("command", command);

            obj.put("address", address);
            obj.put("uuid", uuid);
            obj.put("serviceUuid", serviceUuid);
            obj.put("name", name);

            obj.put("service", service);
            obj.put("characteristic", characteristic);

            obj.put("base64Message", base64Message);

            obj.put("rssi", rssi);
            obj.put("minor", minor);
            obj.put("major", major);

            if(hasError) {
                obj.put("hasError", hasError);
                obj.put("errorMessage", errorMessage);
            }

            return obj.toString();
        }
        catch(JSONException e){
            e.printStackTrace();
        }

        return obj.toString();
    }
}
