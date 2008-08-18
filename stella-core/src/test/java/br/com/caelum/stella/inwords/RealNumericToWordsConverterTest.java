package br.com.caelum.stella.inwords;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Victor dos Santos Pereira
 * @author Leonardo Bessa
 * 
 */
public class RealNumericToWordsConverterTest {

	private NumericToWordsConverter converter = new NumericToWordsConverter(
			new FormatoDeReal());

	@Test
	public void shouldTransform0InWords() {
		double zero = 0;
		String actual = converter.toWords(zero);
		assertEquals("zero", actual);
	}

	@Test
	public void shouldTransform1InWords() {
		double one = 1;
		String actual = converter.toWords(one);
		assertEquals("um real", actual);
	}

	@Test
	public void shouldTransform2InWords() {
		double two = 2;
		String actual = converter.toWords(two);
		;
		assertEquals("dois reais", actual);
	}

	@Test
	public void shouldTransform14InWords() {
		double fourteen = 14;
		String actual = converter.toWords(fourteen);
		;
		assertEquals("quatorze reais", actual);
	}

	@Test
	public void shouldTransform53InWordsUsingAnd() {
		double fiftyThree = 53;
		String actual = converter.toWords(fiftyThree);
		;
		assertEquals("cinquenta e três reais", actual);
	}

	@Test
	public void shouldTransformOneHundredInWords() {
		double oneHundred = 100;
		String actual = converter.toWords(oneHundred);
		;
		assertEquals("cem reais", actual);
	}

	@Test
	public void shouldTransformOneHundredInWordsUsingAnd() {
		double oneHundredAndNine = 109;
		String actual = converter.toWords(oneHundredAndNine);
		assertEquals("cento e nove reais", actual);
	}

	@Test
	public void shouldTransformTwoHundredInWords() {
		double twoHundred = 200;
		String actual = converter.toWords(twoHundred);
		;
		assertEquals("duzentos reais", actual);
	}

	@Test
	public void shouldTransformThousandInWords() {
		double thousand = 1000;
		String actual = converter.toWords(thousand);
		;
		assertEquals("mil reais", actual);
	}

	@Test
	public void shouldTransformThousandInWordsUsingAnd() {
		double thousand = 1031;
		String actual = converter.toWords(thousand);
		;
		assertEquals("mil e trinta e um reais", actual);
	}

	@Test
	public void shouldTransformAMillionIntoNumberInWords() {
		double oneMillion = 1000000;
		String actual = converter.toWords(oneMillion);
		;
		assertEquals("um milhão de reais", actual);
	}

	@Test
	public void shouldTransformAMillionIntoNumberInWordsUsingAnd() {
		double twoHundred = 1000150.99;
		String actual = converter.toWords(twoHundred);
		assertEquals(
				"um milhão e cento e cinquenta reais e noventa e nove centavos",
				actual);
	}

	@Test
	public void shouldTransformAMillionAndThousandIntoNumberInWordsUsingAnd() {
		double twoHundred = 1023850;
		String actual = converter.toWords(twoHundred);
		;
		assertEquals(
				"um milhão, vinte e três mil e oitocentos e cinquenta reais",
				actual);
	}

	@Test
	public void shouldTransformANumberInWordsUsingFraction() {
		double twoHundred = 0.22;
		String actual = converter.toWords(twoHundred);
		assertEquals("vinte e dois centavos", actual);
	}

	@Test
	public void shouldTransformOneDecimalWords() {
		double oneDecimal = 0.1;
		String actual = converter.toWords(oneDecimal);
		assertEquals("dez centavos", actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldTruncAndTransformANumberInWordsUsingFraction() {
		double twoHundred = 0.229;
		converter.toWords(twoHundred);
	}

	@Test
	public void shouldTransformAThousandAndOne() {
		double number = 1001;
		String words = converter.toWords(number);
		assertEquals("mil e um reais", words);
	}

	@Test
	public void shouldTransformAMillionAndOne() {
		double number = 1000001;
		String words = converter.toWords(number);
		assertEquals("um milhão e um reais", words);
	}

	@Test
	public void shouldTransformABillion() {
		double number = 1E9;
		String words = converter.toWords(number);
		assertEquals("um bilhão de reais", words);
	}

	@Test
	public void shouldTransform1E12() {
		double number = 1E12;
		String words = converter.toWords(number);
		assertEquals("um trilhão de reais", words);
	}

	@Test
	public void shouldTransform1E15() {
		double number = 1E15;
		String words = converter.toWords(number);
		assertEquals("um quatrilhão de reais", words);
	}

	@Test
	public void shouldTransform1E18() {
		double number = 1e18;
		String words = converter.toWords(number);
		assertEquals("um quintilhão de reais", words);
	}

	@Test
	public void shouldTransform999999999999999999L() {
		long number = 999999999999999999L;
		String words = converter.toWords(number);
		assertEquals(
				"novecentos e noventa e nove quatrilhões, " +
				"novecentos e noventa e nove trilhões, " +
				"novecentos e noventa e nove bilhões, " +
				"novecentos e noventa e nove milhões, " +
				"novecentos e noventa e nove mil e " +
				"novecentos e noventa e nove reais",
				words);
	}

}
