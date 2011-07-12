package com.evolutionnext.scala.study

/**
 * Created by Daniel Hinojosa
 * User: Daniel Hinojosa
 * Date: 7/7/11
 * Time: 2:49 PM
 * url: <a href="http://www.evolutionnext.com">http://www.evolutionnext.com</a>
 * email: <a href="mailto:dhinojosa@evolutionnext.com">dhinojosa@evolutionnext.com</a>
 * tel: 505.363.5832
 */
class MyTickerTape(stockQuoteProvider: StockQuoteProvider, list: List[String]) {
  def getPrices = list.map(s => (s, stockQuoteProvider.getPrice(s))).toMap
}