package conduit;

import inventi.BaseModelImpl;
import inventi.PostModelImpl;
import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.ReachedVertex;
import org.graphwalker.core.condition.TimeDuration;
import org.graphwalker.core.generator.AStarPath;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.Context;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * We ask GraphWalker to randomly walk the model until the stop condition is fulfilled.
 * That will happen when 1 minute has passed.
 * Of course, in a real test, that might be 30 minutes, or why not hours.
 */
public class StabilityTest {

    @Test
    public void runStabilityTest() {
        TestBuilder testBuilder = new TestBuilder()
                .addContext(
                        new BaseModelImpl(),
                        new File("inventi/BaseModel.json").toPath(),
                        new RandomPath(new TimeDuration(1, TimeUnit.MINUTES))
                )
                .addContext(
                        new PostModelImpl(),
                        new File("inventi/PostModel.json").toPath(),
                        new RandomPath(new TimeDuration(1, TimeUnit.MINUTES))
                );

        Result result = testBuilder.execute();

        Assert.assertFalse(result.hasErrors());
        String resultsAsString = result.getResultsAsString();
    }
}
