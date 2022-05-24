
/*
 * Copyright 2019 Miroslav Pokorny (github.com/mP1)
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

import walkingkooka.Either;
import walkingkooka.tree.expression.ExpressionEvaluationContext;
import walkingkooka.tree.expression.ExpressionNumber;
import walkingkooka.tree.expression.ExpressionNumberKind;
import walkingkooka.tree.expression.FakeExpressionEvaluationContext;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class NumberExpressionFunctionTestCase<F extends NumberExpressionFunction<ExpressionEvaluationContext>> extends ExpressionFunctionTestCase<F, ExpressionNumber> {

    final static ExpressionNumberKind KIND = ExpressionNumberKind.DEFAULT;

    final LocalTime TIME = LocalTime.of(12, 58);

    final ExpressionNumber TIME_VALUE = KIND.create(0.123);

    NumberExpressionFunctionTestCase() {
        super();
    }

    @Override
    public final ExpressionEvaluationContext createContext() {
        return new FakeExpressionEvaluationContext(){
            @Override
            public ExpressionNumberKind expressionNumberKind() {
                return KIND;
            }

            @Override
            public <T> Either<T, String> convert(final Object value,
                                                 final Class<T> target) {
                if(value instanceof LocalDate) {
                    final LocalDate localDate = (LocalDate) value;
                    return this.successfulConversion(
                            KIND.create(localDate.getYear()),
                            target
                    );
                }
                if(value instanceof LocalTime) {
                    checkEquals(TIME, value);
                    return this.successfulConversion(
                            TIME_VALUE,
                            target
                    );
                }
                return this.failConversion(value, target);
            }
        };
    }

    @Override
    public final String typeNamePrefix() {
        return NumberExpressionFunction.class.getSimpleName();
    }
}
