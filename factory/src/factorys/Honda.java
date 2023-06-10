package factorys;

import products.CBX;
import products.Motorbike;

public class Honda extends Factory{

    public Honda(){
        this.nome = "Honda factory";
    }

    @Override
    public Motorbike getMoto(String marca) {
        if(marca.equalsIgnoreCase("CBX"))
            return new CBX();
        return null;
    }
    
}