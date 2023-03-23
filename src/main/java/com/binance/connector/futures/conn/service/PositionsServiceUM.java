package com.binance.connector.futures.conn.service;

import com.binance.connector.futures.conn.Dto.BinancePositionDto;
import com.binance.connector.futures.conn.Dto.PositionForJTableDto;
import com.binance.connector.futures.conn.actions_um.NewOrderUM;
import com.binance.connector.futures.conn.actions_um.PositionInformationUM;
import com.binance.connector.futures.conn.positionStorage.PositionStorage;
import com.binance.connector.futures.conn.util.Parser;
import com.binance.connector.futures.conn.util.enums.OrderSideEnum;
import com.binance.connector.futures.conn.util.enums.PositionSideEnum;
import com.binance.connector.futures.conn.util.enums.TypeOrderEnum;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JTable;

/**
 * сервис для работы с позициями
 */
public class PositionsServiceUM {

  /**
   * полдучить все позиции и взять только открытые
   * @return
   */
  public static String[][] getOpenPositions() {
    String openPos = PositionInformationUM.getAllPositions();
    List<BinancePositionDto> binancePositionDto = Parser.parsePosition(openPos);
    PositionStorage.savePositions(binancePositionDto);
    List<PositionForJTableDto> positionForJTableDtos = PositionStorage.loadForJTableDtoPositions();
    return Parser.parseForJTable(positionForJTableDtos);

  }

  /**
   * закрыть выбраную позицию
   * @param openPositionTable
   * @return
   */
  public static String closeSelectPosition(JTable openPositionTable) {

    int selectedRow = openPositionTable.getSelectedRow();
    BinancePositionDto binancePositionDto = PositionStorage.loadDtoPositions().get(selectedRow);
    OrderSideEnum reversOrderSideEnum = binancePositionDto.getPositionSide() == PositionSideEnum.LONG ? OrderSideEnum.SELL : OrderSideEnum.BUY;

    return NewOrderUM.closePosition(binancePositionDto.getSymbol(), reversOrderSideEnum, binancePositionDto.getPositionSide(), TypeOrderEnum.MARKET,
        binancePositionDto.getPositionAmt(), BigDecimal.valueOf(0));
  }


}
