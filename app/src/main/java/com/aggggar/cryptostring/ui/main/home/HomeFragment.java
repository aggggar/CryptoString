package com.aggggar.cryptostring.ui.main.home;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.SyncStateContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.aggggar.cryptostring.R;
import com.aggggar.cryptostring.ui.base.BaseFragment;
import com.aggggar.cryptostring.ui.main.crypto.CryptoFragment;
import com.aggggar.cryptostring.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.btnEncrypt)
    Button btnEncrypt;
    @BindView(R.id.btnDecrypt)
    Button btnDecrypt;

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View setView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        listener.setTitle(getString(R.string.crypto_string));
        btnEncrypt.setOnClickListener(this);
        btnDecrypt.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnEncrypt:{
                listener.replaceFragment(CryptoFragment.newInstance(Constants.ENCRYPT));
                break;
            }
            case R.id.btnDecrypt:{
                listener.replaceFragment(CryptoFragment.newInstance(Constants.DECRYPT));
                break;
            }
        }
    }
}
