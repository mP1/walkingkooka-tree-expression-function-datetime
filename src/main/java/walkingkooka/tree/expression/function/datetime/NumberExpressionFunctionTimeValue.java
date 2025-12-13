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
import walkingkooka.tree.expression.ExpressionNumber;
import walkingkooka.tree.expression.function.ExpressionFunctionParameter;
import walkingkooka.tree.expression.function.ExpressionFunctionParameterName;

import java.time.LocalTime;
import java.util.List;

/**
 * Requires a single {@link LocalTime} and converts that to an {@link ExpressionNumber}.
 */
// https://exceljet.net/excel-functions/excel-timevalue-function
final class NumberExpressionFunctionTimeValue<C extends ExpressionEvaluationContext> extends NumberExpressionFunction<C> {

    static <C extends ExpressionEvaluationContext> NumberExpressionFunctionTimeValue<C> instance() {
        return Cast.to(INSTANCE);
    }

    private final static NumberExpressionFunctionTimeValue<?> INSTANCE = new NumberExpressionFunctionTimeValue<>();

    private NumberExpressionFunctionTimeValue() {
        super("timeValue");
    }

    @Override
    public ExpressionNumber apply(final List<Object> parameters,
                                  final C context) {
        this.checkParameterCount(parameters);

        return context.convertOrFail(
                TIME.getOrFail(parameters, 0),
                ExpressionNumber.class
        );
    }

    @Override
    public List<ExpressionFunctionParameter<?>> parameters(final int count) {
        return PARAMETERS;
    }

    private final static ExpressionFunctionParameter<LocalTime> TIME = ExpressionFunctionParameterName.TIME.required(LocalTime.class);

    private final static List<ExpressionFunctionParameter<?>> PARAMETERS = ExpressionFunctionParameter.list(
            TIME
    );
}
