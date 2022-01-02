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
import java.util.List;

// https://exceljet.net/excel-functions/excel-today-function
//
// The Excel TODAY function returns the current date,
final class LocalDateExpressionFunctionToday<C extends ExpressionFunctionContext> extends LocalDateExpressionFunction<C> {

    static <C extends ExpressionFunctionContext> LocalDateExpressionFunctionToday<C> instance() {
        return Cast.to(INSTANCE);
    }

    private final static LocalDateExpressionFunctionToday<?> INSTANCE = new LocalDateExpressionFunctionToday<>();

    private LocalDateExpressionFunctionToday() {
        super("today");
    }

    @Override
    public List<ExpressionFunctionParameter<?>> parameters() {
        return PARAMETERS;
    }

    private final static List<ExpressionFunctionParameter<?>> PARAMETERS = ExpressionFunctionParameter.list();

    @Override
    public LocalDate apply(final List<Object> parameters,
                           final C context) {
        this.checkOnlyRequiredParameters(parameters);

        return LocalDate.now();
    }
}
