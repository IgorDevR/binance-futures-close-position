package com.binance.connector.futures.conn.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BinanceOrderEntity {
  private String avgPrice;
  private String clientOrderId;
  private String cumQuote;
  private String executedQty;
  private Long orderId;
  private String origQty;
  private String origType;
  private String price;
  private Boolean reduceOnly;
  private String side;
  private String positionSide;
  private String status;
  private String stopPrice;
  private Boolean closePosition;
  private String symbol;
  private Long time;
  private String timeInForce;
  private String type;
  private String activatePrice;
  private String priceRate;
  private Long updateTime;
  private String workingType;
  private Boolean priceProtect;

}