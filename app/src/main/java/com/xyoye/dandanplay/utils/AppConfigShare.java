package com.xyoye.dandanplay.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;

import com.xyoye.core.BaseApplication;
import com.xyoye.core.utils.Constants;
import com.xyoye.core.utils.SharedPreferencesUtil;

/**
 * Created by YE on 2018/7/2.
 */

public class AppConfigShare {

    private static class ShareHolder{
        private static AppConfigShare appConfigShare = new AppConfigShare();
    }

    private AppConfigShare(){

    }

    public static AppConfigShare getInstance(){
        return ShareHolder.appConfigShare;
    }

    private SharedPreferencesUtil getShare() {
        return SharedPreferencesUtil.getInstance(BaseApplication.get_context(), Constants.APP_CONFIG);
    }

    public String getDownloadFolder(){
       return getShare().load(Config.AppConfig.LOCAL_DANMU_FOLDER, Environment.getExternalStorageDirectory().getAbsolutePath()+"/DanDanPlayer");
    }

    public void setDownloadFolder(String path){
        getShare().save(Config.AppConfig.LOCAL_DANMU_FOLDER, path);
    }

    /**
     * 获取本地软件版本号
	 */
    public static String getLocalVersion(Context context) {
        String localVersionName = "";
        try {
            PackageInfo packageInfo = context.getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            localVersionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localVersionName;
    }

    /**
     * 开启硬解码
     */
    public boolean isOpenMediaCodeC(){
        return getShare().loadBooleanSharedPreference(Config.SHARE_MEDIA_CODE_C);
    }

    public void setOpenMediaCodeC(boolean isUse){
        getShare().saveSharedPreferences(Config.SHARE_MEDIA_CODE_C, isUse);
    }

    /**
     * 开启H265硬解码
     */
    public boolean isOpenMediaCodeCH265(){
        return getShare().loadBooleanSharedPreference(Config.SHARE_MEDIA_CODE_C_H265);
    }

    public void setOpenMediaCodeCH265(boolean isUse){
        getShare().saveSharedPreferences(Config.SHARE_MEDIA_CODE_C_H265, isUse);
    }

    /**
     * OpenSLES
     */
    public boolean isOpenSLES(){
        return getShare().loadBooleanSharedPreference(Config.SHARE_OPEN_SLES);
    }

    public void setOpenSLES(boolean isUse){
        getShare().saveSharedPreferences(Config.SHARE_OPEN_SLES, isUse);
    }

    /**
     * SurfaceRenders
     */
    public boolean isSurfaceRenders(){
        return getShare().loadBooleanSharedPreference(Config.SHARE_SURFACE_RENDERS);
    }

    public void setSurfaceRenders(boolean isUse){
        getShare().saveSharedPreferences(Config.SHARE_SURFACE_RENDERS, isUse);
    }

    /**
     * PlayerType
     */
    public int getPlayerType(){
        return getShare().loadIntSharedPreference(Config.SHARE_PLAYER_TYPE);
    }

    public void setPlayerType(int type){
        getShare().saveSharedPreferences(Config.SHARE_PLAYER_TYPE, type);
    }

    /**
     * PixelFormat
     */
    public String getPixelFormat(){
        return getShare().load(Config.SHARE_PIXEL_FORMAT, "");
    }

    public void setPixelFormat(String pixelFormat){
        getShare().save(Config.SHARE_PIXEL_FORMAT, pixelFormat);
    }

}
