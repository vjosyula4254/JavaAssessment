import DAO.InventoryDAOImpl;
import InventoryDTO.InventoryDTO;
import log4j.Log4j;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class InventoryTest {
    final static Logger logger = Logger.getLogger(Log4j.class);

    public static void beforeClass()
    {
        System.out.println("Before class");
    }
    @AfterClass
    public static void afterClass()
    {
        System.out.println("After class");
    }
    @Before

    public void setUp()
    {
        System.out.println("Inside @Before");
    }
    @Test
    public void DaoTest()  {
        System.out.println("Inside addresstest");

//

        //dto1 = test.getInventoryDetails("icecream");
       //dto1 = test.setInventoryDetails(4,250,350,"car",5);
        //dto1 = test.setInventoryDetails(ID,costprice,sellprice,itemName,quantity);
        //dto1 = test.getInventoryDetails("iphonex");

       // assertEquals("laptop",dto1.get(0).getItemName());
        //dto1=test.updateBuyInventoryDetails("iphonex",7);
//        dto1=test.deleteInventoryDetails("java.io.ByteArrayInputStream@aec6354");
//        System.out.println(dto1);
        List<InventoryDTO> dto1 = null;
        InventoryDAOImpl test =new InventoryDAOImpl();
        assertEquals("car", dto1.get(0).getItemName());
        assertEquals(150, dto1.get(0).getCostPrice(), 0);
        assertEquals(200, dto1.get(0).getSellPrice(), 0);
        assertEquals(5, dto1.get(0).getQuantity());


    }
    @Test
    public void nulltest()
    {
        System.out.println("Inside nulltest");

        InventoryDAOImpl test = new InventoryDAOImpl();
        List<InventoryDTO> dtoList = null;
        dtoList = test.getInventoryDetails();
        assertNull(dtoList.get(0));

    }

}
