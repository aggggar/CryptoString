package com.aggggar.cryptostring.ui.interfaces;

import androidx.fragment.app.Fragment;

public interface FragmentTransListener {
    void replaceFragment(Fragment fragment);
    void replaceFragment(String fragmentTag);
    void popBackStackReplaceFragment(Fragment fragment);
    void setTitle(String title);
    void clearBackStack();
}
