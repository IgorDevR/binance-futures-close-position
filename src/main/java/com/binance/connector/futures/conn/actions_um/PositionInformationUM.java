package com.binance.connector.futures.conn.actions_um;

import com.binance.connector.futures.client.exceptions.BinanceClientException;
import com.binance.connector.futures.client.exceptions.BinanceConnectorException;
import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import com.binance.connector.futures.conn.PrivateConfig;
import com.binance.connector.futures.conn.UI.ErrorUI;
import java.util.LinkedHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PositionInformationUM {

  private PositionInformationUM() {
  }

  private static final Logger logger = LoggerFactory.getLogger(PositionInformationUM.class);

  /**
   * получить все позиции в том числе неоткрытые, другого варианта нет
   *
   * @return
   */
  public static String getAllPositions() {
    LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();

    UMFuturesClientImpl client = new UMFuturesClientImpl(PrivateConfig.API_KEY,
        PrivateConfig.SECRET_KEY, PrivateConfig.UM_BASE_URL);

    try {
      String result = client.account().positionInformation(parameters);
      logger.info(result);
      return result;
    } catch (BinanceConnectorException e) {
      logger.error("fullErrMessage: {}", e.getMessage(), e);
      ErrorUI errorUI = new ErrorUI();
      errorUI.logTextPane.setText("fullErrMessage: " + e.getMessage());
    } catch (BinanceClientException e) {
      logger.error("fullErrMessage: {} \nerrMessage: {} \nerrCode: {} \nHTTPStatusCode: {}",
          e.getMessage(), e.getErrMsg(), e.getErrorCode(), e.getHttpStatusCode(), e);
      ErrorUI errorUI = new ErrorUI();
      errorUI.logTextPane.setText(
          "fullErrMessage: " + e.getMessage() + " \nnerrMessage: {} " + e.getErrMsg() +
              "\nerrCode:  " + e.getErrorCode() + "\nHTTPStatusCode: " + e.getHttpStatusCode());
    }
    return "";
  }
}