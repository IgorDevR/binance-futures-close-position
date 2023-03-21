package com.example.binancefuturescloseposition.futures.conn.positionStorage;

import com.binance.connector.futures.conn.Dto.BinancePositionDto;
import com.binance.connector.futures.conn.Dto.PositionForJTableDto;
import com.binance.connector.futures.conn.entity.BinancePositionEntity;
import com.binance.connector.futures.conn.mapper.PositionMapper;
import java.util.ArrayList;
import java.util.List;

/**
 * класс для сохранения в памяти ли на диске
 */
public class PositionStorage {

  private static List<BinancePositionEntity> onlyOpenPositionList;

  /**
   * для хранения и загрузки в памяти или в другом месте позиции
   * @return
   */
  public static void savePositions(List<BinancePositionDto> openPositionsDto) {

    onlyOpenPositionList = PositionMapper.toPosition(openPositionsDto);
  }
  /**
   * для хранения и загрузки в памяти или в другом месте позиции
   * @return
   */
  public static List<BinancePositionDto> loadDtoPositions() {

    List<BinancePositionDto> onlyOpenPositionDtoList = new ArrayList<>();
    if(!onlyOpenPositionList.isEmpty()){
      onlyOpenPositionDtoList = PositionMapper.toDTO(onlyOpenPositionList);
      return onlyOpenPositionDtoList;
    }
     return onlyOpenPositionDtoList;

  }

  /**
   * для хранения и загрузки в памяти или в другом месте позиции для таблицы отображения
   * @return
   */
  public static List<PositionForJTableDto> loadForJTableDtoPositions() {

    List<PositionForJTableDto> positionForJTableDtos = PositionMapper.positionForJTableDto(onlyOpenPositionList);
    return positionForJTableDtos;
  }


}
