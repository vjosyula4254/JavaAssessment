package Service;

import DAO.InventoryDAO;
import DAO.InventoryDAOImpl;
import InventoryDTO.InventoryDTO;
import log4j.Log4j;
import org.apache.log4j.Logger;

import java.util.List;

public class InventoryServiceImpl {

    final static Logger logger = Logger.getLogger(Log4j.class);
    private InventoryDAO dao;

    public List<InventoryDTO> getInventoryDetails() {
        logger.debug("inside InventoryDetail method and as parameter");
        InventoryDAOImpl dao = new InventoryDAOImpl();
        logger.debug("calling dao and we are getting itemName details");
        dao.getInventoryDetails();
        boolean isRequestValid =Boolean.TRUE;
        List<InventoryDTO> dto= null;
        dto = dao.getInventoryDetails();
        return dto;
    }
    public List<InventoryDTO> setInventoryDetails(int ID,double costprice,double sellprice,String itemName,long quantity) {
        logger.debug("inside InventoryDetail method and  "+itemName+"as parameter");
        InventoryDAOImpl dao = new InventoryDAOImpl();
        logger.debug("calling dao and we are getting itemName details");
        dao.setInventoryDetails(costprice,sellprice,itemName,quantity);
        //boolean isRequestValid =Boolean.TRUE;
        List<InventoryDTO> dto1= null;
        dto1 = dao.setInventoryDetails(costprice,sellprice,itemName,quantity);
        return dto1;
    }
    public List<InventoryDTO> updateBuyInventoryDetails(String itemName,long updatequantity) {
        logger.debug("inside InventoryDetail method and  "+itemName+"as parameter");
        InventoryDAOImpl dao = new InventoryDAOImpl();
        logger.debug("calling dao and we are getting itemName details");
        dao.updateBuyInventoryDetails(itemName,updatequantity);
        //boolean isRequestValid =Boolean.TRUE;
        List<InventoryDTO> dto1= null;
        dto1 = dao.updateBuyInventoryDetails(itemName,updatequantity);
        return dto1;
    }
    public List<InventoryDTO> updateSellInventoryDetails(String itemName,long updatequantity) {
        logger.debug("inside InventoryDetail method and  "+itemName+"as parameter");
        InventoryDAOImpl dao = new InventoryDAOImpl();
        logger.debug("calling dao and we are getting itemName details");
        dao.updateBuyInventoryDetails(itemName,updatequantity);
        //boolean isRequestValid =Boolean.TRUE;
        List<InventoryDTO> dto1= null;
        dto1 = dao.updateSellInventoryDetails(itemName,updatequantity);
        return dto1;
    }

    public List<InventoryDTO> deleteInventoryDetails(String itemName) {
        logger.debug("inside InventoryDetail method and  "+itemName+"as parameter");
        InventoryDAOImpl dao = new InventoryDAOImpl();
        logger.debug("calling dao and we are getting itemName details");
        dao.deleteInventoryDetails(itemName);
        //boolean isRequestValid =Boolean.TRUE;
        List<InventoryDTO> dto1= null;
        dto1 = deleteInventoryDetails(itemName);
        return dto1;
    }
}
