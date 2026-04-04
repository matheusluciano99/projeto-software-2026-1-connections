package br.insper.conexoes.connections;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/connections")
@CrossOrigin(origins = "*")
public class ConnectionController {

    private final ConnectionService service;

    public ConnectionController(ConnectionService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Connection createConnection(@RequestBody CreateConnectionRequest request) {
        return service.create(
                request.fromUserId(),
                request.toUserId()
        );
    }

    @GetMapping("/{userId}")
    public List<Connection> listConnections(@PathVariable String userId) {
        return service.listByUser(userId);
    }

    @DeleteMapping
    public void deleteConnection(@RequestBody DeleteConnectionRequest request) {
        service.delete(
                request.fromUserId(),
                request.toUserId()
        );
    }
}

