# Poor-Man-s-Parallelism

The purpose of this package is to render a Mandelbrot set based on input from the user in the TCPClient.java. It collects the input as parameters in a set of MandelbrotParameter.java, which is threaded via TCP to a set amount of TCPServer.java to be calculated into MandelbrotPicture.java. When the calculations is done, the threads are joined back together in the TCPClient.java to be rendered in MandelbrotRenderer.java.

The input requested by the user for the Mandelbrot is currently:
  The four restrictions of the plotarea:
1. min_c_re
2. min_c_im
3. max_c_re
4. max_c_im

  The max amount of iterations:
5. max_n

  Amount of pixels in width and height:
6. x
7. y

  The amount of subpictures in each picture:
8. divisions

  The amount of servers to thread the workload to:
9. serverCount

  The servers address/port:
10-X. server 
