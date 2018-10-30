package InventoryDTO;

import java.util.Objects;

public class InventoryDTO {
    private String itemName;

    public InventoryDTO(String itemName,int ID, double costPrice, double sellPrice, long quantity) {
        this.itemName = itemName;
        //this.profit = profit;
        //this.ID = ID;
        this.costPrice = costPrice;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
    }

//    public double getProfit() {
//        return profit;
//    }
//
//    public void setProfit(double profit) {
//        this.profit = profit;
//    }
//
//    private double profit;

    @Override
    public String toString() {
        return "InventoryDTO{" +
                "itemName='" + itemName + '\'' +
               // ", ID=" + ID +
                ", costPrice=" + costPrice +
                ", sellPrice=" + sellPrice +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryDTO that = (InventoryDTO) o;
       return
                Double.compare(that.costPrice, costPrice) == 0 &&
                Double.compare(that.sellPrice, sellPrice) == 0 &&
                quantity == that.quantity &&
                Objects.equals(itemName, that.itemName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(itemName,costPrice, sellPrice, quantity);
    }


    //private int ID;
    private double costPrice;
    private double sellPrice;
    private long quantity;

    public String getItemName(){

        return itemName;
    }

    public void setItemName(String itemName) {

        this.itemName = itemName;
    }

    public double getCostPrice() {

        return costPrice;
    }

    public void setCostPrice(double costPrice) {

        this.costPrice = costPrice;
    }

    public double getSellPrice() {

        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {

        this.sellPrice = sellPrice;
    }

    public long getQuantity() {

        return quantity;
    }

    public void setQuantity(long quantity) {

        this.quantity = quantity;
    }

    public InventoryDTO(String itemName, double costPrice, double sellPrice, long quantity){

        this.itemName = itemName;
        this.costPrice=costPrice;
        this.sellPrice=sellPrice;
        this.quantity=quantity;
    }

}
