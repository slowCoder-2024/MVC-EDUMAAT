/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.HousesDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.exceptions.HouseException;
import in.jdsoft.educationmanagement.school.model.Houses;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.services.HousesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="HouseService")
public class HousesServiceImpl
implements HousesService {
    @Autowired
    private HousesDAO housesDAO;
    @Autowired
    private InstitutionDAO institutionDAO;

    @Override
    public Long createHouses(Houses house) {
        try {
            Houses persistedHouse = this.housesDAO.save(house);
            Long HouseId = persistedHouse.getHouseId();
            log.info((Object)("House is created with the id=" + HouseId));
            return HouseId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating House", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteHouses(Long houseId) {
        try {
            Houses House = this.housesDAO.getHousesById(houseId);
            if (House != null) {
                this.housesDAO.delete(House);
                log.info((Object)("House with id=" + houseId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting House", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Houses> housesList() {
        try {
            List<Houses> HouseList = this.housesDAO.getList();
            Integer listSize = HouseList.size();
            if (listSize > 0) {
                log.info((Object)(listSize + " House records where reterived"));
            } else {
                log.info((Object)"No House(s) available");
            }
            return HouseList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving House list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Houses housesById(Long houseId) {
        try {
            Houses House = this.housesDAO.getHousesById(houseId);
            if (House != null) {
                log.info((Object)("House with id=" + houseId + " has been reterived"));
                return House;
            }
            log.info((Object)("No House with  id=" + houseId + " is available"));
            return House;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving House by id=" + houseId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateHouses(Houses house) {
        try {
            this.housesDAO.saveOrUpdate(house);
            Long HouseId = house.getHouseId();
            if (HouseId != null) {
                log.info((Object)("House with id=" + HouseId + " has been updated"));
            } else {
                log.info((Object)"New House has been added, because no House found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating House", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Houses> housesList(Long institutionId) throws HouseException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<Houses> Houses2 = this.housesDAO.getHousesByInstitution(institution);
                Integer HouseRecordSize = Houses2.size();
                if (HouseRecordSize > 0) {
                    log.info((Object)(HouseRecordSize + " House records of institution " + institution.getInstitutionAliasName() + " where reterived"));
                } else {
                    log.info((Object)("No House Records found for institution " + institution.getInstitutionAliasName()));
                }
                return Houses2;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new HouseException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving Houses of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
