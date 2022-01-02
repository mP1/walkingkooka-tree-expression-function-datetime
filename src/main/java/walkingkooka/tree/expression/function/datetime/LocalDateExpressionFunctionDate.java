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
import walkingkooka.tree.expression.function.ExpressionFunctionParameterName;

import java.time.LocalDate;
import java.util.List;

// https://exceljet.net/excel-functions/excel-date-function
// Purpose
//Create a date with year, month, and day
//Return value
//A valid Excel date
//Syntax
//=DATE (year, month, day)
//Arguments
//year - Number for year.
//month - Number for month.
//day - Number for day.
final class LocalDateExpressionFunctionDate<C extends ExpressionFunctionContext> extends LocalDateExpressionFunction<C> {

    static <C extends ExpressionFunctionContext> LocalDateExpressionFunctionDate<C> instance() {
        return Cast.to(INSTANCE);
    }

    private final static LocalDateExpressionFunctionDate<?> INSTANCE = new LocalDateExpressionFunctionDate<>();

    private LocalDateExpressionFunctionDate() {
        super("date");
    }

    @Override
    public List<ExpressionFunctionParameter<?>> parameters() {
        return PARAMETERS;
    }

    private final static ExpressionFunctionParameter<ExpressionNumber> YEAR = ExpressionFunctionParameterName.with("year")
            .setType(ExpressionNumber.class);

    private final static ExpressionFunctionParameter<ExpressionNumber> MONTH = ExpressionFunctionParameterName.with("month")
            .setType(ExpressionNumber.class);

    private final static ExpressionFunctionParameter<ExpressionNumber> DAY = ExpressionFunctionParameterName.with("day")
            .setType(ExpressionNumber.class);

    private final static List<ExpressionFunctionParameter<?>> PARAMETERS = ExpressionFunctionParameter.list(
            YEAR,
            MONTH,
            DAY
    );

    @Override
    public LocalDate apply(final List<Object> parameters,
                           final C context) {
        this.checkOnlyRequiredParameters(parameters);

        int year = component(YEAR, parameters, 0);
        if (year <= 99) {
            year = context.twoToFourDigitYear(year);
        }

        final int month = component(MONTH, parameters, 1);
        final int day = component(DAY, parameters, 2);

        // the of factory does not support lenient/rolling of day or month components
        return LocalDate.of(
                        year,
                        1,
                        1
                ).plusMonths(month - 1)
                .plusDays(day - 1);
    }

    private static int component(final ExpressionFunctionParameter<ExpressionNumber> parameter,
                                 final List<Object> parameters,
                                 final int index) {
        final int value = parameter.getOrFail(parameters, index)
                .intValue();
        if (value < 0) {
            throw new IllegalArgumentException("Invalid " + parameter.name() + " " + value + " < 0");
        }
        return value;
    }
}
