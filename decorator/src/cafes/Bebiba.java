package cafes;

public abstract class Bebiba {
    
    String descricao = "Bebida descinhecida";

    public String getDescricao(){
        return descricao;
    }

    public abstract double custo();
}