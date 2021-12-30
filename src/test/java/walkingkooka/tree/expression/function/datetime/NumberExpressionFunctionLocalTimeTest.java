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

import org.junit.jupiter.api.Test;
import walkingkooka.Cast;
import walkingkooka.collect.list.Lists;
import walkingkooka.tree.expression.function.ExpressionFunctionContext;

import java.time.LocalTime;

public final class NumberExpressionFunctionLocalTimeTest extends NumberExpressionFunctionTestCase<NumberExpressionFunctionLocalTime<ExpressionFunctionContext>> {

    private final static LocalTime TIME = LocalTime.of(0, 58, 59);

    @Test
    public void testHour005859() {
        this.applyAndCheck3(
                NumberExpressionFunctionLocalTime.hour(),
                LocalTime.of(0, 0, 1),
                0
        );
    }


    @Test
    public void testHour015859() {
        this.applyAndCheck3(
                NumberExpressionFunctionLocalTime.hour(),
                LocalTime.of(1, 0, 1),
                1
        );
    }

    @Test
    public void testHour235859() {
        this.applyAndCheck3(
                NumberExpressionFunctionLocalTime.hour(),
                LocalTime.of(23, 0, 1),
                23
        );
    }

    @Test
    public void testMinute() {
        this.applyAndCheck3(
                NumberExpressionFunctionLocalTime.minute(),
                58
        );
    }

    @Test
    public void testSecond() {
        this.applyAndCheck3(
                NumberExpressionFunctionLocalTime.second(),
                59
        );
    }

    private void applyAndCheck3(final NumberExpressionFunctionLocalTime<ExpressionFunctionContext> function, final int expected) {
        this.applyAndCheck3(
                function,
                TIME,
                expected
        );
    }

    private void applyAndCheck3(final NumberExpressionFunctionLocalTime<ExpressionFunctionContext> function,
                                final LocalTime time,
                                final int expected) {
        this.applyAndCheck2(
                function,
                Lists.of(time),
                KIND.create(expected)
        );
    }

    @Test
    public void testToStringHour() {
        this.toStringAndCheck(
                NumberExpressionFunctionLocalTime.hour(),
                "hour"
        );
    }

    @Test
    public void testToStringMinute() {
        this.toStringAndCheck(
                NumberExpressionFunctionLocalTime.minute(),
                "minute"
        );
    }

    @Test
    public void testToStringSecond() {
        this.toStringAndCheck(
                NumberExpressionFunctionLocalTime.second(),
                "second"
        );
    }

    @Override
    public NumberExpressionFunctionLocalTime<ExpressionFunctionContext> createBiFunction() {
        return NumberExpressionFunctionLocalTime.hour();
    }

    @Override
    public Class<NumberExpressionFunctionLocalTime<ExpressionFunctionContext>> type() {
        return Cast.to(NumberExpressionFunctionLocalTime.class);
    }
}
