package com.example.binancefuturescloseposition.futures.conn.util.file;

import com.binance.connector.futures.conn.PrivateConfig;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilesHandler {

  public FilesHandler() {

  }

  private final String FILENAME = "apiKey.txt";

  public void saveToFile(String apiKey, String apiSecretFieldText, String urlServer) {

    changeKeysInPrivateConfigFiles(apiKey, apiSecretFieldText,urlServer);

    FileWriter fileWriter = null;
    BufferedWriter bufferedWriter = null;
    try {
      fileWriter = new FileWriter(FILENAME);
      bufferedWriter = new BufferedWriter(fileWriter);
      bufferedWriter.write(apiKey);
      bufferedWriter.newLine();
      bufferedWriter.write(apiSecretFieldText);
      bufferedWriter.newLine();
      bufferedWriter.write(urlServer);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      if (bufferedWriter != null) {
        try {
          bufferedWriter.close();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      if (fileWriter != null) {
        try {
          fileWriter.close();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    }


  }

  public String[] loadFromFile() {
    File file = new File(FILENAME);
    String[] keys = new String[3];
    if (!file.exists()) {
      // Если файл не существует, ничего не делаем
      return new String[0];
    }
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      keys[0] = reader.readLine();
      keys[1] = reader.readLine();
      keys[2] = reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    changeKeysInPrivateConfigFiles(keys[0],keys[1],keys[2]);
    return keys;
  }

  public void changeKeysInPrivateConfigFiles(String apiKey, String apiSecretField, String urlServer) {
    PrivateConfig.TESTNET_API_KEY = apiKey;
    PrivateConfig.TESTNET_SECRET_KEY = apiSecretField;
    PrivateConfig.TESTNET_BASE_URL = urlServer;

  }

}
