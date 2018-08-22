package pl.agol.openshift.healthchecksdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api")
class DomainController {

    private int requestDelay = 0;

    @PostMapping("hi")
    void setDelay(@RequestBody int requestDelay) {
        this.requestDelay = requestDelay;
        log.info("New value of delay: {} ms", requestDelay);
    }

    @GetMapping("hello")
    String getHello() throws InterruptedException {
        log.info("Get request and going to sleep: {} ms", requestDelay);
        Thread.sleep(requestDelay);
        log.info("Now I'm ready to handle the request");
        return "hello";
    }

    @GetMapping("hi")
    String getHi() {
        return "hi";
    }
}
