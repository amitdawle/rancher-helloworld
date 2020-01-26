package com.ad;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.time.LocalDateTime;

class HelloDocker{


  public static void main(String[] args) throws IOException {
   HttpServer server = HttpServer.create(new InetSocketAddress(8008), 0);
   HttpContext context = server.createContext("/");
   context.setHandler(HelloDocker::handleRequest);
   server.start();
  }

  private static void handleRequest(HttpExchange exchange) throws IOException {
   String response = "Hello from ";
   try{
    InetAddress ip = InetAddress.getLocalHost();
    String hostname = ip.getHostName();
    response += hostname;
    response += ". The time is " + LocalDateTime.now();
   }catch (Exception e){
     response += "Unable to get reponse : " +  e.getMessage();
   }
   exchange.sendResponseHeaders(200, response.getBytes().length);//response code and length
   OutputStream os = exchange.getResponseBody();
   os.write(response.getBytes());
   os.close();
  }

}  