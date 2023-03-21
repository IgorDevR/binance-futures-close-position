package com.example.binancefuturescloseposition.futures.conn.Dto;


import com.binance.connector.futures.conn.util.enums.PositionSideEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BinancePositionDto {

  private long NumPosition;
  private String symbol;
  private BigDecimal positionAmt;
  private String entryPrice;
  private BigDecimal markPrice;
  private BigDecimal unRealizedProfit;
  private BigDecimal liquidationPrice;
  private Integer leverage;
  private BigDecimal maxNotionalValue;
  private String marginType;
  private BigDecimal isolatedMargin;
  private Boolean isAutoAddMargin;
  private PositionSideEnum positionSide;
  private BigDecimal notional;
  private BigDecimal isolatedWallet;
  private long updateTime;



}
