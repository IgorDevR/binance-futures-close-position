package com.binance.connector.futures.conn.util;



import com.binance.connector.futures.conn.Dto.BinancePositionDto;
import com.binance.connector.futures.conn.Dto.PositionForJTableDto;
import com.binance.connector.futures.conn.util.enums.TypeActionEnum;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * обработка json данных и прочее
 */
public class Parser {

  /**
   * сериальзуем json в клас позийций и получаем все позиции с биржи
   *
   * @param json
   * @return
   */
  public static List<BinancePositionDto> parsePosition(String json) {
    Type positionListType = new TypeToken<List<BinancePositionDto>>() {
    }.getType();

    if (!json.isEmpty()) {
      Gson gson = new Gson();
      List<BinancePositionDto> tmpAllSymbolList = gson.fromJson(json, positionListType);
      return filterOpenPositions(tmpAllSymbolList);
    }
    List<BinancePositionDto> onlyOpenPositions = new ArrayList<>();
    return onlyOpenPositions;

  }

  /**
   * оставляем только открыты позиции
   *
   * @param allSymbolList
   * @return
   */

  private static List<BinancePositionDto> filterOpenPositions(
      List<BinancePositionDto> allSymbolList) {
    if (!allSymbolList.isEmpty()) {
      allSymbolList = allSymbolList.stream()
          .filter(p -> p.getPositionAmt().compareTo(BigDecimal.ZERO) != 0).collect(
              Collectors.toList());
    }
    return allSymbolList;
  }

  /**
   * собираем тоблицу для отображения списка позиций в таблице
   *
   * @param positionForJTableDtos
   * @return
   */

  public static String[][] parseForJTable(List<PositionForJTableDto> positionForJTableDtos) {
    String[][] strArrayRows = new String[positionForJTableDtos.size()][HeadersForTables.getCountField(
        TypeActionEnum.OPEN_POSITION)];

    int i = 0;
    for (PositionForJTableDto position : positionForJTableDtos) {

      strArrayRows[i][0] = String.valueOf(position.getNumPosition());
      strArrayRows[i][1] = position.getSymbol();
      strArrayRows[i][2] = position.getEntryPrice();
      strArrayRows[i][3] = position.getPositionAmt();
      strArrayRows[i][4] = position.getPositionSide();
      i++;
    }
    return strArrayRows;
  }


}


