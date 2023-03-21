package com.binance.connector.futures.conn.actions_um;

import com.binance.connector.futures.client.exceptions.BinanceClientException;
import com.binance.connector.futures.client.exceptions.BinanceConnectorException;
import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import com.binance.connector.futures.conn.PrivateConfig;
import com.binance.connector.futures.conn.util.enums.OrderSideEnum;
import com.binance.connector.futures.conn.util.enums.PositionSideEnum;
import com.binance.connector.futures.conn.util.enums.TypeOrderEnum;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class NewOrder {

  private NewOrder() {
  }


  private static final Logger logger = LoggerFactory.getLogger(NewOrder.class);

  public static String newOrder(String symbol, OrderSideEnum side, PositionSideEnum positionSide,
      TypeOrderEnum typeOrderEnum,
      BigDecimal quantity, BigDecimal price) {
    LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();

    UMFuturesClientImpl client = new UMFuturesClientImpl(PrivateConfig.TESTNET_API_KEY,
        PrivateConfig.TESTNET_SECRET_KEY, PrivateConfig.TESTNET_BASE_URL);

    parameters.put("symbol", symbol);
    parameters.put("side", side.name());
    parameters.put("positionSide", positionSide.name());
    parameters.put("type", typeOrderEnum.name());
//    parameters.put("timeInForce", "GTC");
    parameters.put("quantity", quantity.abs());
    if (price.compareTo(BigDecimal.ZERO) != 0) {
      parameters.put("price", price);
    }

    try {
      String result = client.account().newOrder(parameters);
      logger.info(result);
      return result;
    } catch (BinanceConnectorException e) {
      logger.error("fullErrMessage: {}", e.getMessage(), e);
    } catch (BinanceClientException e) {
      logger.error("fullErrMessage: {} \nerrMessage: {} \nerrCode: {} \nHTTPStatusCode: {}",
          e.getMessage(), e.getErrMsg(), e.getErrorCode(), e.getHttpStatusCode(), e);
    }
    return null;
  }
  /**
   * толко для удобстав в названии основной метод newOrder
   * @param symbol
   * @param side
   * @param positionSide
   * @param typeOrderEnum
   * @param quantity
   * @param price
   * @return
   */
  public static String openPosition(String symbol, OrderSideEnum side,
      PositionSideEnum positionSide, TypeOrderEnum typeOrderEnum,
      BigDecimal quantity, BigDecimal price) {
    return newOrder(symbol, side, positionSide, typeOrderEnum, quantity, price);
  }

  /**
   * толко для удобстав в названии основной метод newOrder
   * @param symbol
   * @param side
   * @param positionSide
   * @param typeOrderEnum
   * @param quantity
   * @param price
   * @return
   */
  public static String closePosition(String symbol, OrderSideEnum side,
      PositionSideEnum positionSide, TypeOrderEnum typeOrderEnum,
      BigDecimal quantity, BigDecimal price) {
    return newOrder(symbol, side, positionSide, typeOrderEnum, quantity, price);
  }
}