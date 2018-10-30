package DAO;

import InventoryDTO.InventoryDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAOImpl implements InventoryDAO {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/travel_booking?allowPublicKeyRetrieval=true&useSSL=false";

    //  Database credentials
    static final String USER = "root";
    static final String PASSWORD = "";
    List<InventoryDTO> dtoList = new ArrayList<>();
    public List<InventoryDTO> getInventoryDetails()
    {
        Connection conn = null;
        Statement stmt = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER, PASSWORD);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
           // sql = "SELECT ID,sellprice,costprice,quantity FROM inventorydetails.inventorydetails where ItemName = '"+itemName+"'";
            sql = "SELECT costprice,sellprice,quantity,itemName FROM inventorydetails.inventorydetails";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                Double costprice = rs.getDouble("costprice");
                Double sellprice = rs.getDouble("sellprice");
                Long quantity = rs.getLong("quantity");
                String itemName=rs.getString("itemName");
                //Double profit =rs.getDouble("profit");

                //Display values
//                System.out.print(", costprice: " + costprice);
//                System.out.print(", sellprice: " + sellprice);
//                System.out.println(", quantity: " + quantity);
               // System.out.println("profit: " +profit);
                InventoryDTO dto = new InventoryDTO(itemName,costprice,sellprice, quantity);
                dtoList.add(dto);
            }

            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        return dtoList;
    }//end main
    public List<InventoryDTO> setInventoryDetails(double costprice,double sellprice,String itemName,long quantity)
    {
        Connection conn = null;
        Statement stmt = null;
        List<InventoryDTO> dtoList = new ArrayList<>();
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER, PASSWORD);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql="INSERT INTO inventorydetails.inventorydetails (costprice,sellprice,quantity,Itemname)\n" +
                    "VALUES ('"+costprice+"','"+sellprice+"','"+quantity+"','"+itemName+"')";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        return dtoList;
    }//end main
    public List<InventoryDTO> updateBuyInventoryDetails(String itemName,long updatequantity)
    {
        Connection conn = null;
        Statement stmt = null;
        List<InventoryDTO> dtoList = new ArrayList<>();
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER, PASSWORD);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
//            sql = ",sellprice,costprice,quantity FROM inventorydetails.inventorydetails where ItemName = '"+itemName+"'";
            sql="UPDATE inventorydetails.inventorydetails\n" +
                    "SET quantity = quantity+'"+updatequantity+"'\n" +
                    "WHERE itemName='"+itemName+"';\n";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            //  ResultSet rs = stmt.executeQuery(sql);
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        return dtoList;
    }//end main
    public List<InventoryDTO> updateSellInventoryDetails(String itemName,long updatequantity)
    {
        Connection conn = null;
        Statement stmt = null;
        List<InventoryDTO> dtoList = new ArrayList<>();
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER, PASSWORD);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
//            sql = ",sellprice,costprice,quantity FROM inventorydetails.inventorydetails where ItemName = '"+itemName+"'";
            sql="UPDATE inventorydetails.inventorydetails\n" +
                    "SET quantity = quantity-'"+updatequantity+"'\n" +
                    "WHERE itemName='"+itemName+"';\n";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            //  ResultSet rs = stmt.executeQuery(sql);
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        return dtoList;
    }//end main
    public List<InventoryDTO> deleteInventoryDetails(String itemName)
    {
        Connection conn = null;
        Statement stmt = null;
        List<InventoryDTO> dtoList = new ArrayList<>();
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER, PASSWORD);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
//            sql = ",sellprice,costprice,quantity FROM inventorydetails.inventorydetails where ItemName = '"+itemName+"'";
            sql="Delete from inventorydetails.inventorydetails\n" +
                    "WHERE itemName='"+itemName+"';\n";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            //  ResultSet rs = stmt.executeQuery(sql);
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        return dtoList;
    }//end main
    public double report(){

        getdtoList();
        double value=0;

        for(InventoryDTO dto:dtoList){
            double details = dto.getCostPrice()*dto.getQuantity();
            //System.out.println(dto.toString()+"\t" + details);

            value = value + details;
        }
return value;
    }

    private void getdtoList() {
    }
}


