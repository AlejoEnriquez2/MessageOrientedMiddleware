/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package momcliente;
/*
 * @author alejo
 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ConectorCliente extends Thread{
    //Instancias
    private Socket socket;
    private InputStreamReader entrada;
    private DataOutputStream salida;
    private BufferedReader mensaje;
    final int puerto = 8181;
    String ip;
    
    public ConectorCliente(String ip){
        ip = this.ip;
    }
    
    public void run(){
        String texto;
        try {
            socket = new Socket(ip, this.puerto);
            
            entrada = new InputStreamReader(socket.getInputStream());
            System.out.print("Entrada Éxito " + entrada);
            mensaje = new BufferedReader(entrada);
            System.out.print("Mensaje Éxito " + mensaje);
            salida = new DataOutputStream(socket.getOutputStream());
            System.out.print("Salida Éxito " + salida);
            salida.writeUTF("Conectado... \n");
            
            while(true){
                texto = this.mensaje.readLine();
                VentanaClienteMOM.txtMensaje.setText(VentanaClienteMOM.txtMensaje.getText()+'\n'+texto);
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
        } catch (Exception e) {}
    }
}
