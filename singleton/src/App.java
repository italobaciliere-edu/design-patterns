public class App {
    public static void main(String[] args) throws Exception {
        
        Singleton singletonInstance = Singleton.getInstance();

        System.out.println(singletonInstance);
    }
}
