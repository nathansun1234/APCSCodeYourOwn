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

       
    
            
        
            


    


