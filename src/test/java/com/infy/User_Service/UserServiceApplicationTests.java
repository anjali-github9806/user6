package com.infy.User_Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.infy.User_Service.dto.BuyerDTO;
import com.infy.User_Service.entity.Buyer;
import com.infy.User_Service.repository.BuyerRepository;
import com.infy.User_Service.service.BuyerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceApplicationTests {

	
		@Mock
		BuyerRepository buyerRepo;
		
		@Test
	    public void contextLoads() {
	    }
		
		@InjectMocks
		BuyerService service= new BuyerService();
		
		@Test
		public void authenticateBuyerDetailsValid() throws Exception{
			Buyer buyer = new Buyer();
			buyer.setBuyerId(1);
			 buyer.setEmail("saurbha@gmail.com");
			 buyer.setIsactive(1);
			 buyer.setIsPrivileged(1);
			 buyer.setName("Saurbha Kumar");
			 buyer.setPhonenumber("9999888878");
			 buyer.setPassword("Kumar@w*3996");
			 
			Optional<Buyer> list2=Optional.of(buyer);
			Mockito.when(buyerRepo.findById(1)).thenReturn(list2);
			BuyerDTO buy=service.getSpecificBuyer(list2.get().getBuyerId());
			
		Assertions.assertEquals(1,buy.getBuyerId());
		}
		public void authenticateBuyerDetailsInvalid() throws Exception
		{
			Buyer buyer = new Buyer();
			buyer.setBuyerId(1);
			 buyer.setEmail("saurbha@gmail.com");
			 buyer.setIsactive(1);
			 buyer.setIsPrivileged(1);
			 buyer.setName("Saurbha Kumar");
			 buyer.setPhonenumber("9999888878");
			 buyer.setPassword("Kumar@w*3996");
			 
			 Buyer buyer1 = new Buyer();
			 buyer1.setBuyerId(12);
			 buyer1.setEmail("abc@gmail.com");
			 buyer1.setIsactive(0);
			 buyer1.setIsPrivileged(1);
			 buyer1.setName("abc xyz");
			 buyer1.setPhonenumber("9997654323");
			 buyer1.setPassword("Kumar*3996");
			 Optional<Buyer> list2=Optional.of(buyer1);
			 Mockito.when(buyerRepo.findById(buyer1.getBuyerId())).thenReturn(list2);

		  Exception exception=Assertions.assertThrows(Exception.class,()->service.getSpecificBuyer(buyer1.getBuyerId()));
		  Assertions.assertEquals("service.Buyer_NOT_FOUND", exception.getMessage());
			 }

  
		
	

}
