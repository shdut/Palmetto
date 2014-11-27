/**
 * Copyright (C) 2014 Michael Röder (michael.roeder@unister.de)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.aksw.palmetto.vector;

import java.util.Arrays;
import java.util.Collection;

import org.aksw.palmetto.calculations.direct.LogCondProbConfirmationMeasure;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LogCondProbCalculationBasedCreatorTest extends AbstractProbCalcBasedVectorCreatorTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays
                .asList(new Object[][] {
                        /*
                         * word1 1 1 1
                         * 
                         * word2 0 1 1
                         * 
                         * word3 0 1 1
                         * 
                         * vector1 log(1) log(1) log(1)
                         * 
                         * vector2 log(2/3) log(1) log(1)
                         * 
                         * vector3 log(2/3) log(1) log(1)
                         */
                        {
                                3,
                                new double[][] { { 0, 1.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0,
                                        2.0 / 3.0 } },
                                new double[][][] { { { 0, 0, 0 }, { Math.log(2.0 / 3.0), 0, 0 },
                                        { Math.log(2.0 / 3.0), 0, 0 } } }, "V_lc(1)", 1 },

                        /*
                         * word1 0 1 1
                         * 
                         * word2 1 0 1
                         * 
                         * word3 1 1 0
                         * 
                         * vector1 log(1) log(1/2) log(1/2)
                         * 
                         * vector2 log(1/2) log(1) log(1/2)
                         * 
                         * vector3 log(1/2) log(1/2) log(1)
                         */{
                                3,
                                new double[][] { { 0, 2.0 / 3.0, 2.0 / 3.0, 1.0 / 3.0, 2.0 / 3.0, 1.0 / 3.0, 1.0 / 3.0,
                                        0 } },
                                new double[][][] { { { 0, Math.log(1.0 / 2.0), Math.log(1.0 / 2.0) },
                                        { Math.log(1.0 / 2.0), 0, Math.log(1.0 / 2.0) },
                                        { Math.log(1.0 / 2.0), Math.log(1.0 / 2.0), 0 } } }, "V_lc(1)", 1 },
                        /*
                         * word1 0 0 0 1
                         * 
                         * word2 0 1 0 1
                         * 
                         * word3 0 0 1 1
                         * 
                         * vector1 log(1) log(1/2) log(1/2)
                         * 
                         * vector2 log(1) log(1) log(1/2)
                         * 
                         * vector3 log(1) log(1/2) log(1)
                         */
                        {
                                3,
                                new double[][] { { 0, 0.25, 0.5, 0.25, 0.5, 0.25, 0.25, 0.25 } },
                                new double[][][] { { { 0, Math.log(1.0 / 2.0), Math.log(1.0 / 2.0) },
                                        { 0, 0, Math.log(1.0 / 2.0) }, { 0, Math.log(1.0 / 2.0), 0 } } }, "V_lc(1)", 1 },
                        // all together
                        {
                                3,
                                new double[][] {
                                        { 0, 1.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0 },
                                        { 0, 2.0 / 3.0, 2.0 / 3.0, 1.0 / 3.0, 2.0 / 3.0, 1.0 / 3.0, 1.0 / 3.0, 0 },
                                        { 0, 0.25, 0.5, 0.25, 0.5, 0.25, 0.25, 0.25 } },
                                new double[][][] {
                                        { { 0, 0, 0 }, { Math.log(2.0 / 3.0), 0, 0 }, { Math.log(2.0 / 3.0), 0, 0 } },
                                        { { 0, Math.log(1.0 / 2.0), Math.log(1.0 / 2.0) },
                                                { Math.log(1.0 / 2.0), 0, Math.log(1.0 / 2.0) },
                                                { Math.log(1.0 / 2.0), Math.log(1.0 / 2.0), 0 } },
                                        { { 0, Math.log(1.0 / 2.0), Math.log(1.0 / 2.0) },
                                                { 0, 0, Math.log(1.0 / 2.0) }, { 0, Math.log(1.0 / 2.0), 0 } } },
                                "V_lc(1)", 1 },
                        /*
                         * word1 1 1 1
                         * 
                         * word2 0 1 1
                         * 
                         * word3 0 1 1
                         * 
                         * vector1 log(1) log(1) log(1)
                         * 
                         * vector2 log(2/3) log(1) log(1)
                         * 
                         * vector3 log(2/3) log(1) log(1)
                         */
                        {
                                3,
                                new double[][] { { 0, 1.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0,
                                        2.0 / 3.0 } },
                                new double[][][] { { { 0, 0, 0 }, { Math.pow(Math.log(2.0 / 3.0), 2), 0, 0 },
                                        { Math.pow(Math.log(2.0 / 3.0), 2), 0, 0 } } }, "V_lc(2)", 2 },

                        /*
                         * word1 0 1 1
                         * 
                         * word2 1 0 1
                         * 
                         * word3 1 1 0
                         * 
                         * vector1 log(1) log(1/2) log(1/2)
                         * 
                         * vector2 log(1/2) log(1) log(1/2)
                         * 
                         * vector3 log(1/2) log(1/2) log(1)
                         */{
                                3,
                                new double[][] { { 0, 2.0 / 3.0, 2.0 / 3.0, 1.0 / 3.0, 2.0 / 3.0, 1.0 / 3.0, 1.0 / 3.0,
                                        0 } },
                                new double[][][] { {
                                        { 0, Math.pow(Math.log(1.0 / 2.0), 2), Math.pow(Math.log(1.0 / 2.0), 2) },
                                        { Math.pow(Math.log(1.0 / 2.0), 2), 0, Math.pow(Math.log(1.0 / 2.0), 2) },
                                        { Math.pow(Math.log(1.0 / 2.0), 2), Math.pow(Math.log(1.0 / 2.0), 2), 0 } } },
                                "V_lc(2)", 2 },
                        /*
                         * word1 0 0 0 1
                         * 
                         * word2 0 1 0 1
                         * 
                         * word3 0 0 1 1
                         * 
                         * vector1 log(1) log(1/2) log(1/2)
                         * 
                         * vector2 log(1) log(1) log(1/2)
                         * 
                         * vector3 log(1) log(1/2) log(1)
                         */
                        {
                                3,
                                new double[][] { { 0, 0.25, 0.5, 0.25, 0.5, 0.25, 0.25, 0.25 } },
                                new double[][][] { {
                                        { 0, Math.pow(Math.log(1.0 / 2.0), 2), Math.pow(Math.log(1.0 / 2.0), 2) },
                                        { 0, 0, Math.pow(Math.log(1.0 / 2.0), 2) },
                                        { 0, Math.pow(Math.log(1.0 / 2.0), 2), 0 } } }, "V_lc(2)", 2 },
                        // all together
                        {
                                3,
                                new double[][] {
                                        { 0, 1.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0 },
                                        { 0, 2.0 / 3.0, 2.0 / 3.0, 1.0 / 3.0, 2.0 / 3.0, 1.0 / 3.0, 1.0 / 3.0, 0 },
                                        { 0, 0.25, 0.5, 0.25, 0.5, 0.25, 0.25, 0.25 } },
                                new double[][][] {
                                        { { 0, 0, 0 }, { Math.pow(Math.log(2.0 / 3.0), 2), 0, 0 },
                                                { Math.pow(Math.log(2.0 / 3.0), 2), 0, 0 } },
                                        {
                                                { 0, Math.pow(Math.log(1.0 / 2.0), 2), Math.pow(Math.log(1.0 / 2.0), 2) },
                                                { Math.pow(Math.log(1.0 / 2.0), 2), 0, Math.pow(Math.log(1.0 / 2.0), 2) },
                                                { Math.pow(Math.log(1.0 / 2.0), 2), Math.pow(Math.log(1.0 / 2.0), 2), 0 } },
                                        { { 0, Math.pow(Math.log(1.0 / 2.0), 2), Math.pow(Math.log(1.0 / 2.0), 2) },
                                                { 0, 0, Math.pow(Math.log(1.0 / 2.0), 2) },
                                                { 0, Math.pow(Math.log(1.0 / 2.0), 2), 0 } } }, "V_lc(2)", 2 } });
    }

    public LogCondProbCalculationBasedCreatorTest(int wordsetSize, double[][] probabilities,
            double[][][] expectedVectors, String expectedCreatorName, double gamma) {
        super(new LogCondProbConfirmationMeasure(0), wordsetSize, probabilities, expectedVectors, expectedCreatorName,
                gamma);
    }
}