package com.company.service.implementation;

import com.company.repository.Repository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MyTextServiceTest {

    @Mock
    private Repository repository;
    @InjectMocks
    private MyTextService myTextService;

    @Test
    public void shouldRemoveFromSentences() {
        Map<Integer,String> map = new HashMap<>();
        map.put(5,"got big car");
        when(repository.removeFromSentences("got","car")).thenReturn(map);

        Map<Integer,String> actual = repository.removeFromSentences("got","car");
        Map<Integer,String> expected = new HashMap<>();
        expected.put(5,"got big car");

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnStatistics(){
        String stats = "(This statistics shows count of unique entities)\n"
                + "Sentences: " + 5 + "\n"
                + "Words: " + 10 + "\n"
                + "Symbols: " + 45 + "\n"
                + "Punctuation marks: " + 4;

        when(repository.stats()).thenReturn(stats);

        String actual = repository.stats();
        String expected = "(This statistics shows count of unique entities)\n"
                + "Sentences: " + 5 + "\n"
                + "Words: " + 10 + "\n"
                + "Symbols: " + 45 + "\n"
                + "Punctuation marks: " + 4;

        Assert.assertEquals(expected,actual);
    }
}