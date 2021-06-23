package com.koba.exhibitions.dao;

import com.koba.exhibitions.bean.Hall;
import com.koba.exhibitions.dao.exception.DBException;

import java.util.List;

public interface HallDAO {

    /**
     *
     * @return list of <code>Hall</code> objects
     * @throws DBException if severe problem with database occurred
     */
    List<Hall> getAllHalls() throws DBException;

    /**
     *
     * @param dateFrom start date of the exhibition event
     * @param dateTo end date of the exhibition event
     * @return list of <code>Hall</code> objects
     * @throws DBException if severe problem with database occurred
     */
    List<Hall> getAvailableHalls(String dateFrom, String dateTo) throws DBException;

    /**
     *
     * @param exhibitionId exhibition id
     * @return list of exhibition hall id's
     * @throws DBException if severe problem with database occurred
     */
    List<Hall> getExhibitionHalls(Integer exhibitionId) throws DBException;
}
