package com.xyoye.dandanplay.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xyoye.dandanplay.R;
import com.xyoye.dandanplay.ui.mainMod.HomeFragment;
import com.xyoye.dandanplay.ui.mainMod.MyFragment;
import com.xyoye.dandanplay.ui.mainMod.PlayFragment;

/**
 * Created by YE on 2018/6/28 0028.
 */


public class DataGenerator {

    public static final int []mTabRes = new int[]{R.mipmap.ic_home_light, R.mipmap.ic_play_light,R.mipmap.ic_my_light};
    public static final int []mTabResPressed = new int[]{R.mipmap.ic_home_dark, R.mipmap.ic_play_dark,R.mipmap.ic_my_dark};
    public static final String []mTabTitle = new String[]{"DanDanPlay","Play","我的"};

    public static Fragment[] getFragments(){
        Fragment fragments[] = new Fragment[3];
        fragments[0] = HomeFragment.newInstance();
        fragments[1] = PlayFragment.newInstance();
        fragments[2] = MyFragment.newInstance();
        return fragments;
    }

    /**
     * 获取Tab 显示的内容
     */
    public static View getTabView(Context context, int position){
        View view = LayoutInflater.from(context).inflate(R.layout.layout_tab_content,null);
        ImageView tabIcon = (ImageView) view.findViewById(R.id.tab_content_image);
        tabIcon.setImageResource(DataGenerator.mTabRes[position]);
        TextView tabText = (TextView) view.findViewById(R.id.tab_content_text);
        tabText.setText(mTabTitle[position]);
        return view;
    }

}