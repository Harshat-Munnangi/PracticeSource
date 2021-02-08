package ClientBSFI

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ClientBSFI.DeepTesting.OrderService
import org.junit.Assert

class OrderServiceTest {
	
	private val subcriberMail = "munnangi@example.com"
	private val listOfFruits = arrayListOf("Apple","Orange","Orange","Apple","Orange","Orange")
	private val appleCostTest = 0.6
	private val orangeCostTest = 0.25
	
	
	
	@Test
	fun orderServiceTesting(){
		
		val orderservkce = OrderService()
		val response = orderservkce.orderServices(listOfFruits, appleCostTest, orangeCostTest, subcriberMail)
		Assert.assertEquals("Success", response)
	}
	
	
}