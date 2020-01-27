package com.aggggar.cryptostring.ui.main.crypto;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CryptoViewModel extends ViewModel {
    public LiveData<String> outputStringLiveData = new MutableLiveData<>();

    public LiveData<String> encrypt(String text){
        StringBuilder sbEncrypt = new StringBuilder();
        int count = 1;
        for (int i=0 ; i < text.length(); i++){
            char currentChar = text.charAt(i);

        }
        return outputStringLiveData;
    }

    public LiveData<String> decrypt(String text){

        return outputStringLiveData;
    }
}
