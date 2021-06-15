package com.koba.exhibitions.controller.service;

import com.koba.exhibitions.bean.Exhibition;

import java.util.Comparator;
import java.util.List;

public class SortService {
    public void sort(List<Exhibition> list, String sortMethod) {
        switch (sortMethod) {
            case ("ByNameInc"):
                list.sort(Comparator.comparing(Exhibition::getTitle));
                break;
            case ("ByNameDec"):
                list.sort(Comparator.comparing(Exhibition::getTitle).reversed());
                break;
            case ("ByPriceInc"):
                list.sort(Comparator.comparing(Exhibition::getPrice));
                break;
            case ("ByPriceDec"):
                list.sort(Comparator.comparing(Exhibition::getPrice).reversed());
                break;
        }
    }

}
