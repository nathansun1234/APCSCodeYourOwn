import java.util.*; 
public class Person { 
    private String name; 
    private double money; 
    private Car auto;
    private int hunger;

    public Person(String name, Car auto){  
        this.name = name;  
        this.auto = auto;   
        hunger = 100;
        money = 1000;
    } 

    public boolean setHunger(int a)
    { 
        //returns false if starved, true if okay 
        if((hunger+a)<100){ 
            if((hunger+a)<0){ 
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

    public Car getCar(){ 
        return auto;
    } 

    public String getName(){ 
        return name; 
    }
    }

       
    
            
        
            


    


