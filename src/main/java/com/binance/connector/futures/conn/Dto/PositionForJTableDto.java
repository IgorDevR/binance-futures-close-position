package com.example.binancefuturescloseposition.futures.conn.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PositionForJTableDto {

  private String NumPosition;
  private String Symbol;
  private String EntryPrice;
  private String PositionAmt;
  private String PositionSide;
  private String ClosePosition;

}
