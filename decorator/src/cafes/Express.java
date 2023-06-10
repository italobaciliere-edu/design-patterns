package cafes;

public class Express extends Bebiba{

    public Express(){
        descricao = "EXPRESS";
    }

    @Override
    public double custo() {
        return 6.0;
    }

    
}