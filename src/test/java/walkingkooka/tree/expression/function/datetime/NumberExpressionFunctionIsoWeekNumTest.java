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

// https://exceljet.net/excel-functions/excel-isoweeknum-function
public final class NumberExpressionFunctionIsoWeekNumTest extends NumberExpressionFunctionTestCase<NumberExpressionFunctionIsoWeekNum<ExpressionEvaluationContext>> {

    @Test
    public void test20201225() {
        this.applyAndCheck3(
                LocalDate.of(2020, 12, 25),
                52
        );
    }

    @Test
    public void test20201226() {
        this.applyAndCheck3(
                LocalDate.of(2020, 12, 26),
                52
        );
    }

    @Test
    public void test20201227() {
        this.applyAndCheck3(
                LocalDate.of(2020, 12, 27),
                52
        );
    }

    @Test
    public void test20201228() {
        this.applyAndCheck3(
                LocalDate.of(2020, 12, 28),
                53
        );
    }

    @Test
    public void test20201231() {
        this.applyAndCheck3(
                LocalDate.of(2020, 12, 31),
                53
        );
    }

    @Test
    public void test20210101() {
        this.applyAndCheck3(
                LocalDate.of(2021, 1, 1),
                53
        );
    }

    @Test
    public void test20210102() {
        this.applyAndCheck3(
                LocalDate.of(2021, 1, 2),
                53
        );
    }

    @Test
    public void test20210103() {
        this.applyAndCheck3(
                LocalDate.of(2021, 1, 3),
                53
        );
    }

    @Test
    public void test20210104() {
        this.applyAndCheck3(
                LocalDate.of(2021, 1, 4),
                1
        );
    }

    @Test
    public void test20210105() {
        this.applyAndCheck3(
                LocalDate.of(2021, 1, 5),
                1
        );
    }

    private void applyAndCheck3(final LocalDate date,
                                final int expected) {
        this.applyAndCheck2(
                this.createBiFunction(),
                Lists.of(date),
                KIND.create(expected)
        );
    }

    @Test
    public void testToString() {
        this.toStringAndCheck(
                this.createBiFunction(),
                "isoweeknum"
        );
    }

    @Override
    public NumberExpressionFunctionIsoWeekNum<ExpressionEvaluationContext> createBiFunction() {
        return NumberExpressionFunctionIsoWeekNum.instance();
    }

    @Override
    public Class<NumberExpressionFunctionIsoWeekNum<ExpressionEvaluationContext>> type() {
        return Cast.to(NumberExpressionFunctionIsoWeekNum.class);
    }
}
