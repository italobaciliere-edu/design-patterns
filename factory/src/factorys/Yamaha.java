package factorys;

import products.Motorbike;
import products.XTZ;

public class Yamaha extends Factory{

    @Override
    public Motorbike getMoto(String marca) {
        if(marca.equalsIgnoreCase("Yamaha"))
            return new XTZ();
        throw new UnsupportedOperationException("Unimplemented method 'getMoto'");
    }
    
}