package Association;

class Engine{
    public void print(){
        System.out.println("Hello from Engine");
    }
}
class Truck{
    Truck(){
        Engine engine = new Engine();
    }

    public void print(){

        System.out.println("Hello from Truck");
    }
}

public class Main{
    public static void main(String args[]){

    }
}

