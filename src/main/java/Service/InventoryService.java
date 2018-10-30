package Service;

import InventoryDTO.InventoryDTO;

import java.util.List;

public interface InventoryService {
    public List<InventoryDTO> getInventoryDetails(String itemName);
    public List<InventoryDTO> setInventoryDetails(double costprice,double sellprice,String itemName,long quantity);
    public List<InventoryDTO> updateBuyInventoryDetails(String itemName,long updatequantity);
    public List<InventoryDTO> updateSellInventoryDetails(String itemName,long updatequantity);
    public List<InventoryDTO> deleteInventoryDetails(String itemName);
}
