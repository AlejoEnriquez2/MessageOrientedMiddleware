package momservidor;
/*
 * @author alejo
 */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ConectorServidor extends Thread{
    //Instancias
    private Socket socket;
    private ServerSocket servidor;
    private InputStreamReader entrada;
    private DataOutputStream salida;
    private BufferedReader mensaje;
    final int puerto = 8181;
    private String hostname;
    ArrayList<String> base = new ArrayList<>();
    
    public ConectorServidor(){}
    
    public void run(){
        String texto;
        try {
            servidor = new ServerSocket(puerto);
            socket = servidor.accept();
            entrada = new InputStreamReader(socket.getInputStream());
            mensaje = new BufferedReader(entrada);
            salida = new DataOutputStream(socket.getOutputStream());
            hostname = socket.getRemoteSocketAddress().toString();
            
            System.out.println("La ip del Servidor es: " + hostname);
            
            while(true){
                texto = this.mensaje.readLine();
                if(texto == "Conectado... \n"){
                    for (int i=0; i<base.size(); i++){
                        if(base.get(i).equals(null)){
                            enviarMensaje(base.get(i));
                        }
                    }
                }
                VentanaServidorMOM.textAreaSer.setText(VentanaServidorMOM.textAreaSer.getText()+'\n'+texto);
                enviarMensaje(texto);
            }
            
            /*while(true){
                texto = this.mensaje.readLine();
                VentanaServidorMOM.textAreaSer.setText(VentanaServidorMOM.textAreaSer.getText()+'\n'+texto);
            }*/
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    
    public void enviarMensaje(String mensaje){
        try {
            salida.writeUTF(mensaje+"\n");
        } catch (Exception e) {
            base.add(mensaje);
            System.out.println("Error al enviar mensaje, mensaje guardado");
        }
    }
    
    public void desconectar(){
        try {
            servidor.close();   
            socket.close();
            System.out.println("Desconectar Servidor");
        } catch (Exception e) {
            System.out.println("No se pudo Desconectar Servidor");
        }
    }
}
