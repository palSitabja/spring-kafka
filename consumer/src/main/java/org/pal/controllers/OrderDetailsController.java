package org.pal.controllers;

import org.pal.services.OrderConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.pal.utils.OrderGeneratorUtil.generateOrder;

@RestController
public class OrderDetailsController {

}
