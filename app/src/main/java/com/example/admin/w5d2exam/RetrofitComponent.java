package com.example.admin.w5d2exam;

import dagger.Component;

/**
 * Created by admin on 11/15/2016.
 */

@Component(modules = RetrofitModule.class)
public interface RetrofitComponent {
    void inject(MainActivity mainActivity);
}
