package snowmonkey.exchangemetadata.parsers;

import org.junit.Test;
import snowmonkey.exchangemetadata.BitsAndBobs;
import snowmonkey.exchangemetadata.model.ExchangeMetadata;

// not really a test - just a way to execute the parser
// need to add "--add-modules jdk.incubator.httpclient" to the VM parameters

public class ParsersTest {
    @Test
    public void anxpro() throws Exception {
        go(AnxproParser.create());
    }

    @Test
    public void binance() throws Exception {
        go(BinanceParser.create());
    }

    @Test
    public void bitz() throws Exception {
        go(BitZParser.create());
    }

    @Test
    public void bitbank() throws Exception {
        go(BitbankParser.create());
    }

    @Test
    public void bitbay() throws Exception {
        go(BitbayParser.create());
    }

    @Test
    public void bitfinex() throws Exception {
        go(BitfinexParser.create());
    }

    @Test
    public void bitflyer() throws Exception {
        go(BitflyerParser.create());
    }

    @Test
    public void exmo() throws Exception {
        go(ExmoParser.create());
    }

    private void go(Parser parser) throws Exception {
        ExchangeMetadata exchangeMetadata = parser.generateExchangeMetadata();
        String json = BitsAndBobs.prettyPrint(exchangeMetadata.toJson());
        System.out.println(json);
    }

}