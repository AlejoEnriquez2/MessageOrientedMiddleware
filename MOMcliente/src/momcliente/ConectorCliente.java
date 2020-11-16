package momcliente;
/*
 * @author alejo
 */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ConectorCliente extends Thread{
    //Instancias
    private Socket socket;
    private InputStreamReader entrada;
    private DataOutputStream salida;
    private BufferedReader mensaje;
    final int puerto = 8181;
    String ip;
    private String hostname;
    
    public ConectorCliente(String ip){
        ip = this.ip;
    }
    
    public void run(){
        String texto;
        try {
            socket = new Socket(ip, this.puerto);
            entrada = new InputStreamReader(socket.getInputStream());
            mensaje = new BufferedReader(entrada);
            salida = new DataOutputStream(socket.getOutputStream());
            salida.writeUTF("Conectado... \n");
            hostname = socket.getLocalAddress().toString();
            System.out.println("La ip del Cliente es: " + hostname);
            
            while(true){
                texto = this.mensaje.readLine();
                VentanaClienteMOM.txtMensaje.setText(VentanaClienteMOM.txtMensaje.getText()+'\n'+texto);
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }
    }
    
    public void enviarMensaje(String mensaje){
        try {
            salida.writeUTF(mensaje+"\n");
        } catch (Exception e) {
            System.out.println("Error al enviar mensaje");
        }
    }
    
    public void desconectar(){
        try {
            socket.close();
            System.out.println("Cliente Desconectado");
        } catch (Exception e) {}
    }
}
