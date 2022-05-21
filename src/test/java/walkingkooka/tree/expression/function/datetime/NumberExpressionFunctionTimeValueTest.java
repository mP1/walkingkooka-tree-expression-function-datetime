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

// https://exceljet.net/excel-functions/excel-datevalue-function
public final class NumberExpressionFunctionTimeValueTest extends NumberExpressionFunctionTestCase<NumberExpressionFunctionTimeValue<ExpressionEvaluationContext>> {

    @Test
    public void test() {
        this.applyAndCheck2(
                Lists.of(TIME),
                KIND.create(TIME_VALUE)
        );
    }

    @Test
    public void testToString() {
        this.toStringAndCheck(
                NumberExpressionFunctionTimeValue.instance(),
                "timeValue"
        );
    }

    @Override
    public NumberExpressionFunctionTimeValue<ExpressionEvaluationContext> createBiFunction() {
        return NumberExpressionFunctionTimeValue.instance();
    }

    @Override
    public Class<NumberExpressionFunctionTimeValue<ExpressionEvaluationContext>> type() {
        return Cast.to(NumberExpressionFunctionTimeValue.class);
    }
}
