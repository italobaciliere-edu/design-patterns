package condimentos;

import cafes.Bebiba;
import cafes.DecoratorDeCondimento;

public class Leite extends DecoratorDeCondimento{

    Bebiba bebida;

    public Leite(Bebiba bebida){
        this.bebida = bebida;
    }

    @Override
    public String getDescricao() {
        return bebida.getDescricao() + ", DECORADO COM LEITE";
    }

    @Override
    public double custo() {
        return 0.5 + bebida.custo();
    }
    
}