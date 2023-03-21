package com.binance.connector.futures.client;

import com.binance.connector.futures.client.impl.futures.Account;
import com.binance.connector.futures.client.impl.futures.Market;
import com.binance.connector.futures.client.impl.futures.PortfolioMargin;
import com.binance.connector.futures.client.impl.futures.UserData;

public interface FuturesClient {
    Market market();
    Account account();
    UserData userData();
    PortfolioMargin portfolioMargin();
}
