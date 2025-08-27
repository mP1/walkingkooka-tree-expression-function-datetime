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

import walkingkooka.Cast;
import walkingkooka.tree.expression.ExpressionEvaluationContext;
import walkingkooka.tree.expression.function.ExpressionFunctionParameter;
import walkingkooka.tree.expression.function.ExpressionFunctionParameterKind;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A {@link walkingkooka.tree.expression.function.ExpressionFunction} that requires a single parameter, and returns true
 * if the value is a {@link LocalDate} or {@link LocalDateTime} without attempting to convert the value.
 */
// https://support.google.com/docs/answer/9061381?hl=en&ref_topic=3105471
final class BooleanExpressionFunctionIsDate<C extends ExpressionEvaluationContext> extends BooleanExpressionFunction<C> {

    /**
     * Instance getter.
     */
    static <C extends ExpressionEvaluationContext> BooleanExpressionFunctionIsDate<C> instance() {
        return Cast.to(INSTANCE);
    }

    /**
     * Singleton
     */
    private static final BooleanExpressionFunctionIsDate<?> INSTANCE = new BooleanExpressionFunctionIsDate<>();

    private BooleanExpressionFunctionIsDate() {
        super("isDate");
    }

    @Override
    public Boolean apply(final List<Object> parameters,
                         final C context) {
        this.checkParameterCount(parameters);

        final Object value = ExpressionFunctionParameter.VALUE.getOrFail(parameters, 0);

        return value instanceof LocalDate ||
                value instanceof LocalDateTime;
    }

    private final static ExpressionFunctionParameter<?> VALUE = ExpressionFunctionParameter.VALUE.setKinds(
            ExpressionFunctionParameterKind.EVALUATE_RESOLVE_REFERENCES
    );

    @Override
    public List<ExpressionFunctionParameter<?>> parameters(final int count) {
        return PARAMETERS;
    }

    private final static List<ExpressionFunctionParameter<?>> PARAMETERS = ExpressionFunctionParameter.list(VALUE);
}
