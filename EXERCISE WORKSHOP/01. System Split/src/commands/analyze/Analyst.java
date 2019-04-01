package commands.analyze;

import models.system.System;

public class Analyst {
    public static String analyze(System system, String type){
        if(type.equals("Analyze")){
            return system.analyze();
        }
        else if(type.equals("DumpAnalyze")){
            return system.dumpAnalyze();
        }

        return null;
    }
}
