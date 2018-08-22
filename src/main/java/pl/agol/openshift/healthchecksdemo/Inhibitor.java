package pl.agol.openshift.healthchecksdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
class Inhibitor {

    @Value("${application-start-delay}")
    private int applicationStartDelay;

    @PostConstruct
    void delayStartApplication() throws InterruptedException {
        log.info("Going sleep for next {} ms", applicationStartDelay);
        Thread.sleep(applicationStartDelay);
        log.info("I woke up");
    }
}
