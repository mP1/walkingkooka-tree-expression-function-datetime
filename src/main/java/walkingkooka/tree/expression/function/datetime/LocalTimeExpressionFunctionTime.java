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

import java.time.LocalTime;
import java.util.List;

// https://exceljet.net/excel-functions/excel-time-function
//
// Purpose 
//Create a time with hours, minutes, and seconds
//
//Return value 
//A decimal number representing a particular time in Excel.
//
//Syntax 
//=TIME (hour, minute, second)
//
//Arguments 
//hour - The hour for the time you wish to create.
//minute - The minute for the time you wish to create.
//second - The second for the time you wish to create.
final class LocalTimeExpressionFunctionTime<C extends ExpressionFunctionContext> extends LocalTimeExpressionFunction<C> {

    static <C extends ExpressionFunctionContext> LocalTimeExpressionFunctionTime<C> instance() {
        return Cast.to(INSTANCE);
    }

    private final static LocalTimeExpressionFunctionTime<?> INSTANCE = new LocalTimeExpressionFunctionTime<>();

    private LocalTimeExpressionFunctionTime() {
        super("time");
    }

    @Override
    public List<ExpressionFunctionParameter<?>> parameters() {
        return PARAMETERS;
    }

    private final static ExpressionFunctionParameter<ExpressionNumber> HOUR = ExpressionFunctionParameterName.with("hour")
            .required(ExpressionNumber.class);

    private final static ExpressionFunctionParameter<ExpressionNumber> MINUTE = ExpressionFunctionParameterName.with("minute")
            .required(ExpressionNumber.class);

    private final static ExpressionFunctionParameter<ExpressionNumber> SECOND = ExpressionFunctionParameterName.with("second")
            .required(ExpressionNumber.class);

    private final static List<ExpressionFunctionParameter<?>> PARAMETERS = ExpressionFunctionParameter.list(
            HOUR,
            MINUTE,
            SECOND
    );

    @Override
    public LocalTime apply(final List<Object> parameters,
                           final C context) {
        this.checkParameterCount(parameters);

        final int hour = component(HOUR, parameters, 0);
        final int minute = component(MINUTE, parameters, 1);
        final int second = component(SECOND, parameters, 2);

        // the of factory does not support lenient/rolling of hour or second components
        return LocalTime.MIDNIGHT
                .plusHours(hour)
                .plusMinutes(minute)
                .plusSeconds(second);
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
