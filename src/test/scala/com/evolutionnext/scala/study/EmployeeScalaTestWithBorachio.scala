package com.evolutionnext.scala.study

import org.scalatest.matchers.MustMatchers
import org.scalatest.WordSpec
import com.borachio.scalatest.MockFactory

/**
 * Created by Daniel Hinojosa
 * User: Daniel Hinojosa
 * Date: 7/7/11
 * Time: 11:55 AM
 * url: <a href="http://www.evolutionnext.com">http://www.evolutionnext.com</a>
 * email: <a href="mailto:dhinojosa@evolutionnext.com">dhinojosa@evolutionnext.com</a>
 * tel: 505.363.5832
 */
class EmployeeScalaTestWithBorachio extends WordSpec with MustMatchers with MockFactory {
  "MyTickerTape" should {
    "return a map of my favorite symbols as keys, and their price as values" in {
      val sqp = mock[StockQuoteProvider]

      sqp expects 'getPrice withArgs ("ATT") returning (BigDecimal("33.00"))
      sqp expects 'getPrice withArgs ("ADVS") returning (BigDecimal("12.34"))
      sqp expects 'getPrice withArgs ("MTN") returning (BigDecimal(".22"))

      val tickerTape = new MyTickerTape(sqp, List("ATT", "ADVS", "MTN"))
      tickerTape.getPrices("ATT") must be(BigDecimal(33.00))
      tickerTape.getPrices("ADVS") must be(BigDecimal(12.34))
      tickerTape.getPrices("MTN") must be(BigDecimal(.22))
    }
  }

  "MyTickerTape" should {
    "return a map of my favorite symbols as keys, and their price as values, in the same order as it was given " in {
      val sqp = mock[StockQuoteProvider]

      inSequence {
        sqp expects 'getPrice withArgs ("ATT") returning (BigDecimal("33.00"))
        sqp expects 'getPrice withArgs ("ADVS") returning (BigDecimal("12.34"))
        sqp expects 'getPrice withArgs ("MTN") returning (BigDecimal(".22"))
      }

      val tickerTape = new MyTickerTape(sqp, List("ATT", "ADVS", "MTN"))
      val prices = tickerTape.getPrices
      prices("ATT") must be(BigDecimal(33.00))
      prices("ADVS") must be(BigDecimal(12.34))
      prices("MTN") must be(BigDecimal(.22))
    }
  }

  "Borachio" should {
    "mock functions by their signature" in {
      val tickerTapeFunction = mockFunction[String, BigDecimal]

      tickerTapeFunction expects ("ATT") returning BigDecimal("33.00")
      tickerTapeFunction expects ("ADVS") returning BigDecimal("12.34")
      tickerTapeFunction expects ("MTN") returning BigDecimal(".22")

      expect(List(BigDecimal("33.00"), BigDecimal("12.34"), BigDecimal(".22"))) {
        List("ATT", "ADVS", "MTN").map(tickerTapeFunction)
      }
    }
  }
}