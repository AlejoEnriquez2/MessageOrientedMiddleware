/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package momcliente;

/**
 *
 * @author alejo
 */
public class MOMcliente {

    /**
     * @param args the command line arguments
     */
    static ConectorCliente cliente;
    public static void main(String[] args) {
        // TODO code application logic here
        VentanaClienteMOM client = new VentanaClienteMOM();
        client.setVisible(true);
    }
    
    public void initCliente(String ip){
        cliente = new ConectorCliente(ip);
        cliente.start();
    }
    
}
