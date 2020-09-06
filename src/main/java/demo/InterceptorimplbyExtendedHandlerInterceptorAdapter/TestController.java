package demo.InterceptorimplbyExtendedHandlerInterceptorAdapter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping(path = "/")
public class TestController {

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ResponseEntity<Object> login() {
        return new ResponseEntity<>("LOGIN ACTION", HttpStatus.OK);
    }

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public ResponseEntity<Object> test() {
        return new ResponseEntity<>("TEST ACTION", HttpStatus.OK);
    }
}