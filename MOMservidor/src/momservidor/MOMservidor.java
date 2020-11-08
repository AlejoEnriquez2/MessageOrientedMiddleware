/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package momservidor;

/**
 *
 * @author alejo
 */
public class MOMservidor {

    /**
     * @param args the command line arguments
     */
    static ConectorServidor servidor;
    public static void main(String[] args) {
        VentanaServidorMOM server = new VentanaServidorMOM();
        server.main();
    }
    
    public void initServer(){
        servidor = new ConectorServidor();
        servidor.start();
        System.out.print("Servidor Iniciado...");
    }
}
