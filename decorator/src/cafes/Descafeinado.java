package cafes;

public class Descafeinado extends Bebiba{

    public Descafeinado(){
        descricao = "DESCAFEINADO";
    }

    @Override
    public double custo() {
        return 2.0;
    }
    
}