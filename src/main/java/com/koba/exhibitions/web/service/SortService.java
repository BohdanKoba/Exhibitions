package com.koba.exhibitions.web.service;

import com.koba.exhibitions.db.bean.Exhibition;

import java.util.Comparator;
import java.util.List;

public class SortService {
    public static List<Exhibition> sort(List<Exhibition> list, String sortMethod) {
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
        return list;
    }

}
