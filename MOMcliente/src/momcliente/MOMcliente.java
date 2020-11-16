package momcliente;
/*
 * @author alejo
 */
public class MOMcliente {    
    static ConectorCliente cliente;
    public static void main(String[] args) {
        // TODO code application logic here
        VentanaClienteMOM client = new VentanaClienteMOM();
        client.setVisible(true);
    }
    
    public void initCliente(String ip){
        cliente = new ConectorCliente(ip);
        cliente.start();
        System.out.println("Cliente Conectado a " + ip);
    }
}
