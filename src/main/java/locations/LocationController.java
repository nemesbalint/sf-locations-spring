package locations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Controller
public class LocationController {

    private AtomicInteger id = new AtomicInteger();
    private List<Location> locations = Collections.synchronizedList(new ArrayList<>(List.of(
            new Location(id.incrementAndGet(), "Fót", 1.0, 1.1),
            new Location(id.incrementAndGet(), "Dunakeszi", 1.2, 1.3),
            new Location(id.incrementAndGet(), "Göd", 1.4, 1.5))
    ));

    @GetMapping("/")
    @ResponseBody
    public String listLocations() {
        return locations.toString();

    }
}
