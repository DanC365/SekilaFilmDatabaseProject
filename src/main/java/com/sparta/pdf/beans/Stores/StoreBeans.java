package com.sparta.pdf.beans.Stores;

import com.sparta.pdf.components.Store;
import com.sparta.pdf.services.StoreRetriever;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class StoreBeans implements Serializable {
    List<Store> storeList;
    @Inject
    StoreRetriever storeRetriever;

    public void retrieveStoreList(){
        storeList = storeRetriever.getFullStoreList();
    }

    public List<Store> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<Store> storeList) {
        this.storeList = storeList;
    }
}
