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

//    /**
//     *
//     * @param hallId hall id
//     * @return <code>Hall</code> object
//     * @throws DBException if severe problem with database occurred
//     */
//    Hall getHall(Integer hallId) throws DBException;

    /**
     *
     * @param exhibitionId exhibition id
     * @return list of exhibition hall id's
     * @throws DBException if severe problem with database occurred
     */
    List<Hall> getExhibitionHalls(Integer exhibitionId) throws DBException;
}
