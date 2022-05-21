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
import walkingkooka.tree.expression.ExpressionEvaluationContext;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

public final class LocalDateTimeExpressionFunctionNowTest extends LocalDateTimeExpressionFunctionTestCase<LocalDateTimeExpressionFunctionNow<ExpressionEvaluationContext>> {

    @Test
    public void testApply() {
        final LocalDateTime date = this.apply2();
        assertTrue(
                date.getYear() >= 2021,
                () -> date + " year >= 2021"
        );
    }

    @Test
    public void testToString() {
        this.toStringAndCheck(this.createBiFunction(), "now");
    }

    @Override
    public LocalDateTimeExpressionFunctionNow<ExpressionEvaluationContext> createBiFunction() {
        return LocalDateTimeExpressionFunctionNow.instance();
    }

    @Override
    public Class<LocalDateTimeExpressionFunctionNow<ExpressionEvaluationContext>> type() {
        return Cast.to(LocalDateTimeExpressionFunctionNow.class);
    }
}
