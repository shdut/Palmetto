/**
 * Copyright (C) 2014 Michael Röder (michael.roeder@unister.de)
 *
 * Licensed under the Creative Commons Attribution-NonCommercial 4.0
 * International Public License (the "License").
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://creativecommons.org/licenses/by-nc/4.0/legalcode
 *
 * Unless required by applicable law or agreed to in writing, a file
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.aksw.palmetto.prob;

import java.util.Arrays;
import java.util.Collection;

import org.aksw.palmetto.data.CountedSubsets;
import org.aksw.palmetto.data.SegmentationDefinition;
import org.aksw.palmetto.prob.bd.ListBasedBooleanDocumentFrequencyDeterminer;
import org.aksw.palmetto.subsets.AnyAny;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ListBasedBooleanDocumentFrequencyDeterminerTest extends AbstractBooleanDocumentSupportingAdapterBasedTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays
                .asList(new Object[][] {
                        /*
                         * word0 1 1 1
                         * 
                         * word1 0 1 1
                         * 
                         * word2 0 0 1
                         */

                        { new int[][] { { 0, 1, 2 }, { 1, 2 }, { 2 } }, new int[] { 0, 3, 2, 2, 1, 1, 1, 1 } },

                        /*
                         * word0 1 1 0 0
                         * 
                         * word1 0 1 1 1
                         * 
                         * word2 0 0 1 1
                         */

                        { new int[][] { { 0, 1 }, { 1, 2, 3 }, { 2, 3 } }, new int[] { 0, 2, 3, 1, 2, 0, 2, 0 } },

                        /*
                         * word0 1 1 0 0
                         * 
                         * word1 0 1 1 0
                         * 
                         * word2 0 0 1 1
                         * 
                         * word3 1 1 0 1
                         */

                        { new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 0, 1, 3 } },
                                new int[] { 0, 2, 2, 1, 2, 0, 1, 0, 3, 2, 1, 1, 1, 0, 0, 0 } } });
    }

    private int wordDocuments[][];
    private int expectedCounts[];

    public ListBasedBooleanDocumentFrequencyDeterminerTest(int[][] wordDocuments, int[] expectedCounts) {
        super(wordDocuments, 0);
        this.wordDocuments = wordDocuments;
        this.expectedCounts = expectedCounts;
    }

    @Test
    public void test() {
        String words[] = new String[wordDocuments.length];
        for (int i = 0; i < words.length; i++) {
            words[i] = Integer.toString(i);
        }

        ListBasedBooleanDocumentFrequencyDeterminer freqDeterminer = new ListBasedBooleanDocumentFrequencyDeterminer(this);
        CountedSubsets countedSubsets[] = freqDeterminer.determineCounts(new String[][] { words },
                new SegmentationDefinition[] { (new AnyAny()).getSubsetDefinition(words.length) });

        int counts[] = countedSubsets[0].counts;
        Assert.assertArrayEquals(expectedCounts, counts);
    }
}