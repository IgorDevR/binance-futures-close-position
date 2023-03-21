package com.binance.connector.futures.conn.mapper;


import com.binance.connector.futures.conn.Dto.BinancePositionDto;
import com.binance.connector.futures.conn.Dto.PositionForJTableDto;
import com.binance.connector.futures.conn.entity.BinancePositionEntity;
import com.binance.connector.futures.conn.util.enums.PositionSideEnum;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class PositionMapper {
  /**
   * формируем dto из позиции
   *    * @return
   */
  public static List<BinancePositionDto> toDTO(
      List<BinancePositionEntity> position) {

    List<BinancePositionDto> dtoList = new ArrayList<>();
    for (int i = 0; i < position.size(); i++) {
      BinancePositionDto dto = new BinancePositionDto();
      dto.setSymbol(position.get(i).getSymbol());
      dto.setNumPosition(position.get(i).getNumPosition());
      dto.setPositionAmt(position.get(i).getPositionAmt());
      dto.setEntryPrice(position.get(i).getEntryPrice());
      dto.setMarkPrice(position.get(i).getMarkPrice());
      dto.setUnRealizedProfit(position.get(i).getUnRealizedProfit());
      dto.setLiquidationPrice(position.get(i).getLiquidationPrice());
      dto.setLeverage(position.get(i).getLeverage());
      dto.setMaxNotionalValue(position.get(i).getMaxNotionalValue());
      dto.setMarginType(position.get(i).getMarginType());
      dto.setIsolatedMargin(position.get(i).getIsolatedMargin());
      dto.setIsAutoAddMargin(position.get(i).getIsAutoAddMargin());
      dto.setPositionSide(
          setPositionSide(position.get(i).getPositionSide(), position.get(i).getPositionAmt()));
      dto.setNotional(position.get(i).getNotional());
      dto.setIsolatedWallet(position.get(i).getIsolatedWallet());
      dto.setUpdateTime(position.get(i).getUpdateTime());
      dtoList.add(dto);
    }

    return dtoList;
  }

  /**
   * формируем позиции из dto
   * @param dto
   * @return
   */
  public static List<BinancePositionEntity> toPosition(
      List<BinancePositionDto> dto) {

    List<BinancePositionEntity> positionList = new ArrayList<>();
    for (int i = 0; i < dto.size(); i++) {
      BinancePositionEntity position = new BinancePositionEntity();
      position.setNumPosition(i + 1);
      position.setSymbol(dto.get(i).getSymbol());
      position.setPositionAmt(dto.get(i).getPositionAmt());
      position.setEntryPrice(dto.get(i).getEntryPrice());
      position.setMarkPrice(dto.get(i).getMarkPrice());
      position.setUnRealizedProfit(dto.get(i).getUnRealizedProfit());
      position.setLiquidationPrice(dto.get(i).getLiquidationPrice());
      position.setLeverage(dto.get(i).getLeverage());
      position.setMaxNotionalValue(dto.get(i).getMaxNotionalValue());
      position.setMarginType(dto.get(i).getMarginType());
      position.setIsolatedMargin(dto.get(i).getIsolatedMargin());
      position.setIsAutoAddMargin(dto.get(i).getIsAutoAddMargin());
      position.setPositionSide(
          setPositionSide(dto.get(i).getPositionSide(), dto.get(i).getPositionAmt()));
      position.setNotional(dto.get(i).getNotional());
      position.setIsolatedWallet(dto.get(i).getIsolatedWallet());
      position.setUpdateTime(dto.get(i).getUpdateTime());
      positionList.add(position);
    }
    return positionList;
  }

  /**
   * формируем dto для таблицы отображения
   * @param positions
   * @return
   */
  public static List<PositionForJTableDto> positionForJTableDto(
      List<BinancePositionEntity> positions) {

    List<PositionForJTableDto> dtoList = new ArrayList<>();
    for (int i = 0; i < positions.size(); i++) {
      PositionForJTableDto dto = new PositionForJTableDto();
      dto.setNumPosition(String.valueOf(positions.get(i).getNumPosition()));
      dto.setSymbol(positions.get(i).getSymbol());
      dto.setPositionAmt(String.valueOf(positions.get(i).getPositionAmt()));
      dto.setEntryPrice(positions.get(i).getEntryPrice());
      dto.setPositionSide(
          String.valueOf(
              setPositionSide(positions.get(i).getPositionSide(), positions.get(i).getPositionAmt())));
      dtoList.add(dto);
    }

    return dtoList;
  }

  /**
   * тестовый метод для назначении позиции
   * @param positionSideEnum
   * @param positionAmt
   * @return
   */
  private static PositionSideEnum setPositionSide(PositionSideEnum positionSideEnum,
      BigDecimal positionAmt) {

//    int posOrNegPosition = 0;
//    if (positionSideEnum == PositionSideEnum.BOTH
//        && positionAmt.compareTo(BigDecimal.ZERO) != posOrNegPosition) {
//
//      positionSideEnum =
//          positionAmt.compareTo(BigDecimal.ZERO) > posOrNegPosition ? PositionSideEnum.LONG
//              : PositionSideEnum.SHORT;
//
//    }
    return positionSideEnum;
  }

}
