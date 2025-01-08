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
import walkingkooka.tree.expression.ExpressionEvaluationContext;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class LocalTimeExpressionFunctionTimeTest extends LocalTimeExpressionFunctionTestCase<LocalTimeExpressionFunctionTime<ExpressionEvaluationContext>> {

    @Test
    public void testInvalidHourFails() {
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    this.apply2(
                            Lists.of(
                                    KIND.create(-1),
                                    KIND.create(58),
                                    KIND.create(59)
                            )
                    );
                });
    }

    @Test
    public void testInvalidMinuteFails() {
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    this.apply2(
                            Lists.of(
                                    KIND.create(12),
                                    KIND.create(-1),
                                    KIND.create(59)
                            )
                    );
                });
    }

    @Test
    public void testInvalidSecondFails() {
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    this.apply2(
                            Lists.of(
                                    KIND.create(12),
                                    KIND.create(58),
                                    KIND.create(-1)
                            )
                    );
                });
    }

    @Test
    public void test000000() {
        this.timeAndCheck(
                0,
                0,
                0,
                LocalTime.of(0, 0, 0)
        );
    }

    @Test
    public void test000060() {
        this.timeAndCheck(
                0,
                0,
                60,
                LocalTime.of(0, 1, 0)
        );
    }

    @Test
    public void test000061() {
        this.timeAndCheck(
                0,
                0,
                61,
                LocalTime.of(0, 1, 1)
        );
    }

    @Test
    public void test006000() {
        this.timeAndCheck(
                0,
                60,
                0,
                LocalTime.of(1, 0, 0)
        );
    }

    @Test
    public void test006100() {
        this.timeAndCheck(
                0,
                61,
                0,
                LocalTime.of(1, 1, 0)
        );
    }

    @Test
    public void test240000() {
        this.timeAndCheck(
                24,
                0,
                0,
                LocalTime.of(0, 0, 0)
        );
    }

    @Test
    public void test125859() {
        this.timeAndCheck(
                12,
                58,
                59,
                LocalTime.of(12, 58, 59)
        );
    }

    @Test
    public void test126061() {
        this.timeAndCheck(
                12,
                60,
                61,
                LocalTime.of(13, 01, 01)
        );
    }

    private void timeAndCheck(final int hours,
                              final int minutes,
                              final int seconds,
                              final LocalTime expected) {
        this.applyAndCheck2(
                Lists.of(
                        KIND.create(hours),
                        KIND.create(minutes),
                        KIND.create(seconds)
                ),
                expected
        );
    }

    @Test
    public void testToString() {
        this.toStringAndCheck(this.createBiFunction(), "time");
    }

    @Override
    public LocalTimeExpressionFunctionTime<ExpressionEvaluationContext> createBiFunction() {
        return LocalTimeExpressionFunctionTime.instance();
    }

    @Override
    public int minimumParameterCount() {
        return 3;
    }

    @Override
    public Class<LocalTimeExpressionFunctionTime<ExpressionEvaluationContext>> type() {
        return Cast.to(LocalTimeExpressionFunctionTime.class);
    }
}
