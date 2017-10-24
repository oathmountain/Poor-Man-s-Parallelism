package mandelbrot;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class TCPClient {

	public static void main(String[] args) throws Exception{
		String pictureName = "MandelbrotPicture";
		int max_n, divisions, serverCount, pictureCount, picturesPerServer,count=1;
		double min_c_re, min_c_im, max_c_re, max_c_im, resolution;
		double width,height;
		int[] servers;
		String modifiedSentence;
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

		//read in parameters of Mandelbrot
		min_c_re = inFromUser.read();
		min_c_im = inFromUser.read();
		max_c_re = inFromUser.read();
		max_c_im = inFromUser.read();
		max_n = inFromUser.read();
		width = inFromUser.read();
		height = inFromUser.read();
		divisions = inFromUser.read();
		
		//read in the servers
		serverCount = inFromUser.read();
		servers = new int[serverCount];
		for(int i = 0; i < serverCount; i++){
			servers[i] = inFromUser.read();
		}
		
		//perform setup calculations
		pictureCount = (int)(width*height / divisions);//could loose pictures by clipping
		picturesPerServer = pictureCount / serverCount;//could loose pictures
		resolution = serverCount/width/divisions;
		
		//setup parameters of all the subpictures, for all the severs
		for(int a = 0; a < serverCount;a++){
			MandelbrotParameter[] theArray = new MandelbrotParameter[picturesPerServer];
			for(int b = 0; b < picturesPerServer; b++){
				
				theArray[b] = new MandelbrotParameter(pictureName+" "+count,resolution, xPos,yPos);
				count++;
			}
			
			//send parameters to the current server
			Socket clientSocket = new Socket("localhost", servers[a]);
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			//outToServer.writeBytes(theArray); //send array to server server
			clientSocket.close();
		}

		//collect the processed MandelbrotPictures and render them
		//pictureArray = inFromServer.readLine();
		//renderAllArrays
		
	}
}