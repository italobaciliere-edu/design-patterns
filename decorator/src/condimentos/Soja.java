package condimentos;

import cafes.Bebiba;
import cafes.DecoratorDeCondimento;

public class Soja extends DecoratorDeCondimento{

    Bebiba bebida;

    public Soja(Bebiba bebida){
        this.bebida = bebida;
    }

    @Override
    public String getDescricao() {
        return bebida.getDescricao() + ", DECORADO COM SOJA";
    }

    @Override
    public double custo() {
        return 3.0 + bebida.custo();
    }
    
}