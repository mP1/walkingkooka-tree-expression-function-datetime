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
import walkingkooka.tree.expression.ExpressionNumber;
import walkingkooka.tree.expression.function.ExpressionFunctionContext;
import walkingkooka.tree.expression.function.ExpressionFunctionParameter;

import java.time.temporal.IsoFields;
import java.util.List;

// https://exceljet.net/excel-functions/excel-isoweeknum-function
final class NumberExpressionFunctionIsoWeekNum<C extends ExpressionFunctionContext> extends NumberExpressionFunction<C> {

    static <C extends ExpressionFunctionContext> NumberExpressionFunctionIsoWeekNum<C> instance() {
        return Cast.to(INSTANCE);
    }

    private final static NumberExpressionFunctionIsoWeekNum<?> INSTANCE = new NumberExpressionFunctionIsoWeekNum<>();

    private NumberExpressionFunctionIsoWeekNum() {
        super("isoweeknum");
    }

    @Override
    public List<ExpressionFunctionParameter<?>> parameters() {
        return PARAMETERS;
    }

    private final static List<ExpressionFunctionParameter<?>> PARAMETERS = ExpressionFunctionParameter.list(
            ExpressionFunctionParameter.DATE
    );

    @Override
    public ExpressionNumber apply(final List<Object> parameters,
                                  final C context) {
        return context.expressionNumberKind()
                .create(
                        ExpressionFunctionParameter.DATE.getOrFail(parameters, 0)
                                .get(
                                        IsoFields.WEEK_OF_WEEK_BASED_YEAR
                                )
                );
    }
}
