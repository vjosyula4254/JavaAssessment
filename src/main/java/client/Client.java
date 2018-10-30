package client;

import DAO.InventoryDAOImpl;
import InventoryDTO.InventoryDTO;
import Service.InventoryServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public void scan() {

        Scanner sc;
        sc = new Scanner(System.in);
        System.out.println("WARNING: OPERATIONS are case-Sensitive");
        System.out.println("choose from the following/n 1.delete 2.updateBuy 3.updateSell 4.Create 5.report");
         String operation = sc.next(); //scanner to read input
        List<InventoryDTO> dto1;
        InventoryDAOImpl test =new InventoryDAOImpl();


//switch case to read user operation
        switch(operation) {
            case "delete" :
                System.out.println("item Name");
                String itemName= sc.next();
                System.out.println(dto1 = test.deleteInventoryDetails(itemName));
                break;
            case "updateBuy" :
                System.out.println("item Name");
                 itemName= sc.next();
                System.out.println("enter quantity");
                long quantity = sc.nextLong();

                System.out.println(dto1 = test.updateBuyInventoryDetails(itemName,quantity));
                break;
            case "updateSell" :
                System.out.println("item Name");
                itemName= sc.next();
                System.out.println("enter quantity");
                quantity = sc.nextLong();
                System.out.println(dto1 = test.updateSellInventoryDetails(itemName,quantity));
                System.out.println("You passed");
                break;
            case "create" :
                System.out.println("enter Costprice");
                double costprice = sc.nextDouble();
                System.out.println("enter Sellingprice");
                double sellprice = sc.nextDouble();
                System.out.println("enter quantity");
                quantity = sc.nextLong();
                System.out.println("item Name");
                itemName= sc.next();
                System.out.println(dto1 = test.setInventoryDetails(costprice,sellprice,itemName,quantity));
                break;
            case "report" :
                System.out.println("display details in db");
                //System.out.println(dto1=test.getInventoryDetails());
                InventoryServiceImpl Service = new InventoryServiceImpl();
                List<InventoryDTO> dtoList = new ArrayList<>();
                InventoryDAOImpl daoImpl =new InventoryDAOImpl();
                dtoList = daoImpl.getInventoryDetails();

                System.out.println("           " + "INVENTORY REPORT" + "          ");
                System.out.println("Item Name" + "    " + "Bought At" + "    " + "Sold At" + "   " + "AvailableQty" + "  " + "Value");
                System.out.println("---------" + "    " + "---------" + "    " + "-------" + "   " + "------------" + "  " + "-----");

                System.out.println("-----------------------------------------------------------------------------------------------------");

                double details=0;
                for(InventoryDTO dto:dtoList){
                    details = details + (dto.getCostPrice()*dto.getQuantity());
                    System.out.println(     dto.getItemName() + "        " + dto.getCostPrice() + "         " + dto.getSellPrice() + "          " + dto.getQuantity() + "          " + ((dto.getCostPrice()) * (dto.getQuantity())));

                }
//
                break;
            default :
                System.out.println("operation failed");
        }
        System.out.println("Your operation is " + operation);
        }
    public static void main(String args[]){
        Client client = new Client();
        client.scan();

    }

}
