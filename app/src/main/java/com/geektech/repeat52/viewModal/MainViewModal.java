package com.geektech.repeat52.viewModal;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.repeat52.network.LoveModel;
import com.geektech.repeat52.repository.Repository;

public class MainViewModal extends ViewModel {

    Repository repository = new Repository();

    public LiveData<LoveModel> getLoveModelLiveData(String first, String second) {
        return repository.getData(first,second);
    }
}
