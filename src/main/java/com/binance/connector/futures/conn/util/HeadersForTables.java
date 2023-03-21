package com.binance.connector.futures.conn.util;



import com.binance.connector.futures.conn.Dto.BinancePositionDto;
import com.binance.connector.futures.conn.Dto.PositionForJTableDto;
import com.binance.connector.futures.conn.util.enums.TypeActionEnum;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * создает заговоки (колонки) таблицы
 */
public class HeadersForTables {

  /**
   * с помощью рефлецсии перебераем все поля класса и делаем из них колонки таблицы
   * @return
   */
  public static String[] getHeadersOpenPosition() {

    PositionForJTableDto myObject = new PositionForJTableDto();

    Field[] headerFields = myObject.getClass().getDeclaredFields();
    String[] headerArr = Arrays.stream(headerFields).map(field -> field.getName())
        .toArray(String[]::new);

    return headerArr;
  }
  /**
   * с помощью рефлецсии перебераем все поля класса и делаем из них колонки таблицы
   * @return
   */
  public static String[] getHeadersOpenOrders() {

    BinancePositionDto myObject = new BinancePositionDto();

    Field[] headerFields = myObject.getClass().getDeclaredFields();
    String[] headerArr = Arrays.stream(headerFields).map(field -> field.getName())
        .toArray(String[]::new);

    return headerArr;
  }

  public static int getCountFieldOpenPosition(TypeActionEnum action){
    if(action == TypeActionEnum.OPEN_POSITION){
      String[] headersOpenPosition = getHeadersOpenPosition();
      return headersOpenPosition.length;
    }
    if(action == TypeActionEnum.OPEN_ORDER){
      String[] headersOpenPosition = getHeadersOpenOrders();
      return headersOpenPosition.length;
    }
    return 0;
  }

  /**
   * получить число полей класса
   * @param action
   * @return
   */
  public static int getCountField(TypeActionEnum action){
    if(action == TypeActionEnum.OPEN_POSITION){
      String[] headersOpenPosition = getHeadersOpenPosition();
      return headersOpenPosition.length;
    }
    if(action == TypeActionEnum.OPEN_ORDER){
      String[] headersOpenPosition = getHeadersOpenOrders();
      return headersOpenPosition.length;
    }
    return 0;
  }

}
