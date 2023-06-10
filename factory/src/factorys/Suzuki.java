package factorys;

import products.DRZ;
import products.Motorbike;

public class Suzuki extends Factory{

    public Suzuki(){
        this.nome = "Suzuki's factory";
    }

    @Override
    public Motorbike getMoto(String marca) {
        if(marca.equalsIgnoreCase("DRZ"))
            return new DRZ();
        return null;
    }
    
}