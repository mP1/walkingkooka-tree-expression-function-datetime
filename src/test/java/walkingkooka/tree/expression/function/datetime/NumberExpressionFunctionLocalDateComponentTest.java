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

public final class NumberExpressionFunctionLocalDateComponentTest extends NumberExpressionFunctionTestCase<NumberExpressionFunctionLocalDateComponent<ExpressionEvaluationContext>> {

    private final static LocalDate DATE = LocalDate.of(1999, 12, 31);

    @Test
    public void testDay() {
        this.applyAndCheck3(
                NumberExpressionFunctionLocalDateComponent.day(),
                31
        );
    }

    @Test
    public void testMonth() {
        this.applyAndCheck3(
                NumberExpressionFunctionLocalDateComponent.month(),
                12
        );
    }

    @Test
    public void testYear() {
        this.applyAndCheck3(
                NumberExpressionFunctionLocalDateComponent.year(),
                1999
        );
    }

    private void applyAndCheck3(final NumberExpressionFunctionLocalDateComponent<ExpressionEvaluationContext> function, final int expected) {
        this.applyAndCheck2(
                function,
                Lists.of(DATE),
                KIND.create(expected)
        );
    }

    @Test
    public void testToStringDay() {
        this.toStringAndCheck(
                NumberExpressionFunctionLocalDateComponent.day(),
                "day"
        );
    }

    @Test
    public void testToStringMonth() {
        this.toStringAndCheck(
                NumberExpressionFunctionLocalDateComponent.month(),
                "month"
        );
    }

    @Test
    public void testToStringYear() {
        this.toStringAndCheck(
                NumberExpressionFunctionLocalDateComponent.year(),
                "year"
        );
    }

    @Override
    public NumberExpressionFunctionLocalDateComponent<ExpressionEvaluationContext> createBiFunction() {
        return NumberExpressionFunctionLocalDateComponent.day();
    }

    @Override
    public Class<NumberExpressionFunctionLocalDateComponent<ExpressionEvaluationContext>> type() {
        return Cast.to(NumberExpressionFunctionLocalDateComponent.class);
    }
}
