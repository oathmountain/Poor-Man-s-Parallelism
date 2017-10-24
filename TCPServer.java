package mandelbrot;
import java.io.*;
import java.net.*;

public class TCPServer {
	Socket connectionSocket;
	ServerSocket welcomeSocket;
	MandelbrotParameter[] parameters;
	MandelbrotPictures[] pictures;
	
	protected static void setServerSocket(int socket){
		connectionSocket.close();
		welcomeSocket = new ServerSocket(socket);
	}
	public static void main(String[] args) throws Exception{
		setServerSocket(6789);

		while(true){
			//read in parameters from client
			connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			parameters = inFromClient.readLine();
			
			//process parameters into pictures
			for(int index = 0; index < MandelbrotParameter.length; index++){
				//for each pixel(Px, Py) in the parameter
				int x0;// = scaled x coordinate
				int y0;// = scaled y coordinate 
				int x = 0;
				int y = 0;
				int iteration = 0;
				int max_iteration;// = max_n;
				while(x*x + Y*y < 2*2 && iteration < max_iteration){
					int xtemp = x*x - y*y + x0;
					y = 2*x*y + y0;
					x = xtemp;
					iteration++;
				}
				int color; 
				if(iteration < max_iteration){
					color = 1;
				}else{
					color = 0;
				}
				
				pictures[index] = new MandelbrotPicture(Px, Py, color);
			}
			
			//send back mandelbrotpictures to be rendered in client
			outToClient.writeBytes(pictures);
		}
	}
}
