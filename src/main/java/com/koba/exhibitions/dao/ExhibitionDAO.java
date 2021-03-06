package com.koba.exhibitions.dao;

import com.koba.exhibitions.bean.Exhibition;
import com.koba.exhibitions.bean.ExhibitionData;
import com.koba.exhibitions.dao.exception.DBException;

import java.util.List;

public interface ExhibitionDAO {
    /**
     * Creates new exhibition.
     *
     * @param data <code>RegistrationData</code> object which contains data need to create new exhibition
     * @throws DBException if severe problem with database occurred
     */
    void createExhibition(ExhibitionData data) throws DBException;

    /**
     * Returns exhibition by id.
     *
     * @return <code>Exhibition</code> object
     * @throws DBException if severe problem with database occurred
     */
    Exhibition getExhibition(Integer id) throws DBException;

    /**
     * Returns all exhibitions
     *
     * @return list of <code>Exhibition</code> objects
     * @throws DBException if severe problem with database occurred
     */
    List<Exhibition> getAllExhibitions() throws DBException;

    /**
     * Returns exhibitions for which tickets can be purchased.
     *
     * @return list of <code>Exhibition</code> objects
     * @throws DBException if severe problem with database occurred
     */
    List<Exhibition> getAvailableExhibitions() throws DBException;

    /**
     * Updates exhibition status.
     *
     * @param id exhibition id
     * @param status the name of the updated status
     * @throws DBException if severe problem with database occurred
     */
    void updateExhibitionStatus(Integer id, String status) throws DBException;

}
