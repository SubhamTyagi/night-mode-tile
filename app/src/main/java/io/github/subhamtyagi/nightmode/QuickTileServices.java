package io.github.subhamtyagi.nightmode;

import android.annotation.TargetApi;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

@TargetApi(Build.VERSION_CODES.N)
public class QuickTileServices extends TileService {
    UiModeManager uiModeManager;

    @Override
    public void onCreate() {
        super.onCreate();
        uiModeManager = (UiModeManager) getSystemService(Context.UI_MODE_SERVICE);
    }

    @Override
    public void onClick() {
        super.onClick();
        updateSettings();
    }

    @Override
    public void onTileAdded() {
        super.onTileAdded();
        Tile tile = this.getQsTile();
        int newState;
        if(uiModeManager.getNightMode()==UiModeManager.MODE_NIGHT_YES){
            newState = Tile.STATE_ACTIVE;
        }else {
            newState= Tile.STATE_INACTIVE;
        }
        tile.setState(newState);
        tile.updateTile();
    }

    private void updateSettings() {
        Tile tile = this.getQsTile();
        int newState;
        if (tile.getState()==Tile.STATE_ACTIVE){
            //switch off the night mode
            uiModeManager.setNightMode(UiModeManager.MODE_NIGHT_NO);
            newState = Tile.STATE_INACTIVE;
        }else {
            // enable night mode
            uiModeManager.setNightMode(UiModeManager.MODE_NIGHT_YES);
            newState = Tile.STATE_ACTIVE;
        }
        tile.setState(newState);
        tile.updateTile();
    }


}


