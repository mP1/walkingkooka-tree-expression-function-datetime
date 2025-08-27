/*
 * Copyright 2019 Miroslav Pokorny (github.com/mP1)
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
import walkingkooka.tree.expression.ExpressionEvaluationContexts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public final class BooleanExpressionFunctionIsDateTest extends BooleanExpressionFunctionTestCase<BooleanExpressionFunctionIsDate<ExpressionEvaluationContext>> {

    @Test
    public void testNullParameterFalse() {
        this.applyFunctionAndCheck(null, false);
    }

    @Test
    public void testApplyStringParameterFalse() {
        this.applyFunctionAndCheck(
                "String123",
                false
        );
    }

    @Test
    public void testApplyStringDate() {
        this.applyFunctionAndCheck(
                "1999-12-31",
                false
        );
    }

    @Test
    public void testApplyStringDateTime() {
        this.applyFunctionAndCheck(
                "1999-12-31T12:58:59",
                false
        );
    }

    @Test
    public void testApplyStringTime() {
        this.applyFunctionAndCheck(
                "12:58:59",
                false
        );
    }

    @Test
    public void testApplyLocalDate() {
        this.applyFunctionAndCheck(
                LocalDate.now(),
                true
        );
    }

    @Test
    public void testApplyLocalDateTime() {
        this.applyFunctionAndCheck(
                LocalDateTime.now(),
                true
        );
    }

    @Test
    public void testApplyLocalTime() {
        this.applyFunctionAndCheck(
                LocalTime.now(),
                false
        );
    }

    private void applyFunctionAndCheck(final Object parameter, 
                                       final boolean expected) {
        this.applyAndCheck(
                Lists.of(parameter),
                this.createContext(),
                expected
        );
    }

    @Test
    public void testToString() {
        this.toStringAndCheck(this.createBiFunction(), "isDate");
    }

    @Override
    public BooleanExpressionFunctionIsDate<ExpressionEvaluationContext> createBiFunction() {
        return BooleanExpressionFunctionIsDate.instance();
    }

    @Override
    public int minimumParameterCount() {
        return 1;
    }

    @Override
    public ExpressionEvaluationContext createContext() {
        return ExpressionEvaluationContexts.fake();
    }

    @Override
    public Class<BooleanExpressionFunctionIsDate<ExpressionEvaluationContext>> type() {
        return Cast.to(BooleanExpressionFunctionIsDate.class);
    }
}
