package com.example.binancefuturescloseposition.futures.conn.util.enums;

/**
 * типы возможных закрытия и открытия ордеров по рынку цене итп
 */
public enum TypeOrderEnum {
  LIMIT("LIMIT"),
  MARKET("MARKET"),
  STOP("STOP"),
  TAKE_PROFIT("TAKE_PROFIT"),
  STOP_MARKET("STOP_MARKET"),
  TAKE_PROFIT_MARKET("TAKE_PROFIT_MARKET"),
  TRAILING_STOP_MARKET("TRAILING_STOP_MARKET");


  TypeOrderEnum(String name) {

  }
}
