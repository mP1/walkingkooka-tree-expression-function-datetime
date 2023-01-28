package test;

import com.google.gwt.junit.client.GWTTestCase;

import java.time.LocalDateTime;

import walkingkooka.collect.list.Lists;
import walkingkooka.tree.expression.FakeExpressionEvaluationContext;
import walkingkooka.tree.expression.function.datetime.DateTimeExpressionFunctions;

public class TestGwtTest extends GWTTestCase {

    @Override
    public String getModuleName() {
        return "test.Test";
    }

    public void testAssertEquals() {
        assertEquals(
                1,
                1
        );
    }

    public void testNow() {
        final LocalDateTime now = LocalDateTime.now();

        assertEquals(
                now,
                DateTimeExpressionFunctions.now()
                        .apply(
                                Lists.of(),
                                new FakeExpressionEvaluationContext() {
                                    @Override
                                    public LocalDateTime now() {
                                        return now;
                                    }
                                }
                        )
        );
    }
}
