package factorys;

import products.Motorbike;

public abstract class Factory {
    
    public String nome;

    public abstract Motorbike getMoto(String marca);

    public static Factory getInstance(String factory){
        if(factory.equalsIgnoreCase("Honda")){
            return new Honda();
        } else if(factory.equalsIgnoreCase("Yamaha")){
            return new Yamaha();
        } else if(factory.equalsIgnoreCase("Suzuki")){
            return new Suzuki();
        }   

        throw new IllegalArgumentException("Não existe este modelo de moto!");
    }

}