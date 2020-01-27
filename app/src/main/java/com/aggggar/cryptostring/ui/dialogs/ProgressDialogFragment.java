package com.aggggar.cryptostring.ui.dialogs;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.aggggar.cryptostring.R;
import com.aggggar.cryptostring.ui.base.BaseDialogFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProgressDialogFragment extends BaseDialogFragment {

    @Override
    public View setView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_progress_dialog, container, false);
        return view;
    }

}
