package com.example.postgresdemo.schdele;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * User: ankoks
 * Date: 15/01/2019
 */
@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = "${application.cron.value}")
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    public static void main(String[] args) {
        List<PoJo> pojos = new ArrayList<>();
        pojos.add(new PoJo("Anton", 26, "d", false));
        pojos.add(new PoJo("Michail", 31, "d", false));
        pojos.add(new PoJo("Alex", 15, "some signature 3", false));
        pojos.add(new PoJo("Tolya", 15, null, true));

        Optional<PoJo> first = pojos.stream()
                .filter(s -> s.getSignature() == null || s.getSignature().isEmpty())
                .filter(s -> !s.isLastCurator()).min(Comparator.comparing(PoJo::getAge));

        System.out.println(first);

        System.out.println(first.isPresent());
    }

    static class PoJo {
        private String name;
        private Integer age;
        private String signature;
        private boolean lastCurator;

        public PoJo(String name, Integer age, String signature, boolean lastCurator) {
            this.name = name;
            this.age = age;
            this.signature = signature;
            this.lastCurator = lastCurator;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public boolean isLastCurator() {
            return lastCurator;
        }

        public void setLastCurator(boolean lastCurator) {
            this.lastCurator = lastCurator;
        }

        @Override
        public String toString() {
            return "PoJo{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", signature='" + signature + '\'' +
                    ", lastCurator=" + lastCurator +
                    '}';
        }
    }
}
