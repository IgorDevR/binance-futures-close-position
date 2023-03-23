package com.binance.connector.futures.conn.util.file;

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

  public void saveToFile(String apiKey, String apiSecretFieldText, String urlServerUM,
      String urlServerCM) {

    changeKeysInPrivateConfigFiles(apiKey, apiSecretFieldText, urlServerUM, urlServerUM);

    FileWriter fileWriter = null;
    BufferedWriter bufferedWriter = null;
    try {
      fileWriter = new FileWriter(FILENAME);
      bufferedWriter = new BufferedWriter(fileWriter);
      bufferedWriter.write(apiKey);
      bufferedWriter.newLine();
      bufferedWriter.write(apiSecretFieldText);
      bufferedWriter.newLine();
      bufferedWriter.write(urlServerUM);
      bufferedWriter.newLine();
      bufferedWriter.write(urlServerCM);
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
    String[] keys = new String[4];
    if (!file.exists()) {
      // Если файл не существует, ничего не делаем
      return new String[0];
    }
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      keys[0] = reader.readLine();
      keys[1] = reader.readLine();
      keys[2] = reader.readLine();
      keys[3] = reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    changeKeysInPrivateConfigFiles(keys[0], keys[1], keys[2], keys[3]);
    return keys;
  }

  public void changeKeysInPrivateConfigFiles(String apiKey, String apiSecretField,
      String urlServerUm, String urlServerCm) {
    PrivateConfig.API_KEY = apiKey;
    PrivateConfig.SECRET_KEY = apiSecretField;
    PrivateConfig.UM_BASE_URL = urlServerUm;
    PrivateConfig.CM_BASE_URL = urlServerCm;

  }

}
