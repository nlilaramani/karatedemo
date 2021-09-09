/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

//import com.intuit.karate.FileUtils;
import org.apache.commons.io.FileUtils;
import net.masterthought.cucumber.Configuration;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.intuit.karate.Runner;
import net.masterthought.cucumber.ReportBuilder;
import com.intuit.karate.Results;

/**
 *
 * @author itexps
 */
public class CucumberReportParallelRunner {

    public static void generateReport(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[]{"json"}, true);
        List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"),
                "com.rkdevblog.karate.employee");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }

    @Test
    public void testParallel() {
        Results results = Runner.parallel(getClass(), 5, "target/surefire-reports");
        generateReport(results.getReportDir());
        assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
    }

}
