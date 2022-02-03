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

import org.junit.jupiter.api.Test;
import walkingkooka.Cast;
import walkingkooka.Either;
import walkingkooka.collect.list.Lists;
import walkingkooka.tree.expression.function.ExpressionFunctionContext;
import walkingkooka.tree.expression.function.FakeExpressionFunctionContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public final class BooleanExpressionFunctionIsDateTest extends BooleanExpressionFunctionTestCase<BooleanExpressionFunctionIsDate<ExpressionFunctionContext>> {

    @Test
    public void testNullParameterFalse() {
        this.isNumberAndCheck(null, false);
    }

    @Test
    public void testStringParameterFalse() {
        this.isNumberAndCheck(
                "String123",
                false
        );
    }

    @Test
    public void testConvertedDateTrue() {
        this.isNumberAndCheck(
                "1999-12-31",
                true
        );
    }

    @Test
    public void testConvertedDateTimeTrue() {
        this.isNumberAndCheck(
                "1999-12-31T12:58:59",
                true
        );
    }

    @Test
    public void testConvertedTimeTrue() {
        this.isNumberAndCheck(
                "12:58:59",
                true
        );
    }

    @Test
    public void testLocalDateParameterTrue() {
        this.isNumberAndCheck(
                LocalDate.now(),
                true
        );
    }

    @Test
    public void testLocalDateTimeParameterTrue() {
        this.isNumberAndCheck(
                LocalDateTime.now(),
                true
        );
    }

    @Test
    public void testLocalTimeParameterTrue() {
        this.isNumberAndCheck(
                LocalTime.now(),
                true
        );
    }

    private void isNumberAndCheck(final Object parameter,
                                  final boolean expected) {
        this.applyAndCheck(
                Lists.of(parameter),
                this.createContext(),
                expected
        );
    }

    @Test
    public void testToString() {
        this.toStringAndCheck(this.createBiFunction(), "isDate");
    }

    @Override
    public BooleanExpressionFunctionIsDate<ExpressionFunctionContext> createBiFunction() {
        return BooleanExpressionFunctionIsDate.instance();
    }

    @Override
    public ExpressionFunctionContext createContext() {
        return new FakeExpressionFunctionContext() {
            @Override
            public <T> Either<T, String> convert(final Object value,
                                                 final Class<T> target) {
                if (value instanceof LocalDate || value instanceof LocalDateTime || value instanceof LocalTime) {
                    return Cast.to(
                            Either.left(
                                    value
                            )
                    );
                }

                for (final DateTimeFormatter formatter : Lists.of(
                        DateTimeFormatter.ISO_DATE,
                        DateTimeFormatter.ISO_DATE_TIME,
                        DateTimeFormatter.ISO_TIME
                )) {
                    try {
                        return Cast.to(
                                Either.left(
                                        formatter.parse((String) value)
                                )
                        );
                    } catch (final Exception fail2) {
                    }
                }

                return this.failConversion(
                        value,
                        target
                );
            }
        };
    }

    @Override
    public Class<BooleanExpressionFunctionIsDate<ExpressionFunctionContext>> type() {
        return Cast.to(BooleanExpressionFunctionIsDate.class);
    }
}
