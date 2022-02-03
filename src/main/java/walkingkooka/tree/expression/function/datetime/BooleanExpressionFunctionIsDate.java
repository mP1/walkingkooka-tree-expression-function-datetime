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
import walkingkooka.tree.expression.function.ExpressionFunctionContext;
import walkingkooka.tree.expression.function.ExpressionFunctionParameter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * A {@link walkingkooka.tree.expression.function.ExpressionFunction} that requires a single parameter, and returns true
 * if it isConvertable a {@link LocalDate}, {@link LocalDateTime} or {@link LocalTime}.
 */
// https://support.google.com/docs/answer/9061381?hl=en&ref_topic=3105471
final class BooleanExpressionFunctionIsDate<C extends ExpressionFunctionContext> extends BooleanExpressionFunction<C> {

    /**
     * Instance getter.
     */
    static <C extends ExpressionFunctionContext> BooleanExpressionFunctionIsDate<C> instance() {
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

        return isConvertable(value, LocalDate.class, context) ||
                isConvertable(value, LocalDateTime.class, context) ||
                isConvertable(value, LocalTime.class, context);
    }

    /**
     * Returns true if the value can be converted to the requested target type.
     */
    private boolean isConvertable(final Object value,
                                  final Class<?> type,
                                  final C context) {
        return context.convert(
                value,
                type
        ).isLeft();
    }

    @Override
    public List<ExpressionFunctionParameter<?>> parameters() {
        return PARAMETERS;
    }

    private final static List<ExpressionFunctionParameter<?>> PARAMETERS = ExpressionFunctionParameter.list(
            ExpressionFunctionParameter.VALUE
    );
}
