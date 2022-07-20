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
import walkingkooka.tree.expression.function.ExpressionFunctionParameterKind;
import walkingkooka.tree.expression.function.ExpressionFunctionParameterName;

import java.time.LocalDate;
import java.util.List;

/**
 * Requires a single date and converts that to an {@link ExpressionNumber}.
 *
 * @param <C>
 */
// https://exceljet.net/excel-functions/excel-datevalue-function
final class NumberExpressionFunctionDateValue<C extends ExpressionEvaluationContext> extends NumberExpressionFunction<C> {

    static <C extends ExpressionEvaluationContext> NumberExpressionFunctionDateValue<C> instance() {
        return Cast.to(INSTANCE);
    }

    private final static NumberExpressionFunctionDateValue<?> INSTANCE = new NumberExpressionFunctionDateValue<>();

    private NumberExpressionFunctionDateValue() {
        super("dateValue");
    }

    @Override
    public ExpressionNumber apply(final List<Object> parameters,
                                  final C context) {
        this.checkParameterCount(parameters);

        return context.convertOrFail(
                DATE.getOrFail(parameters, 0),
                ExpressionNumber.class
        );
    }

    @Override
    public List<ExpressionFunctionParameter<?>> parameters(final int count) {
        return PARAMETERS;
    }

    private final static ExpressionFunctionParameter<LocalDate> DATE = ExpressionFunctionParameterName.DATE.required(LocalDate.class)
            .setKinds(ExpressionFunctionParameterKind.CONVERT_EVALUATE_RESOLVE_REFERENCES);

    private final static List<ExpressionFunctionParameter<?>> PARAMETERS = ExpressionFunctionParameter.list(
            DATE
    );
}
