package Demo;

public class Demo{
    public static void main(String[] agrs){
        Laptop l1 = new Laptop();
        Desktop d1 = new Desktop();

        Dev d = new Dev();
        d.code(d1);


        int a = 11;
        int b =10;

        int result;

        try{
            result = b/a;
            if(result == 0){
                throw new ArithmeticException("Result is 0");
            }

        } catch (ArithmeticException e) {
            System.out.println("Arth Excep");;
        }
        catch (Exception e) {
            System.out.println("Error block reached!" + e.getMessage());
        }
        finally {
            System.out.println("Will be always called after try and catch!");
        }
    }
}