import java.util.*; 
public class Person { 
    private String name; 
    private double money; 
    private int hunger; //must increment by 10s

    public Person(String name){  
        this.name = name;   
        hunger = 100;
        money = 1000;
    } 

    public boolean incrementHunger(int a)
    { 
        //returns false if starved, true if okay 
        if((hunger + a)<100){ 
            if((hunger + a)<0){ 
                hunger = 0; 
                return false; 
            } 
            else{ 
                hunger+=a; 
                return true;
            } 
        } 
        else{ 
            hunger = 100; 
            return true;
        }
    }  

    public int getHunger(){ 
        return hunger;
    }

    public boolean setMoney(int a)
    {
        //returns false if broke, true if okay 
         
        if((money+a)<0){ 
                money = 0; 
                return false; 
            } 
            else{ 
                money+=a; 
                return true;
            } 
        }     

    public double getMoney(){ 
        return money;
    } 

    public String getName(){ 
        return name; 
    }
    }

       
    
            
        
            


    


