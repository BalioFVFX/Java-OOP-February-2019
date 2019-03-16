import enums.Corps;
import enums.MissionState;
import interfaces.*;
import models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Private> privateSoldiers = new LinkedHashMap<>();

        while (true) {
            String[] lines = bufferedReader.readLine().split("\\s+");

            if (lines[0].equals("End")) {
                return;
            }

            String id = lines[1];
            String firstName = lines[2];
            String lastName = lines[3];

            if (lines[0].equals("Private")) {
                double salary = Double.parseDouble(lines[4]);
                Private privateSoldier = new PrivateImpl(firstName, lastName, id, salary);
                privateSoldiers.put(id, privateSoldier);
                System.out.println(privateSoldier);
            }

            if (lines[0].equals("LeutenantGeneral")) {
                Set<Private> leutenantPrivates = new TreeSet<>();
                double salary = Double.parseDouble(lines[4]);

                for (int i = 5; i < lines.length; i++) {
                    String privateId = lines[i];
                    if (privateSoldiers.containsKey(privateId)) {
                        leutenantPrivates.add(privateSoldiers.get(privateId));
                    }
                }
                LeutenantGeneral leutenantGeneral = new LeutenantGeneralImpl(firstName, lastName, id, salary, leutenantPrivates);
                System.out.println(leutenantGeneral);
            }

            if (lines[0].equals("Engineer")) {
                double salary = Double.parseDouble(lines[4]);
                String corps = lines[5];
                if (!Corps.isValidCorp(corps)) {
                    continue;
                }

                Set<Repair> repairSet = new LinkedHashSet<>();
                for (int i = 6; i < lines.length; i += 2) {
                    Repair repair = new RepairImpl(lines[i], Integer.parseInt(lines[i + 1]));
                    repairSet.add(repair);
                }

                Engineer engineerImpl = new EngineerImpl(firstName, lastName, id, salary, Corps.valueOf(corps), repairSet);

                System.out.println(engineerImpl);
            }

            if (lines[0].equals("Commando")) {
                double salary = Double.parseDouble(lines[4]);
                String corps = lines[5];
                if (!Corps.isValidCorp(corps)) {
                    continue;
                }

                Set<Mission> missionSet = new LinkedHashSet<>();
                for (int i = 6; i < lines.length; i += 2) {
                    String missionCodeName = lines[i];
                    String missionState = lines[i + 1];
                    if (Arrays.stream(MissionState.values()).filter(m -> m.name().equals(missionState)).findFirst().orElse(null) != null) {
                        missionSet.add(new MissionImpl(missionCodeName, MissionState.valueOf(missionState)));
                    }
                }

                Commando commando = new CommandoImpl(firstName, lastName, id, salary, Corps.valueOf(corps), missionSet);
                System.out.println(commando);
            }

            if (lines[0].equals("Spy")) {
                String codeNumber = lines[4];

                Spy spy = new SpyImpl(firstName, lastName, id, codeNumber);
                System.out.println(spy);
            }
        }
    }
}
