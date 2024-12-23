/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.HouseException;
import in.jdsoft.educationmanagement.school.model.Houses;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface HousesService {
    public static final Logger log = LogManager.getLogger((String)HousesService.class.getName());

    public Long createHouses(Houses var1);

    public void deleteHouses(Long var1);

    public List<Houses> housesList();

    public List<Houses> housesList(Long var1) throws HouseException;

    public Houses housesById(Long var1);

    public void updateHouses(Houses var1);
}
