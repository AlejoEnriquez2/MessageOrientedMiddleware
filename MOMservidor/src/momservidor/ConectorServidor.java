package momservidor;
/*
 * @author alejo
 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ConectorServidor extends Thread{
    //Instancias
    private Socket socket;
    private ServerSocket servidor;
    private InputStreamReader entrada;
    private DataOutputStream salida;
    private BufferedReader mensaje;
    final int puerto = 8181;
    
    public ConectorServidor(){}
    
    public void run(){
        String texto;
        try {
            servidor = new ServerSocket(puerto);
            socket = servidor.accept();
            entrada = new InputStreamReader(socket.getInputStream());
            mensaje = new BufferedReader(entrada);
            salida = new DataOutputStream(socket.getOutputStream());
            
            while(true){
                texto = this.mensaje.readLine();
                VentanaServidorMOM.textAreaSer.setText(VentanaServidorMOM.textAreaSer.getText()+'\n'+texto);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    
    public void enviarMensaje(String mensaje){
        try {
            salida.writeUTF(mensaje+"\n");
        } catch (Exception e) {}
    }
    
    public void desconectar(){
        try {
            socket.close();
            servidor.close();   
        } catch (Exception e) {}
    }
}
