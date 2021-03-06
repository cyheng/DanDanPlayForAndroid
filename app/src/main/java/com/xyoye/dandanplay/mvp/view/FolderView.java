package com.xyoye.dandanplay.mvp.view;

import com.xyoye.core.interf.view.BaseMvpView;
import com.xyoye.core.interf.view.LoadDataView;
import com.xyoye.dandanplay.bean.VideoBean;

import java.util.List;

/**
 * Created by YE on 2018/6/30 0030.
 */


public interface FolderView extends BaseMvpView, LoadDataView {
    String getFolderPath();

    void refreshAdapter(List<VideoBean> beans);
}
