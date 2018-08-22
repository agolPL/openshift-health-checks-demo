package pl.agol.openshift.healthchecksdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/hello")
class DomainController {

    @GetMapping
    String getHello(@RequestParam("requestDelay") int requestDelay) throws InterruptedException {
        log.info("Get request and going to sleep: {} ms", requestDelay);
        Thread.sleep(requestDelay);
        log.info("Now I'm ready to handle the request");
        return "hello";
    }
}
