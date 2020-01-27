package com.aggggar.cryptostring.ui.main;

import android.os.Bundle;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.aggggar.cryptostring.R;
import com.aggggar.cryptostring.ui.base.BaseActivity;
import com.aggggar.cryptostring.ui.interfaces.FragmentTransListener;
import com.aggggar.cryptostring.ui.main.home.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements FragmentTransListener {

    @BindView(R.id.tvToolbarTitle)
    TextView tvToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        launchFragment(HomeFragment.newInstance());
    }

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public boolean setToolbar() {
        return true;
    }

    @Override
    public boolean hideStatusBar() {
        return false;
    }

    private void launchFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (!(fragment instanceof HomeFragment)){
            transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
            transaction.addToBackStack(null);
        }
        transaction.replace(R.id.flContainer, fragment, null);
        transaction.commit();
    }

    @Override
    public void replaceFragment(Fragment fragment) {
        launchFragment(fragment);
    }

    @Override
    public void replaceFragment(String fragmentTag) {

    }

    @Override
    public void popBackStackReplaceFragment(Fragment fragment) {

    }

    @Override
    public void setTitle(String title) {
        tvToolbarTitle.setText(title);
    }

    @Override
    public void clearBackStack() {

    }
}
