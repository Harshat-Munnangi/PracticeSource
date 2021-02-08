package ClientBSFI.DeepTesting

import java.util.Scanner

class OrderService {
	fun main(args : Array<String>) : Unit{

		println("Enter List Size")
		val inputScan = Scanner(System.`in`) 
		
		val numberofItems = inputScan.nextInt()
		val fruiteList : Array<String> = arrayOf()
		val finalFruitList : List<String> = arrayListOf()
		for(k in 0..numberofItems-1){
			val nextItem = readLine()
			fruiteList[k] = if(nextItem != null) nextItem else "null"
		}
		for(i in fruiteList){
			val indexFruits = i.split(",")
			finalFruitList.plus(indexFruits)
		}
		println("Please enter your Email Id: ")
		val subcriberMail = readLine().toString()
		//println(fruiteList)
		println("-------First Step------------")
		orderServices(finalFruitList , 0.60 , 0.25, subcriberMail)
		println("-------Second Step------------")
		orderServices(finalFruitList , 0.30 , 0.5/3, subcriberMail)
		
	}
	
	fun orderServices(fruitList : List<String>, appleCost : Double, orangeCost : Double, subcriberMail : String) : String{
		
		val totalApples = countSpecificFruit(fruitList, "Apple")
		val totalOranges = countSpecificFruit(fruitList,"Orange")
		val totalCost : Double 
		val totalDuration : Double 
		//val availableApples = applesAvailableInStore()
		
		if(applesAvailableInStore() >= totalApples && orangesAvailableInStore() >= totalOranges){
			totalCost = totalApples * appleCost + totalOranges * orangeCost
			totalDuration = totalApples * 1 + totalOranges * 0.5
			SendMailToCustomers.initiateMail(subcriberMail, "S")
			println("Total $totalApples Apples and $totalOranges Oranges Purcased.")
			println("Bill Amount is $totalCost . Delivery Time: $totalDuration mins")
			return "Success"
		}else{
			SendMailToCustomers.initiateMail(subcriberMail, "F")
			println("Sorry!!! Stock run out. Please try after sometime")
			return "Success"
		}
		
	}
	
	fun countSpecificFruit(fruitList : List<String>, fruitName : String) : Int{
		return fruitList.filter { a -> a.equals(fruitName)}.count()
	}
	
	
	fun applesAvailableInStore() : Int{
		return 10
	}
	fun orangesAvailableInStore() : Int {
		return 12
	}
}

