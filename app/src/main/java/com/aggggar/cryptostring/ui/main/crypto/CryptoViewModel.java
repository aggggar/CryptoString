package com.aggggar.cryptostring.ui.main.crypto;

import android.text.TextUtils;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CryptoViewModel extends ViewModel {
    MutableLiveData<String> outputStringLiveData = new MutableLiveData<>();

    void encrypt(String text){
        StringBuilder sbEncrypt = new StringBuilder();
        int count = 1;
        String charPrev = null;
        for (int i=0 ; i < text.length(); i++){
            String charCurrent = Character.toString(text.charAt(i));
            if (charPrev != null){
                if (charCurrent.equals(charPrev)){
                    count++;
                } else {
                    sbEncrypt.append(charPrev);
                    sbEncrypt.append(count);
                    count = 1;
                }
            }
            charPrev = charCurrent;
        }
        sbEncrypt.append(charPrev);
        sbEncrypt.append(count);
        outputStringLiveData.setValue(sbEncrypt.toString());
    }

    void decrypt(String text){
        StringBuilder sbDecrypt = new StringBuilder();
        StringBuilder sbCount = new StringBuilder();
        StringBuilder sbStr = new StringBuilder();
        int length = text.length();
        String charPrev = null;
        for (int i = 0; i < length; i++){
            if (!Character.isDigit(text.charAt(i))) {
                sbStr.append(text.charAt(i));
                if (sbStr.toString().length() > 1){
                    outputStringLiveData.setValue("Format is not correct");
                    break;
                } else {
                    if (charPrev != null){
                        if (!TextUtils.isEmpty(sbCount.toString())) {
                            int count = Integer.parseInt(sbCount.toString());
                            for (int j = 0; j < count ; j++){
                                sbDecrypt.append(charPrev);
                            }
                            sbCount = new StringBuilder();
                        }
                    }
                }
                charPrev = sbStr.toString();
            } else {
                sbStr = new StringBuilder();
                if (i == 0) {
                    outputStringLiveData.setValue("Format is not correct");
                    break;
                } else {
                    sbCount.append(text.charAt(i));
                }
            }

        }
        if (sbStr.toString().length() > 1){
            outputStringLiveData.setValue("Format is not correct");
        } else {
            if (charPrev != null){
                if (!TextUtils.isEmpty(sbCount.toString())) {
                    int count = Integer.parseInt(sbCount.toString());
                    for (int j = 0; j < count ; j++){
                        sbDecrypt.append(charPrev);
                    }
                }
            }
            outputStringLiveData.setValue(sbDecrypt.toString());
        }

    }
}
