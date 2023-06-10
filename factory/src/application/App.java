package application;

import javax.swing.JOptionPane;

import factorys.Factory;
import products.Motorbike;

public class App {
    public static void main(String[] args) throws Exception {
        while(true){
            try {
                String factoryName = JOptionPane.showInputDialog("Factory name? ");
                Factory factory = Factory.getInstance(factoryName);
                if(factory == null){
                    JOptionPane.showMessageDialog(null, "Factory does't exist");
                    break;
                }

                String motorbikeName = JOptionPane.showInputDialog("Motorbike name? ");
                Motorbike motorbike = factory.getMoto(motorbikeName);
                
                if(motorbike != null){
                    JOptionPane.showMessageDialog(null, 
                        "Factory " + factoryName + "\n"
                        + "------------------------------\n"
                        + "Name: " + motorbike.getName() + "\n"
                        + "Color: " + motorbike.getColor() + "\n"
                        + "Displacement: " + motorbike.getDisplacement() + "\n"
                        + "Value: " + motorbike.getValue()
                    );
                }else {
                    JOptionPane.showMessageDialog(null, "Motorbike does't exist");
                }

            } catch (Exception e) {
            }
        }
        System.out.println("Exit");
    }
}
