package com.newlionlabs.cordova.plugin;

// The native Toast API
import android.widget.Toast;
// Cordova-required packages
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
// ProviderInstaller and related
import android.content.Intent;
import android.content.Context;
import com.google.android.gms.security.ProviderInstaller;
import com.google.android.gms.security.ProviderInstaller.ProviderInstallListener;

public class UpdateSecurityProvider extends CordovaPlugin {
  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) {
    if (!action.equals("update")) {
      callbackContext.error("\"" + action + "\" is not a recognized action.");
      return false;
    }
    final Context context = this.cordova.getActivity().getApplicationContext();

    this.cordova.getActivity().runOnUiThread(new Runnable() {
      public void run() {
        ProviderInstaller.installIfNeededAsync(context, new ProviderInstallListener() {
          @Override
          public void onProviderInstalled() {
            String response = "Calling ProviderInstaller.installIfNeededAsync() was successfull. Security is up to date.";
            PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, response);
            pluginResult.setKeepCallback(true);
            callbackContext.sendPluginResult(pluginResult);
          }

          @Override
          public void onProviderInstallFailed(int errorCode, Intent recoveryIntent) {
            String response = "Calling ProviderInstaller.installIfNeededAsync() failed with error code " + errorCode;
            PluginResult pluginResult = new PluginResult(PluginResult.Status.ERROR, response);
            pluginResult.setKeepCallback(true);
            callbackContext.sendPluginResult(pluginResult);
          }
        });
      }
    });
    return true;
  }
}
