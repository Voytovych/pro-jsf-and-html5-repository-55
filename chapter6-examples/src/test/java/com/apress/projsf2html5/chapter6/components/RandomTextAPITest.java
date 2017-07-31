package com.apress.projsf2html5.chapter6.components;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class RandomTextAPITest {

    int outputCount = 10;
    int wordCountLower = 3;
    int wordCountUpper = 15;

    @Test
    public void testListRandomText() throws Exception {
        RandomTextAPI.TextType type = RandomTextAPI.TextType.gibberish;
        RandomTextAPI.OutputTag output = RandomTextAPI.OutputTag.ul;

        RandomTextAPI instance = new RandomTextAPI();
        String result = instance.getRandomText(type, output, outputCount, wordCountLower, wordCountUpper);

        int paragraphCount = StringUtils.countMatches(result, "<li>");

        assertEquals("Incorrect number of items in the list", outputCount, paragraphCount);
    }

    @Test
    public void testGibberishParagraphsRandomText() throws Exception {
        RandomTextAPI.TextType type = RandomTextAPI.TextType.gibberish;
        RandomTextAPI.OutputTag output = RandomTextAPI.OutputTag.p;

        RandomTextAPI instance = new RandomTextAPI();
        String result = instance.getRandomText(type, output, outputCount, wordCountLower, wordCountUpper);

        int paragraphCount = StringUtils.countMatches(result, "<p>");

        assertEquals("Incorrect number of paragraphs", outputCount, paragraphCount);
    }

    @Test
    public void testLoremIpsumParagraphsRandomText() throws Exception {
        RandomTextAPI.TextType type = RandomTextAPI.TextType.lorem;
        RandomTextAPI.OutputTag output = RandomTextAPI.OutputTag.p;

        RandomTextAPI instance = new RandomTextAPI();
        String result = instance.getRandomText(type, output, outputCount, wordCountLower, wordCountUpper);

        int paragraphCount = StringUtils.countMatches(result, "<p>");
        boolean containsLoremIpsum = result.contains("Lorem ipsum");

        assertEquals("Incorrect number of paragraphs", outputCount, paragraphCount);
        assertTrue("Lorem Ipsum was not found in the result", containsLoremIpsum);
    }
}