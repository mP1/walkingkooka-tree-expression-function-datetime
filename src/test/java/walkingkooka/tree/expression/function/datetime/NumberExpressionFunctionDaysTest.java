/*
 * Copyright 2020 Miroslav Pokorny (github.com/mP1)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package walkingkooka.tree.expression.function.datetime;

import org.junit.jupiter.api.Test;
import walkingkooka.Cast;
import walkingkooka.collect.list.Lists;
import walkingkooka.tree.expression.ExpressionEvaluationContext;

import java.time.LocalDate;
import java.time.LocalTime;

// https://exceljet.net/excel-functions/excel-days-function
public final class NumberExpressionFunctionDaysTest extends NumberExpressionFunctionTestCase<NumberExpressionFunctionDays<ExpressionEvaluationContext>> {

    private final static LocalTime TIME = LocalTime.of(0, 58, 59);

    @Test
    public void test1April2021_1Jan2021() {
        this.applyAndCheck3(
                LocalDate.of(2021, 4, 1),
                LocalDate.of(2021, 1, 1),
                90
        );
    }

    @Test
    public void test1Jan2021_1April2021() {
        this.applyAndCheck3(
                LocalDate.of(2021, 1, 1),
                LocalDate.of(2021, 4, 1),
                -90
        );
    }

    @Test
    public void test1Jan2016_1Jan2015() {
        this.applyAndCheck3(
                LocalDate.of(2016, 1, 1),
                LocalDate.of(2015, 1, 1),
                365
        );
    }

    @Test
    public void test1Jan2017_1Jan2016() {
        this.applyAndCheck3(
                LocalDate.of(2017, 1, 1),
                LocalDate.of(2016, 1, 1),
                366
        );
    }

    private void applyAndCheck3(final LocalDate date1,
                                final LocalDate date2,
                                final int expected) {
        this.applyAndCheck2(
                Lists.of(date1, date2),
                KIND.create(expected)
        );
    }

    @Test
    public void testToString() {
        this.toStringAndCheck(
                NumberExpressionFunctionDays.instance(),
                "days"
        );
    }

    @Override
    public NumberExpressionFunctionDays<ExpressionEvaluationContext> createBiFunction() {
        return NumberExpressionFunctionDays.instance();
    }

    @Override
    public Class<NumberExpressionFunctionDays<ExpressionEvaluationContext>> type() {
        return Cast.to(NumberExpressionFunctionDays.class);
    }
}
