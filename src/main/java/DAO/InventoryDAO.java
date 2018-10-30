package DAO;

import InventoryDTO.InventoryDTO;

import java.util.List;

public interface InventoryDAO {
    public List<InventoryDTO> getInventoryDetails(); //report
    public List<InventoryDTO> setInventoryDetails(double costprice,double sellprice,String itemName,long quantity);
    public List<InventoryDTO> updateBuyInventoryDetails(String itemName,long updatequantity);
    public List<InventoryDTO> updateSellInventoryDetails(String itemName,long updatequantity);
    public List<InventoryDTO> deleteInventoryDetails(String itemName);
}
