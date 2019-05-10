package com.company.service.implementation;

import com.company.text.textDecomposition;
import javafx.util.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MyTextServiceTest {

    @Mock
    private textDecomposition textDecomposition;

    @Test
    public void shouldRemoveFromSentences() {
        Map<Integer,String> map = new HashMap<>();
        map.put(5,"got big car");
        when(textDecomposition.removeFromSentences("got","car")).thenReturn(map);

        Map<Integer,String> actual = textDecomposition.removeFromSentences("got","car");
        Map<Integer,String> expected = new HashMap<>();
        expected.put(5,"got big car");

        assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnStatistics(){
        Pair<Integer, Integer> stats = new Pair<>(2,9);

        when(textDecomposition.stats()).thenReturn(stats);

        Pair<Integer, Integer> actual = textDecomposition.stats();
        Pair<Integer, Integer> expected = new Pair<>(2,9);
        assertEquals(expected,actual);
    }
}