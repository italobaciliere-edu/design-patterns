public class Singleton {
    
    private static Singleton instance;

    private Singleton(){}


    public static Singleton getInstance(){
        if(Singleton.instance == null)
            Singleton.instance = new Singleton();
        return Singleton.instance;
    }

    @Override
    public String toString(){
        return "Singleton instance";
    }

}