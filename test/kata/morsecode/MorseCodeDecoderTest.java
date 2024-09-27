package kata.morsecode;

import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeDecoderTest {

    @Test
    public void testDecode(){
        Assert.assertEquals("HEY JUDE", MorseCodeDecoder.decodeMorse(".... . -.--   .--- ..- -.. ."));
    }

    @Test
    public void testDecode2(){
        Assert.assertEquals("E E", MorseCodeDecoder.decodeMorse("   .   ."));
    }

    @Test
    public void testExampleFromDescription() throws Exception {
        Assert.assertEquals(
            ".... . -.--   .--- ..- -.. .",
            MorseCodeDecoder.decodeBits(
            "1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011"
            )
        );
    }



    @Test
    public void testExampleFromDescription2() throws Exception {
        Assert.assertEquals(
                "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.",
                MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBits(
                        "00011100010101010001000000011101110101110001010111000101000111010111010001110101110000000111010101000101110100011101110111000101110111000111010000000101011101000111011101110001110101011100000001011101110111000101011100011101110001011101110100010101000000011101110111000101010111000100010111010000000111000101010100010000000101110101000101110001110111010100011101011101110000000111010100011101110111000111011101000101110101110101110"
                ))
        );
    }

    @Test
    public void testExampleFromDescription4() throws Exception {
        Assert.assertEquals(
                "EE",
                MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBits(
                        "111000000000111"
                ))
        );
    }


    @Test
    public void testExampleFromDescription3() throws Exception {
        Assert.assertEquals(
                ".-.-.-",
                MorseCodeDecoder.decodeBits(
                        "10111010111010111"
                )
        );
    }




    @Test
    public void testExampleFromDescription1() throws Exception {
        Assert.assertEquals(
                "--",
                MorseCodeDecoder.decodeBits(
                        "1110111"
                )
        );

        Assert.assertEquals(
                ". .",
                MorseCodeDecoder.decodeBits(
                        "10001"
                )
        );

        Assert.assertEquals(
                "E",MorseCodeDecoder.decodeMorse(
                MorseCodeDecoder.decodeBits(
                        "01110"
                ))
        );
    }

    @Test
    public void testTimeUnitFromBits() throws Exception {
        Assert.assertEquals(
                2,
                MorseCodeDecoder.analyseTimeUnit(
                        "1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011"
                )
        );

        Assert.assertEquals(
                1,
                MorseCodeDecoder.analyseTimeUnit(
                        "0000010100010"
                )
        );
    }

    @Test
    public void testStrippingZeroPaddingBits() throws Exception {

        System.out.println(

        );

        Assert.assertEquals(
                "1010001",
                MorseCodeDecoder.stripZeroPaddings(
                        "0000010100010"
                )
        );

        Assert.assertEquals(
                "1010001",
                MorseCodeDecoder.stripZeroPaddings(
                        "1010001"
                )
        );

        Assert.assertEquals(
                "1",
                MorseCodeDecoder.stripZeroPaddings(
                        "1"
                )
        );

        Assert.assertEquals(
                "",
                MorseCodeDecoder.stripZeroPaddings(
                        "000000"
                )
        );
    }

}