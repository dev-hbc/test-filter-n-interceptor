package demo.InterceptorimplbyExtendedHandlerInterceptorAdapter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> login() {
        return new ResponseEntity<>("TEST DEFAULT API", HttpStatus.OK);
    }
}