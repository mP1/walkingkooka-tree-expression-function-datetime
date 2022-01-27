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
import walkingkooka.tree.expression.function.ExpressionFunctionContext;

import java.time.LocalDate;

// https://exceljet.net/excel-functions/excel-edate-function
public final class LocalDateExpressionFunctionDateMonthAddTest extends LocalDateExpressionFunctionTestCase<LocalDateExpressionFunctionDateMonthAdd<ExpressionFunctionContext>> {

    @Test
    public void testZero() {
        final LocalDate date = LocalDate.now();

        this.applyAndCheck2(
                Lists.of(
                        date,
                        KIND.zero()
                ),
                date
        );
    }

    @Test
    public void test20180201_1Month() {
        this.applyAndCheck2(
                Lists.of(
                        LocalDate.of(2018, 2, 1),
                        KIND.one()
                ),
                LocalDate.of(2018, 3, 1)
        );
    }

    @Test
    public void test20180201_Minus1Month() {
        this.applyAndCheck2(
                Lists.of(
                        LocalDate.of(2018, 2, 1),
                        KIND.create(-1)
                ),
                LocalDate.of(2018, 1, 1)
        );
    }

    @Test
    public void test20190215_3Months() {
        this.applyAndCheck2(
                Lists.of(
                        LocalDate.of(2019, 2, 15),
                        KIND.create(3)
                ),
                LocalDate.of(2019, 5, 15)
        );
    }

    @Test
    public void test30March2019_Minus1Month() {
        this.applyAndCheck2(
                Lists.of(
                        LocalDate.of(2019, 3, 31),
                        KIND.create(-1)
                ),
                LocalDate.of(2019, 2, 28)
        );
    }

    @Test
    public void testToString() {
        this.toStringAndCheck(this.createBiFunction(), "dateMonthAdd");
    }

    @Override
    public LocalDateExpressionFunctionDateMonthAdd<ExpressionFunctionContext> createBiFunction() {
        return LocalDateExpressionFunctionDateMonthAdd.instance();
    }

    @Override
    public Class<LocalDateExpressionFunctionDateMonthAdd<ExpressionFunctionContext>> type() {
        return Cast.to(LocalDateExpressionFunctionDateMonthAdd.class);
    }
}
