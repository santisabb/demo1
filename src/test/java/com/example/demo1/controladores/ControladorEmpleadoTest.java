package com.example.demo1.controladores;

import com.example.demo1.entidades.Empleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ControladorEmpleadoTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp(){
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }


    @Test
    void crear() {
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                    {
                        "idEmpleado": 2,
                        "cuil": "4-49381355-20",
                        "nombreyApellidoEmpleado": "Tomas Campos"
                    }
                """;

        HttpEntity<String> request = new HttpEntity<>(json, httpHeaders);
        ResponseEntity<Empleado> response =
                testRestTemplate.exchange("/api/empleados", HttpMethod.POST, request, Empleado.class);

        Empleado result = response.getBody();

    }

    @Test
    void buscarId() {
        ResponseEntity<Empleado> response =
                testRestTemplate.getForEntity("/api/empleados/0", Empleado.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void borrarEmplado() {
    }

    @Test
    void modEmpleado() {
    }
}