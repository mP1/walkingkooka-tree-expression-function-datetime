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

public final class LocalDateExpressionFunctionTodayTest extends LocalDateExpressionFunctionTestCase<LocalDateExpressionFunctionToday<ExpressionEvaluationContext>> {

    @Test
    public void testApply() {
        this.applyAndCheck2(
                Lists.empty(),
                NOW.toLocalDate()
        );
    }

    @Test
    public void testToString() {
        this.toStringAndCheck(this.createBiFunction(), "today");
    }

    @Override
    public LocalDateExpressionFunctionToday<ExpressionEvaluationContext> createBiFunction() {
        return LocalDateExpressionFunctionToday.instance();
    }

    @Override
    public int minimumParameterCount() {
        return 0;
    }

    @Override
    public Class<LocalDateExpressionFunctionToday<ExpressionEvaluationContext>> type() {
        return Cast.to(LocalDateExpressionFunctionToday.class);
    }
}
