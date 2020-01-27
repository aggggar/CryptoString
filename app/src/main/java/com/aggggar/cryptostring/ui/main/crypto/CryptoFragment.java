package com.aggggar.cryptostring.ui.main.crypto;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.aggggar.cryptostring.R;
import com.aggggar.cryptostring.ui.base.BaseFragment;
import com.aggggar.cryptostring.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CryptoFragment extends BaseFragment implements View.OnClickListener {

    private static final String PARAM_1 = "param_1";
    private int mType;
    private CryptoViewModel cryptoViewModel;

    @BindView(R.id.etText)
    EditText etText;
    @BindView(R.id.btnSubmit)
    Button btnSubmit;
    @BindView(R.id.tvOutputString)
    TextView tvOutputString;


    public static CryptoFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt(PARAM_1, type);
        CryptoFragment fragment = new CryptoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View setView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crypto, container, false);
        ButterKnife.bind(this, view);
        cryptoViewModel = ViewModelProviders.of(this).get(CryptoViewModel.class);
        if (getArguments()!= null) {
            mType = getArguments().getInt(PARAM_1);
            listener.setTitle(mType == Constants.ENCRYPT ? getString(R.string.encryption) : getString(R.string.decryption));
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        btnSubmit.setOnClickListener(this);
        etText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().length()>0){
                    btnSubmit.setEnabled(true);
                } else {
                    btnSubmit.setEnabled(false);
                }
            }
        });

        cryptoViewModel.outputStringLiveData.observe(this, s -> tvOutputString.setText(s));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSubmit:{
                if (mType == Constants.ENCRYPT){
                    cryptoViewModel.encrypt(etText.getText().toString());
                } else {
                    cryptoViewModel.decrypt(etText.getText().toString());
                }
                break;
            }
        }
    }
}
