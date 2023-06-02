import java.util.*; 
public class Person { 
    private String name; 
    private int money; 
    private int hunger; //must increment by 10s

    public Person(String name, int difficulty){  
        this.name = name;   
        hunger = 100;
        if (difficulty == 0) {
            money = 1000;
        }
        else if (difficulty == 1) {
            money = 500;
        }
        else if (difficulty == 2) {
            money = 100;
        }
    } 

    public void setHunger(int a) { 
        //returns false if starved, true if okay 
        // if((hunger + a)<100){ 
        //     if((hunger + a)<0){ 
        //         hunger = 0; 
        //         return false; 
        //     } 
        //     else{ 
        //         hunger+=a; 
        //         return true;
        //     } 
        // } 
        // else{ 
        //     hunger = 100; 
        //     return true;
        // }
        hunger = a;
    }
    public void incrementHunger(int a) {
        hunger += a;
    }

    public int getHunger() { 
        return hunger;
    }

    public void setMoney(int a)
    {
        //returns false if broke, true if okay 
        // if((money+a)<0){ 
        //     money = 0; 
        //     return false; 
        // } 
        // else{ 
        //     money+=a; 
        //     return true;
        // }
        money = a;
    }     

    public void incrementMoney(int a) {
        money += a;
    }

    public int getMoney(){ 
        return money;
    } 

    public String getName(){ 
        return name; 
    }
    }

       
    
            
        
            


    


