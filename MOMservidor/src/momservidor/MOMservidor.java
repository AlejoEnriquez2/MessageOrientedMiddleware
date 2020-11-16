package momservidor;

/*
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
