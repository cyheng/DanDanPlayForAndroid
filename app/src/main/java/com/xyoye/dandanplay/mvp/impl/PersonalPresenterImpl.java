package com.xyoye.dandanplay.mvp.impl;

import android.os.Bundle;

import com.xyoye.core.base.BaseMvpPresenter;
import com.xyoye.core.rx.Lifeful;
import com.xyoye.dandanplay.mvp.presenter.PersonalFavoritePresenter;
import com.xyoye.dandanplay.mvp.view.PeronalFavoriteView;

/**
 * Created by YE on 2018/7/24.
 */


public class PersonalPresenterImpl extends BaseMvpPresenter<PeronalFavoriteView> implements PersonalFavoritePresenter {

    public PersonalPresenterImpl(PeronalFavoriteView view, Lifeful lifeful) {
        super(view, lifeful);
    }

    @Override
    public void init() {

    }

    @Override
    public void process(Bundle savedInstanceState) {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }
}
