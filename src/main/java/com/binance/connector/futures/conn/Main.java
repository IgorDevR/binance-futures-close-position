package com.example.binancefuturescloseposition.futures.conn;



import com.example.binancefuturescloseposition.futures.conn.UI.MainWindowUI;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
    System.setProperty("java.awt.headless", "false");
    MainWindowUI mainWindowUI = new MainWindowUI();
//    PositionsService uiViewModel = new PositionsService();

  }

}