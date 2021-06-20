package conduit;

import inventi.BaseModelImpl;
import inventi.PostModelImpl;
import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.ReachedVertex;
import org.graphwalker.core.generator.AStarPath;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.Context;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

/**
 * This verifies the basic flow of the model.
 * Using the A* algorithm, we create a straight path from the starting point,
 * e_Init in the graph, to the vertex v_Post_detail_page.
 */
public class SmokeTest {

    @Test
    public void runSmokeTest() {
        TestBuilder testBuilder = new TestBuilder()
                .addContext(
                        new BaseModelImpl(),
                        new File("inventi/BaseModel.json").toPath(),
                        new AStarPath(new ReachedVertex("v_homeSignedPage"))
                )
                .addContext(
                        new PostModelImpl(),
                        new File("inventi/PostModel.json").toPath(),
                        new AStarPath(new ReachedVertex("v_postDetailPage"))
                );


        Result result = testBuilder.execute();

        Assert.assertFalse(result.hasErrors());
        String resultsAsString = result.getResultsAsString();
    }
}
