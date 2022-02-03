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

// https://exceljet.net/excel-functions/excel-datevalue-function
public final class NumberExpressionFunctionDateValueTest extends NumberExpressionFunctionTestCase<NumberExpressionFunctionDateValue<ExpressionFunctionContext>> {

    @Test
    public void test() {
        final LocalDate localDate = LocalDate.of(1999, 12, 31);

        this.applyAndCheck2(
                Lists.of(localDate),
                KIND.create(localDate.getYear())
        );
    }

    @Test
    public void testToString() {
        this.toStringAndCheck(
                NumberExpressionFunctionDateValue.instance(),
                "dateValue"
        );
    }

    @Override
    public NumberExpressionFunctionDateValue<ExpressionFunctionContext> createBiFunction() {
        return NumberExpressionFunctionDateValue.instance();
    }

    @Override
    public Class<NumberExpressionFunctionDateValue<ExpressionFunctionContext>> type() {
        return Cast.to(NumberExpressionFunctionDateValue.class);
    }
}
