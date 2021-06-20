package conduit;

import inventi.BaseModelImpl;
import inventi.PostModelImpl;
import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.Context;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a test where GraphWalker covers the complete graph.
 * It will start from e_Init, and ends as soon as the stop condition is fulfilled,
 * i.e. 100% coverage of all edges.
 */
public class FunctionalTest {

    @Test
    public void runFunctionalTest() {
        TestBuilder testBuilder = new TestBuilder()
                .addContext(
                        new BaseModelImpl(),
                        new File("inventi/BaseModel.json").toPath(),
                        new RandomPath(new EdgeCoverage(100))
                )
                .addContext(
                        new PostModelImpl(),
                        new File("inventi/PostModel.json").toPath(),
                        new RandomPath(new EdgeCoverage(100))
                );

        Result result = testBuilder.execute();

        Assert.assertFalse(result.hasErrors());
        String resultsAsString = result.getResultsAsString();
    }
}