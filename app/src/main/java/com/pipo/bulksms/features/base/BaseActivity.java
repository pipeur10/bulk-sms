package com.pipo.bulksms.features.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.pipo.bible.features.base.BaseViewModel;

import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by Philip on 29/12/2017.
 */

public abstract class BaseActivity< V extends BaseViewModel> extends DaggerAppCompatActivity implements BaseFragment.Callback {


    private V mViewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection();

//
        super.onCreate(savedInstanceState);
        performDataBinding();
    }

    private void performDataBinding() {
        setContentView(getLayoutId());
        this.mViewModel = mViewModel == null ? getViewModel() : mViewModel;
    }


    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }


        }
    }


    public String getText(EditText editText){
        if(editText==null) return "";
        return editText.getText().toString();
    }



    /**
     * Override for set view model
     *
     * @return view model instance
     */
    public abstract V getViewModel();


    /**
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();

    public void performDependencyInjection() {
        AndroidInjection.inject(this);
    }

}